package com.yuhang.novel.pirate.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yuhang.novel.pirate.dto.entity.BookSpiderHistoryEntity;
import com.yuhang.novel.pirate.dto.entity.BooksEntity;
import com.yuhang.novel.pirate.dto.mapper.BookResouceMapper;
import com.yuhang.novel.pirate.dto.mapper.BookSpiderHistoryMapper;
import com.yuhang.novel.pirate.dto.mapper.BooksMapper;
import com.yuhang.novel.pirate.model.BookResouceModel;
import com.yuhang.novel.pirate.model.BooksModel;
import com.yuhang.novel.pirate.model.page.BookResoucePage;
import com.yuhang.novel.pirate.model.params.ResouceInfoParams;
import com.yuhang.novel.pirate.model.resouce.BooksKdModel;
import com.yuhang.novel.pirate.model.resouce.CategoryKdModel;
import com.yuhang.novel.pirate.model.result.BooksReuslt;
import com.yuhang.novel.pirate.service.BookResouceService;
import com.yuhang.novel.pirate.utils.ResouceUtils;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 获取小说源
 */
@Service
public class BookResouceServiceImpl implements BookResouceService {

    private OkHttpClient client = new OkHttpClient.Builder()
            .readTimeout(60 * 3, TimeUnit.SECONDS)//设置读取超时时间
            .writeTimeout(60 * 3, TimeUnit.SECONDS)//设置写的超时时间
            .connectTimeout(60 * 3, TimeUnit.SECONDS)//设置连接超时时间
            .build();

    public static final String FORMAT_FULL_TIME_NO_ZONE = "yyyy-MM-dd HH:mm:ss";

    @Resource
    private BookResouceMapper mBookResouceMapper;

    @Resource
    private BooksMapper mBooksMapper;

    @Resource
    private BookSpiderHistoryMapper mBookSpiderHistoryMapper;


    @Override
    public BookResoucePage getResouceListByWeight(ResouceInfoParams params) {
        Page<BookResouceModel> page = new Page<>(params.getPageNum(), params.getPageSize());
        page = mBookResouceMapper.selectListByWeight(page);

        BookResoucePage resoucePage = new BookResoucePage();
        resoucePage
                .setList(page.getRecords())
                .setTotal(page.getTotal())
                .setPageNum(page.getCurrent())
                .setPageSize(page.getSize());
        return resoucePage;
    }

    @Override
    public void readBookInfo() {
        StringBuilder sb = new StringBuilder();
        Gson gson = new Gson();
        int bookid = mBooksMapper.selectByMaxBookid();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = bookid + 1; i < 482435; i++) {

                    Response response = null;
                    try {
                        response = getResponse(ResouceUtils.getBookInfoUrl(sb, i));

                        if (response.code() == 404) {
                            System.out.println("404地址: " + response.request().url().toString());
                            System.out.println("\n");
                            continue;
                        }
                        if (!StringUtils.isEmpty(response.body()) && response.code() == 200) {
                            String body = response.body().string();
                            BooksReuslt result = gson.fromJson(body, BooksReuslt.class);
                            BooksModel model = result.getData();

                            if (model != null) {
                                BooksEntity booksEntity = mBooksMapper.selectByAuthorAndBookName(model.getAuthor(), model.getName());

                                BooksEntity entity = new BooksEntity();
                                entity.setAuthor(model.getAuthor());
                                entity.setBookKsId(model.getId());
                                entity.setTypeKs(1);
                                entity.setBookName(model.getName());
                                entity.setCover(ResouceUtils.getCover(model.getImg()));
                                entity.setDescription(model.getDesc());
                                entity.setLastChapterName(model.getLastChapter());
                                entity.setResouceType(model.getBookStatus());
                                entity.setKind(model.getCName());

                                if (booksEntity == null) {
                                    mBooksMapper.insert(entity);
                                } else {
                                    entity.setId(booksEntity.getId());
                                    mBooksMapper.updateById(entity);
                                }


                            }

                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (Exception e) {

                    }
                }
            }
        }).start();
    }

    @Override
    public void readBookInfoKD() {
        try {
            Gson gson = new Gson();
            Response response = getResponse("http://lunbo.gdugm.cn/category/all");
            String category = response.body().string();
            List<CategoryKdModel> categoryList = gson.fromJson(category, new TypeToken<List<CategoryKdModel>>() {
            }.getType());

            List<String> urls = mBookSpiderHistoryMapper.selectByKdAll(2);

            BookSpiderHistoryEntity bookSpiderHistoryEntity =
                    mBookSpiderHistoryMapper.selectByUrl(2);
            for (CategoryKdModel model : categoryList) {

                int start = 0;
                int limit = 50;
                while (start < model.getCount()) {
                    String url = ResouceUtils.getCategoryUrl(model, start, limit);
                    start += limit;


                    if (!urls.contains(url) || url.equals(bookSpiderHistoryEntity.getUrl())) {
                        String bookInfo = getResponse(url).body().string();
                        BooksKdModel booksKdModel = gson.fromJson(bookInfo, BooksKdModel.class);


                        if (!urls.contains(url)) {
                            BookSpiderHistoryEntity spiderHistoryEntity = new BookSpiderHistoryEntity();
                            spiderHistoryEntity.setType(2);
                            spiderHistoryEntity.setUrl(url);
                            mBookSpiderHistoryMapper.insert(spiderHistoryEntity);
                        }


                        for (BooksKdModel.BooksBean book : booksKdModel.getBooks()) {
                            BooksEntity booksEntity = mBooksMapper.selectByAuthorAndBookName(book.getAuthor(), book.getTitle());

                            try {
                                if (booksEntity == null) {
                                    BooksEntity entity = new BooksEntity();
                                    entity.setBookKdId(book.get_id());
                                    entity.setTypeKd(1);
                                    entity.setResouceType("");
                                    entity.setAuthor(book.getAuthor());
                                    entity.setBookName(book.getTitle());
                                    entity.setCover(book.getCover());
                                    entity.setKind(book.getCat());
                                    entity.setLastChapterName(book.getLastChapter());
                                    entity.setDescription(book.getLongIntro());
                                    mBooksMapper.insert(entity);
                                } else {
                                    booksEntity.setBookKdId(book.get_id());
                                    booksEntity.setTypeKd(1);
                                    mBooksMapper.updateById(booksEntity);
                                }
                            } catch (Exception e) {

                            }


                        }
                    }


                }


            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    /**
     * 获取HTTP请求对象
     *
     * @param url
     * @return
     */
    private Response getResponse(String url) throws IOException {
        Request request = new Request.Builder()
                .get()
                .url(url)
                .build();

        Call call = client.newCall(request);
        return call.execute();
    }


    public static void main(String[] args) {
        BookResouceService service = new BookResouceServiceImpl();


//        try {
//            List<BookResouceModel> models = service.readBookResouceList();
//            service.readBookResouceDetails(models);
//        } catch (IOException e) {
//
//        }

        service.readBookInfo();
    }

}

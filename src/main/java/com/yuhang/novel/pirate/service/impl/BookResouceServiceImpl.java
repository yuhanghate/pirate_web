package com.yuhang.novel.pirate.service.impl;

import com.yuhang.novel.pirate.constant.BookResouceConstant;
import com.yuhang.novel.pirate.dto.entity.BookResouceEntity;
import com.yuhang.novel.pirate.dto.mapper.BookResouceMapper;
import com.yuhang.novel.pirate.model.BookResouceModel;
import com.yuhang.novel.pirate.service.BookResouceService;
import com.yuhang.novel.pirate.service.BookService;
import com.yuhang.novel.pirate.utils.UUIDUtils;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.seimicrawler.xpath.JXDocument;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.boot.json.JsonParseException;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 获取小说源
 */
@Service
public class BookResouceServiceImpl implements BookResouceService {

    private OkHttpClient client = new OkHttpClient();

    public static final String FORMAT_FULL_TIME_NO_ZONE = "yyyy-MM-dd HH:mm:ss";

    @Resource
    private BookResouceMapper mBookResouceMapper;

    @Override
    public List<BookResouceModel> readBookResouceList() throws IOException {

        List<BookResouceModel> list = new ArrayList<>();
        //获取所有页面HTML
        List<String> htmlList = getPageHtmlList(getPageSize());

        for (String html : htmlList) {
            List<BookResouceModel> itemList = getItemList(getJXDocument(html));
            list.addAll(itemList);
        }

        return list;
    }

    @Override
    public void readBookResouceDetails(List<BookResouceModel> list) throws IOException {

//        String html = BookResouceConstant.TEST_HTML_DETAILS;

        int count = 1;
        for (BookResouceModel model : list) {
            Response response = getResponse(BookResouceConstant.RESOUCE_URL + model.getUrl());
            if (response.body() != null) {
                String html = response.body().string();
                JXDocument jxDocument = getJXDocument(html);

                String status = (String) jxDocument.selOne("//span[@id='status']/text()");
                String websiteUrl = (String) jxDocument.selOne("//input[@id='url']/@value");
                String resouce = (String) jxDocument.selOne("//pre[@class='layui-code']/text()");
                List<Object> headList = jxDocument.sel("//input[@class='layui-input']/@value");

                String title = "";
                String updateTime = "";
                String checkTime = "";
                if (headList.size() >= 5) {
                    title = (String) jxDocument.selOne("//input[@class='layui-input']/@value");
                    updateTime = (String) jxDocument.sel("//input[@class='layui-input']/@value").get(2);
                    checkTime = (String) jxDocument.sel("//input[@class='layui-input']/@value").get(4);
                }

                JacksonJsonParser parser = new JacksonJsonParser();
                try {
                    Map<String, Object> map = parser.parseMap(resouce);
                    if (map.containsKey("bookSourceGroup") && !((String) map.get("bookSourceGroup")).contains("删除")) {
                        model.setStatus(status);
                        model.setWebsiteUrl(websiteUrl);
                        model.setResouceRule(resouce);
                        model.setTitle(title);
                        model.setUpdateTime(updateTime);
                        model.setCheckTime(checkTime);
                        boolean bookResouce = insertBookResouce(model);
                        System.out.println("书源名称:" + title + " 网站状态:" + status + " 书源网址:" + websiteUrl + " 页数:" + count + "/" + list.size());
                        count++;
                    }
                } catch (JsonParseException e) {

                }

            }
        }


//        String html = BookResouceConstant.TEST_HTML_DETAILS;
//        JXDocument jxDocument = getJXDocument(html);
//
//        String status = (String) jxDocument.selOne("//span[@id='status']/text()");
//        String websiteUrl = (String) jxDocument.selOne("//input[@id='url' and @class='layui-input']/@value");
//        String resouce = (String) jxDocument.selOne("//pre[@class='layui-code']/text()");
//        String title = (String) jxDocument.selOne("//input[@class='layui-input']/@value");
//        String updateTime = (String) jxDocument.sel("//input[@class='layui-input']/@value").get(2);
//        String checkTime = (String) jxDocument.sel("//input[@class='layui-input']/@value").get(4);
//
//        JacksonJsonParser parser = new JacksonJsonParser();
//        Map<String, Object> map = parser.parseMap(resouce);
//        if (map.containsKey("bookSourceGroup") && !((String) map.get("bookSourceGroup")).contains("删除")) {
//            BookResouceDetailsModel model = new BookResouceDetailsModel();
//            model.setStatus(status);
//            model.setWebsiteUrl(websiteUrl);
//            model.setResouceJson(resouce);
//            model.setTitle(title);
//            model.setUpdateTime(updateTime);
//            model.setCheckTime(checkTime);
//        }
    }

    /**
     * 获取总页数
     *
     * @return
     */
    private int getPageSize() throws IOException {
        Response response = getResponseSearch(1);
        //最后一页
        int page = 1;

        if (response.body() != null) {
            String html = response.body().string();
            JXDocument jxDocument = getJXDocument(html);


            String pageUrl = (String) jxDocument.selOne("//ul/li/a[text()='尾页']/@href");
            if (!StringUtils.isEmpty(pageUrl)) {
                String replace = pageUrl.replace("/index/search.html?page=", "");
                page = Integer.valueOf(replace);

            }
        }
        return page;
    }

    /**
     * 获取列表数据
     *
     * @return
     */
    private List<BookResouceModel> getItemList(JXDocument jxDocument) {
        List<Object> list = jxDocument.sel("//div[@class='layui-card']");

        List<BookResouceModel> models = new ArrayList<>();
        for (Object obj : list) {
            if (obj instanceof Element) {
                Element element = (Element) obj;
                JXDocument jxd = JXDocument.create(element.html());
                String url = (String) jxd.selOne("//a/@href");
                String heat = (String) jxd.selOne("//div[@class='layui-card-body']/span[1]/span/text()");
                String updateTime = (String) jxd.selOne("//div[@class='layui-card-body']/span[4]/span/text()");
                String title = (String) jxd.selOne("//a/div/span[@class='bname']/text()");

                if (!StringUtils.isEmpty(url) && !StringUtils.isEmpty(heat) && !StringUtils.isEmpty(updateTime) && !StringUtils.isEmpty(title)) {
                    BookResouceModel model = new BookResouceModel();
                    model.setUrl(url);
                    model.setHeat(Integer.valueOf(heat));
                    model.setUpdateTime(updateTime);
                    model.setTitle(title);

                    System.out.println("解析源列表: " + title + "  " + BookResouceConstant.RESOUCE_URL + url);
                    models.add(model);
                }

            }
        }
        return models;
    }

    /**
     * 获取所有页面URL列表
     *
     * @return
     */
    private List<String> getPageHtmlList(int page) throws IOException {
        List<String> list = new ArrayList<>();

        for (int i = 1; i <= page; i++) {

            Response response = getResponseSearch(i);

            System.out.println("源列表页:" + response.request().url());
            if (response.body() != null) {
                String html = response.body().string();
                Document doc = Jsoup.parse(html);
                list.add(doc.html());
            }
        }

        return list;
    }

    /**
     * 获取搜索页面
     *
     * @param page
     * @return
     * @throws IOException
     */
    private Response getResponseSearch(int page) throws IOException {
        return getResponse(BookResouceConstant.RESOUCE_URL + "/index/search.html?page=" + page);
    }

    /**
     * 详情页
     *
     * @param url
     * @return
     * @throws IOException
     */
    private Response getResponseDetails(String url) throws IOException {
        return getResponse(BookResouceConstant.RESOUCE_URL + url);
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

    private JXDocument getJXDocument(String html) {
        Document doc = Jsoup.parse(html);
        return JXDocument.create(doc);
    }

    /**
     * 插入或者更新源
     * @param model
     * @return
     */
    private boolean insertBookResouce(BookResouceModel model) {

        BookResouceEntity entity = mBookResouceMapper.selectByWebsite(model.getWebsiteUrl());

        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(FORMAT_FULL_TIME_NO_ZONE);
        if (entity == null) {

            //插入新源
            entity = new BookResouceEntity();
            BeanUtils.copyProperties(model, entity);
            entity.setCreateTime(new Date());
            entity.setCheckTime(dateTimeFormatter.parseDateTime(model.getCheckTime()).toDate());
            entity.setUpdateTime(dateTimeFormatter.parseDateTime(model.getUpdateTime()).toDate());
            entity.setId(UUIDUtils.get());
            entity.setResouceRule(URLEncoder.encode(entity.getResouceRule()));
            mBookResouceMapper.insert(entity);
            return true;
        } else {
            //更新源
            entity.setHeat(model.getHeat());
            entity.setUpdateTime(dateTimeFormatter.parseDateTime(model.getCheckTime()).toDate());
            entity.setCheckTime(dateTimeFormatter.parseDateTime(model.getUpdateTime()).toDate());
            entity.setResouceRule(model.getResouceRule());
            entity.setStatus(model.getStatus());
            entity.setTitle(model.getTitle());
            entity.setWebsiteUrl(model.getWebsiteUrl());
            mBookResouceMapper.updateById(entity);

            return true;
        }
    }
    public static void main(String[] args) {
        BookResouceService service = new BookResouceServiceImpl();


        try {
            List<BookResouceModel> models = service.readBookResouceList();
            service.readBookResouceDetails(models);
        } catch (IOException e) {

        }

    }
}

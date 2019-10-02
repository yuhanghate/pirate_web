package com.yuhang.novel.pirate.service.impl;

import com.yuhang.novel.pirate.constant.BookResouceConstant;
import com.yuhang.novel.pirate.model.BookResouceDetailsModel;
import com.yuhang.novel.pirate.model.BookResouceListModel;
import com.yuhang.novel.pirate.service.BookResouceService;
import net.minidev.json.JSONObject;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.seimicrawler.xpath.JXDocument;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 获取小说源
 */
public class BookResouceServiceImpl implements BookResouceService {

    private OkHttpClient client = new OkHttpClient();

    public BookResouceServiceImpl() {
    }

    @Override
    public List<BookResouceListModel> readBookResouceList() throws IOException {

        List<BookResouceListModel> list = new ArrayList<>();
        //获取所有页面HTML
        List<String> htmlList = getPageHtmlList(getPageSize());

        for (String html : htmlList) {
            List<BookResouceListModel> itemList = getItemList(getJXDocument(html));
            list.addAll(itemList);
        }

        return list;
    }

    @Override
    public void readBookResouceDetails(List<BookResouceListModel> list) throws IOException {

//        String html = BookResouceConstant.TEST_HTML_DETAILS;

//        for (BookResouceListModel resouceListModel : list) {
//            Response response = getResponse(resouceListModel.getUrl());
//            if (response.body() != null) {
//                String html = response.body().string();
//                html = BookResouceConstant.TEST_HTML_DETAILS;
//                JXDocument jxDocument = getJXDocument(html);
//
//                String status = (String) jxDocument.selOne("//span[@id='status']/text()");
//                String websiteUrl = (String) jxDocument.selOne("//input[@id='url' and @data-cip-id='url']/@value");
//                String resouce = (String) jxDocument.selOne("//pre[@class='layui-code']/text()");
//
//                JacksonJsonParser parser = new JacksonJsonParser();
//                Map<String, Object> map = parser.parseMap(resouce);
//                if (map.containsKey("bookSourceGroup") && !((String) map.get("bookSourceGroup")).contains("删除")) {
//                    BookResouceDetailsModel model = new BookResouceDetailsModel();
//                    model.setStatus(status);
//                    model.setWebsiteUrl(websiteUrl);
//                    model.setResouceJson(resouce);
//                }
//            }
//        }


        String html = BookResouceConstant.TEST_HTML_DETAILS;
        JXDocument jxDocument = getJXDocument(html);

        String status = (String) jxDocument.selOne("//span[@id='status']/text()");
        String websiteUrl = (String) jxDocument.selOne("//input[@id='url' and @class='layui-input']/@value");
        String resouce = (String) jxDocument.selOne("//pre[@class='layui-code']/text()");
        String title = (String) jxDocument.selOne("//input[@class='layui-input']/@value");
        String updateTime = (String) jxDocument.sel("//input[@class='layui-input']/@value").get(2);
        String checkTime = (String) jxDocument.sel("//input[@class='layui-input']/@value").get(4);

        JacksonJsonParser parser = new JacksonJsonParser();
        Map<String, Object> map = parser.parseMap(resouce);
        if (map.containsKey("bookSourceGroup") && !((String) map.get("bookSourceGroup")).contains("删除")) {
            BookResouceDetailsModel model = new BookResouceDetailsModel();
            model.setStatus(status);
            model.setWebsiteUrl(websiteUrl);
            model.setResouceJson(resouce);
            model.setTitle(title);
            model.setUpdateTime(updateTime);
            model.setCheckTime(checkTime);
        }
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
    private List<BookResouceListModel> getItemList(JXDocument jxDocument) {
        List<Object> list = jxDocument.sel("//div[@class='layui-card']");

        List<BookResouceListModel> models = new ArrayList<>();
        for (Object obj : list) {
            if (obj instanceof Element) {
                Element element = (Element) obj;
                JXDocument jxd = JXDocument.create(element.html());
                String url = (String) jxd.selOne("//a/@href");
                String heat = (String) jxd.selOne("//div[@class='layui-card-body']/span[1]/span/text()");
                String updateTime = (String) jxd.selOne("//div[@class='layui-card-body']/span[4]/span/text()");
                String title = (String) jxd.selOne("//a/div/span[@class='bname']/text()");

                if (!StringUtils.isEmpty(url) && !StringUtils.isEmpty(heat) && !StringUtils.isEmpty(updateTime) && !StringUtils.isEmpty(title)) {
                    BookResouceListModel model = new BookResouceListModel();
                    model.setUrl(url);
                    model.setHeat(Integer.valueOf(heat));
                    model.setUpdateTime(updateTime);
                    model.setTitle(title);

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

            Response response = getResponseSearch(page);

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

    public static void main(String[] args) {
        BookResouceService service = new BookResouceServiceImpl();


        try {
//            List<BookResouceListModel> models = service.readBookResouceList();
            service.readBookResouceDetails(null);
        } catch (IOException e) {

        }

    }
}

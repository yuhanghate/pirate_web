package com.yuhang.novel.pirate.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yuhang.novel.pirate.dto.entity.BooksEntity;
import com.yuhang.novel.pirate.model.BookResouceModel;
import com.yuhang.novel.pirate.model.BooksModel;
import com.yuhang.novel.pirate.model.RuleModel;
import com.yuhang.novel.pirate.model.resouce.CategoryKdModel;
import com.yuhang.novel.pirate.model.result.BaseResult;
import com.yuhang.novel.pirate.model.result.BookResouceResult;
import net.minidev.json.JSONObject;
import org.springframework.boot.json.JacksonJsonParser;

import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class ResouceUtils {

    /**
     * 获取书源url
     * @param sb
     * @param bookid
     * @return
     */
    public static String getBookInfoUrl(StringBuilder sb, int bookid) {
        return sb.delete(0, sb.length())
                .append("https://infos.xllxdg.com/BookFiles/Html/")
                .append(getDirId(bookid))
                .append("/")
                .append(bookid)
                .append("/info.html").toString();
    }

    /**
     * 获取目录id
     *
     * @param bookid
     * @return
     */
    public static int getDirId(int bookid) {
        if (bookid < 1000) {
            return 1;
        }
        String bookStr = String.valueOf(bookid);
        return Integer.valueOf(bookStr.substring(0, bookStr.length() - 3)) + 1;
    }

    /**
     * 封面地址
     *
     * @param cover
     * @return
     */
    public static String getCover(String cover) {
        if (cover == null || cover.startsWith("http://") || cover.startsWith("https://")) {
            return cover;
        }
        try {
            return "https://appbdimg.cdn.bcebos.com/BookFiles/BookImages/" + URLEncoder.encode(cover, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "https://appbdimg.cdn.bcebos.com/BookFiles/BookImages/" + cover;
    }


    private static String json = "{\"bookSourceGroup\":\"发现\",\"bookSourceName\":\"一品小说网\",\"bookSourceType\":\"TEXT\",\"bookSourceUrl\":\"http:\\/\\/www.1pxs.com\",\"enable\":true,\"httpUserAgent\":\"\",\"lastUpdateTime\":1563628531344,\"ruleBookAuthor\":\"\",\"ruleBookContent\":\"id.content@textNodes\",\"ruleBookName\":\"\",\"ruleChapterList\":\"class.novel_list@tag.dl@tag.dd@tag.a\",\"ruleChapterName\":\"text\",\"ruleChapterUrl\":\"class.info@class.r_tools@tag.a.1@href\",\"ruleChapterUrlNext\":\"\",\"ruleContentUrl\":\"href\",\"ruleContentUrlNext\":\"\",\"ruleCoverUrl\":\"class.con_limg@tag.img.0@src\",\"ruleFindUrl\":\"玄幻魔法::http:\\/\\/www.1pxs.com\\/mulu\\/1-searchPage.html&&武侠修真::http:\\/\\/www.1pxs.com\\/mulu\\/2-searchPage.html&&都市言情::http:\\/\\/www.1pxs.com\\/mulu\\/3-searchPage.html&&历史军事::http:\\/\\/www.1pxs.com\\/mulu\\/4-searchPage.html&&穿越小说::http:\\/\\/www.1pxs.com\\/mulu\\/9-searchPage.html&&恐怖灵异::http:\\/\\/www.1pxs.com\\/mulu\\/8-searchPage.html&&侦探推理::http:\\/\\/www.1pxs.com\\/mulu\\/5-searchPage.html&&科幻小说::http:\\/\\/www.1pxs.com\\/mulu\\/7-searchPage.html&&网游动漫::http:\\/\\/www.1pxs.com\\/mulu\\/6-searchPage.html&&其他类型::http:\\/\\/www.1pxs.com\\/mulu\\/10-searchPage.html\",\"ruleIntroduce\":\"class.info@class.r_cons@textNodes\",\"ruleSearchAuthor\":\"class.odd.1@text||class.info@tag.p.0@tag.a.0@text||id.alistbox@tag.span.0@tag.a.0@text\",\"ruleSearchCoverUrl\":\"class.con_limg@tag.img.0@src||id.alistbox@tag.a.0@tag.img.0@src\",\"ruleSearchKind\":\"class.even.2@text\",\"ruleSearchLastChapter\":\"class.even.0@tag.a.0@text||class.info@tag.strong.0@tag.a.0@text||id.alistbox@tag.li.0@tag.a.0@text\",\"ruleSearchList\":\"class.grid@tag.tr!0||class.con_txt||id.alist@tag.div!0\",\"ruleSearchName\":\"class.odd.0@tag.a.0@text||class.info@tag.h1.0@tag.a.0@text||id.alistbox@tag.h2.0@tag.a.0@text#《|》\",\"ruleSearchNoteUrl\":\"class.odd.0@tag.a.0@href||id.alistbox@tag.h2.0@tag.a.0@href\",\"ruleSearchUrl\":\"http:\\/\\/www.1pxs.com\\/modules\\/article\\/search.php?ie=gbk&searchkey=searchKey&ct=2097152|char=gbk\",\"serialNumber\":0,\"weight\":25}";
    public static void main(String[] args) {


//        try {
//            InputStream inStream = new FileInputStream(new File("/Users/yuhang/book/pirate_web/src/main/resources/config/application.properties"));
//            Properties prop = new Properties();
//            prop.load(inStream);
//            String json = prop.getProperty("json");
//            BookResouceResult baseResult = new Gson().fromJson(json, BookResouceResult.class);
//            JacksonJsonParser parser = new JacksonJsonParser();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        Map<String, String> retMap = new Gson().fromJson(json,
                new TypeToken<Map<String, String>>() {
                }.getType());

        String s = new Gson().toJson(retMap);

//        RuleModel baseResult = new Gson().fromJson(json, RuleModel.class);
        JacksonJsonParser parser = new JacksonJsonParser();



//        BookResouceResult resouceResult = new Gson().fromJson(json, BookResouceResult.class);
//        List<BookResouceModel> list = resouceResult.getData().getList();
//        for (BookResouceModel model : list) {
//            String resouceRule = model.getResouceRule();
//            Map<String, Object> map = parser.parseMap(resouceRule);
//            String ruleBookContent = (String) map.get("ruleBookContent");
//            System.out.println(ruleBookContent);
//        }

    }


    /**
     * 获取类型
     * @return
     */
    public static List<String> getGenderList() {
        List<String> list = new ArrayList<>();
        list.add("male");
        list.add("female");
        list.add("press");
        return list;
    }

    public static List<String> getMajorList(String gender) {

        List<String> list = new ArrayList<>();
        if (gender.equals("male")) {

            list.add("玄幻");
            list.add("奇幻");
            list.add("武侠");
            list.add("仙侠");
            list.add("都市");
            list.add("职场");
            list.add("历史");
            list.add("军事");
            list.add("游戏");
            list.add("竞技");
            list.add("科幻");
            list.add("灵异");
            list.add("同人");
            list.add("轻小说");
        } else if (gender.equals("female")) {

            list.add("古代言情");
            list.add("现代言情");
            list.add("青春校园");
            list.add("耽美");
            list.add("玄幻奇幻");
            list.add("武侠仙侠");
            list.add("科幻");
            list.add("游戏竞技");
            list.add("悬疑灵异");
            list.add("同人");
            list.add("女尊");
            list.add("百合");
        } else {

            list.add("传记名著");
            list.add("出版小说");
            list.add("人文社科");
            list.add("生活时尚");
            list.add("经管理财");
            list.add("青春言情");
            list.add("外文原版");
            list.add("政治军事");
            list.add("成功励志");
            list.add("育儿健康");
        }
        return list;
    }

    public static String getCategoryUrl(CategoryKdModel model, int start, int limit) {
        return "http://api.wgfgr.cn/book/list?gender="+model.getGender()+ "&major=" + model.getMajorCate() + "&start="+start+"&limit="+limit;
    }
}

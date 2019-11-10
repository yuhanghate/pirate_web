package com.yuhang.novel.pirate.model.result;

import com.yuhang.novel.pirate.model.BooksModel;

import java.util.List;

public class BooksReuslt {

    /**
     * status : 1
     * info : success
     * data : {"Id":462437,"Name":"氪命得分王","Img":"kemingdefenwang.jpg","Author":"暖舒柳岸","Desc":"赵乐说他的偶像是\u201c魔术师\u201d，他喜欢传球。可是没有人相信，所有人都说赵乐比科比更毒瘤。\r\n　　赵乐无奈的很，他不是不喜欢传球，关键是他得分越多活的越久。用50年寿命买来的系统，不翻倍赚回来，那就是血亏。","CId":95,"CName":"玄幻奇幻","LastTime":"10/11/2019 11:53:22 PM","FirstChapterId":2347322,"LastChapter":"第二百八十一章 他们响应赵乐了","LastChapterId":2546345,"BookStatus":"连载","SameUserBooks":[],"SameCategoryBooks":[{"Id":457573,"Name":"快穿之总有男神想黑化","Img":"kuaichuanzhizongyounanshenxiangheihua.jpg","Score":0},{"Id":369539,"Name":"风水女术士","Img":"fengshuinvshushi.jpg","Score":0},{"Id":454028,"Name":"婚姻是道算术题","Img":"hunyinshidaosuanshuti.jpg","Score":0},{"Id":459043,"Name":"重生直播系统","Img":"zhongshengzhiboxitong.jpg","Score":0},{"Id":465602,"Name":"一人之力","Img":"yirenzhili.jpg","Score":0},{"Id":469635,"Name":"凤凰乌鸦","Img":"fenghuangwuya.jpg","Score":0},{"Id":446714,"Name":"凶尸实录","Img":"xiongshishilu.jpg","Score":0},{"Id":475972,"Name":"修真轩辕","Img":"xiuzhenxuanyuan.jpg","Score":0},{"Id":451668,"Name":"不一样的一代人","Img":"buyiyangdeyidairen.jpg","Score":0},{"Id":433799,"Name":"快穿系统：矫宠无罪","Img":"kuaichuanxitong：jiaochongwuzui.jpg","Score":0},{"Id":451200,"Name":"斗罗之重生昊天锤","Img":"douluozhizhongshenghaotianchui.jpg","Score":0},{"Id":422941,"Name":"星魂帝主","Img":"xinghundizhu.jpg","Score":0}],"BookVote":{"BookId":462437,"TotalScore":6,"VoterCount":1,"Score":6}}
     */

    private int status;
    private String info;
    private BooksModel data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public BooksModel getData() {
        return data;
    }

    public void setData(BooksModel data) {
        this.data = data;
    }

}

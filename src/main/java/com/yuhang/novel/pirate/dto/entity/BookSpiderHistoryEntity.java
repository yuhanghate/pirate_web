package com.yuhang.novel.pirate.dto.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author yuhang
 * @since 2019-10-26
 */
@TableName("book_spider_history")
public class BookSpiderHistoryEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 1:看书  2:快读
     */
    private Integer type;

    /**
     * 二级分类URL
     */
    private String url;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "BookSpiderHistoryEntity{" +
            "type=" + type +
            ", url=" + url +
        "}";
    }
}

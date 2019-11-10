package com.yuhang.novel.pirate.dto.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author yuhang
 * @since 2019-10-14
 */
@TableName("books")
public class BooksEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;

    /**
     * 书名
     */
    private String bookName;

    /**
     * 作者
     */
    private String author;

    /**
     * 封面
     */
    private String cover;

    /**
     * 简介
     */
    private String description;

    /**
     * 章节名称
     */
    private String lastChapterName;

    /**
     * 书源类型
     */
    private String resouceType;

    /**
     * 小说id
     */
    private int bookKsId;

    /**
     * 书类型
     */
    private String kind;


    /**
     * 看书神器
     */
    private int typeKs;

    /**
     * 快读类型
     */
    private int typeKd;

    /**
     * 快读id
     */
    private String bookKdId;

    /**
     * 权重
     */
    private int weight;

    public int getId() {
        return id;
    }

    public BooksEntity setId(int id) {
        this.id = id;
        return this;
    }

    public String getKind() {
        return kind;
    }

    public BooksEntity setKind(String kind) {
        this.kind = kind;
        return this;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getLastChapterName() {
        return lastChapterName;
    }

    public void setLastChapterName(String lastChapterName) {
        this.lastChapterName = lastChapterName;
    }
    public String getResouceType() {
        return resouceType;
    }

    public void setResouceType(String resouceType) {
        this.resouceType = resouceType;
    }

    public int getBookKsId() {
        return bookKsId;
    }

    public BooksEntity setBookKsId(int bookKsId) {
        this.bookKsId = bookKsId;
        return this;
    }

    public int getTypeKs() {
        return typeKs;
    }

    public BooksEntity setTypeKs(int typeKs) {
        this.typeKs = typeKs;
        return this;
    }

    public int getTypeKd() {
        return typeKd;
    }

    public BooksEntity setTypeKd(int typeKd) {
        this.typeKd = typeKd;
        return this;
    }

    public String getBookKdId() {
        return bookKdId;
    }

    public BooksEntity setBookKdId(String bookKdId) {
        this.bookKdId = bookKdId;
        return this;
    }

    public int getWeight() {
        return weight;
    }

    public BooksEntity setWeight(int weight) {
        this.weight = weight;
        return this;
    }

    @Override
    public String toString() {
        return "BooksEntity{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", cover='" + cover + '\'' +
                ", description='" + description + '\'' +
                ", lastChapterName='" + lastChapterName + '\'' +
                ", resouceType='" + resouceType + '\'' +
                ", bookKsId=" + bookKsId +
                ", kind='" + kind + '\'' +
                ", typeKs='" + typeKs + '\'' +
                ", typeKd='" + typeKd + '\'' +
                ", bookKdId='" + bookKdId + '\'' +
                ", weight=" + weight +
                '}';
    }
}

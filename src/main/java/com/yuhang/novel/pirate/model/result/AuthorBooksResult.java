package com.yuhang.novel.pirate.model.result;

import com.yuhang.novel.pirate.model.AuthorBooksModel;
import io.swagger.annotations.ApiModel;

import java.util.List;

@ApiModel(description = "作者所有作品")
public class AuthorBooksResult extends BaseResult {

    private List<AuthorBooksModel> data;

    public List<AuthorBooksModel> getData() {
        return data;
    }

    public AuthorBooksResult setData(List<AuthorBooksModel> data) {
        this.data = data;
        return this;
    }
}

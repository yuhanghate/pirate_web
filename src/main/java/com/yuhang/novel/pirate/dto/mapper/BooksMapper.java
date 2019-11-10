package com.yuhang.novel.pirate.dto.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuhang.novel.pirate.dto.entity.BooksEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yuhang.novel.pirate.model.AuthorBooksModel;
import com.yuhang.novel.pirate.model.BookSearchModel;
import com.yuhang.novel.pirate.model.page.BookSearchPage;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yuhang
 * @since 2019-10-14
 */
public interface BooksMapper extends BaseMapper<BooksEntity> {

    BooksEntity selectByAuthorAndBookName(String author, String bookname);

    /**
     * 最后爬的书源
     * @return
     */
    int selectByMaxBookid();

    /**
     * 根据名称或者作者查找书名
     * @param page 页面
     * @param keyword 小说名称/作者
     * @return
     */
    Page<BookSearchModel> selectSearchModelByBookName(Page<BookSearchModel> page, String keyword);


    /**
     * 获取作者所有书籍
     * @param author 作者名
     * @return
     */
    List<AuthorBooksModel> selectAuthorBooksByAuthor(String author);

    /**
     * 根据看书id查询
     * @param bookid
     * @return
     */
    BookSearchModel selectSearchModelByBookidKs(String bookid);
}

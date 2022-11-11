package net.hnkj.springboot0202.service;

import net.hnkj.springboot0202.model.Book;
import net.hnkj.springboot0202.utils.PageBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface IBookService {
    int deleteByPrimaryKey(Integer bookId);

    int insert(Book record);

    int insertSelective(Book record);

    @Transactional(readOnly = true)
    Book selectByPrimaryKey(Integer bookId);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);

    //查询全部书本
    @Transactional(readOnly = true)
    List<Book> listBook(Book book, PageBean pageBean);
}
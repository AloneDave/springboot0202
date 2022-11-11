package net.hnkj.springboot0202.service.impl;

import net.hnkj.springboot0202.model.Book;
import net.hnkj.springboot0202.service.IBookService;
import net.hnkj.springboot0202.utils.PageBean;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookServiceImplTest{

    @Autowired
    private IBookService bookService;
    private Book book;
    private PageBean pageBean;

    @BeforeEach
    void setUp() {
        book = new Book();
        pageBean = new PageBean();
    }

    @Test
    void insertSelective() {
        book.setBookName("红楼梦33");
        book.setBookPrice(33f);
        bookService.insertSelective(book);
    }

    @Test
    void selectByPrimaryKey() {
    }

    @Test
    void updateByPrimaryKeySelective() {
        book.setBookId(110);
        book.setBookName("红楼梦33");
        book.setBookPrice(43f);
        bookService.updateByPrimaryKeySelective(book);
    }

    @Test
    void listBook() {
        book.setBookName("4");
        List<Book> books = bookService.listBook(book, pageBean);
        for (Book book1 : books) {
            System.out.println(book1);
        }
    }
}
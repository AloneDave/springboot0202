package net.hnkj.springboot0202.model;

import lombok.ToString;

import java.io.Serializable;

@ToString
public class Book implements Serializable {
    private Integer bookId;

    private String bookName;

    private Float bookPrice;

    public Book(Integer bookId, String bookName, Float bookPrice) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookPrice = bookPrice;
    }

    public Book() {
        super();
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Float getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(Float bookPrice) {
        this.bookPrice = bookPrice;
    }
}
package com.example.jpahibernate.Book;

import javax.persistence.*;

@Entity
@Table(name = "Book")
@NamedQueries({
        @NamedQuery(name = "Book.findAll", query = "select b from Book b where b.price < 50")
})
public class Book {
    private Integer bookId;
    private String title;
    private String author;
    private float price;
    @Id
    @Column(name="book_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getBook_id() {
        return bookId;
    }

    public void setBook_id(Integer book_id) {
        this.bookId = book_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}

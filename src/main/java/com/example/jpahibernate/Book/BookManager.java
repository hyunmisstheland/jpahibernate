package com.example.jpahibernate.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class BookManager {
    static EntityManagerFactory factory;
    static EntityManager entityManager;
    public static void main(String[] args){
        begin();
        query();
        end();
    }

    private static void end() {
        entityManager.getTransaction().commit();
        entityManager.close();
        factory.close();
    }
    private static void query(){
        String qryStatement = "Select b From Book b where b.price < 30";
        Query query = entityManager.createQuery(qryStatement);
        List<Book> resultList = query.getResultList();
        for(Book aBook: resultList){
            System.out.println(aBook.getTitle());
        }
    }
    private static void begin() {
        factory = Persistence.createEntityManagerFactory("BookUnit");
        entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
    }
    private static void delete(){
        Integer bookId = 2;
        Book book = entityManager.find(Book.class, bookId);
        if(book != null){
            entityManager.remove(book);
        }else{
            System.out.println("Invalid book id");
        }
    }
    private static void read(){
        Integer bookId = 3;
        Book book = entityManager.find(Book.class, bookId);
        if(book != null){
            System.out.println(book.getTitle());
            System.out.println(book.getAuthor());
            System.out.println(book.getPrice());
        }else{
            System.out.println("Invalid book id");
        }
    }
    private static void create() {
        Book newBook = new Book();
        newBook.setTitle("Thinking in Javascript");
        newBook.setAuthor("Bruce Eckel");
        newBook.setPrice(20.5F);
        entityManager.persist(newBook);
    }
    private static void update(){
        Book existedBook = new Book();
        Integer bookId = 1;
        existedBook.setBook_id(bookId);
        existedBook.setTitle("Thinking in Javascript Version 2.0");
        existedBook.setAuthor("NTH");
        existedBook.setPrice(40.5F);
        entityManager.merge(existedBook);
    }
}

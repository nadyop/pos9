package com.blibli.dao_api;

import com.blibli.model.Book;

import java.util.List;

public interface BookDaoInterface {
    List<Book> getAllBooks();
    List<Book> getAllBooksDiscount();
    List<Book> getAllBooksEmty();
    List<Book> search(String searchKey);
    List<Book> searchDiscount(String searchKey);
    List<Book> searchEmptyBook(String searchKey);
    Book getIdBook(int idBook);
    void saveBook(Book book);
    void softDelete(Book book);
    void deleteBook(int idBook);
}

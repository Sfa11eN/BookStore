package com.example.onlinebookstore;

import java.util.List;

public interface BookService {
    void addBook(Book book);

    Book getBookById(int id);

    List<Book> getAllBooks();

    void updateBook(Book book);

    void deleteBook(int id);
}

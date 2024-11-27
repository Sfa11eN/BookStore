package com.example.onlinebookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class BookServiceImpl implements BookService {
    private static final Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);
    private Map<Integer, Book> books = new HashMap<>();

    @Override
    public void addBook(Book book) {
        if (book.getPrice() < 0) {
            logger.error("Price cannot be negative");
            throw new IllegalArgumentException("Price cannot be negative");
        }
        books.put(book.getId(), book);
        logger.info("Book added: {}", book);
    }

    @Override
    public Book getBookById(int id) {
        Book book = books.get(id);
        if (book != null) {
            logger.info("Book found: {}", book);
        } else {
            logger.warn("Book with id {} not found", id);
        }
        return book;
    }

    @Override
    public List<Book> getAllBooks() {
        List<Book> allBooks = new ArrayList<>(books.values());
        logger.info("Retrieved all books: {}", allBooks);
        return allBooks;
    }

    @Override
    public void updateBook(Book book) {
        if (books.containsKey(book.getId())) {
            books.put(book.getId(), book);
            logger.info("Book updated: {}", book);
        } else {
            logger.error("Book with id {} does not exist", book.getId());
            throw new IllegalArgumentException("Book with id " + book.getId() + " does not exist");
        }
    }

    @Override
    public void deleteBook(int id) {
        Book removedBook = books.remove(id);
        if (removedBook != null) {
            logger.info("Book deleted: {}", removedBook);
        } else {
            logger.warn("Book with id {} not found", id);
        }
    }
}

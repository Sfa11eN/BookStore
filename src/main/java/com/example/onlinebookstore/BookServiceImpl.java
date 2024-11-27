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
            logger.error("Цена не может быть отрицательной");
            throw new IllegalArgumentException("Цена не может быть отрицательной");
        }
        books.put(book.getId(), book);
        logger.info("Книга добавлена: {}", book);
    }

    @Override
    public Book getBookById(int id) {
        Book book = books.get(id);
        if (book != null) {
            logger.info("Книга получена: {}", book);
        } else {
            logger.warn("Книга с id {} не найдена", id);
        }
        return book;
    }

    @Override
    public List<Book> getAllBooks() {
        List<Book> allBooks = new ArrayList<>(books.values());
        logger.info("Извлеченные книги: {}", allBooks);
        return allBooks;
    }

    @Override
    public void updateBook(Book book) {
        if (books.containsKey(book.getId())) {
            books.put(book.getId(), book);
            logger.info("Книга обновлена: {}", book);
        } else {
            logger.error("Книга с id {} не найдена", book.getId());
            throw new IllegalArgumentException("Книга с id" + book.getId() + " не найдена");
        }
    }

    @Override
    public void deleteBook(int id) {
        Book removedBook = books.remove(id);
        if (removedBook != null) {
            logger.info("Книга удалена: {}", removedBook);
        } else {
            logger.warn("Книга с id {} не найдена", id);
        }
    }
}

package com.example.onlinebookstore;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookServiceTest {
    private BookService bookService;

    @BeforeEach
    void setUp() {
        bookService = new BookServiceImpl();
    }

    @Test
    void testAddBook() {
        Book book = new Book(1, "Законы медицины", "Джон Скотт", 29.99);
        bookService.addBook(book);
        assertEquals(book, bookService.getBookById(1));
    }

    @Test
    void testGetBookById() {
        Book book = new Book(2, "Новые горизонты", "Яна Ристор", 24.99);
        bookService.addBook(book);
        assertEquals(book, bookService.getBookById(2));
    }

    @Test
    void testGetAllBooks() {
        bookService.addBook(new Book(3, "В руках врага", "Алиса Робинсон", 34.99));
        bookService.addBook(new Book(4, "Умный Глупец", "Марк Копполо", 19.99));
        List<Book> books = bookService.getAllBooks();
        assertEquals(2, books.size());
    }

    @Test
    void testUpdateBook() {
        Book book = new Book(5, "Физика химика", "Даррен Хейес", 29.99);
        bookService.addBook(book);
        book.setPrice(39.99);
        bookService.updateBook(book);
        assertEquals(39.99, bookService.getBookById(5).getPrice());
    }

    @Test
    void testDeleteBook() {
        Book book = new Book(6, "Законы медицины", "Джон Скотт", 29.99);
        bookService.addBook(book);
        bookService.deleteBook(6);
        assertNull(bookService.getBookById(6));
    }
}

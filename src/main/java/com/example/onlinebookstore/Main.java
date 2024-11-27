package com.example.onlinebookstore;

public class Main {
    public static void main(String[] args) {
        BookService bookService = new BookServiceImpl();
        ConsoleUI consoleUI = new ConsoleUI(bookService);
        consoleUI.start();
    }
}
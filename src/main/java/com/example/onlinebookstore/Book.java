package com.example.onlinebookstore;

/**
 * Класс, представляющий книгу в онлайн-магазине.
 */
public class Book {
    private int id;
    private String title;
    private String author;
    private double price;

    /**
     * Конструктор для создания объекта Book.
     *
     * @param id     Идентификатор книги.
     * @param title  Название книги.
     * @param author Автор книги.
     * @param price  Цена книги.
     */
    public Book(int id, String title, String author, double price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Геттеры и сеттеры

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }
}

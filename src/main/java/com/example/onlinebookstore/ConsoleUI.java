package com.example.onlinebookstore;

import java.util.List;
import java.util.Scanner;

public class ConsoleUI {
    private BookService bookService;

    public ConsoleUI(BookService bookService) {
        this.bookService = bookService;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Добавить книгу");
            System.out.println("2. Найти книгу по id");
            System.out.println("3. Получить все книги");
            System.out.println("4. Обновить книгу");
            System.out.println("5. Удалить книгу");
            System.out.println("6. Выход");
            System.out.print("Выберите действие: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addBook(scanner);
                    break;
                case 2:
                    getBookById(scanner);
                    break;
                case 3:
                    getAllBooks();
                    break;
                case 4:
                    updateBook(scanner);
                    break;
                case 5:
                    deleteBook(scanner);
                    break;
                case 6:
                    System.out.println("Выход...");
                    return;
                default:
                    System.out.println("Неизвестная команда");
            }
        }
    }

    private void addBook(Scanner scanner) {
        System.out.print("Введите id: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Введите название книги: ");
        String title = scanner.nextLine();
        System.out.print("Введите автора книги: ");
        String author = scanner.nextLine();
        System.out.print("Введите стоимость книги: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        Book book = new Book(id, title, author, price);
        bookService.addBook(book);
        System.out.println("Книга успешно добавлена");
    }

    private void getBookById(Scanner scanner) {
        System.out.print("Введите id книги: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline

        Book book = bookService.getBookById(id);
        if (book != null) {
            System.out.println(book);
        } else {
            System.out.println("Книга не найдена");
        }
    }

    private void getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        if (books.isEmpty()) {
            System.out.println("Не найдено ни одной книги");
        } else {
            books.forEach(System.out::println);
        }
    }

    private void updateBook(Scanner scanner) {
        System.out.print("Ввели id книги: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Введите новое название книги: ");
        String title = scanner.nextLine();
        System.out.print("Введите нового автора книги: ");
        String author = scanner.nextLine();
        System.out.print("Введите новую стоимость книги: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // consume newline

        Book book = new Book(id, title, author, price);
        bookService.updateBook(book);
        System.out.println("Книга успешно обновлена");
    }

    private void deleteBook(Scanner scanner) {
        System.out.print("Ввели id книги: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        bookService.deleteBook(id);
        System.out.println("Книга успешно удалена");
    }
}
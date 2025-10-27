package org.example.knjizara.data;


import org.example.knjizara.model.Author;
import org.example.knjizara.model.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DemoData {
    private List<Author> authors = new ArrayList<>();
    private List<Book> books = new ArrayList<>();

    public DemoData() {
        // Kreiraj autore
        Author a1 = new Author(1L, "George Orwell", "British", 1903, "orwell@mail.com");
        Author a2 = new Author(2L, "J.K. Rowling", "British", 1965, "jkrowling@mail.com");

        // Kreiraj knjige
        Book b1 = new Book(1L, "1984", "Dystopian", 1949, 12.99, a1);
        Book b2 = new Book(2L, "Animal Farm", "Political satire", 1945, 9.99, a1);
        Book b3 = new Book(3L, "Harry Potter and the Sorcerer's Stone", "Fantasy", 1997, 14.99, a2);
        Book b4 = new Book(4L, "Harry Potter and the Chamber of Secrets", "Fantasy", 1998, 15.99, a2);

        // Dodaj knjige autorima
        a1.addBook(b1);
        a1.addBook(b2);
        a2.addBook(b3);
        a2.addBook(b4);

        authors.add(a1);
        authors.add(a2);
        books.addAll(List.of(b1, b2, b3, b4));
    }

    public List<Author> getAuthors() { return authors; }
    public List<Book> getBooks() { return books; }
    public Author findAuthorById(Long id) {
        return authors.stream().filter(a -> a.getId().equals(id)).findFirst().orElse(null);
    }
}

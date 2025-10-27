package org.example.knjizara.model;

import java.util.ArrayList;
import java.util.List;

public class Author {
    private Long id;
    private String name;
    private String nationality;
    private int birthYear;
    private String email;
    private List<Book> books = new ArrayList<>();

    public Author(Long id, String name, String nationality, int birthYear, String email) {
        this.id = id;
        this.name = name;
        this.nationality = nationality;
        this.birthYear = birthYear;
        this.email = email;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getNationality() { return nationality; }
    public int getBirthYear() { return birthYear; }
    public String getEmail() { return email; }
    public List<Book> getBooks() { return books; }

    public void addBook(Book book) {
        books.add(book);
    }
}

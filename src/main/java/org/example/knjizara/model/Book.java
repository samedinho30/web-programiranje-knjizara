package org.example.knjizara.model;


public class Book {
    private Long id;
    private String title;
    private String genre;
    private int year;
    private double price;
    private Author author;

    public Book(Long id, String title, String genre, int year, double price, Author author) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.price = price;
        this.author = author;
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getGenre() { return genre; }
    public int getYear() { return year; }
    public double getPrice() { return price; }
    public Author getAuthor() { return author; }
}

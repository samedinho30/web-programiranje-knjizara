package org.example.knjizara.model;

import jakarta.persistence.*;

@Entity
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String reviewerName;
    private Integer rating; // 1-5 stars
    private String comment;
    private Integer year; // Changed from int to Integer to allow null values

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    public Review() {}

    public Review(String reviewerName, Integer rating, String comment, Integer year, Book book) { // Changed year parameter type to Integer
        this.reviewerName = reviewerName;
        this.rating = rating;
        this.comment = comment;
        this.year = year;
        this.book = book;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getReviewerName() { return reviewerName; }
    public void setReviewerName(String reviewerName) { this.reviewerName = reviewerName; }

    public Integer getRating() { return rating; }
    public void setRating(Integer rating) { this.rating = rating; }

    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }

    public Integer getYear() { return year; } // Changed return type to Integer
    public void setYear(Integer year) { this.year = year; } // Changed parameter type to Integer

    public Book getBook() { return book; }
    public void setBook(Book book) { this.book = book; }
}

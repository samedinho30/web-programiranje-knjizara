package org.example.knjizara.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String nationality;
    private Integer birthYear;
    private String email;

    @JsonIgnore
    @OneToMany(mappedBy = "author")
    private List<Book> books;

    public Author() {}

    public Author(Long id, String name, String nationality, Integer birthYear, String email) {
        this.id = id;
        this.name = name;
        this.nationality = nationality;
        this.birthYear = birthYear;
        this.email = email;
    }

    // Getteri i setteri
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getNationality() { return nationality; }
    public void setNationality(String nationality) { this.nationality = nationality; }

    public Integer getBirthYear() { return birthYear; }
    public void setBirthYear(Integer birthYear) { this.birthYear = birthYear; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public List<Book> getBooks() { return books; }
    public void setBooks(List<Book> books) { this.books = books; }
}

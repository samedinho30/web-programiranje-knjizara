package org.example.knjizara.data;

import org.example.knjizara.model.Author;
import org.example.knjizara.model.Book;
import org.example.knjizara.model.Review;
import org.example.knjizara.repository.AuthorRepository;
import org.example.knjizara.repository.BookRepository;
import org.example.knjizara.repository.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DemoData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final ReviewRepository reviewRepository;

    public DemoData(AuthorRepository authorRepository, BookRepository bookRepository, ReviewRepository reviewRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.reviewRepository = reviewRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Check if authors already exist to prevent duplicate data on restart
        if (authorRepository.findAll().size() > 0) {
            return; // Data already exists, skip loading
        }

        Author a1 = new Author();
        a1.setName("George Orwell");
        a1.setNationality("British");
        a1.setBirthYear(1903);
        a1.setEmail("george@example.com");
        authorRepository.save(a1);

        Author a2 = new Author();
        a2.setName("J.K. Rowling");
        a2.setNationality("British");
        a2.setBirthYear(1965);
        a2.setEmail("jk@example.com");
        authorRepository.save(a2);

        // Kreiraj knjige
        Book b1 = new Book();
        b1.setTitle("1984");
        b1.setGenre("Dystopian");
        b1.setYear(1949);
        b1.setPrice(12.99);
        b1.setAuthor(a1);
        bookRepository.save(b1);

        Book b2 = new Book();
        b2.setTitle("Animal Farm");
        b2.setGenre("Political satire");
        b2.setYear(1945);
        b2.setPrice(9.99);
        b2.setAuthor(a1);
        bookRepository.save(b2);

        Book b3 = new Book();
        b3.setTitle("Harry Potter and the Sorcerer's Stone");
        b3.setGenre("Fantasy");
        b3.setYear(1997);
        b3.setPrice(14.99);
        b3.setAuthor(a2);
        bookRepository.save(b3);

        Book b4 = new Book();
        b4.setTitle("Harry Potter and the Chamber of Secrets");
        b4.setGenre("Fantasy");
        b4.setYear(1998);
        b4.setPrice(15.99);
        b4.setAuthor(a2);
        bookRepository.save(b4);

        Review r1 = new Review("John Smith", 5, "Amazing dystopian novel!", 2024, b1);
        reviewRepository.save(r1);

        Review r2 = new Review("Jane Doe", 4, "Great allegory about power.", 2024, b2);
        reviewRepository.save(r2);

        Review r3 = new Review("Mark Wilson", 5, "Best fantasy series ever!", 2024, b3);
        reviewRepository.save(r3);

        Review r4 = new Review("Sarah Connor", 4, "Excellent continuation of the story.", 2024, b4);
        reviewRepository.save(r4);
    }
}

package org.example.knjizara.data;


import org.example.knjizara.model.Author;
import org.example.knjizara.model.Book;
import org.example.knjizara.repository.AuthorRepository;
import org.example.knjizara.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DemoData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public DemoData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Kreiraj autore
        Author a1 = new Author();
        a1.setName("George Orwell");
        authorRepository.save(a1);

        Author a2 = new Author();
        a2.setName("J.K. Rowling");
        authorRepository.save(a2);

        // Kreiraj knjige i poveži s autorima
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
    }
}



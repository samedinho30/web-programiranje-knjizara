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
        // Autori
        Author a1 = new Author(1L, "George Orwell", "British", 1903, "orwell@mail.com");
        Author a2 = new Author(2L, "J.K. Rowling", "British", 1965, "jkrowling@mail.com");
        Author a3 = new Author(3L, "J.R.R. Tolkien", "British", 1892, "tolkien@mail.com");
        Author a4 = new Author(4L, "Agatha Christie", "British", 1890, "christie@mail.com");
        Author a5 = new Author(5L, "Leo Tolstoy", "Russian", 1828, "tolstoy@mail.com");
        Author a6 = new Author(6L, "Mark Twain", "American", 1835, "twain@mail.com");
        Author a7 = new Author(7L, "F. Scott Fitzgerald", "American", 1896, "fitzgerald@mail.com");
        Author a8 = new Author(8L, "Mary Shelley", "British", 1797, "shelley@mail.com");

        // Knjige Georgea Orwella
        Book b1 = new Book(1L, "1984", "Dystopian", 1949, 12.99, a1);
        Book b2 = new Book(2L, "Animal Farm", "Political satire", 1945, 9.99, a1);
        Book b3 = new Book(3L, "Homage to Catalonia", "Memoir", 1938, 11.49, a1);

        // Knjige J.K. Rowling
        Book b4 = new Book(4L, "Harry Potter and the Sorcerer's Stone", "Fantasy", 1997, 14.99, a2);
        Book b5 = new Book(5L, "Harry Potter and the Chamber of Secrets", "Fantasy", 1998, 15.99, a2);
        Book b6 = new Book(6L, "Harry Potter and the Prisoner of Azkaban", "Fantasy", 1999, 16.99, a2);

        // Knjige J.R.R. Tolkiena
        Book b7 = new Book(7L, "The Hobbit", "Fantasy", 1937, 13.99, a3);
        Book b8 = new Book(8L, "The Lord of the Rings", "Fantasy", 1954, 29.99, a3);
        Book b9 = new Book(9L, "The Silmarillion", "Fantasy", 1977, 19.99, a3);

        // Knjige Agathe Christie
        Book b10 = new Book(10L, "Murder on the Orient Express", "Mystery", 1934, 11.99, a4);
        Book b11 = new Book(11L, "And Then There Were None", "Mystery", 1939, 10.99, a4);
        Book b12 = new Book(12L, "The Murder of Roger Ackroyd", "Mystery", 1926, 12.49, a4);

        // Knjige Lea Tolstoja
        Book b13 = new Book(13L, "War and Peace", "Historical fiction", 1869, 19.99, a5);
        Book b14 = new Book(14L, "Anna Karenina", "Drama", 1877, 17.99, a5);
        Book b15 = new Book(15L, "The Death of Ivan Ilyich", "Novella", 1886, 9.99, a5);

        // Knjige Marka Twaina
        Book b16 = new Book(16L, "The Adventures of Tom Sawyer", "Adventure", 1876, 12.49, a6);
        Book b17 = new Book(17L, "Adventures of Huckleberry Finn", "Adventure", 1884, 13.49, a6);
        Book b18 = new Book(18L, "A Connecticut Yankee in King Arthur's Court", "Satire", 1889, 11.99, a6);

        // Knjige F. Scott Fitzgeralda
        Book b19 = new Book(19L, "The Great Gatsby", "Tragedy", 1925, 14.49, a7);
        Book b20 = new Book(20L, "Tender is the Night", "Drama", 1934, 15.49, a7);
        Book b21 = new Book(21L, "This Side of Paradise", "Novel", 1920, 12.99, a7);

        // Knjige Mary Shelley
        Book b22 = new Book(22L, "Frankenstein", "Horror", 1818, 11.99, a8);
        Book b23 = new Book(23L, "The Last Man", "Science Fiction", 1826, 13.99, a8);
        Book b24 = new Book(24L, "Mathilda", "Novella", 1819, 10.99, a8);

        // Dodaj knjige autorima
        a1.addBook(b1); a1.addBook(b2); a1.addBook(b3);
        a2.addBook(b4); a2.addBook(b5); a2.addBook(b6);
        a3.addBook(b7); a3.addBook(b8); a3.addBook(b9);
        a4.addBook(b10); a4.addBook(b11); a4.addBook(b12);
        a5.addBook(b13); a5.addBook(b14); a5.addBook(b15);
        a6.addBook(b16); a6.addBook(b17); a6.addBook(b18);
        a7.addBook(b19); a7.addBook(b20); a7.addBook(b21);
        a8.addBook(b22); a8.addBook(b23); a8.addBook(b24);

        // Dodaj autore i knjige u listu
        authors.addAll(List.of(a1, a2, a3, a4, a5, a6, a7, a8));
        books.addAll(List.of(
                b1, b2, b3, b4, b5, b6, b7, b8, b9,
                b10, b11, b12, b13, b14, b15, b16, b17, b18,
                b19, b20, b21, b22, b23, b24
        ));
    }

    public List<Author> getAuthors() { return authors; }
    public List<Book> getBooks() { return books; }
    public Author findAuthorById(Long id) {
        return authors.stream().filter(a -> a.getId().equals(id)).findFirst().orElse(null);
    }
}

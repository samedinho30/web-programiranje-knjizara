package org.example.knjizara.controller;

import org.example.knjizara.model.Author;
import org.example.knjizara.model.Book;
import org.example.knjizara.repository.AuthorRepository;
import org.example.knjizara.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class AppController {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    // Lista autora
    @GetMapping("/autori")
    public String listAuthors(Model model) {
        model.addAttribute("authors", authorRepository.findAll());
        return "listA";
    }

    // Lista knjiga
    @GetMapping("/knjige")
    public String listBooks(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "listB";
    }

    // Akcija: prikaz svih knjiga jednog autora
    @GetMapping("/autori/autoriPoId/{id}")
    public String showAuthorBooks(@PathVariable Long id, Model model) {
        Author author = authorRepository.findById(id).orElse(null);
        if (author == null) {
            model.addAttribute("error", "Author not found!");
            return "action";
        }

        // Dohvati sve knjige autora
        List<Book> booksByAuthor = bookRepository.findByAuthorId(id);

        model.addAttribute("author", author);
        model.addAttribute("books", booksByAuthor);
        return "action";
    }
}

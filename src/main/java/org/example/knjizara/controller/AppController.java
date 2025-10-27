package org.example.knjizara.controller;


import org.example.knjizara.data.DemoData;
import org.example.knjizara.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AppController {

    @Autowired
    private DemoData demoData;

    // Lista autora
    @GetMapping("/autori")
    public String listAuthors(Model model) {
        model.addAttribute("authors", demoData.getAuthors());
        return "listA";
    }

    // Lista knjiga
    @GetMapping("/knjige")
    public String listBooks(Model model) {
        model.addAttribute("books", demoData.getBooks());
        return "listB";
    }

    // Akcija: prikaz svih knjiga jednog autora
    @GetMapping("/autori/autoriPoId/{id}")
    public String showAuthorBooks(@PathVariable Long id, Model model) {
        Author author = demoData.findAuthorById(id);
        if (author == null) {
            model.addAttribute("error", "Author not found!");
            return "action";
        }
        model.addAttribute("author", author);
        model.addAttribute("books", author.getBooks());
        return "action";
    }
}

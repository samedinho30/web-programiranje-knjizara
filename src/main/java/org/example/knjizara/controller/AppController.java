package org.example.knjizara.controller;

import org.example.knjizara.model.Author;
import org.example.knjizara.model.Book;
import org.example.knjizara.model.Review;
import org.example.knjizara.repository.AuthorRepository;
import org.example.knjizara.repository.BookRepository;
import org.example.knjizara.repository.ReviewRepository;
import org.example.knjizara.services.AuthorService;
import org.example.knjizara.services.BookService;
import org.example.knjizara.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class AppController {

    private final AuthorService authorService;
    private final BookService bookService;
    private final ReviewService reviewService;

    public AppController(AuthorService authorService, BookService bookService, ReviewService reviewService) {
        this.authorService = authorService;
        this.bookService = bookService;
        this.reviewService = reviewService;
    }

    // HOME
    @GetMapping("/")
    public String index() {
        return "index";
    }

    // AUTHOR - GET
    @GetMapping("/authors")
    public String authorsListPage(Model model) {
        model.addAttribute("authors", authorService.getAllAuthors());
        return "authors-list";
    }

    @GetMapping("/authors/new")
    public String authorFormPage(Model model) {
        model.addAttribute("author", new Author());
        return "author-form";
    }

    @GetMapping("/authors/{id}")
    public String authorDetailsPage(@PathVariable Long id, Model model) {
        Optional<Author> author = authorService.getAuthorById(id);
        if (author.isPresent()) {
            model.addAttribute("author", author.get());
            model.addAttribute("books", bookService.getBooksByAuthorId(id));
            return "author-details";
        }
        return "redirect:/authors";
    }

    @GetMapping("/authors/{id}/edit")
    public String authorEditPage(@PathVariable Long id, Model model) {
        Optional<Author> author = authorService.getAuthorById(id);
        if (author.isPresent()) {
            model.addAttribute("author", author.get());
            return "author-form";
        }
        return "redirect:/authors";
    }

    // AUTHOR - POST/PUT
    @PostMapping("/authors")
    public String saveAuthor(@ModelAttribute Author author) {
        authorService.createAuthor(author);
        return "redirect:/authors";
    }

    @PostMapping("/authors/{id}")
    public String updateAuthor(@PathVariable Long id, @ModelAttribute Author authorForm) {
        authorService.updateAuthor(id, authorForm);
        return "redirect:/authors/" + id;
    }

    @PutMapping("/authors/{id}")
    @ResponseBody
    public Author updateAuthorPut(@PathVariable Long id, @RequestBody Author authorForm) {
        return authorService.updateAuthor(id, authorForm);
    }

    @GetMapping("/authors/{id}/delete")
    public String deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
        return "redirect:/authors";
    }

    // BOOK - GET
    @GetMapping("/books")
    public String booksListPage(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "books-list";
    }

    @GetMapping("/books/new")
    public String bookFormPage(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("authors", authorService.getAllAuthors());
        return "book-form";
    }

    @GetMapping("/books/{id}")
    public String bookDetailsPage(@PathVariable Long id, Model model) {
        Optional<Book> book = bookService.getBookById(id);
        if (book.isPresent()) {
            model.addAttribute("book", book.get());
            model.addAttribute("reviews", reviewService.getReviewsByBookId(id));
            return "book-details";
        }
        return "redirect:/books";
    }

    @GetMapping("/books/{id}/edit")
    public String bookEditPage(@PathVariable Long id, Model model) {
        Optional<Book> book = bookService.getBookById(id);
        if (book.isPresent()) {
            model.addAttribute("book", book.get());
            model.addAttribute("authors", authorService.getAllAuthors());
            return "book-form";
        }
        return "redirect:/books";
    }

    // BOOK - POST/PUT
    @PostMapping("/books")
    public String saveBook(@ModelAttribute Book book) {
        bookService.createBook(book);
        return "redirect:/books";
    }

    @PostMapping("/books/{id}")
    public String updateBook(@PathVariable Long id, @ModelAttribute Book bookForm) {
        bookService.updateBook(id, bookForm);
        return "redirect:/books/" + id;
    }

    @PutMapping("/books/{id}")
    @ResponseBody
    public Book updateBookPut(@PathVariable Long id, @RequestBody Book bookForm) {
        return bookService.updateBook(id, bookForm);
    }

    @GetMapping("/books/{id}/delete")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }

    // REVIEW - GET
    @GetMapping("/reviews")
    public String reviewsListPage(Model model) {
        model.addAttribute("reviews", reviewService.getAllReviews());
        return "reviews-list";
    }

    @GetMapping("/books/{bookId}/reviews/new")
    public String reviewFormPage(@PathVariable Long bookId, Model model) {
        Review review = new Review();
        Optional<Book> book = bookService.getBookById(bookId);
        if (book.isPresent()) {
            review.setBook(book.get());
            model.addAttribute("review", review);
            model.addAttribute("books", bookService.getAllBooks());
            return "review-form";
        }
        return "redirect:/books";
    }

    @GetMapping("/reviews/{id}")
    public String reviewDetailsPage(@PathVariable Long id, Model model) {
        Optional<Review> review = reviewService.getReviewById(id);
        if (review.isPresent()) {
            model.addAttribute("review", review.get());
            return "review-details";
        }
        return "redirect:/reviews";
    }

    @GetMapping("/reviews/{id}/edit")
    public String reviewEditPage(@PathVariable Long id, Model model) {
        Optional<Review> review = reviewService.getReviewById(id);
        if (review.isPresent()) {
            model.addAttribute("review", review.get());
            model.addAttribute("books", bookService.getAllBooks());
            return "review-form";
        }
        return "redirect:/reviews";
    }

    // REVIEW - POST/PUT
    @PostMapping("/reviews")
    public String saveReview(@ModelAttribute Review review, @RequestParam(required = false) Long bookId) {
        System.out.println("[v0] Review: " + review);
        System.out.println("[v0] BookId: " + bookId);
        System.out.println("[v0] Review.book: " + review.getBook());
        System.out.println("[v0] Review.rating: " + review.getRating());

        if (review.getRating() == null || review.getRating() < 1 || review.getRating() > 5) {
            System.out.println("[v0] Invalid rating: " + review.getRating());
            return "redirect:/reviews";
        }

        if (bookId != null) {
            Book book = new Book();
            book.setId(bookId);
            review.setBook(book);
        }

        Review savedReview = reviewService.createReview(review);
        if (savedReview.getBook() != null && savedReview.getBook().getId() != null) {
            return "redirect:/books/" + savedReview.getBook().getId();
        }
        return "redirect:/reviews";
    }

    @PostMapping("/reviews/{id}")
    public String updateReview(@PathVariable Long id, @ModelAttribute Review reviewForm) {
        reviewService.updateReview(id, reviewForm);
        return "redirect:/reviews/" + id;
    }

    @PutMapping("/reviews/{id}")
    @ResponseBody
    public Review updateReviewPut(@PathVariable Long id, @RequestBody Review reviewForm) {
        Optional<Review> existingReview = reviewService.getReviewById(id);
        if (existingReview.isPresent()) {
            Review review = existingReview.get();

            // Update only the fields provided
            if (reviewForm.getReviewerName() != null) {
                review.setReviewerName(reviewForm.getReviewerName());
            }
            if (reviewForm.getRating() != null && reviewForm.getRating() >= 1 && reviewForm.getRating() <= 5) {
                review.setRating(reviewForm.getRating());
            }
            if (reviewForm.getComment() != null) {
                review.setComment(reviewForm.getComment());
            }
            if (reviewForm.getYear() != null) {
                review.setYear(reviewForm.getYear());
            }

            // If book ID is provided, load it from repository
            if (reviewForm.getBook() != null && reviewForm.getBook().getId() != null) {
                Optional<Book> book = bookService.getBookById(reviewForm.getBook().getId());
                if (book.isPresent()) {
                    review.setBook(book.get());
                }
            }

            return reviewService.createReview(review);
        }
        return null;
    }

    @GetMapping("/reviews/{id}/delete")
    public String deleteReview(@PathVariable Long id) {
        Optional<Review> review = reviewService.getReviewById(id);
        reviewService.deleteReview(id);

        if (review.isPresent() && review.get().getBook() != null) {
            return "redirect:/books/" + review.get().getBook().getId();
        }
        return "redirect:/reviews";
    }

}

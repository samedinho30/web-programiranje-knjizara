package org.example.knjizara.services;

import org.example.knjizara.model.Author;
import org.example.knjizara.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Optional<Author> getAuthorById(Long id) {
        return authorRepository.findById(id);
    }

    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

    public Author updateAuthor(Long id, Author authorDetails) {
        Optional<Author> authorOpt = authorRepository.findById(id);
        if (authorOpt.isPresent()) {
            Author author = authorOpt.get();
            author.setName(authorDetails.getName());
            author.setNationality(authorDetails.getNationality());
            author.setBirthYear(authorDetails.getBirthYear());
            author.setEmail(authorDetails.getEmail());
            return authorRepository.save(author);
        }
        return null;
    }

    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }
}

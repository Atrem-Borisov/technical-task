package ru.borisov.technical.task.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.borisov.technical.task.models.Author;
import ru.borisov.technical.task.models.Book;
import ru.borisov.technical.task.repositories.AuthorRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class AuthorService {

    private final AuthorRepository authorRepository;
    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Book> getBooksByAuthor(Author author){
        return author.getBooks();
    }

    public Author getAuthor(Long id){
        Optional<Author> findAuthor = authorRepository.findById(id);

        return findAuthor.orElse(null);
    }
    @Transactional
    public Author saveAuthor(String name, List<Book> books){
        Author author = new Author();
        author.setName(name);
        author.setBooks(books);
        authorRepository.save(author);
        return author;
    }

}

package ru.borisov.technical.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import ru.borisov.technical.task.models.Author;
import ru.borisov.technical.task.models.Book;
import ru.borisov.technical.task.service.AuthorService;
import ru.borisov.technical.task.service.BookService;

import java.util.List;
import java.util.Optional;

@Controller
public class AuthorController {

    private final AuthorService authorService;
    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }
    @QueryMapping
    public List<Book> getBooksByAuthor(@Argument  Author author){
        return author.getBooks();
    }
    @QueryMapping
    public Author getAuthor(@Argument Long id){
        return authorService.getAuthor(id);
    }
    @MutationMapping
    public Author saveAuthor(String name, List<Book> books){
        return authorService.saveAuthor(name, books);
    }

}

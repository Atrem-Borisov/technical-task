package ru.borisov.technical.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import ru.borisov.technical.task.models.Author;
import ru.borisov.technical.task.models.Book;
import ru.borisov.technical.task.service.BookService;

import java.util.List;

@Controller
public class BookController {

    private final BookService bookService;
    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @QueryMapping
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }
    @MutationMapping
    public Book saveBook(String title, List<Author> authors){
        return bookService.saveBook(title,authors);
    }
}

package ru.borisov.technical.task.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.borisov.technical.task.models.Author;
import ru.borisov.technical.task.models.Book;
import ru.borisov.technical.task.service.AuthorService;
import ru.borisov.technical.task.service.BookService;

import java.util.List;
import java.util.Optional;

@Component
public class BookQuery implements GraphQLQueryResolver {
    @Autowired
    private BookService bookService;
    @Autowired
    private AuthorService authorService;

    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    public List<Book> getBooksByAuthor(Author author){
        return author.getBooks();
    }

    public Author getAuthor(Long id){
        return authorService.getAuthor(id);
    }

}

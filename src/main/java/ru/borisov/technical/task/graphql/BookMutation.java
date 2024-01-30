package ru.borisov.technical.task.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;
import ru.borisov.technical.task.models.Author;
import ru.borisov.technical.task.models.Book;
import ru.borisov.technical.task.service.AuthorService;
import ru.borisov.technical.task.service.BookService;

import java.util.List;

@Component
public class BookMutation implements GraphQLMutationResolver {

    private AuthorService authorService;
    private BookService bookService;

    public Author saveAuthor(String name, List<Book> books){
        return authorService.saveAuthor(name, books);
    }

    public Book saveBook(String title, List<Author> authors){
        return bookService.saveBook(title,authors);
    }

}

package ru.borisov.technical.task.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.borisov.technical.task.models.Author;
import ru.borisov.technical.task.models.Book;
import ru.borisov.technical.task.repositories.BookRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class BookService {

    private final BookRepository bookRepository;
    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public Book saveBook(String title, List<Author> authors){
        Book book = new Book();
        book.setTitle(title);
        book.setAuthors((Author) authors);
       return bookRepository.save(book);

    }
}

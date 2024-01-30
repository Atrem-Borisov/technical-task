package ru.borisov.technical.task.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.borisov.technical.task.models.Book;
@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
}

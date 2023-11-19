package ru.hpclab.bd.module1.repository;

import org.springframework.data.repository.CrudRepository;
import ru.hpclab.bd.module1.entity.BookEntity;
import ru.hpclab.bd.module1.entity.IssueEntity;
import ru.hpclab.bd.module1.model.Book;

import java.util.*;

public interface BookRepository extends CrudRepository<BookEntity, Long> {

    @Override
    List<BookEntity> findAll();


}
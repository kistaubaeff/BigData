package ru.hpclab.bd.module1.repository;

import org.springframework.data.repository.CrudRepository;
import ru.hpclab.bd.module1.entity.BookEntity;


import java.util.*;

public interface BookRepository extends CrudRepository<BookEntity, Long> {

    @Override
    List<BookEntity> findAll();

}

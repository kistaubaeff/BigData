package ru.hpclab.bd.module1.service;


import ru.hpclab.bd.module1.controller.exeption.BookException;
import ru.hpclab.bd.module1.entity.BookEntity;
import ru.hpclab.bd.module1.repository.BookRepository;
import java.util.List;

import static java.lang.String.format;

public class BookService {
    private final BookRepository bookRepository;
    public static final String BOOK_NOT_FOUND_MSG = "Book with ID %s not found";

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    public BookRepository getBookRepository() {
        return bookRepository;
    }


    public BookEntity getBookById(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new BookException(format(BOOK_NOT_FOUND_MSG, id)));
    }

    public BookEntity saveBook(BookEntity bookEntity) {
        return bookRepository.save(bookEntity);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public BookEntity updateBook(Long id, BookEntity bookEntity) {
        bookEntity.setId(id);
        //when id is not empty save works with update logic
        return bookRepository.save(bookEntity);
    }
    public List<BookEntity> getAllBooks() {
        return bookRepository.findAll();
    }

}

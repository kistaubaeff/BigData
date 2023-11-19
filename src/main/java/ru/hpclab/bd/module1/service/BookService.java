package ru.hpclab.bd.module1.service;

import ru.hpclab.bd.module1.controller.exeption.BookException;
import ru.hpclab.bd.module1.entity.BookEntity;
import ru.hpclab.bd.module1.repository.BookRepository;

import java.util.List;

import static java.lang.String.format;

/**
 * Service to manage books.
 */
public class BookService {

    private final BookRepository bookRepository;
    /**
     * Book exception not found message.
     */
    public static final String BOOK_NOT_FOUND_MSG = "Book with ID %s not found";

    /**
     * Constructor for BookService.
     *
     * @param bookRepository The book repository.
     */
    public BookService(final BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    /**
     * Get the book repository.
     *
     * @return The book repository.
     */
    public BookRepository getBookRepository() {
        return bookRepository;
    }

    /**
     * Get a book by its ID.
     *
     * @param id The ID of the book.
     * @return The book.
     * @throws BookException If the book is not found.
     */
    public BookEntity getBookById(final Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new BookException(format(BOOK_NOT_FOUND_MSG, id)));
    }

    /**
     * Save a book.
     *
     * @param bookEntity The book to save.
     * @return The saved book.
     */
    public BookEntity saveBook(final BookEntity bookEntity) {
        return bookRepository.save(bookEntity);
    }

    /**
     * Delete a book by its ID.
     *
     * @param id The ID of the book to delete.
     */
    public void deleteBook(final Long id) {
        bookRepository.deleteById(id);
    }

    /**
     * Update a book.
     *
     * @param id          The ID of the book to update.
     * @param bookEntity  The book with new attributes.
     * @return The updated book.
     */
    public BookEntity updateBook(final Long id, final BookEntity bookEntity) {
        bookEntity.setId(id);
        // when id is not empty, save works with update logic
        return bookRepository.save(bookEntity);
    }

    /**
     * Get all books.
     *
     * @return List of all books.
     */
    public List<BookEntity> getAllBooks() {
        return bookRepository.findAll();
    }
}

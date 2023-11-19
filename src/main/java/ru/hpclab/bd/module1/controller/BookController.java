package ru.hpclab.bd.module1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.hpclab.bd.module1.mapper.Mapper;
import ru.hpclab.bd.module1.model.Book;
import ru.hpclab.bd.module1.service.BookService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public final class BookController {
    private final BookService bookService;


    /**
     * Constructs a BookController with the specified parameters.
     * @param bookService book service
     */

    @Autowired
    public BookController(final BookService bookService) {
        this.bookService = bookService;
    }

    /**
     * Retrieves all books.
     *
     * @return List of books
     */
    @GetMapping("/books")
    public List<Book> getBooks() {
        return bookService.getAllBooks().stream()
                .map(Mapper::entity2Book).collect(Collectors.toList());
    }

    /**
     * Retrieves a book by its ID.
     *
     * @param id The ID of the book
     * @return The book with the specified ID
     */
    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable final Long id) {
        return Mapper.entity2Book(bookService.getBookById(id));
    }

    /**
     * Deletes a book by its ID.
     *
     * @param id The ID of the book to be deleted
     */
    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable final Long id) {
        bookService.deleteBook(id);
    }

    /**
     * Saves a new book.
     *
     * @param book The book to be saved
     * @return The saved book
     */
    @PostMapping("/books")
    public Book saveBook(@RequestBody final Book book) {
        return Mapper.entity2Book(bookService.saveBook(Mapper.book2Entity(book)));
    }

    /**
     * Updates a book by its ID.
     *
     * @param id   The ID of the book to be updated
     * @param book The updated book information
     * @return The updated book
     */
    @PutMapping("/books/{id}")
    public Book updateBook(@PathVariable(required = false) final Long id, @RequestBody final Book book) {
        return Mapper.entity2Book(bookService.updateBook(id, Mapper.book2Entity(book)));
    }
}

package ru.hpclab.bd.module1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.hpclab.bd.module1.mapper.UserMapper;
import ru.hpclab.bd.module1.model.Book;
import ru.hpclab.bd.module1.service.BookService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public List<Book> getBooks() {
        return bookService.getAllBooks().stream()
                .map(UserMapper::entity2Book).collect(Collectors.toList());
    }

    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable Long id) {
        return UserMapper.entity2Book(bookService.getBookById(id));
    }

    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }

    @PostMapping(value = "/books")
    public Book saveBook(@RequestBody Book book) {
        return UserMapper.entity2Book(bookService.saveBook(UserMapper.book2Entity(book)));
    }

    @PutMapping(value = "/books/{id}")
    public Book updateBook(@PathVariable(required = false) Long id, @RequestBody Book book) {
        return UserMapper.entity2Book(bookService.updateBook(id, UserMapper.book2Entity(book)));
    }

}

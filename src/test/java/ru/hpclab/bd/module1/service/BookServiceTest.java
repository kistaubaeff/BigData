package ru.hpclab.bd.module1.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.hpclab.bd.module1.entity.BookEntity;
import ru.hpclab.bd.module1.repository.BookRepository;

import java.util.Arrays;
import java.util.List;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {BookServiceTest.BookServiceTestConfiguration.class})
public class BookServiceTest {

    public static final String BOOK_ISBN = "9781234567890";
    public static final String BOOK_TITLE = "The Great Novel";
    public static final String BOOK_LIST_OF_AUTHORS = "Dostoevsky";
    public static final int BOOK_YEAR = 1866;
    public static final int BOOK_VOLUME = 100;


    @Autowired
    private BookService bookService;

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void testCreateAndGet() {
        //create
        BookEntity bookEntity = new BookEntity(0L, BOOK_ISBN, BOOK_TITLE, BOOK_LIST_OF_AUTHORS, BOOK_YEAR, BOOK_VOLUME);

        BookEntity savedBook = bookService.saveBook(bookEntity);

        Assertions.assertEquals(bookEntity.getIsbn(), savedBook.getIsbn());
        Mockito.verify(bookRepository, Mockito.times(1)).save(bookEntity);

        //getAll
        List<BookEntity> bookList = bookService.getAllBooks();

        Assertions.assertEquals("9789876543210", bookList.get(0).getIsbn());
        Assertions.assertEquals("9780123456789", bookList.get(1).getIsbn());
        Mockito.verify(bookRepository, Mockito.times(1)).findAll();

    }

    @Configuration
    static class BookServiceTestConfiguration {
        public static final int YEAR1 = 1954;
        public static final int VOL1 = 500;

        public static final int YEAR2 = 1939;
        public static final int VOL2 = 300;

        @Bean
        BookRepository bookRepository() {
            BookRepository bookRepository = mock(BookRepository.class);
            when(bookRepository.save(any())).thenReturn(new BookEntity(0L, BOOK_ISBN, BOOK_TITLE,
                    BOOK_LIST_OF_AUTHORS, BOOK_YEAR, BOOK_VOLUME));
            when(bookRepository.findAll())
                    .thenReturn(Arrays.asList(new BookEntity(1L, "9789876543210",
                            "Epic Adventure", "Tolkien", YEAR1, VOL1),
                            new BookEntity(2L, "9780123456789", "Mystery Thriller",
                                    "Agatha Christie", YEAR2, VOL2)));
            return bookRepository;
        }

        @Bean
        BookService BookService(final BookRepository bookRepository) {
            return new BookService(bookRepository);
        }
    }

}

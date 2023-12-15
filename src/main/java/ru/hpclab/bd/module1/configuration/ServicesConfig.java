package ru.hpclab.bd.module1.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.hpclab.bd.module1.entity.BookEntity;
import ru.hpclab.bd.module1.entity.UserEntity;
import ru.hpclab.bd.module1.repository.BookRepository;
import ru.hpclab.bd.module1.repository.IssueRepository;
import ru.hpclab.bd.module1.repository.UserRepository;
import ru.hpclab.bd.module1.service.BookService;
import ru.hpclab.bd.module1.service.IssueService;
import ru.hpclab.bd.module1.service.UserService;

import java.util.UUID;

@Configuration
public class ServicesConfig {

    private static final int NUMBER_OF_USERS = 5;
    private static final String DEFAULT_TITLE = "20000 leagues under the Seas";
    private static final String DEFAULT_AUTHOR = "Jules Verne";
    private static final int DEFAULT_YEAR = 1872;
    private static final String DEFAULT_ISBN = "9780679203735";
    private static final int DEFAULT_VOLUME = 56;

    /**
     * Configures and provides a UserService bean.
     *
     * @param userRepository The UserRepository used by the UserService.
     * @return An instance of UserService.
     */
    @Bean
    UserService userService(final UserRepository userRepository) {
        UserService userService = new UserService(userRepository);
        for (int i = 0; i < NUMBER_OF_USERS; i++) {
            UserEntity userEntity = new UserEntity();
            userEntity.setIdentifier(UUID.randomUUID().toString());
            userEntity.setFio("FIO" + i);
            userRepository.save(userEntity);
        }
        return userService;
    }

    /**
     * Configures and provides a BookService bean.
     *
     * @param bookRepository The BookRepository used by the BookService.
     * @return An instance of BookService.
     */
    @Bean
    BookService bookService(final BookRepository bookRepository) {
        BookService bookService = new BookService(bookRepository);
        BookEntity bookEntity = new BookEntity();
        bookEntity.setTitle(DEFAULT_TITLE);
        bookEntity.setListOfAuthors(DEFAULT_AUTHOR);
        bookEntity.setYear(DEFAULT_YEAR);
        bookEntity.setIsbn(DEFAULT_ISBN);
        bookEntity.setVolume(DEFAULT_VOLUME);
        bookService.saveBook(bookEntity);
        return bookService;
    }
    /**
     * Configures and provides an IssueService bean.
     *
     * @param issueRepository The IssueRepository used by the IssueService.
     * @param bookService     The BookService used by the IssueService.
     * @param userService     The UserService used by the IssueService.
     * @return An instance of IssueService.
     */
    @Bean
    IssueService issueService(final IssueRepository issueRepository,
                              final BookService bookService,
                              final UserService userService) {
        IssueService issueService = new IssueService(issueRepository,
                userService.getUserRepository(), bookService.getBookRepository());

        return issueService;
    }
}

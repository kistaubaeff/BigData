package ru.hpclab.bd.module1.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.hpclab.bd.module1.entity.BookEntity;
import ru.hpclab.bd.module1.entity.IssueEntity;
import ru.hpclab.bd.module1.entity.UserEntity;
import ru.hpclab.bd.module1.repository.BookRepository;
import ru.hpclab.bd.module1.repository.IssueRepository;
import ru.hpclab.bd.module1.repository.UserRepository;
import ru.hpclab.bd.module1.service.BookService;
import ru.hpclab.bd.module1.service.IssueService;
import ru.hpclab.bd.module1.service.UserService;

import java.util.Arrays;
import java.util.UUID;

@Configuration
public class ServicesConfig {

    @Bean
    UserService userService(UserRepository userRepository) {
        UserService userService = new UserService(userRepository);
        for (int i = 0; i < 5; i++) {
            UserEntity userEntity = new UserEntity();
            userEntity.setIdentifier(UUID.randomUUID().toString());
            userEntity.setFio("FIO" + i);
            userRepository.save(userEntity);
        }
        return userService;
    }

    @Bean
    BookService bookService(BookRepository bookRepository){
        BookService bookService = new BookService(bookRepository);
        BookEntity bookEntity = new BookEntity();
        bookEntity.setTitle("20000 leagues under the Seas");
        bookEntity.setListOfAuthors("Jules Verne");
        bookEntity.setYear(1872);
        bookEntity.setIsbn("9780679203735");
        bookEntity.setVolume(56);
        bookService.saveBook(bookEntity);
        return bookService;
    }

    @Bean
    IssueService issueService(IssueRepository issueRepository, BookService bookService, UserService userService) {
        IssueService issueService = new IssueService(issueRepository,
                userService.getUserRepository(), bookService.getBookRepository());


        return issueService;
    }
}

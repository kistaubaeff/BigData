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
import ru.hpclab.bd.module1.entity.IssueEntity;
import ru.hpclab.bd.module1.entity.UserEntity;
import ru.hpclab.bd.module1.repository.BookRepository;
import ru.hpclab.bd.module1.repository.IssueRepository;
import ru.hpclab.bd.module1.repository.UserRepository;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {IssueServiceTest.IssueServiceTestConfiguration.class})
public class IssueServiceTest {
    public static final String BOOK_ISBN = "9781234567890";
    public static final String BOOK_TITLE = "The Great Novel";
    public static final String BOOK_LIST_OF_AUTHORS = "Dostoevsky";
    public static final int BOOK_YEAR = 1866;
    public static final int BOOK_VOLUME = 100;
    public static final int PERIOD = 20;

    @Autowired
    private IssueService issueService;

    @Autowired
    private IssueRepository issueRepository;

//    @Autowired
//    private UserRepository userRepository;
//    @Autowired
//    private BookRepository bookRepository;

    @Test
    public void testCreateAndGet() {
        //create
        UserEntity userEntity = new UserEntity(0L, UUID.randomUUID().toString(), "name");

        BookEntity bookEntity = new BookEntity(0L, BOOK_ISBN, BOOK_TITLE,
                BOOK_LIST_OF_AUTHORS, BOOK_YEAR, BOOK_VOLUME);

        IssueEntity issueEntity = new IssueEntity(0L, UUID.randomUUID().toString(),
                userEntity, bookEntity, "08.08.2008", PERIOD);

        IssueEntity savedIssue = issueService.createIssue(issueEntity);

        Assertions.assertEquals(issueEntity.getIssueDate(), savedIssue.getIssueDate());
        Assertions.assertEquals(issueEntity.getPeriod(), savedIssue.getPeriod());
        Mockito.verify(issueRepository, Mockito.times(1)).save(issueEntity);

        //getAll
        List<IssueEntity> issueEntityList = issueService.getAllIssues();

        Assertions.assertEquals("today", issueEntityList.get(0).getIssueDate());
        Assertions.assertEquals("tomorrow", issueEntityList.get(1).getIssueDate());
        Mockito.verify(issueRepository, Mockito.times(1)).findAll();

    }

    @Configuration
    static class IssueServiceTestConfiguration {


        @Bean
        IssueRepository issueRepository() {
            IssueRepository issueRepository = mock(IssueRepository.class);
            when(issueRepository.save(any())).thenReturn(new IssueEntity(0L,
                    UUID.randomUUID().toString(), new UserEntity(0L, UUID.randomUUID().toString(), "name"),
                    new BookEntity(0L, BOOK_ISBN, BOOK_TITLE,
                    BOOK_LIST_OF_AUTHORS, BOOK_YEAR, BOOK_VOLUME),
                    "08.08.2008", PERIOD));
            when(issueRepository.findAll())
                    .thenReturn(Arrays.asList(new IssueEntity(1L, UUID.randomUUID().toString(), null, null,
                                    "today", 1),
                            new IssueEntity(2L, UUID.randomUUID().toString(), null,
                                    null, "tomorrow", 2)));
            return issueRepository;
        }

        @Bean
        UserRepository UserRepository() {
            UserRepository userRepository = mock(UserRepository.class);
            return userRepository;
        }

        @Bean
        BookRepository BookRepository() {
            BookRepository bookRepository = mock(BookRepository.class);
            return bookRepository;
        }

        @Bean
        IssueService IssueService(final IssueRepository issueRepository,
                                  final UserRepository userRepository,
                                  final BookRepository bookRepository) {
            return new IssueService(issueRepository, userRepository, bookRepository);
        }
    }

}

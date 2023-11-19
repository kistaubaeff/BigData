package ru.hpclab.bd.module1.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.zonky.test.db.AutoConfigureEmbeddedDatabase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import ru.hpclab.bd.module1.Module1Application;
import ru.hpclab.bd.module1.entity.BookEntity;
import ru.hpclab.bd.module1.entity.IssueEntity;
import ru.hpclab.bd.module1.entity.UserEntity;
import ru.hpclab.bd.module1.repository.BookRepository;
import ru.hpclab.bd.module1.repository.IssueRepository;
import ru.hpclab.bd.module1.repository.UserRepository;


import java.util.UUID;

import static io.zonky.test.db.AutoConfigureEmbeddedDatabase.DatabaseProvider.ZONKY;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru.hpclab.bd.module1.mapper.Mapper.entity2Issue;


@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Module1Application.class)
@AutoConfigureMockMvc
@AutoConfigureEmbeddedDatabase(provider = ZONKY)
public class IssueControllerTest {
    private ObjectMapper objectMapper = new ObjectMapper();

    public static final String STATIONMASTER_ISBN = "9781421527635";
    public static final String STATIONMASTER_TITLE = "Stationmaster";
    public static final String STATIONMASTER_LIST_OF_AUTHOURS = "Pushkin";
    public static final int STATIONMASTER_YEAR = 1831;
    public static final int STATIONMASTER_VOLUME = 48;

    public static final String ISSUE_DATE = "04.10.1993";
    public static final int ISSUE_PERIOD = 200;


    @Autowired
    private MockMvc mvc;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private IssueRepository issueRepository;

    /**
     * Clears all records from the user repository before each test.
     */
    @BeforeEach
    public void init() {
        userRepository.deleteAll();
        bookRepository.deleteAll();
        issueRepository.deleteAll();
    }

    @Test
    public void get_should_returnIssue_when_IssueExists() throws Exception {

        UserEntity userEntity = new UserEntity();
        userEntity.setIdentifier(UUID.randomUUID().toString());
        userEntity.setFio("FIO");

        userRepository.save(userEntity);

        BookEntity bookEntity = new BookEntity();
        bookEntity.setIsbn(STATIONMASTER_ISBN);
        bookEntity.setTitle(STATIONMASTER_TITLE);
        bookEntity.setListOfAuthors(STATIONMASTER_LIST_OF_AUTHOURS);
        bookEntity.setYear(STATIONMASTER_YEAR);
        bookEntity.setVolume(STATIONMASTER_VOLUME);

        bookRepository.save(bookEntity);

        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setIdentifier(UUID.randomUUID().toString());
        issueEntity.setUserEntity(userEntity);
        issueEntity.setBookEntity(bookEntity);

        issueEntity.setIssueDate(ISSUE_DATE);
        issueEntity.setPeriod(ISSUE_PERIOD);
        IssueEntity savedIssueEntity = issueRepository.save(issueEntity);

        String expectedJson = objectMapper.writeValueAsString(entity2Issue(savedIssueEntity));


        mvc.perform(get("/issues/" + issueEntity.getId()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJson));
    }
}

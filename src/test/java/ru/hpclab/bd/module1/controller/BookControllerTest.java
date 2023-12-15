package ru.hpclab.bd.module1.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.containers.wait.strategy.Wait;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import ru.hpclab.bd.module1.Module1Application;
import ru.hpclab.bd.module1.entity.BookEntity;
import ru.hpclab.bd.module1.mapper.Mapper;
import ru.hpclab.bd.module1.repository.BookRepository;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Module1Application.class)
@AutoConfigureMockMvc
@TestPropertySource("classpath:application-test.properties")
@Testcontainers
public class BookControllerTest {
    private ObjectMapper objectMapper = new ObjectMapper();
    public static final String STATIONMASTER_ISBN = "9781421527635";
    public static final String STATIONMASTER_TITLE = "Stationmaster";
    public static final String STATIONMASTER_LIST_OF_AUTHOURS = "Pushkin";
    public static final int STATIONMASTER_YEAR = 1831;
    public static final int STATIONMASTER_VOLUME = 48;

    @Autowired
    private MockMvc mvc;

    @Autowired
    private BookRepository bookRepository;

    @Container
    private static PostgreSQLContainer<?> postgreSQLContainer =
            (PostgreSQLContainer) new PostgreSQLContainer("postgres:15.2-alpine")
                    .withDatabaseName("test-db")
                    .withUsername("test")
                    .withPassword("test")
                    .waitingFor(Wait.forListeningPort());

    @DynamicPropertySource
    static void dataSourceProperties(final DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgreSQLContainer::getJdbcUrl);
        registry.add("spring.datasource.username", postgreSQLContainer::getUsername);
        registry.add("spring.datasource.password", postgreSQLContainer::getPassword);
    }

    /**
     * Clears all records from the book repository before each test.
     */


    @Test
    public void get_should_returnBook_when_bookExists() throws Exception {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setIsbn(STATIONMASTER_ISBN);
        bookEntity.setTitle(STATIONMASTER_TITLE);
        bookEntity.setListOfAuthors(STATIONMASTER_LIST_OF_AUTHOURS);
        bookEntity.setYear(STATIONMASTER_YEAR);
        bookEntity.setVolume(STATIONMASTER_VOLUME);


        BookEntity savedBookEntity = bookRepository.save(bookEntity);
        String expectedJson = objectMapper.writeValueAsString(Mapper.entity2Book(savedBookEntity));


        mvc.perform(get("/books/" + bookEntity.getId()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJson));
    }
}

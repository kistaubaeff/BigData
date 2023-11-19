package ru.hpclab.bd.module1.mapper;

import ru.hpclab.bd.module1.entity.BookEntity;
import ru.hpclab.bd.module1.entity.IssueEntity;
import ru.hpclab.bd.module1.entity.UserEntity;
import ru.hpclab.bd.module1.model.Book;
import ru.hpclab.bd.module1.model.Issue;
import ru.hpclab.bd.module1.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Mapper class representing a universal mapper.
 */
public final class Mapper {

    private Mapper() {
    }

    /**
     * Maps a User model to a UserEntity.
     *
     * @param user The User model to be mapped.
     * @return The corresponding UserEntity.
     */
    public static UserEntity user2Entity(final User user) {
        UUID identifier = user.getIdentifier();

        UserEntity userEntity = new UserEntity();
        userEntity.setIdentifier(identifier != null ? identifier.toString() : null);
        userEntity.setFio(user.getFio());
        userEntity.setId(user.getId());

        List<IssueEntity> issueEntities = new ArrayList<>();
//        for (Issue issue : user.getIssues()) {
//            IssueEntity issueEntity = new IssueEntity();
//            issueEntity.setUserEntity(userEntity);
//            issueEntity.setBookEntity(book2Entity(issue.getBook()));
//            issueEntity.setIssueDate(issue.getIssueDate());
//            issueEntity.setPeriod(issue.getPeriod());
//
//            issueEntities.add(issueEntity);
//        }
//        userEntity.setIssues(issueEntities);

        return userEntity;
    }

    /**
     * Maps a UserEntity to a User model.
     *
     * @param userEntity The UserEntity to be mapped.
     * @return The corresponding User model.
     */
    public static User entity2User(final UserEntity userEntity) {
        String identifier = userEntity.getIdentifier();

//        List<Issue> issues = new ArrayList<>();
//        for (IssueEntity issueEntity : userEntity.getIssues()) {
//            Issue issue = new Issue();
//            issue.setBook(entity2Book(issueEntity.getBookEntity()));
//            issue.setIssueDate(issueEntity.getIssueDate());
//            issue.setPeriod(issueEntity.getPeriod());
//            issues.add(issue);
//        }

        User user = new User();
        user.setId(userEntity.getId());
        user.setIdentifier(identifier != null ? UUID.fromString(identifier) : null);
        user.setFio(userEntity.getFio());
//        user.setIssues(issues);

        return user;
    }

    // Assuming the following methods for book mapping
    /**
     * Maps a Book model to a BookEntity.
     *
     * @param book The Book model to be mapped.
     * @return The corresponding BookEntity.
     */
    public static BookEntity book2Entity(final Book book) {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setId(book.getId());
        bookEntity.setIsbn(book.getIsbn());
        bookEntity.setTitle(book.getTitle());
        bookEntity.setVolume(book.getVolume());
        bookEntity.setYear(book.getYear());
        bookEntity.setListOfAuthors(book.getListOfAuthors());
        return bookEntity;
    }

    /**
     * Maps a BookEntity to a Book model.
     *
     * @param bookEntity The BookEntity to be mapped.
     * @return The corresponding Book model.
     */
    public static Book entity2Book(final BookEntity bookEntity) {
        Book book = new Book();
        book.setId(bookEntity.getId());
        book.setIsbn(bookEntity.getIsbn());
        book.setTitle(bookEntity.getTitle());
        book.setVolume(bookEntity.getVolume());
        book.setYear(bookEntity.getYear());
        book.setListOfAuthors(bookEntity.getListOfAuthors());
        return book;
    }

    /**
     * Maps an IssueEntity to an Issue model.
     *
     * @param issueEntity The IssueEntity to be mapped.
     * @return The corresponding Issue model.
     */
    public static Issue entity2Issue(final IssueEntity issueEntity) {
        Issue issue = new Issue();
        issue.setId(issueEntity.getId());
        issue.setIdentifier(issueEntity.getIdentifier());
        issue.setUser(entity2User(issueEntity.getUserEntity()));
        issue.setBook(entity2Book(issueEntity.getBookEntity()));
        issue.setIssueDate(issueEntity.getIssueDate());
        issue.setPeriod(issueEntity.getPeriod());
        return issue;
    }

    /**
     * Maps an Issue model to an IssueEntity.
     *
     * @param issue The Issue model to be mapped.
     * @return The corresponding IssueEntity.
     */
    public static IssueEntity issue2Entity(final Issue issue) {
        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setId(issue.getId());
        issueEntity.setIdentifier(issue.getIdentifier());
        issueEntity.setUserEntity(user2Entity(issue.getUser()));
        issueEntity.setBookEntity(book2Entity(issue.getBook()));
        issueEntity.setIssueDate(issue.getIssueDate());
        issueEntity.setPeriod(issue.getPeriod());
        return issueEntity;
    }
}

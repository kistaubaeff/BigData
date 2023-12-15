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

public class UserMapper {

    private UserMapper() {
    }

    public static UserEntity user2Entity(User user) {
        UUID identifier = user.getIdentifier();

        UserEntity userEntity = new UserEntity();
        userEntity.setIdentifier(identifier != null ? identifier.toString() : null);
        userEntity.setFio(user.getFio());
        userEntity.setId(user.getId());

        List<IssueEntity> issueEntities = new ArrayList<>();
        for (Issue issue : user.getIssues()) {
            IssueEntity issueEntity = new IssueEntity();
            issueEntity.setUserEntity(userEntity);
            issueEntity.setBookEntity(book2Entity(issue.getBook()));
            issueEntity.setIssueDate(issue.getIssueDate());
            issueEntity.setPeriod(issue.getPeriod());

            issueEntities.add(issueEntity);
        }
        userEntity.setIssues(issueEntities);

        return userEntity;
    }

    public static User entity2User(UserEntity userEntity) {
        String identifier = userEntity.getIdentifier();

        List<Issue> issues = new ArrayList<>();
        for (IssueEntity issueEntity : userEntity.getIssues()) {
            Issue issue = new Issue();
            issue.setBook(entity2Book(issueEntity.getBookEntity()));
            issue.setIssueDate(issueEntity.getIssueDate());
            issue.setPeriod(issueEntity.getPeriod());
            issues.add(issue);
        }

        User user = new User();
        user.setId(userEntity.getId());
        user.setIdentifier(identifier != null ? UUID.fromString(identifier) : null);
        user.setFio(userEntity.getFio());
        user.setIssues(issues);

        return user;
    }

    // Assuming the following methods for book mapping
    public static BookEntity book2Entity(Book book) {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setIsbn(book.getISBN());
        bookEntity.setTitle(book.getTitle());
        bookEntity.setVolume(book.getVolume());
        bookEntity.setYear(book.getYear());
        bookEntity.setListOfAuthors(book.getListOfAuthors());
        return bookEntity;
    }

    public static Book entity2Book(BookEntity bookEntity) {
        Book book = new Book();
        book.setIsbn(bookEntity.getIsbn());
        book.setTitle(bookEntity.getTitle());
        book.setVolume(bookEntity.getVolume());
        book.setYear(bookEntity.getYear());
        book.setListOfAuthors(bookEntity.getListOfAuthors());
        return book;
    }
}

package ru.hpclab.bd.module1.entity;

import jakarta.persistence.*;


import java.util.Objects;
import java.util.UUID;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "tIssue")
public class IssueEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String identifier;


    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "book_id")
    private BookEntity bookEntity;

    @Column(name = "issue_date")
    private String issueDate;

    @Column(name = "period")
    private int period;

    public IssueEntity() {
    }

    public IssueEntity(String issueID, UserEntity user, BookEntity book, String issueDate, int period) {
        this.identifier = issueID;
        this.userEntity = user;
        this.bookEntity = book;
        this.issueDate = issueDate;
        this.period = period;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public BookEntity getBookEntity() {
        return bookEntity;
    }

    public void setBookEntity(BookEntity bookEntity) {
        this.bookEntity = bookEntity;
    }


    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }


    @Override
    public String toString() {
        return "IssueEntity{" +
                "id=" + id +
                ", identifier='" + identifier + '\'' +
                ", userEntity=" + userEntity +
                ", bookEntity=" + bookEntity +
                ", issueDate='" + issueDate + '\'' +
                ", period=" + period +
                '}';
    }
}

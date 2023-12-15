package ru.hpclab.bd.module1.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "issue")
public class IssueEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "issue_id")
    private UUID issueID;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "book_isbn")
    private BookEntity book;

    @Column(name = "issue_date")
    private LocalDate issueDate;

    @Column(name = "period")
    private int period;

    public IssueEntity() {
    }

    public IssueEntity(UUID issueID, UserEntity user, BookEntity book, LocalDate issueDate, int period) {
        this.issueID = issueID;
        this.user = user;
        this.book = book;
        this.issueDate = issueDate;
        this.period = period;
    }

    public UUID getIssueID() {
        return issueID;
    }

    public void setIssueID(UUID issueID) {
        this.issueID = issueID;
    }

    public UserEntity getUserEntity() {
        return user;
    }

    public void setUserEntity(UserEntity user) {
        this.user = user;
    }

    public BookEntity getBookEntity() {
        return book;
    }

    public void setBookEntity(BookEntity book) {
        this.book = book;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    @Override
    public String toString() {
        return "IssueEntity{" +
                "issueID=" + issueID +
                ", user=" + user +
                ", book=" + book +
                ", issueDate=" + issueDate +
                ", period=" + period +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IssueEntity that = (IssueEntity) o;
        return Objects.equals(issueID, that.issueID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(issueID);
    }
}

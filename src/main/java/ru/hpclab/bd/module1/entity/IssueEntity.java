package ru.hpclab.bd.module1.entity;

import jakarta.persistence.*;
/**
 * Entity class representing an issue.
 */
@Entity
@Table(name = "tIssue")
public class IssueEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "identifier", nullable = false)
    private String identifier;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity userEntity;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "book_id")
    private BookEntity bookEntity;

    @Column(name = "issue_date")
    private String issueDate;

    @Column(name = "period")
    private int period;

    /**
     * Empty constructor.
     */
    public IssueEntity() {
    }

    /**
     * Parameterized constructor.
     * @param id         The issue id
     * @param issueID    The issue identifier.
     * @param user       The user associated with the issue.
     * @param book       The book associated with the issue.
     * @param issueDate  The date of the issue.
     * @param period     The period for which the book is issued.
     */
    public IssueEntity(final Long id, final String issueID, final UserEntity user,
                       final BookEntity book, final String issueDate, final int period) {
        this.id = id;
        this.identifier = issueID;
        this.userEntity = user;
        this.bookEntity = book;
        this.issueDate = issueDate;
        this.period = period;
    }

    /**
     * Gets the ID of the issue.
     *
     * @return The ID of the issue.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of the issue.
     *
     * @param id The ID of the issue.
     */
    public void setId(final Long id) {
        this.id = id;
    }

    /**
     * Gets the user associated with the issue.
     *
     * @return The user associated with the issue.
     */
    public UserEntity getUserEntity() {
        return userEntity;
    }

    /**
     * Sets the user associated with the issue.
     *
     * @param userEntity The user associated with the issue.
     */
    public void setUserEntity(final UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    /**
     * Gets the book associated with the issue.
     *
     * @return The book associated with the issue.
     */
    public BookEntity getBookEntity() {
        return bookEntity;
    }

    /**
     * Sets the book associated with the issue.
     *
     * @param bookEntity The book associated with the issue.
     */
    public void setBookEntity(final BookEntity bookEntity) {
        this.bookEntity = bookEntity;
    }

    /**
     * Gets the date of the issue.
     *
     * @return The date of the issue.
     */
    public String getIssueDate() {
        return issueDate;
    }

    /**
     * Sets the date of the issue.
     *
     * @param issueDate The date of the issue.
     */
    public void setIssueDate(final String issueDate) {
        this.issueDate = issueDate;
    }

    /**
     * Gets the period for which the book is issued.
     *
     * @return The period for which the book is issued.
     */
    public int getPeriod() {
        return period;
    }

    /**
     * Sets the period for which the book is issued.
     *
     * @param period The period for which the book is issued.
     */
    public void setPeriod(final int period) {
        this.period = period;
    }

    /**
     * Gets the identifier of the issue.
     *
     * @return The identifier of the issue.
     */
    public String getIdentifier() {
        return identifier;
    }

    /**
     * Sets the identifier of the issue.
     *
     * @param identifier The identifier of the issue.
     */
    public void setIdentifier(final String identifier) {
        this.identifier = identifier;
    }

    /**
     * Generates a string representation of the object.
     *
     * @return String representation of the object.
     */
    @Override
    public String toString() {
        return "IssueEntity{"
                + "id=" + id
                + ", identifier='" + identifier + '\''
                + ", userEntity=" + userEntity
                + ", bookEntity=" + bookEntity
                + ", issueDate='" + issueDate + '\''
                + ", period=" + period
                + '}';
    }
}

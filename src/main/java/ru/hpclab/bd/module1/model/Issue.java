package ru.hpclab.bd.module1.model;

import org.springframework.lang.NonNull;

import java.time.LocalDate;
import java.util.UUID;

/**
 * Issue model.
 */

public class Issue {
    @NonNull
    private UUID issueID;
    @NonNull
    private User user;

    @NonNull
    private  Book book;

    private LocalDate issueDate;


    private int period;

    /**
     * Builds new issue.
     * @param identifier issue id
     * @param user issue user
     * @param book issue book
     * @param issueDate issue date
     * @param period issue period
     */
    public Issue(@NonNull final UUID identifier, @NonNull final User user,
                 @NonNull final Book book, final LocalDate issueDate, final int period) {
        this.issueID = identifier;
        this.user = user;
        this.book = book;
        this.issueDate = issueDate;
        this.period = period;
    }

    /**
     * Empty constructor.
     */
    public Issue() {
    }

    /**
     * Return's issue's user.
     * @return user of issue
     */
    @NonNull
    public User getUser() {
        return user;
    }

    /**
     * Returns issue's id.
     * @return id of issue
     */

    @NonNull
    public UUID getIssueID() {
        return issueID;
    }

    /**
     * Sets issue's id.
     * @param issueID issue's id
     */
    public void setIssueID(@NonNull final UUID issueID) {
        this.issueID = issueID;
    }

    /**
     * Sets issue's date.
     * @param issueDate issue date
     */
    public void setIssueDate(@NonNull final LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    /**
     * Returns issue's book.
     * @return book of issue
     */
    @NonNull
    public Book getBook() {
        return book;
    }

    /**
     * Returns issue's date.
     * @return date of issue
     */

    public LocalDate getIssueDate() {
        return issueDate;
    }

    /**
     * Returns issue's period.
     * @return period of issue
     */

    public int getPeriod() {
        return period;
    }



    /**
     * Returns string representation of the issue.
     */

    @Override
    public String toString() {
        return "Issue{"
                + "issueID=" + issueID + ", "
                + "user='" + user + "'"
                + "book='" + book + "'"
                + "issueDate='" + issueDate + "'"
                + "period='" + period + "'"
                + "}";
    }

    public void setUser(@NonNull User user) {
        this.user = user;
    }

    public void setBook(@NonNull Book book) {
        this.book = book;
    }

    public void setPeriod(int period) {
        this.period = period;
    }
}

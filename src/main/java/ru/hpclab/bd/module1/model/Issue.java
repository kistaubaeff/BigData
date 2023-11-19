package ru.hpclab.bd.module1.model;


/**
 * Issue model.
 */

public class Issue {


    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String identifier;
    private User user;

    private Book book;

    private String issueDate;


    private int period;

    /**
     * Builds new issue.
     *
     * @param id         issue
     * @param identifier issue id
     * @param user       issue user
     * @param book       issue book
     * @param issueDate  issue date
     * @param period     issue period
     */
    public Issue(Long id, String identifier, User user, Book book, String issueDate, int period) {
        this.id = id;
        this.identifier = identifier;
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
     *
     * @return user of issue
     */
    public User getUser() {
        return user;
    }

    /**
     * Returns issue's id.
     *
     * @return id of issue
     */

    public String getIdentifier() {
        return identifier;
    }


    /**
     * Sets issue's id.
     *
     * @param issueID issue's id
     */
    public void setIdentifier(final String issueID) {
        this.identifier = issueID;
    }

    /**
     * Sets issue's date.
     *
     * @param issueDate issue date
     */
    public void setIssueDate(final String issueDate) {
        this.issueDate = issueDate;
    }

    /**
     * Returns issue's book.
     *
     * @return book of issue
     */
    public Book getBook() {
        return book;
    }

    /**
     * Returns issue's date.
     *
     * @return date of issue
     */

    public String getIssueDate() {
        return issueDate;
    }

    /**
     * Returns issue's period.
     *
     * @return period of issue
     */

    public int getPeriod() {
        return period;
    }


    /**
     * Returns string representation of the issue.
     */


    public void setUser(User user) {
        this.user = user;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    @Override
    public String toString() {
        return "Issue{" +
                "id=" + id +
                ", identifier='" + identifier + '\'' +
                ", user=" + user +
                ", book=" + book +
                ", issueDate='" + issueDate + '\'' +
                ", period=" + period +
                '}';
    }
}

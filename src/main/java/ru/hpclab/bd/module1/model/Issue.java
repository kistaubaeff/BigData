package ru.hpclab.bd.module1.model;

/**
 * Model representing an issue.
 */
public class Issue {

    private Long id;
    private String identifier;
    private User user;
    private Book book;
    private String issueDate;
    private int period;

    /**
     * Constructs a new Issue.
     *
     * @param id         The issue ID.
     * @param identifier The issue identifier.
     * @param user       The user associated with the issue.
     * @param book       The book associated with the issue.
     * @param issueDate  The date when the issue was made.
     * @param period     The period of the issue.
     */
    public Issue(final Long id, final String identifier,
                 final User user, final Book book,
                 final String issueDate, final int period) {
        this.id = id;
        this.identifier = identifier;
        this.user = user;
        this.book = book;
        this.issueDate = issueDate;
        this.period = period;
    }

    /**
     * Empty constructor for Issue.
     */
    public Issue() {
    }

    /**
     * Gets the user associated with the issue.
     *
     * @return The user associated with the issue.
     */
    public User getUser() {
        return user;
    }

    /**
     * Gets the ID of the issue.
     *
     * @return The ID of the issue.
     */
    public String getIdentifier() {
        return identifier;
    }

    /**
     * Sets the identifier of the issue.
     *
     * @param issueID The identifier of the issue.
     */
    public void setIdentifier(final String issueID) {
        this.identifier = issueID;
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
     * Gets the book associated with the issue.
     *
     * @return The book associated with the issue.
     */
    public Book getBook() {
        return book;
    }

    /**
     * Gets the date when the issue was made.
     *
     * @return The date of the issue.
     */
    public String getIssueDate() {
        return issueDate;
    }

    /**
     * Gets the period of the issue.
     *
     * @return The period of the issue.
     */
    public int getPeriod() {
        return period;
    }

    /**
     * Sets the user associated with the issue.
     *
     * @param user The user associated with the issue.
     */
    public void setUser(final User user) {
        this.user = user;
    }

    /**
     * Sets the book associated with the issue.
     *
     * @param book The book associated with the issue.
     */
    public void setBook(final Book book) {
        this.book = book;
    }

    /**
     * Sets the period of the issue.
     *
     * @param period The period of the issue.
     */
    public void setPeriod(final int period) {
        this.period = period;
    }

    /**
     * Returns a string representation of the issue.
     */
    @Override
    public String toString() {
        return "Issue{"
                + "id=" + id
                + ", identifier='" + identifier + '\''
                + ", user=" + user
                + ", book=" + book
                + ", issueDate='" + issueDate + '\''
                + ", period=" + period
                + '}';
    }
    /**
     * Gets the id associated with the issue.
     *
     * @return The id associated with the issue.
     */

    public Long getId() {
        return id;
    }
    /**
     * Sets the id associated with the issue.
     *
     * @param id The id associated with the issue.
     */
    public void setId(final Long id) {
        this.id = id;
    }
}

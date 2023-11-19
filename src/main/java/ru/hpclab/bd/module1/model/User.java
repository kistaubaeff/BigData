package ru.hpclab.bd.module1.model;


import java.util.UUID;

/**
 * Represents a User in the system.
 */
public class User {
    private Long id;
    private UUID identifier;
    private String fio;
//    private List<Issue> issues = new ArrayList<>();

    /**
     * Constructs a User with specified parameters.
     *
     * @param id         The user ID.
     * @param identifier The user identifier.
     * @param fio        The full name of the user.
//     * @param issues     The list of issues associated with the user.
     */
    public User(final Long id, final UUID identifier,
                final String fio) {
        this.id = id;
        this.identifier = identifier;
        this.fio = fio;
//        this.issues = issues;
    }


    /**
     * Default constructor for User.
     */
    public User() {
    }

//    /**
//     * Sets the list of issues associated with the user.
//     *
//     * @param issues The list of issues.
//     */
//    public void setIssues(final List<Issue> issues) {
//        this.issues = issues;
//    }

    /**
     * Gets the ID of the user.
     *
     * @return The user ID.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of the user.
     *
     * @param id The user ID.
     */
    public void setId(final Long id) {
        this.id = id;
    }

    /**
     * Gets the identifier of the user.
     *
     * @return The user identifier.
     */
    public UUID getIdentifier() {
        return identifier;
    }

    /**
     * Sets the identifier of the user.
     *
     * @param identifier The user identifier.
     */
    public void setIdentifier(final UUID identifier) {
        this.identifier = identifier;
    }

    /**
     * Gets the full name of the user.
     *
     * @return The full name of the user.
     */
    public String getFio() {
        return fio;
    }

    /**
     * Sets the full name of the user.
     *
     * @param fio The full name of the user.
     */
    public void setFio(final String fio) {
        this.fio = fio;
    }

//    /**
//     * Gets the list of issues associated with the user.
//     *
//     * @return The list of issues.
//     */
//    public List<Issue> getIssues() {
//        return issues;
//    }

    /**
     * Returns a string representation of the user.
     */
    @Override
    public String toString() {
        return "User{" + "id=" + id + ", identifier="
                + identifier + ", fio='" + fio + '\'' + ", phones="
//                + issues
                + '}';
    }
}

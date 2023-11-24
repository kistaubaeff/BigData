package ru.hpclab.bd.module1.entity;

import jakarta.persistence.*;



import static jakarta.persistence.GenerationType.IDENTITY;
/**
 * Entity class representing a user.
 */
@Entity
@Table(name = "t_user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String identifier;
    private String fio;

//    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
//    private List<IssueEntity> issues = new ArrayList<>();

    /**
     * Empty constructor.
     */
    public UserEntity() {
    }

    /**
     * Parameterized constructor.
     *
     * @param id         The ID of the user.
     * @param identifier The identifier of the user.
     * @param fio        The full name of the user.
//     * @param issues     The list of issues associated with the user.
     */
    public UserEntity(final Long id, final String identifier, final String fio) {
        this.id = id;
        this.identifier = identifier;
        this.fio = fio;
//        this.issues = issues;
    }

    /**
     * Gets the ID of the user.
     *
     * @return The ID of the user.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of the user.
     *
     * @param id The ID of the user.
     */
    public void setId(final Long id) {
        this.id = id;
    }

    /**
     * Gets the identifier of the user.
     *
     * @return The identifier of the user.
     */
    public String getIdentifier() {
        return identifier;
    }

    /**
     * Sets the identifier of the user.
     *
     * @param identifier The identifier of the user.
     */
    public void setIdentifier(final String identifier) {
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
//
//    /**
//     * Gets the list of issues associated with the user.
//     *
//     * @return The list of issues associated with the user.
//     */
//    public List<IssueEntity> getIssues() {
//        return issues;
//    }

//    /**
//     * Sets the list of issues associated with the user.
//     *
//     * @param issues The list of issues associated with the user.
//     */
//    public void setIssues(final List<IssueEntity> issues) {
//        this.issues = issues;
//    }

    /**
     * Generates a string representation of the object.
     *
     * @return String representation of the object.
     */
    @Override
    public String toString() {
        return "UserEntity{"
                + "id=" + id
                + ", identifier='" + identifier + '\''
                + ", fio='" + fio + '\''
//                + ", issues=" + issues
                + '}';
    }
}

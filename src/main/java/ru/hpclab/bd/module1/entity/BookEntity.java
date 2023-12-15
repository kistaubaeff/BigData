package ru.hpclab.bd.module1.entity;

import jakarta.persistence.*;



import static jakarta.persistence.GenerationType.IDENTITY;

/**
 * Entity class representing a book.
 */
@Entity
@Table(name = "t_book")
public final class BookEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String isbn;

    private String title;

    private String listOfAuthors;

    private int year;

    private int volume;


    /**
     * Empty constructor.
     */
    public BookEntity() {
    }

    /**
     * Constructs a BookEntity with the specified parameters.
     * @param id            the id of the book
     * @param isbn          the ISBN of the book
     * @param title         the title of the book
     * @param listOfAuthors the list of authors of the book
     * @param year          the publication year of the book
     * @param volume        the volume of the book
     */
    public BookEntity(final Long id, final String isbn, final String title,
                      final String listOfAuthors, final int year, final int volume) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.listOfAuthors = listOfAuthors;
        this.year = year;
        this.volume = volume;
    }

    /**
     * Gets the ISBN of the book.
     *
     * @return the ISBN of the book
     */
    public String getIsbn() {
        return isbn;
    }


    /**
     * Sets the ISBN of the book.
     *
     * @param isbn the ISBN to set
     */
    public void setIsbn(final String isbn) {
        this.isbn = isbn;
    }

    /**
     * Gets the title of the book.
     *
     * @return the title of the book
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the book.
     *
     * @param title the title to set
     */
    public void setTitle(final String title) {
        this.title = title;
    }

    /**
     * Gets the list of authors of the book.
     *
     * @return the list of authors of the book
     */
    public String getListOfAuthors() {
        return listOfAuthors;
    }

    /**
     * Sets the list of authors of the book.
     *
     * @param listOfAuthors the list of authors to set
     */
    public void setListOfAuthors(final String listOfAuthors) {
        this.listOfAuthors = listOfAuthors;
    }

    /**
     * Gets the publication year of the book.
     *
     * @return the publication year of the book
     */
    public int getYear() {
        return year;
    }

    /**
     * Sets the publication year of the book.
     *
     * @param year the publication year to set
     */
    public void setYear(final int year) {
        this.year = year;
    }

    /**
     * Gets the volume of the book.
     *
     * @return the volume of the book
     */
    public int getVolume() {
        return volume;
    }

    /**
     * Sets the volume of the book.
     *
     * @param volume the volume to set
     */
    public void setVolume(final int volume) {
        this.volume = volume;
    }

    /**
     * Gets the ID of the book.
     *
     * @return the ID of the book
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of the book.
     *
     * @param id the ID to set
     */
    public void setId(final Long id) {
        this.id = id;
    }

    /**
     * Generates a string representation of the object.
     *
     * @return String representation of the object
     */
    @Override
    public String toString() {
        return "BookEntity{"
                + "id=" + id
                + ", isbn='" + isbn + '\''
                + ", title='" + title + '\''
                + ", listOfAuthors='" + listOfAuthors + '\''
                + ", year=" + year
                + ", volume=" + volume
                + '}';
    }
}

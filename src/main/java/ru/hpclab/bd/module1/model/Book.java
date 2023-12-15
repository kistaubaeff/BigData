package ru.hpclab.bd.module1.model;

/**
 * Represents a Book in the system.
 */
public class Book {

    private Long id;
    private String isbn;
    private String title;
    private String listOfAuthors;
    private int year;
    private int volume;

    /**
     * Constructs a new book.
     *
     * @param id             The book ID.
     * @param isbn           The book ISBN.
     * @param title          The book title.
     * @param listOfAuthors The list of authors for the book.
     * @param year           The publication year of the book.
     * @param volume         The volume of the book.
     */
    public Book(final Long id, final String isbn,
                final String title, final String listOfAuthors,
                final int year, final int volume) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.listOfAuthors = listOfAuthors;
        this.year = year;
        this.volume = volume;
    }

    /**
     * Empty constructor for Book.
     */
    public Book() {
    }

    /**
     * Sets the ISBN of the book.
     *
     * @param isbn The ISBN of the book.
     */
    public void setIsbn(final String isbn) {
        this.isbn = isbn;
    }

    /**
     * Sets the title of the book.
     *
     * @param title The title of the book.
     */
    public void setTitle(final String title) {
        this.title = title;
    }

    /**
     * Gets the ID of the book.
     *
     * @return The book ID.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of the book.
     *
     * @param id The book ID.
     */
    public void setId(final Long id) {
        this.id = id;
    }

    /**
     * Sets the list of authors for the book.
     *
     * @param listOfAuthors The list of authors.
     */
    public void setListOfAuthors(final String listOfAuthors) {
        this.listOfAuthors = listOfAuthors;
    }

    /**
     * Sets the publication year of the book.
     *
     * @param year The publication year of the book.
     */
    public void setYear(final int year) {
        this.year = year;
    }

    /**
     * Sets the volume of the book.
     *
     * @param volume The volume of the book.
     */
    public void setVolume(final int volume) {
        this.volume = volume;
    }

    /**
     * Gets the ISBN of the book.
     *
     * @return The ISBN of the book.
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Gets the title of the book.
     *
     * @return The title of the book.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets the list of authors for the book.
     *
     * @return The list of authors for the book.
     */
    public String getListOfAuthors() {
        return listOfAuthors;
    }

    /**
     * Gets the publication year of the book.
     *
     * @return The publication year of the book.
     */
    public int getYear() {
        return year;
    }

    /**
     * Gets the volume of the book.
     *
     * @return The volume of the book.
     */
    public int getVolume() {
        return volume;
    }

    /**
     * Returns a string representation of the book.
     */
    @Override
    public String toString() {
        return "Book{"
                + "id=" + id
                + ", isbn='" + isbn + '\''
                + ", title='" + title + '\''
                + ", listOfAuthors='" + listOfAuthors + '\''
                + ", year=" + year
                + ", volume=" + volume
                + '}';
    }
}

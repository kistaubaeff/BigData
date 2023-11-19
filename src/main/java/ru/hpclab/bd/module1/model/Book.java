package ru.hpclab.bd.module1.model;

/**
 * Book model.
 */
public class Book {

    private Long id;
    private String isbn;

    private String title;

    private String listOfAuthors;

    private int year;
    private int volume;

    /**
     * Builds new book.
     *
     * @param id
     * @param isbn          book isbn
     * @param title         book title
     * @param listOfAuthors book list of authors
     * @param year          book year
     * @param volume        book volume
     */
    public Book(Long id, final String isbn, final String title, final String listOfAuthors, final int year, final int volume) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.listOfAuthors = listOfAuthors;
        this.year = year;
        this.volume = volume;
    }

    /**
     * Empty contructor.
     */
    public Book() {
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public void setListOfAuthors(String listOfAuthors) {
        this.listOfAuthors = listOfAuthors;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    /**
     * Returns book's identifier.
     *
     * @return book's id
     */

    public String getIsbn() {
        return isbn;
    }

    /**
     * returns book's title.
     *
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * returns book's list of authors.
     *
     * @return list of authors
     */

    public String getListOfAuthors() {
        return listOfAuthors;
    }

    /**
     * Returns book's year.
     *
     * @return book year
     */
    public int getYear() {
        return year;
    }

    /**
     * Returns book's volume.
     *
     * @return book volume
     */
    public int getVolume() {
        return volume;
    }

    /**
     * Returns string representation of the book.
     */
    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", isbn='" + isbn + '\'' + ", title='" + title + '\'' + ", listOfAuthors='" + listOfAuthors + '\'' + ", year=" + year + ", volume=" + volume + '}';
    }
}

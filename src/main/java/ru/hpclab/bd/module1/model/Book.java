package ru.hpclab.bd.module1.model;
import org.springframework.lang.NonNull;

/**
 * Book model.
 */
public class Book {


    @NonNull
    private String isbn;

    @NonNull
    private String title;

    @NonNull
    private String listOfAuthors;

    private int year;
    private int volume;

    /**
     * Builds new book.
     * @param isbn book isbn
     * @param title book title
     * @param listOfAuthors book list of authors
     * @param year book year
     * @param volume book volume
     */
    public Book(@NonNull final String isbn, @NonNull final String title,
                @NonNull final String listOfAuthors, final int year, final int volume) {
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

    public void setIsbn(@NonNull String isbn) {
        this.isbn = isbn;
    }

    public void setTitle(@NonNull String title) {
        this.title = title;
    }

    public void setListOfAuthors(@NonNull String listOfAuthors) {
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
     * @return book's id
     */

    @NonNull
    public String getISBN() {
        return isbn;
    }

    /**
     * returns book's title.
     * @return title
     */
    @NonNull
    public String getTitle() {
        return title;
    }

    /**
     * returns book's list of authors.
     * @return list of authors
     */

    @NonNull
    public String getListOfAuthors() {
        return listOfAuthors;
    }

    /**
     * Returns book's year.
     * @return book year
     */
    public int getYear() {
        return year;
    }
    /**
     * Returns book's volume.
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
        return "User{"
                + "ISBN=" + isbn + ", "
                + "title='" + title + "'"
                + "list_of_authors='" + listOfAuthors + "'"
                + "year='" + year + "'"
                + "volume='" + volume + "'"
                + "}";
    }
}

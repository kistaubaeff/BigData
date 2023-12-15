package ru.hpclab.bd.module1.entity;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "book")
public class BookEntity {

    @Id
    @Column(name = "isbn")
    private String isbn;

    @Column(name = "title")
    private String title;

    @Column(name = "list_of_authors")
    private String listOfAuthors;

    @Column(name = "year")
    private int year;

    @Column(name = "volume")
    private int volume;

    public BookEntity() {
    }

    public BookEntity(String isbn, String title, String listOfAuthors, int year, int volume) {
        this.isbn = isbn;
        this.title = title;
        this.listOfAuthors = listOfAuthors;
        this.year = year;
        this.volume = volume;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getListOfAuthors() {
        return listOfAuthors;
    }

    public void setListOfAuthors(String listOfAuthors) {
        this.listOfAuthors = listOfAuthors;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "BookEntity{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", listOfAuthors='" + listOfAuthors + '\'' +
                ", year=" + year +
                ", volume=" + volume +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookEntity that = (BookEntity) o;
        return Objects.equals(isbn, that.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }
}

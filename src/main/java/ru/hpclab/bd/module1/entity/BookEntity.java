package ru.hpclab.bd.module1.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "t_book")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String isbn;

    private String title;

    private String listOfAuthors;

    private int year;

    private int volume;

    @OneToMany(mappedBy = "bookEntity", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)

    private List<IssueEntity> issues = new ArrayList<>();

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

    public List<IssueEntity> getIssues() {
        return issues;
    }

    public void setIssues(List<IssueEntity> issues) {
        this.issues = issues;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "BookEntity{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", listOfAuthors='" + listOfAuthors + '\'' +
                ", year=" + year +
                ", volume=" + volume +
                ", issues=" + issues +
                '}';
    }
}

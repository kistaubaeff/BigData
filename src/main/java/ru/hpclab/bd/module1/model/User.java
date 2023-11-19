package ru.hpclab.bd.module1.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User {
    private Long id;
    private UUID identifier;
    private String fio;
    private List<Issue> issues = new ArrayList<>();

    public User(Long id, UUID identifier, String fio, List<Issue> issues) {
        this.id = id;
        this.identifier = identifier;
        this.fio = fio;
        this.issues = issues;
    }

    public User() {
    }

    public void setIssues(List<Issue> issues) {
        this.issues = issues;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getIdentifier() {
        return identifier;
    }

    public void setIdentifier(UUID identifier) {
        this.identifier = identifier;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public List<Issue> getIssues() {
        return issues;
    }

    public void setPhones(List<Issue> issues) {
        this.issues = issues;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", identifier=" + identifier + ", fio='" + fio + '\'' + ", phones=" + issues + '}';
    }
}

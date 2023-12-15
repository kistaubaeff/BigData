package ru.hpclab.bd.module1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.hpclab.bd.module1.mapper.Mapper;
import ru.hpclab.bd.module1.model.Issue;
import ru.hpclab.bd.module1.service.IssueService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public final class IssueController {
    private final IssueService issueService;

    /**
     * Constructs a IssueController with the specified parameters.
     * @param issueService Issue controller
     */
    @Autowired
    public IssueController(final IssueService issueService) {
        this.issueService = issueService;
    }

    /**
     * Retrieves all issues.
     *
     * @return List of issues
     */
    @GetMapping("/issues")
    public List<Issue> getIssues() {
        return issueService.getAllIssues().stream()
                .map(Mapper::entity2Issue).collect(Collectors.toList());
    }

    /**
     * Retrieves an issue by its ID.
     *
     * @param id The ID of the issue
     * @return The issue with the specified ID
     */
    @GetMapping("/issues/{id}")
    public Issue getIssueById(@PathVariable final Long id) {
        return Mapper.entity2Issue(issueService.getIssueById(id));
    }

    /**
     * Deletes an issue by its ID.
     *
     * @param id The ID of the issue to be deleted
     */
    @DeleteMapping("/issues/{id}")
    public void deleteIssue(@PathVariable final Long id) {
        issueService.deleteIssue(id);
    }

    /**
     * Creates a new issue.
     *
     * @param issue The issue to be created
     * @return The created issue
     */
    @PostMapping("/issues")
    public Issue createIssue(@RequestBody final Issue issue) {
        return Mapper.entity2Issue(issueService.createIssue(Mapper.issue2Entity(issue)));
    }

    /**
     * Updates an issue by its ID.
     *
     * @param id    The ID of the issue to be updated
     * @param issue The updated issue information
     * @return The updated issue
     */
    @PutMapping("/issues/{id}")
    public Issue updateIssue(@PathVariable(required = false) final Long id, @RequestBody final Issue issue) {
        return Mapper.entity2Issue(issueService.updateIssue(id, Mapper.issue2Entity(issue)));
    }
}

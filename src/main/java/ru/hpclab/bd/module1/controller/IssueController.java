package ru.hpclab.bd.module1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.hpclab.bd.module1.mapper.UserMapper;
import ru.hpclab.bd.module1.model.Issue;
import ru.hpclab.bd.module1.service.IssueService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class IssueController {
    private final IssueService issueService;

    @Autowired
    public IssueController(IssueService issueService) {
        this.issueService = issueService;
    }

    @GetMapping("/issues")
    public List<Issue> getIssues() {
        return issueService.getAllIssues().stream()
                .map(UserMapper::entity2Issue).collect(Collectors.toList());
    }

    @GetMapping("/issues/{id}")
    public Issue getIssueById(@PathVariable Long id) {
        return UserMapper.entity2Issue(issueService.getIssueById(id));
    }

//    @GetMapping("/issues/phone/{phoneNumber}")
//    public Issue getIssueByPhoneNumber(@PathVariable String phoneNumber) {
//        return IssueMapper.entity2Issue(issueService.getIssueByPhoneNumber(phoneNumber));
//    }

    @DeleteMapping("/issues/{id}")
    public void deleteIssue(@PathVariable Long id) {
        issueService.deleteIssue(id);
    }

    @PostMapping(value = "/issues")
    public Issue createIssue(@RequestBody Issue issue) {
        return UserMapper.entity2Issue(issueService.createIssue(UserMapper.issue2Entity(issue)));
    }

    @PutMapping(value = "/issues/{id}")
    public Issue updateIssue(@PathVariable(required = false) Long id, @RequestBody Issue issue) {
        return UserMapper.entity2Issue(issueService.updateIssue(id, UserMapper.issue2Entity(issue)));
    }

}

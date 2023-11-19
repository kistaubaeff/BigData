package ru.hpclab.bd.module1.service;


import ru.hpclab.bd.module1.controller.exeption.IssueException;
import ru.hpclab.bd.module1.entity.IssueEntity;
import ru.hpclab.bd.module1.repository.BookRepository;
import ru.hpclab.bd.module1.repository.IssueRepository;
import ru.hpclab.bd.module1.repository.UserRepository;

import java.util.List;

import static java.lang.String.format;

/**
 * Service to control issues.
 */
public class IssueService {
    /**
     * User exception not found in repository message.
     */
    public static final String USER_NOT_FOUND_IN_REPO = "This user was not found in user repository";
    /**
     * Book exception not found in repository message.
     */
    public static final String BOOK_NOT_FOUND_IN_REPO = "This book was not found in book repository";

    public static final String ISSUE_NOT_FOUND_MSG = "ssue with %s was not found";
    private final IssueRepository issueRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;
    /**
     * Builds new issueService.
     * @param issueRepository issue repository
     * @param userRepository user repository
     * @param bookRepository book repository
     *
     */
    public IssueService(final IssueRepository issueRepository,
                        final UserRepository userRepository,
                        final BookRepository bookRepository) {
        this.issueRepository = issueRepository;
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
    }
    /**
     * Fetches all issues.
     * @return list of issues
     */
    public List<IssueEntity> getAllIssues() {
        return issueRepository.findAll();
    }
    /**
     * Fetches issue by id.
     * @param id issue id
     * @return issue
     */

    public IssueEntity getIssueById(Long id) {
        return issueRepository.findById(id).orElseThrow(() -> new IssueException(format(ISSUE_NOT_FOUND_MSG, id)));
    }

    /**
     * Creates or updates issue.
     * throws runtime exception
     * @param issueEntity issue to save
     * @return saved issue
     */
    public IssueEntity createIssue(final IssueEntity issueEntity) {
        userRepository.findById(issueEntity.getUserEntity().getId());
        bookRepository.findById(issueEntity.getBookEntity().getId());
        return issueRepository.save(issueEntity);
    }

    /**
     * Deletes issue by id.
     * @param id issue id
     */
    public void deleteIssue(Long id) {
        issueRepository.deleteById(id);
    }

    /**
     * Updates issue.
     * @param id issue id to update
     * @param issueEntity issue with new attributes
     * @return updated issue
     */
    public IssueEntity updateIssue(Long id, final IssueEntity issueEntity) {
        issueEntity.setId(id);
        return issueRepository.save(issueEntity);
    }

}

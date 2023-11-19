package ru.hpclab.bd.module1.repository;

import org.springframework.data.repository.CrudRepository;
import ru.hpclab.bd.module1.entity.IssueEntity;

import java.util.*;

public interface IssueRepository extends CrudRepository<IssueEntity, Long> {

    @Override
    List<IssueEntity> findAll();


}
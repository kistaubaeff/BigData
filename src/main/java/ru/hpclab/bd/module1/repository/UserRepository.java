package ru.hpclab.bd.module1.repository;

import org.springframework.data.repository.CrudRepository;
import ru.hpclab.bd.module1.entity.UserEntity;

import java.util.*;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
    @Override
    List<UserEntity> findAll();
}

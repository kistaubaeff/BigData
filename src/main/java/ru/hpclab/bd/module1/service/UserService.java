package ru.hpclab.bd.module1.service;


import ru.hpclab.bd.module1.controller.exeption.UserException;
import ru.hpclab.bd.module1.entity.UserEntity;
import ru.hpclab.bd.module1.repository.BookRepository;
import ru.hpclab.bd.module1.repository.UserRepository;

import java.util.List;
import java.util.UUID;

import static java.lang.String.format;

public class UserService {
    private final UserRepository userRepository;

    public static final String USER_NOT_FOUND_MSG = "User with ID %s not found";

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }
    public UserRepository getUserRepository() {
        return userRepository;
    }
    public UserEntity getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserException(format(USER_NOT_FOUND_MSG, id)));
    }

    public UserEntity saveUser(UserEntity userEntity) {
        userEntity.setIdentifier(UUID.randomUUID().toString());
        return userRepository.save(userEntity);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public UserEntity updateUser(Long id, UserEntity userEntity) {
        userEntity.setId(id);
        //when id is not empty save works with update logic
        return userRepository.save(userEntity);
    }


}

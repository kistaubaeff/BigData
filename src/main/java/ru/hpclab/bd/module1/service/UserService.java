package ru.hpclab.bd.module1.service;

import ru.hpclab.bd.module1.controller.exeption.UserException;
import ru.hpclab.bd.module1.entity.UserEntity;
import ru.hpclab.bd.module1.repository.UserRepository;

import java.util.List;
import java.util.UUID;

import static java.lang.String.format;

/**
 * Service class for managing users.
 */
public class UserService {

    private final UserRepository userRepository;
    /**
     * User exception not found message.
     */
    public static final String USER_NOT_FOUND_MSG = "User with ID %s not found";
    /**
     * Constructor for UserService.
     *
     * @param userRepository The user repository.
     */
    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Retrieves a list of all users.
     *
     * @return List of UserEntity objects.
     */
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Gets the UserRepository used by this service.
     *
     * @return The UserRepository instance.
     */
    public UserRepository getUserRepository() {
        return userRepository;
    }

    /**
     * Retrieves a user by their ID.
     *
     * @param id The ID of the user.
     * @return The UserEntity with the specified ID.
     * @throws UserException if the user with the given ID is not found.
     */
    public UserEntity getUserById(final Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserException(format(USER_NOT_FOUND_MSG, id)));
    }

    /**
     * Saves a new user.
     *
     * @param userEntity The UserEntity object to be saved.
     * @return The saved UserEntity.
     */
    public UserEntity saveUser(final UserEntity userEntity) {
        userEntity.setIdentifier(UUID.randomUUID().toString());
        return userRepository.save(userEntity);
    }

    /**
     * Deletes a user by their ID.
     *
     * @param id The ID of the user to be deleted.
     */
    public void deleteUser(final Long id) {
        userRepository.deleteById(id);
    }

    /**
     * Updates an existing user.
     *
     * @param id          The ID of the user to be updated.
     * @param userEntity The updated UserEntity object.
     * @return The updated UserEntity.
     */
    public UserEntity updateUser(final Long id, final UserEntity userEntity) {
        userEntity.setId(id);
        // when id is not empty, save works with update logic
        return userRepository.save(userEntity);
    }
}

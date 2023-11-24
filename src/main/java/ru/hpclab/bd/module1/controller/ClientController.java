package ru.hpclab.bd.module1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.hpclab.bd.module1.mapper.Mapper;
import ru.hpclab.bd.module1.model.User;
import ru.hpclab.bd.module1.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public final class ClientController {
    private final UserService userService;

    /**
     * Constructs a UserController with the specified parameters.
     * @param userService user service
     */

    @Autowired
    public ClientController(final UserService userService) {
        this.userService = userService;
    }

    /**
     * Retrieves all users.
     *
     * @return List of users
     */
    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getAllUsers().stream()
                .map(Mapper::entity2User).collect(Collectors.toList());
    }

    /**
     * Retrieves a user by their ID.
     *
     * @param id The ID of the user
     * @return The user with the specified ID
     */
    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable final Long id) {
        return Mapper.entity2User(userService.getUserById(id));
    }

    /**
     * Deletes a user by their ID.
     *
     * @param id The ID of the user to be deleted
     */
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable final Long id) {
        userService.deleteUser(id);
    }

    /**
     * Saves a new user.
     *
     * @param user The user to be saved
     * @return The saved user
     */
    @PostMapping("/users")
    public User saveUser(@RequestBody final User user) {
        return Mapper.entity2User(userService.saveUser(Mapper.user2Entity(user)));
    }

    /**
     * Updates a user by their ID.
     *
     * @param id   The ID of the user to be updated
     * @param user The updated user information
     * @return The updated user
     */
    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable(required = false) final Long id, @RequestBody final User user) {
        return Mapper.entity2User(userService.updateUser(id, Mapper.user2Entity(user)));
    }
}

package assignment.TaskAPI.controller;

import assignment.TaskAPI.model.User;
import assignment.TaskAPI.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Get all users
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // Get user by ID
    @GetMapping("/{id}")
    public User getUserById(@PathVariable String id) {
        return userService.getUserById(id);
    }

    // Create a new user
    @PostMapping
    public User createUser (@RequestBody User user) {
        return userService.createUser (user);
    }

    // Update an existing user
    @PutMapping("/{id}")
    public User updateUser (@PathVariable String id, @RequestBody User user) {
        return userService.updateUser (id, user);
    }

    // Delete a user
    @DeleteMapping("/{id}")
    public void deleteUser (@PathVariable String id) {
        userService.deleteUser (id);
    }

    // Get user by username
    @GetMapping("/username/{username}")
    public Optional<User> getUserByUsername(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }
}

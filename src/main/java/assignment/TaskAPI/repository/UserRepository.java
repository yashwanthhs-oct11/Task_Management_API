package assignment.TaskAPI.repository;

import assignment.TaskAPI.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {

    // Find a user by their username
    Optional<User> findByUsername(String username);

}
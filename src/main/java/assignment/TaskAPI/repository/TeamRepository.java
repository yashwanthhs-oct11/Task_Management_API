package assignment.TaskAPI.repository;

import assignment.TaskAPI.model.Team;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TeamRepository extends MongoRepository<Team, String> {
    Team findByName(String name);
}

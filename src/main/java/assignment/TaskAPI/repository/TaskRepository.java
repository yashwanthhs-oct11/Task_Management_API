package assignment.TaskAPI.repository;

import assignment.TaskAPI.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface TaskRepository extends MongoRepository<Task, String> {
    List<Task> findByCollaboratorsContaining(String userId);
    List<Task> findByDependenciesContaining(String taskId);
    List<Task> findByPriority(String priority);
    List<Task> findByDueDateBefore(LocalDateTime dueDate);
    List<Task> findByDueDateAfter(LocalDateTime dueDate);
}
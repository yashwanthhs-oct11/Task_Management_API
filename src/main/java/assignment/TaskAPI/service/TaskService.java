package assignment.TaskAPI.service;

import assignment.TaskAPI.model.Task;
import assignment.TaskAPI.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskById(String id) {
        return taskRepository.findById(id);
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Task updateTask(String id, Task task) {
        task.setId(id);
        return taskRepository.save(task);
    }

    public void deleteTask(String id) {
        taskRepository.deleteById(id);
    }

    public List<Task> getTasksByCollaborator(String userId) {
        return taskRepository.findByCollaboratorsContaining(userId);
    }

    public List<Task> getTasksByDependency(String taskId) {
        return taskRepository.findByDependenciesContaining(taskId);
    }

    public List<Task> getOverdueTasks() {
        return taskRepository.findByDueDateBefore(LocalDateTime.now());
    }

    public List<Task> getTasksByPriority(String priority) {
        return taskRepository.findByPriority(priority);
    }

    public List<Task> getTasksDueSoon() {
        return taskRepository.findByDueDateAfter(LocalDateTime.now().minusDays(1));
    }

    public void markTaskAsComplete(String id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
        for (String dependencyId : task.getDependencies()) {
            Task dependencyTask = taskRepository.findById(dependencyId).orElseThrow(() -> new RuntimeException("Dependency task not found"));
            if (!dependencyTask.isCompleted()) {
                throw new RuntimeException("Cannot complete this task until all dependencies are completed.");
            }
        }
        task.setCompleted(true);
        taskRepository.save(task);
    }

    public void markTaskAsIncomplete(String id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
        task.setCompleted(false);
        taskRepository.save(task);
    }
}


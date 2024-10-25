package assignment.TaskAPI.controller;

import assignment.TaskAPI.model.Task;
import assignment.TaskAPI.service.TaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    //To Get all tasks
    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    // Get task by ID
    @GetMapping("/{id}")
    public Optional<Task> getTaskById(@PathVariable String id) {
        return taskService.getTaskById(id);
    }

    // Create a new task
    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    // Update an existing task
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable String id, @RequestBody Task task) {
        return taskService.updateTask(id, task);
    }

    // Delete a task
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable String id) {
        taskService.deleteTask(id);
    }

    // Get tasks by collaborator
    @GetMapping("/collaborators/{userId}")
    public List<Task> getTasksByCollaborator(@PathVariable String userId) {
        return taskService.getTasksByCollaborator(userId);
    }

    // Get tasks by dependency
    @GetMapping("/dependencies/{taskId}")
    public List<Task> getTasksByDependency(@PathVariable String taskId) {
        return taskService.getTasksByDependency(taskId);
    }

    // Get overdue tasks
    @GetMapping("/overdue")
    public List<Task> getOverdueTasks() {
        return taskService.getOverdueTasks();
    }

    // Get tasks by priority
    @GetMapping("/priority/{priority}")
    public List<Task> getTasksByPriority(@PathVariable String priority) {
        return taskService.getTasksByPriority(priority);
    }

    // Get tasks due soon (within the next day)
    @GetMapping("/due-soon")
    public List<Task> getTasksDueSoon() {
        return taskService.getTasksDueSoon();
    }

    // Mark a task as complete
    @PutMapping("/{id}/complete")
    public void markTaskAsComplete(@PathVariable String id) {
        taskService.markTaskAsComplete(id);
    }

    // Mark a task as incomplete
    @PutMapping("/{id}/incomplete")
    public void markTaskAsIncomplete(@PathVariable String id) {
        taskService.markTaskAsIncomplete(id);
    }
}
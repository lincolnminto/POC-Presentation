package app.controller;

import app.entity.Task;
import app.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

  private final TaskService taskService;

  @Autowired
  public TaskController(TaskService taskService) {
    this.taskService = taskService;
  }

  @GetMapping
  public List<Task> getAllTasks() {
    return taskService.getAllTasks();
  }

  @GetMapping("/{id}")
  public Task getTaskById(@PathVariable("id") Long id) {
    return taskService.getTaskById(id);
  }

  @PostMapping
  public Task createTask(@RequestBody Task task) {
    return taskService.saveTask(task);
  }

  @PutMapping("/{id}")
  public Task updateTask(@PathVariable("id") Long id, @RequestBody Task task) {
    return taskService.updateTask(id, task);
  }

  @DeleteMapping("/{id}")
  public void deleteTask(@PathVariable("id") Long id) {
    taskService.deleteTaskById(id);
  }

}

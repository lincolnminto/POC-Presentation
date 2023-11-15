package app.service;

import app.dao.TaskRepositoryDAO;
import app.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

  private final TaskRepositoryDAO taskRepositoryDAO;

  @Autowired
  public TaskService(TaskRepositoryDAO taskRepositoryDAO) {
    this.taskRepositoryDAO = taskRepositoryDAO;
  }

  public List<Task> getAllTasks() {
    return taskRepositoryDAO.findAll();
  }

  public List<Task> getCompletedTasks() {
    return taskRepositoryDAO.findByCompleted(true);
  }

  public List<Task> getUncompletedTasks() {
    return taskRepositoryDAO.findByCompleted(false);
  }

  public Task getTaskById(Long id) {
    return taskRepositoryDAO.findById(id).orElse(null);
  }

  public Task saveTask(Task task) {
    return taskRepositoryDAO.save(task);
  }

  public void deleteTaskById(Long id) {
    taskRepositoryDAO.deleteById(id);
  }

  public Task updateTask(Long id, Task task) {
    task.setId(id);
    return taskRepositoryDAO.save(task);
  }
}

package app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity(name = "task")
public class Task implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String title;
  private String description;
  private boolean completed;

  public Long getId() {
    return id;
  }

  public Task setId(Long id) {
    this.id = id;
    return this;
  }

  public String getTitle() {
    return title;
  }

  public Task setTitle(String title) {
    this.title = title;
    return this;
  }

  public String getDescription() {
    return description;
  }

  public Task setDescription(String description) {
    this.description = description;
    return this;
  }

  public boolean isCompleted() {
    return completed;
  }

  public Task setCompleted(boolean completed) {
    this.completed = completed;
    return this;
  }
}

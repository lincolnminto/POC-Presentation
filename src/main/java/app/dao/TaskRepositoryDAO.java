package app.dao;

import app.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("app-TaskRepositoryDAO")
@Transactional(transactionManager = "app-TransactionManager")
public interface TaskRepositoryDAO extends JpaRepository<Task, Long> {

  @Query("SELECT t FROM app.entity.Task t WHERE t.completed = :completed")
  List<Task> findByCompleted(@Param("completed") boolean completed);
}

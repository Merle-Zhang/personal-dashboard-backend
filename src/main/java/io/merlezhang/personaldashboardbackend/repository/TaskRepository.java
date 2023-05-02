package io.merlezhang.personaldashboardbackend.repository;

import io.merlezhang.personaldashboardbackend.entity.Task;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(collectionResourceRel = "tasks", path = "tasks")
public interface TaskRepository extends PagingAndSortingRepository<Task, Long> {
  List<Task> findByTitle(@Param("title") String title);

  Task save(Task task);
}

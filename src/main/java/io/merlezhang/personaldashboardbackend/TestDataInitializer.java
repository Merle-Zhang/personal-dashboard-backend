package io.merlezhang.personaldashboardbackend;

import io.merlezhang.personaldashboardbackend.entity.Task;
import io.merlezhang.personaldashboardbackend.repository.TaskRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TestDataInitializer implements CommandLineRunner {

  private final TaskRepository taskRepository;

  public TestDataInitializer(TaskRepository taskRepository) {
    this.taskRepository = taskRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    Task task1 = new Task((long) 1, "task1", "todo");
    Task task2 = new Task((long) 2, "task2", "todo");
    Task task3 = new Task((long) 3, "task3", "inprogress");
    Task task4 = new Task((long) 4, "task4", "inprogress");
    Task task5 = new Task((long) 5, "task5", "done");
    Task task6 = new Task((long) 6, "task6", "done");
    Task task7 = new Task((long) 7, "task7", "done");

    taskRepository.save(task1);
    taskRepository.save(task2);
    taskRepository.save(task3);
    taskRepository.save(task4);
    taskRepository.save(task5);
    taskRepository.save(task6);
    taskRepository.save(task7);
  }
}

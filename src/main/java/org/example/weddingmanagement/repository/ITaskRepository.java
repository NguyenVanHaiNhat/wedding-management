package org.example.weddingmanagement.repository;

import org.example.weddingmanagement.model.entity.Category;
import org.example.weddingmanagement.model.entity.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface ITaskRepository extends CrudRepository<Task, Long> {
    Iterable<Task> findAllByCategory(Category category);
    Page<Task> findAll(Pageable pageable);
    Page<Task> findAllByNameTaskContaining(Pageable pageable, String nameTask);
}

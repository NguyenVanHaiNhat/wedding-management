package org.example.weddingmanagement.service;

import org.example.weddingmanagement.model.entity.Category;
import org.example.weddingmanagement.model.entity.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ITaskService extends IGenerateService<Task> {
    Iterable<Task> findAllByCategory(Category category);

    Page<Task> findAll(Pageable pageable);
    Page<Task> findAllByName(Pageable pageable, String nameTask);
}

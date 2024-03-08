package org.example.weddingmanagement.service.impl;

import org.example.weddingmanagement.model.entity.Category;
import org.example.weddingmanagement.model.entity.Task;
import org.example.weddingmanagement.repository.ITaskRepository;
import org.example.weddingmanagement.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class TaskService implements ITaskService {
    @Autowired
    private ITaskRepository iTaskRepository;
    @Override
    public Iterable<Task> findAll() {
        return iTaskRepository.findAll();
    }

    @Override
    public void save(Task task) {
        iTaskRepository.save(task);
    }

    @Override
    public Optional<Task> findById(Long id) {
        return iTaskRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        iTaskRepository.deleteById(id);
    }

    @Override
    public Iterable<Task> findAllByCategory(Category category) {
        return iTaskRepository.findAllByCategory(category);
    }

    @Override
    public Page<Task> findAll(Pageable pageable) {
        return iTaskRepository.findAll(pageable);
    }

    @Override
    public Page<Task> findAllByName(Pageable pageable, String nameTask) {
        return iTaskRepository.findAllByNameTaskContaining(pageable, nameTask);
    }
}

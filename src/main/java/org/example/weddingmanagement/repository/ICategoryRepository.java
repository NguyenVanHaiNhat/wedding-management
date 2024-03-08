package org.example.weddingmanagement.repository;

import org.example.weddingmanagement.model.entity.Category;
import org.springframework.data.repository.CrudRepository;

public interface ICategoryRepository extends CrudRepository<Category, Long> {
}

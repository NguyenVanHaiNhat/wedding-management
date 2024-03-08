package org.example.weddingmanagement.service.impl;

import org.example.weddingmanagement.model.DTO.Statistical;
import org.example.weddingmanagement.model.entity.Category;
import org.example.weddingmanagement.repository.ICategoryRepository;
import org.example.weddingmanagement.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository iCategoryRepository;
    @Override
    public Iterable<Category> findAll() {
        return iCategoryRepository.findAll();
    }

    @Override
    public void save(Category category) {
        iCategoryRepository.save(category);
    }

    @Override
    public Optional<Category> findById(Long id) {
        return iCategoryRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        iCategoryRepository.deleteById(id);
    }

    @Override
    public Iterable<Statistical> statistical() {
        return iCategoryRepository.statistical();
    }
}

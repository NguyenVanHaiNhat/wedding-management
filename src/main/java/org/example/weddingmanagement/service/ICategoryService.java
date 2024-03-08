package org.example.weddingmanagement.service;

import org.example.weddingmanagement.model.DTO.Statistical;
import org.example.weddingmanagement.model.entity.Category;

public interface ICategoryService extends IGenerateService<Category> {
    Iterable<Statistical> statistical();
}

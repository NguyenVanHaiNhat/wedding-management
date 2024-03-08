package org.example.weddingmanagement.formatter;

import org.example.weddingmanagement.model.entity.Category;
import org.example.weddingmanagement.service.ICategoryService;
import org.springframework.format.Formatter;

import java.util.Locale;
import java.util.Optional;

public class CategoryFormatter implements Formatter<Category> {
    private final ICategoryService categoryService;

    public CategoryFormatter(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public Category parse(String text, Locale locale) {
        Optional<Category> optionalCategory = categoryService.findById(Long.parseLong(text));
        return optionalCategory.orElse(null);
    }

    @Override
    public String print(Category object, Locale locale) {
        return "[" + object.getId_Category() + ", " + object.getNameCategory() + "]";
    }
}

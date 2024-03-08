package org.example.weddingmanagement.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Category;
    private String nameCategory;
    private String description;

    public Category() {
    }

    public Category(Long id_Category, String nameCategory, String description) {
        this.id_Category = id_Category;
        this.nameCategory = nameCategory;
        this.description = description;
    }

    public Long getId_Category() {
        return id_Category;
    }

    public void setId_Category(Long id_Category) {
        this.id_Category = id_Category;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

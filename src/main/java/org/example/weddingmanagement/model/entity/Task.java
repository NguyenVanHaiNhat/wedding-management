package org.example.weddingmanagement.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Task;
    private String nameTask;
    private String note;
    private double price;
    @ManyToOne
    @JoinColumn(name = "id_Category")
    private Category category;

    public Task() {
    }

    public Long getId_Task() {
        return id_Task;
    }

    public void setId_Task(Long id_Task) {
        this.id_Task = id_Task;
    }

    public String getNameTask() {
        return nameTask;
    }

    public void setNameTask(String nameTask) {
        this.nameTask = nameTask;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

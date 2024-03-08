package org.example.weddingmanagement.repository;

import org.example.weddingmanagement.model.DTO.Statistical;
import org.example.weddingmanagement.model.entity.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ICategoryRepository extends CrudRepository<Category, Long> {
    @Query(nativeQuery = true, value = "select c.nameCategory, sum(t.price) as totalPrice from\n" +
            "             category c join wedding.task t on c.id_Category = t.id_Category\n" +
            "group by c.nameCategory;")
    Iterable<Statistical> statistical();
}

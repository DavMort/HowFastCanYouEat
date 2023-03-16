package com.example.HowFastCanEat;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RecordsRepository extends CrudRepository<Records, Integer> {
    @Query(value = "SELECT PERSON.NAME \"Name\", FOOD.NAME \"Food\", COUNT_EATEN \"Count\", TIME_MINUTES, round(1.0 * count_eaten / time_minutes, 2) as \"FPM\" FROM RECORDS\n" +
            "RIGHT JOIN PERSON\n" +
            "ON PERSON.ID = RECORDS.PERSON_ID\n" +
            "RIGHT JOIN FOOD\n" +
            "ON FOOD.ID = RECORDS.FOOD_ID\n" +
            "where food.id = ?1\n" +
            "order by count_eaten desc", nativeQuery = true)
    List<Records> findAllByFoodId(Integer food_id);

    List<Records> findAllByOrderByIdDesc();
}

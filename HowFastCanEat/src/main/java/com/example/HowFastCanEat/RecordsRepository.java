package com.example.HowFastCanEat;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RecordsRepository extends CrudRepository<Records, Integer> {
    @Query(value = """
            SELECT PERSON.NAME, FOOD.NAME, COUNT_EATEN, TIME_MINUTES FROM RECORDS
            RIGHT JOIN PERSON
            ON PERSON.ID = RECORDS.PERSON_ID
            RIGHT JOIN FOOD
            ON FOOD.ID = RECORDS.FOOD_ID
            order by count_eaten desc""", nativeQuery = true)
    List<Records> findAllByFoodId(Integer food_id);

    List<Records> findAllByOrderByIdDesc();
}

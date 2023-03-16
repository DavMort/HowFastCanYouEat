package com.example.HowFastCanEat;

import jakarta.persistence.*;

@Entity
public class Records {

    @Id
    @GeneratedValue /*(strategy = GenerationType.IDENTITY)*/
    private Integer id;
    private Integer person_id;
    private Integer food_id;
    private Integer count_eaten;
    private Integer time_minutes;

    public Records() {
    }

    public Records(Integer id, Integer person_id, Integer food_id, Integer count_eaten, Integer time_minutes) {
        this.id = id;
        this.person_id = person_id;
        this.food_id = food_id;
        this.count_eaten = count_eaten;
        this.time_minutes = time_minutes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPerson_id() {
        return person_id;
    }

    public void setPerson_id(Integer person_id) {
        this.person_id = person_id;
    }

    public Integer getFood_id() {
        return food_id;
    }

    public void setFood_id(Integer food_id) {
        this.food_id = food_id;
    }

    public Integer getCount_eaten() {
        return count_eaten;
    }

    public void setCount_eaten(Integer count_eaten) {
        this.count_eaten = count_eaten;
    }

    public Integer getTime_minutes() {
        return time_minutes;
    }

    public void setTime_minutes(Integer time_minutes) {
        this.time_minutes = time_minutes;
    }

}

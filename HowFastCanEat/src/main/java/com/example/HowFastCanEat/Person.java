package com.example.HowFastCanEat;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
public class Person {

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private List<Records> records = new ArrayList<>();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;


    public Person() {
    }

    public Person(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package com.example.HowFastCanEat;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

public class Food {
    @NotEmpty
    String name;
    @Positive
    Integer numberOfFood;
    @Positive
    Integer time;
    double kpm;

    public Food() {

    }
    public Food(String name, Integer numberOfFood, Integer time) {
        this.name = name;
        this.numberOfFood = numberOfFood;
        this.time = time;
        this.kpm = (double)numberOfFood / time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumberOfFood() {
        return numberOfFood;
    }

    public void setNumberOfFood(int numberOfFood) {
        this.numberOfFood = numberOfFood;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public double getKpm() {
        return kpm;
    }

    public void setKpm(int kpm) {
        this.kpm = kpm;
    }
}

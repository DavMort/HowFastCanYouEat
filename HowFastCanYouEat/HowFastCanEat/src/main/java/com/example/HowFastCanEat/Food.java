package com.example.HowFastCanEat;

public class Food {
    String name;
    int numberOfFood;
    int time;
    int kpm;

    public Food(String name, int numberOfFood, int time) {
        this.name = name;
        this.numberOfFood = numberOfFood;
        this.time = time;
        this.kpm = numberOfFood / time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfFood() {
        return numberOfFood;
    }

    public void setNumberOfFood(int numberOfFood) {
        this.numberOfFood = numberOfFood;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getKpm() {
        return kpm;
    }

    public void setKpm(int kpm) {
        this.kpm = kpm;
    }
}

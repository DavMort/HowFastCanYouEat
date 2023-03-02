package com.example.HowFastCanEat;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class Records {

    public ArrayList<Food> korvList = new ArrayList<>();
    public ArrayList<Food> pizzaList = new ArrayList<>();
    public ArrayList<Food> burgerList = new ArrayList<>();


    public Records() {
        populateKorvList();
        populatePizzaList();
        populateBurgerList();
    }

    public void addFood(ArrayList<Food> list, String name, Integer number, Integer time) {
        list.add(new Food(name, number, time));
        sortList(list);
    }

    public ArrayList<Food> top3(ArrayList<Food> list) {
        sortList(list);
        ArrayList<Food> top3 = new ArrayList<>();
        if (list.size() > 3) {
            for (int i = 0; i < 3; i++) {
                top3.add(list.get(i));
            }
        } else {
            for (int i = 0; i < list.size(); i++) {
                top3.add(list.get(i));
            }
        }
        return top3;
    }

    public void sortList(ArrayList<Food> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            Food temp = list.get(i);
            if (list.get(i + 1).getNumberOfFood() > temp.getNumberOfFood()) {
                list.remove(i);
                list.add(temp);
                i = 0;
            }
        }
    }
    public void populateKorvList() {
        korvList.add(new Food("David", 10, 2));
        sortList(korvList);
    }

    public void populatePizzaList() {
        pizzaList.add(new Food("Jesper", 10, 3));
        pizzaList.add(new Food("Olle", 11, 5));
        pizzaList.add(new Food("Frida", 22, 9));
        pizzaList.add(new Food("Anders", 13, 10));
        pizzaList.add(new Food("Zirha", 12, 5));
        pizzaList.add(new Food("Johan", 16, 3));
        sortList(pizzaList);
    }

    public void populateBurgerList() {
        burgerList.add(new Food("Zirha", 10, 3));
        burgerList.add(new Food("Johan", 11, 5));
        burgerList.add(new Food("David", 22, 15));
        burgerList.add(new Food("Yoshi", 13, 8));
        burgerList.add(new Food("Jesper", 12, 7));
        burgerList.add(new Food("Pedro", 16, 10));
        sortList(burgerList);
    }
}

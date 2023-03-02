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
        for (int i = 0; i < 3; i++) {
            top3.add(list.get(i));
        }
        return top3;
    }

    public void sortList(ArrayList<Food> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            Food temp = list.get(i);
            if (list.get(i + 1).getKpm() > temp.getKpm()) {
                list.remove(i);
                list.add(temp);
                i = 0;
            }
        }
    }
    public void populateKorvList() {
        korvList.add(new Food("Jesper", 10, 2));
        korvList.add(new Food("Jesper", 11, 2));
        korvList.add(new Food("Jesper", 22, 2));
        korvList.add(new Food("Jesper", 13, 2));
        korvList.add(new Food("Jesper", 12, 2));
        korvList.add(new Food("Jesper", 16, 2));
        korvList.add(new Food("Jesper", 2, 2));
        korvList.add(new Food("Jesper", 4, 2));
        korvList.add(new Food("Jesper", 5, 2));
        korvList.add(new Food("Jesper", 7, 2));
        korvList.add(new Food("Jesper", 21, 2));
        sortList(korvList);
    }

    public void populatePizzaList() {
        pizzaList.add(new Food("Jesper", 10, 2));
        pizzaList.add(new Food("Jesper", 11, 2));
        pizzaList.add(new Food("Jesper", 22, 2));
        pizzaList.add(new Food("Jesper", 13, 2));
        pizzaList.add(new Food("Jesper", 12, 2));
        pizzaList.add(new Food("Jesper", 16, 2));
        sortList(pizzaList);
    }

    public void populateBurgerList() {
        burgerList.add(new Food("Jesper", 10, 2));
        burgerList.add(new Food("Jesper", 11, 2));
        burgerList.add(new Food("Jesper", 22, 2));
        burgerList.add(new Food("Jesper", 13, 2));
        burgerList.add(new Food("Jesper", 12, 2));
        burgerList.add(new Food("Jesper", 16, 2));
        sortList(burgerList);
    }
}

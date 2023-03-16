package com.example.HowFastCanEat;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class Records {

    public ArrayList<OldFood> korvList = new ArrayList<>();
    public ArrayList<OldFood> pizzaList = new ArrayList<>();
    public ArrayList<OldFood> burgerList = new ArrayList<>();


    public Records() {
        populateKorvList();
        populatePizzaList();
        populateBurgerList();
    }

    public void addFood(ArrayList<OldFood> list, String name, Integer number, Integer time) {
        list.add(new OldFood(name, number, time));
        sortList(list);
    }

    public ArrayList<OldFood> top3(ArrayList<OldFood> list) {
        sortList(list);
        ArrayList<OldFood> top3 = new ArrayList<>();
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

    public void sortList(ArrayList<OldFood> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            OldFood temp = list.get(i);
            if (list.get(i + 1).getNumberOfFood() > temp.getNumberOfFood()) {
                list.remove(i);
                list.add(temp);
                i = 0;
            }
        }
    }
    public void populateKorvList() {
        korvList.add(new OldFood("David", 10, 2));
        sortList(korvList);
    }

    public void populatePizzaList() {
        pizzaList.add(new OldFood("Jesper", 10, 3));
        pizzaList.add(new OldFood("Olle", 11, 5));
        pizzaList.add(new OldFood("Frida", 22, 9));
        pizzaList.add(new OldFood("Anders", 13, 10));
        pizzaList.add(new OldFood("Zirha", 12, 5));
        pizzaList.add(new OldFood("Johan", 16, 3));
        sortList(pizzaList);
    }

    public void populateBurgerList() {
        burgerList.add(new OldFood("Zirha", 10, 3));
        burgerList.add(new OldFood("Johan", 11, 5));
        burgerList.add(new OldFood("David", 22, 15));
        burgerList.add(new OldFood("Yoshi", 13, 8));
        burgerList.add(new OldFood("Jesper", 12, 7));
        burgerList.add(new OldFood("Pedro", 16, 10));
        sortList(burgerList);
    }
}

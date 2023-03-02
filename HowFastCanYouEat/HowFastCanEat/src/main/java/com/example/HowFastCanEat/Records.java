package com.example.HowFastCanEat;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class Records {
    public ArrayList<Food> korvList = new ArrayList<>();
    public ArrayList<Food> pizzaList = new ArrayList<>();
    public ArrayList<Food> burgerList = new ArrayList<>();

    public Records() {

        korvList.add(new Food("Jesper", 10, 2));
    }


    public void addKorv(String name, int number, int time) {
        korvList.add(new Food(name, number, time));
    }

    public ArrayList<Food> top3Korv() {
        ArrayList<Food> top3 = new ArrayList<>();
        for (Food f : korvList) {
            if (top3.size() < 4) {
                top3.add(f);
            }
            for (Food top : top3) {
                if (f.getKpm() > top.kpm) {
                    top3.remove(top);
                    top3.add(f);
                }
            }
        }
        return top3;
    }
}

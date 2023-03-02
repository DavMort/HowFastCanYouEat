package com.example.HowFastCanEat;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class HFCEController {

    @Autowired
    Records records;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("foodHotDog", new Food());
        model.addAttribute("foodPizza", new Food());
        model.addAttribute("foodBurger", new Food());
        model.addAttribute("korvList", records.top3(records.korvList));
        model.addAttribute("pizzaList", records.top3(records.pizzaList));
        model.addAttribute("burgerList", records.top3(records.burgerList));
        return "index";
    }

    @PostMapping("/saveHotdog")
    public String newRecordHotdog(@Valid Food foodHotDog, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("foodHotDog", foodHotDog);
            model.addAttribute("foodPizza", new Food());
            model.addAttribute("foodBurger", new Food());
            model.addAttribute("korvList", records.top3(records.korvList));
            model.addAttribute("pizzaList", records.top3(records.pizzaList));
            model.addAttribute("burgerList", records.top3(records.burgerList));
            return "index";
        }
        records.addFood(records.korvList, foodHotDog.name, foodHotDog.numberOfFood, foodHotDog.time);
        records.sortList(records.korvList);
        return "redirect:/";
    }

    @PostMapping("/savePizza")
    public String newRecordPizza(@Valid Food foodPizza, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("foodHotDog", new Food());
            model.addAttribute("foodPizza", foodPizza);
            model.addAttribute("foodBurger", new Food());
            model.addAttribute("korvList", records.top3(records.korvList));
            model.addAttribute("pizzaList", records.top3(records.pizzaList));
            model.addAttribute("burgerList", records.top3(records.burgerList));
            return "index";
        }
        records.addFood(records.pizzaList, foodPizza.name, foodPizza.numberOfFood, foodPizza.time);
        records.sortList(records.pizzaList);
        return "redirect:/";
    }

    @PostMapping("/saveBurger")
    public String newRecordBurger(@Valid Food foodBurger, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("foodHotDog", new Food());
            model.addAttribute("foodPizza", new Food());
            model.addAttribute("foodBurger", foodBurger);
            model.addAttribute("korvList", records.top3(records.korvList));
            model.addAttribute("pizzaList", records.top3(records.pizzaList));
            model.addAttribute("burgerList", records.top3(records.burgerList));
            return "index";
        }
        records.addFood(records.burgerList, foodBurger.name, foodBurger.numberOfFood, foodBurger.time);
        records.sortList(records.burgerList);
        return "redirect:/";
    }

    @GetMapping("/topdogs")
    public String allDogs(Model model) {
        model.addAttribute("food", "HotDogs");
        model.addAttribute("list", records.korvList);
        return "fullList";
    }

    @GetMapping("/toppizza")
    public String allPizza(Model model) {
        model.addAttribute("food", "Pizzas");
        model.addAttribute("list", records.pizzaList);
        return "fullList";
    }

    @GetMapping("/topburger")
    public String allBurger(Model model) {
        model.addAttribute("food", "Burgers");
        model.addAttribute("list", records.burgerList);
        return "fullList";
    }
}

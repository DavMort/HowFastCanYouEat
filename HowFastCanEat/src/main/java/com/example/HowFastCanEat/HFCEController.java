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
        model.addAttribute("food", new Food());
        model.addAttribute("korvList", records.top3(records.korvList));
        model.addAttribute("pizzaList", records.top3(records.pizzaList));
        model.addAttribute("burgerList", records.top3(records.burgerList));
        return "index";
    }

    @PostMapping("/saveHotdog")
    public String newRecordHotdog(@Valid Food food, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("korvList", records.top3(records.korvList));
            model.addAttribute("pizzaList", records.top3(records.pizzaList));
            model.addAttribute("burgerList", records.top3(records.burgerList));
            return "index";
        }
        records.addFood(records.korvList, food.name, food.numberOfFood, food.time);
        records.sortList(records.korvList);
        return "redirect:/";
    }

    @PostMapping("/savePizza")
    public String newRecordPizza(@Valid Food food, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("korvList", records.top3(records.korvList));
            model.addAttribute("pizzaList", records.top3(records.pizzaList));
            model.addAttribute("burgerList", records.top3(records.burgerList));
            return "index";
        }
        records.addFood(records.pizzaList, food.name, food.numberOfFood, food.time);
        records.sortList(records.pizzaList);
        return "redirect:/";
    }

    @PostMapping("/saveBurger")
    public String newRecordBurger(@Valid Food food, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("korvList", records.top3(records.korvList));
            model.addAttribute("pizzaList", records.top3(records.pizzaList));
            model.addAttribute("burgerList", records.top3(records.burgerList));
            return "index";
        }
        records.addFood(records.burgerList, food.name, food.numberOfFood, food.time);
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

package com.example.HowFastCanEat;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.sql.DataSource;


@Controller
public class HFCEController {

    @Autowired
    DataSource datasource;
    @Autowired
    OldRecords oldRecords;

    @Autowired
    RecordsService recordsService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("foodHotDog", new OldFood());
        model.addAttribute("foodPizza", new OldFood());
        model.addAttribute("foodBurger", new OldFood());
        model.addAttribute("korvList", oldRecords.top3(oldRecords.korvList));
        model.addAttribute("pizzaList", oldRecords.top3(oldRecords.pizzaList));
        model.addAttribute("burgerList", oldRecords.top3(oldRecords.burgerList));
        return "index";
    }

    @PostMapping("/saveHotdog")
    public String newRecordHotdog(@Valid OldFood oldFoodHotDog, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("foodHotDog", oldFoodHotDog);
            model.addAttribute("foodPizza", new OldFood());
            model.addAttribute("foodBurger", new OldFood());
            model.addAttribute("korvList", oldRecords.top3(oldRecords.korvList));
            model.addAttribute("pizzaList", oldRecords.top3(oldRecords.pizzaList));
            model.addAttribute("burgerList", oldRecords.top3(oldRecords.burgerList));
            return "index";
        }
        oldRecords.addFood(oldRecords.korvList, oldFoodHotDog.name, oldFoodHotDog.numberOfFood, oldFoodHotDog.time);
        oldRecords.sortList(oldRecords.korvList);
        return "redirect:/";
    }

    @PostMapping("/savePizza")
    public String newRecordPizza(@Valid OldFood oldFoodPizza, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("foodHotDog", new OldFood());
            model.addAttribute("foodPizza", oldFoodPizza);
            model.addAttribute("foodBurger", new OldFood());
            model.addAttribute("korvList", oldRecords.top3(oldRecords.korvList));
            model.addAttribute("pizzaList", oldRecords.top3(oldRecords.pizzaList));
            model.addAttribute("burgerList", oldRecords.top3(oldRecords.burgerList));
            return "index";
        }
        oldRecords.addFood(oldRecords.pizzaList, oldFoodPizza.name, oldFoodPizza.numberOfFood, oldFoodPizza.time);
        oldRecords.sortList(oldRecords.pizzaList);
        return "redirect:/";
    }

    @PostMapping("/saveBurger")
    public String newRecordBurger(@Valid OldFood oldFoodBurger, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("foodHotDog", new OldFood());
            model.addAttribute("foodPizza", new OldFood());
            model.addAttribute("foodBurger", oldFoodBurger);
            model.addAttribute("korvList", oldRecords.top3(oldRecords.korvList));
            model.addAttribute("pizzaList", oldRecords.top3(oldRecords.pizzaList));
            model.addAttribute("burgerList", oldRecords.top3(oldRecords.burgerList));
            return "index";
        }
        oldRecords.addFood(oldRecords.burgerList, oldFoodBurger.name, oldFoodBurger.numberOfFood, oldFoodBurger.time);
        oldRecords.sortList(oldRecords.burgerList);
        return "redirect:/";
    }

    @GetMapping("/topdogs")
    public String allDogs(Model model) {
        model.addAttribute("food", "HotDogs");
        model.addAttribute("list", oldRecords.korvList);
        return "fullList";
    }

    @GetMapping("/toppizza")
    public String allPizza(Model model) {
        model.addAttribute("food", "Pizzas");
        model.addAttribute("list", oldRecords.pizzaList);
        return "fullList";
    }

    @GetMapping("/topburger")
    public String allBurger(Model model) {
        model.addAttribute("food", "Burgers");
        model.addAttribute("list", oldRecords.burgerList);
        return "fullList";
    }

    @GetMapping("/test")
    public String testTop3(Model model) {
        model.addAttribute("record", recordsService.getTopThree());
        model.addAttribute("persons", recordsService.getAllPerson());
        return "test";
    }
}

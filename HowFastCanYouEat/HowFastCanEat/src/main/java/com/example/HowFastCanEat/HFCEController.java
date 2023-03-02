package com.example.HowFastCanEat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HFCEController {

    @Autowired
    Records records;

    @GetMapping("/")
   public String index (Model model){
        model.addAttribute("korvList",records.korvList);
        return "index";
    }

    @PostMapping("/")
    public String index1 (Model model){
        
    }

}

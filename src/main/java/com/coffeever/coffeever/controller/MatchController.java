package com.coffeever.coffeever.controller;

import com.coffeever.coffeever.model.CoffeeBean;
import com.coffeever.coffeever.service.CoffeeBeanCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MatchController {
    @Autowired
    CoffeeBeanCrudService coffeeBeanCrudService;
    @PostMapping("/findBestMatch/{aroma}/{acidity}/{body}/{flavor}")
    public CoffeeBean findBestMatch(@PathVariable("aroma") int aroma, @PathVariable("acidity") int acidity, @PathVariable("body") int body, @PathVariable("flavor") int flavor) {
        return coffeeBeanCrudService.findBestMatch(aroma, acidity, body, flavor);
    }
}

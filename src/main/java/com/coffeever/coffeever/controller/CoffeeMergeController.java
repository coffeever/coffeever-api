package com.coffeever.coffeever.controller;


import com.coffeever.coffeever.model.CoffeeMerged;
import com.coffeever.coffeever.model.ReturnCoffes;
import com.coffeever.coffeever.service.CoffeeMergeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CoffeeMergeController {

    @Autowired
    CoffeeMergeService coffeeMergeService;

    @GetMapping("/getAllCoffees")
    public List<CoffeeMerged> findAllBeans() {

        return coffeeMergeService.getAllCoffees();
    }

    @GetMapping("/findBestMatch")
    public List<ReturnCoffes> findBestMatches(@RequestBody CoffeeMerged coffeeMerged) {
    /*
        return  coffeeMergeService.findBestMatch(coffeeMerged.getAroma(),coffeeMerged.getAcidity(),
                coffeeMerged.getBody(),coffeeMerged.getFlavor(),
                coffeeMerged.getDecaf(),coffeeMerged.getKeywords());*/

        //istenen field'lar bununla döndürülecek
        List<CoffeeMerged> bestMatchesList =
                coffeeMergeService.findBestMatch(coffeeMerged.getAroma(),coffeeMerged.getAcidity(),
                        coffeeMerged.getBody(),coffeeMerged.getFlavor(),
                        coffeeMerged.getDecaf(),coffeeMerged.getKeywords());

        return coffeeMergeService.rightFieldsCoffee(bestMatchesList);

    }

    // id ile kahve döndür
    @GetMapping("/getSingleCoffee")
    public CoffeeMerged getSingleCoffee(@RequestParam String slug) {

        return coffeeMergeService.getCoffeeById(slug);
    }
}


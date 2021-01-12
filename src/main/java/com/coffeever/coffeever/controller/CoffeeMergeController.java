package com.coffeever.coffeever.controller;


import com.coffeever.coffeever.model.CoffeeMerged;
import com.coffeever.coffeever.model.User;
import com.coffeever.coffeever.service.CoffeeMergeService;
import com.coffeever.coffeever.service.UserCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CoffeeMergeController {

    @Autowired
    CoffeeMergeService coffeeMergeService;
    UserCrudService userCrudService;

    @GetMapping("/getAllCoffees")
    public List<CoffeeMerged> findAllBeans() {

        return coffeeMergeService.getAllCoffees();
    }

    @GetMapping("/findBestMatch")
    public List<CoffeeMerged> findBestMatches(@RequestBody CoffeeMerged coffeeMerged) {

        return  coffeeMergeService.findBestMatch(coffeeMerged.getAroma(),coffeeMerged.getAcidity(),
                coffeeMerged.getBody(),coffeeMerged.getFlavor(),
                coffeeMerged.getDecaf(),coffeeMerged.getKeywords());

    }

    @GetMapping("/findBestMatch2/{aroma}/{acidity}/{body}/{flavor}/{decaf}")
    public List<CoffeeMerged> findBestMatch2(@PathVariable("aroma") int aroma, @PathVariable("decaf") int decaf, @PathVariable("acidity") int acidity, @PathVariable("body") int body, @PathVariable("flavor") int flavor) {
        return coffeeMergeService.findBestMatch(aroma, acidity, body, flavor, decaf, "");
    }

    @GetMapping("/addFavorite")
    public void addFavorite(@RequestBody User user){

        coffeeMergeService.addFavorite(user.getGoogle_id(), user.getFavorites());
    }

    @GetMapping("/findBasedOnFavs")
    public List<CoffeeMerged> findBasedOnFavs(@RequestBody User user){

        return coffeeMergeService.findBasedOnFavs(user.getGoogle_id());
    }
}
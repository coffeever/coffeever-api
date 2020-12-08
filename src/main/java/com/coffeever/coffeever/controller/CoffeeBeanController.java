package com.coffeever.coffeever.controller;

import com.coffeever.coffeever.model.CoffeeBean;
import com.coffeever.coffeever.service.CoffeeBeanCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CoffeeBeanController {

    @Autowired
    CoffeeBeanCrudService coffeeBeanCrudService;

    @GetMapping("/getAllCoffees")
    public List<CoffeeBean> findAllBeans() {
        return coffeeBeanCrudService.getAllBeans();
    }
}


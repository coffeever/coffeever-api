package com.coffeever.coffeever.service;

import com.coffeever.coffeever.model.CoffeeBean;
import com.coffeever.coffeever.repository.CoffeBeanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoffeeBeanCrudService {

    @Autowired
    CoffeBeanRepository coffeBeanRepository;

    //databaseden id ile coffeebean döndürür
    public CoffeeBean getBeanById(String slug) {
        return coffeBeanRepository.findById(slug).orElse(null);
    }

    //databasedeki coffeebean listesini döndürür
    public List<CoffeeBean> getAllBeans() {
        return coffeBeanRepository.findAll();
    }

    // bu method closest bean'e alınacak.
    public CoffeeBean findBestMatch(int aroma, int acidity, int body, int flavor) {
        CoffeeBean askedBean = new CoffeeBean(aroma, acidity, body, flavor);
        ClosestBeanService closestBean = new ClosestBeanService();
        return closestBean.bestMatch(askedBean, getAllBeans());
    }
}

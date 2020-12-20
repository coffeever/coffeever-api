package com.coffeever.coffeever.service;


import com.coffeever.coffeever.model.CoffeeMerged;
import com.coffeever.coffeever.model.ReturnCoffes;
import com.coffeever.coffeever.repository.CoffeeMergedRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CoffeeMergeService {

    @Autowired
    CoffeeMergedRepo coffeeMergedRepo;

    //databaseden id ile coffee döndürür
    public CoffeeMerged getCoffeeById(String slug) {
        return coffeeMergedRepo.findById(slug).orElse(null);
    }


    //5 coffee ile istenen fieldları döndüren method
    public ArrayList<ReturnCoffes> rightFieldsCoffee(List<CoffeeMerged> coffes) {
        ArrayList<ReturnCoffes> coffeeList = new ArrayList<>();

        for(int i=0;i<5;i++) {

            ReturnCoffes returnCoffes = new ReturnCoffes(coffes.get(i).getSlug(),
                    coffes.get(i).getAroma(),coffes.get(i).getAcidity(),
                    coffes.get(i).getBody(),coffes.get(i).getFlavor(),
                    coffes.get(i).getRoast(),coffes.get(i).getRegion(),
                    coffes.get(i).getDecaf(),coffes.get(i).getName(),
                    coffes.get(i).getBlindAssessment());

            coffeeList.add(returnCoffes);
        }
        return  coffeeList;
    }

    // Return best match based on given 6 main parameters
    public List<CoffeeMerged> findBestMatch(int aroma, int acidity, int body, int flavor, int decaf, String keywords) {
        CoffeeMerged askedBean = new CoffeeMerged(aroma, acidity, body, flavor, decaf, keywords);
        TopNBestMatches closestBeans = new TopNBestMatches();
        return closestBeans.bestMatch(askedBean, getAllCoffees());
    }




    //databasedeki coffee listesini döndürür
    public List<CoffeeMerged> getAllCoffees() {
        return coffeeMergedRepo.findAll();
    }
}

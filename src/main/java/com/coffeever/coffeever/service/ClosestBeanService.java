package com.coffeever.coffeever.service;

import com.coffeever.coffeever.model.CoffeeBean;
import org.springframework.stereotype.Service;

@Service
public class ClosestBeanService {

    public CoffeeBean bestMatch (CoffeeBean pref, Iterable<CoffeeBean> allBeans){

        CoffeeBean closestBean = new CoffeeBean(0,0,0,0);
        double gap = 18;
        for(CoffeeBean bean : allBeans){
            double asd = euclidean(pref, bean);
            if (asd < gap){
                gap = asd;
                closestBean = bean;
            }
        }
        return closestBean;
    }

    private double euclidean(CoffeeBean b1, CoffeeBean b2){
        return Math.sqrt(Math.pow((b1.getAroma() - b2.getAroma()),2) + (Math.pow((b1.getAcidity() - b2.getAcidity()),2)) +
                Math.pow((b1.getBody() - b2.getBody()),2) + Math.pow((b1.getFlavor() - b2.getFlavor()),2));
    }

}

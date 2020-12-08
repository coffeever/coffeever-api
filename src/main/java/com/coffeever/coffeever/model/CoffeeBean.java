package com.coffeever.coffeever.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "coffee_bean")
public class CoffeeBean {

    @Id
    private String slug;

    @Column
    private int aroma;

    @Column
    private int acidity;

    @Column
    private int body;

    @Column
    private int flavor;

    @Column
    private String roast;

    @Column
    private String region;

    @Column
    private int decaf;

    // bu constructor yerine setter injection yapılacak sonra sorun çıkarabilir
    public CoffeeBean(int aroma, int acidity, int body, int flavor) {
        this.aroma = aroma;
        this.acidity = acidity;
        this.body = body;
        this.flavor = flavor;
    }


    public CoffeeBean() {

    }
}

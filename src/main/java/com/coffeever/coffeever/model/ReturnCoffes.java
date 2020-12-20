package com.coffeever.coffeever.model;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReturnCoffes {

    private String slug;

    private int aroma;

    private int acidity;

    private int body;

    private int flavor;

    private String roast;

    private String region;

    private int decaf;

    private String name;

    private String blind_assessment;

    public ReturnCoffes(String slug, int aroma, int acidity, int body, int flavor, String roast, String region, int decaf, String name, String blind_assessment) {
        this.slug = slug;
        this.aroma = aroma;
        this.acidity = acidity;
        this.body = body;
        this.flavor = flavor;
        this.roast = roast;
        this.region = region;
        this.decaf = decaf;
        this.name = name;
        this.blind_assessment = blind_assessment;
    }
}

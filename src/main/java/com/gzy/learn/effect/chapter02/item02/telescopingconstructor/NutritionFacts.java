/**
* Copyright (C) 2016, wangao110@hotmail.com All Rights Reserved.
*/
package com.gzy.learn.effect.chapter02.item02.telescopingconstructor;

/**
* ClassName: NutritionFacts <br/>
*
* @author wangao110@hotmail.com
* @version 1.0
* @date 2016年9月28日
* @since JDK 1.7
*/
public class NutritionFacts {
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;
    
    public NutritionFacts(int servingSize, int servings) {
        this(servingSize, servings, 0);
    }
    
    public NutritionFacts(int servingSize, int servings, int calories) {
        this(servingSize, servings, calories, 0);
    }
    
    public NutritionFacts(int servingSize, int servings, int calories, int fat) {
        this(servingSize, servings, calories, fat, 0);
    }
    
    public NutritionFacts(int servingSize, int servings, int calories, int fat, int sodium) {
        this(servingSize, servings, calories, fat, sodium, 0);
    }
    
    public NutritionFacts(int servingSize, int servings, int calories, int fat, int sodium, int carbohydrate) {
        this.servingSize = servingSize;
        this.servings = servings;
        this.calories = calories;
        this.fat = fat;
        this.sodium = sodium;
        this.carbohydrate = carbohydrate;
    }
    
    public static void main(String[] args) {
        NutritionFacts cocaCola = new NutritionFacts(240, 8, 100, 0, 35, 27);
    }
}

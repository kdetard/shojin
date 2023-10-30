package io.github.ktard.shojin;

public class Food {
    public String name;
    public int discountPrice;
    public int originalPrice;
    public int rating;
    public int imageResource;

    public Food(String foodName, int foodDiscountPrice, int foodOriginalPrice, int foodRating, int foodImageResource) {
        name = foodName;
        discountPrice = foodDiscountPrice;
        originalPrice = foodOriginalPrice;
        rating = foodRating;
        imageResource = foodImageResource;
    }
}

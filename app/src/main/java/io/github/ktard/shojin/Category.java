package io.github.ktard.shojin;

public class Category {
    public String name;
    public int productCount;
    public int saleCount;
    public int imageResource;

    public Category(String categoryName, int categoryProductCount, int categorySaleCount, int categoryImageResource) {
        name = categoryName;
        productCount = categoryProductCount;
        saleCount = categorySaleCount;
        imageResource = categoryImageResource;
    }
}

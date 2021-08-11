package task18;

import java.io.Serializable;

public abstract class Product implements Serializable {
    private String nameProduct;
    private int priceProduct;
    private double weightProduct;
    private int shelfLifeDaysOfProduct;
    private String categoryProduct;

    public Product(String nameProduct, int priceProduct, double weightProduct, int shelfLifeDaysOfProduct, String categoryProduct) {
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
        this.weightProduct = weightProduct;
        this.shelfLifeDaysOfProduct = shelfLifeDaysOfProduct;
        this.categoryProduct = categoryProduct;
    }

    @Override
    public String toString() {

        return "\nProduct: " +
                "Название='" + nameProduct + '\'' +
                ", Цена=" + priceProduct +
                ", Вес=" + weightProduct +
                ", Срок годности=" + shelfLifeDaysOfProduct +
                ", Категория товара=" + categoryProduct;
    }


    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public int getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(int priceProduct) {
        this.priceProduct = priceProduct;
    }

    public double getWeightProduct() {
        return weightProduct;
    }

    public void setWeightProduct(double weightProduct) {
        this.weightProduct = weightProduct;
    }

    public int getShelfLifeDaysOfProduct() {
        return shelfLifeDaysOfProduct;
    }

    public void setShelfLifeDaysOfProduct(int shelfLifeDaysOfProduct) {
        this.shelfLifeDaysOfProduct = shelfLifeDaysOfProduct;
    }

    public String getCategoryProduct() {
        return categoryProduct;
    }

    public void setCategoryProduct(String categoryProduct) {
        this.categoryProduct = categoryProduct;
    }
}

package task19;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Random;

public class CakeFactory {

    private String nameProduct = "Торт";

    private int priceProduct;

    private double weightProduct;

    private int shelfLifeDaysOfProduct;

    private final Random r = new Random();
    private final String[] namesArray = new String[]{" шоколадный", " сладкий", " с печеньем", " с кремовой начинкой", " с ягодами"};

    public Cake create() {
        int nameI = r.nextInt(5);
        for (int i = 0; i < nameI; i++) {
            nameProduct += namesArray[r.nextInt(5)];
        }
        priceProduct = r.nextInt(5000);
        weightProduct = r.nextInt(10) + ((double) r.nextInt(10) / 10);
        shelfLifeDaysOfProduct = r.nextInt(10);

        return new Cake(nameProduct, priceProduct, weightProduct, shelfLifeDaysOfProduct);
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public int getPriceProduct() {
        return priceProduct;
    }

    public double getWeightProduct() {
        return weightProduct;
    }

    public int getShelfLifeDaysOfProduct() {
        return shelfLifeDaysOfProduct;
    }
}

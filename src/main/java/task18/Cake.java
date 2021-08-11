package task18;

import java.io.Serializable;

public class Cake extends Product implements Serializable {

    public Cake(String nameProduct, int priceProduct, double weightProduct, int shelfLifeDaysOfProduct) {
        super(nameProduct, priceProduct, weightProduct, shelfLifeDaysOfProduct, "Торты");
    }
}

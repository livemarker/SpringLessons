package task19;

import java.io.Serializable;

public class Soap extends Product implements Serializable {

    public Soap(String nameProduct, int priceProduct, double weightProduct) {
        super(nameProduct, priceProduct, weightProduct, -1, "Мыло");
    }
}

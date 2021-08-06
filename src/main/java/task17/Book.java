package task17;

import java.io.Serializable;

public class Book extends Product implements Serializable {

    public Book(String nameProduct, int priceProduct, double weightProduct) {
        super(nameProduct, priceProduct, weightProduct, -1, "Книги");
    }
}

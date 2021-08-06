package task17;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CakeFactoryTest {

    @Test
    void isTrueCreate() {
        Cake cake;
        CakeFactory cakeFactory = new CakeFactory();
        cake = cakeFactory.create();
        boolean condition = cake != null;
        boolean condition1 = cake.getNameProduct() != null && cake.getNameProduct().length() > 3;
        boolean condition2 = cake.getPriceProduct() > 0 && cake.getWeightProduct() > 0;
        boolean condition3= cake.getShelfLifeDaysOfProduct()>0;
        Assertions.assertTrue(condition);
        Assertions.assertTrue(condition1);
        Assertions.assertTrue(condition2);
        Assertions.assertTrue(condition3);
    }
}
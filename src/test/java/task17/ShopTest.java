package task17;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShopTest {
    Shop shop = Shop.create(25);
    List<Product> productsTest = new ArrayList<>();

    @Test
    void create() {
        Shop shopTest = Shop.create(25);
        Assertions.assertEquals(shop, shopTest);
    }

    @Test
    void delOfNameProduct() throws ShopNotHaveThisProduct {
        List<Product> productsExpected = new ArrayList<>();
        Book book = new Book("BBBBB", 10, 2);
        productsExpected.add(book);

        shop.add(new Book("AAAAA", 12, 1));
        shop.add(book);
        shop.delOfNameProduct("AAAAA");
        Assertions.assertEquals(productsExpected, shop.getProducts());
    }
}
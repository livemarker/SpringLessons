package task17;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ShopIndexSearchTest {
    ShopIndexSearch sis = new ShopIndexSearch();

    @Test
    void addIndex() {
        Map<String, List<Product>> dataTest = new HashMap<>();
        List<Product> arrayProduct = new ArrayList<>();
        Book book = new Book("AAAA BBB CCC", 1, 2);

        arrayProduct.add(book);
        dataTest.put("AAAA", arrayProduct);
        dataTest.put("BBB", arrayProduct);
        dataTest.put("CCC", arrayProduct);

        sis.addIndex(book);
        Assertions.assertEquals(dataTest,sis.getData());
    }

    @Test
    void removeIndex() {
        Map<String, List<Product>> dataTest = new HashMap<>();
        Book book = new Book("AAAA BBB CCC", 1, 2);

        sis.addIndex(book);
        sis.removeIndex(book);
        Assertions.assertEquals(dataTest,sis.getData());
    }
}
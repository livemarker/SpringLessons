package task18;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Shop implements Serializable {
    private final int capacity;
    private final List<Product> products = new ArrayList<>();


    public Shop(int capacity) {
        this.capacity = capacity;
    }

    public void add(Product product) {
        products.add(product);

    }

    public void del(Product product) throws ShopNotHaveThisProduct {
        boolean isShopNotHaveThisProduct = true;

        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).equals(product)) {
                isShopNotHaveThisProduct = false;
                // System.out.println(products.get(i).getNameProduct() + " успешно удален");

                products.remove(products.get(i));
            }
        }

        if (isShopNotHaveThisProduct) {
            System.out.println(product.toString() + " не удален");
            throw new ShopNotHaveThisProduct("Продукт " + product.toString() + " не найден в магазине, удаление не возможно");
        }
    }

    public List<Product> getProducts() {
        return products;
    }

    public int getCapacity() {
        return capacity;
    }

    public void save() throws IOException {
        File file = new File("saveShop.txt");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(this);
        oos.close();
    }

    public static Shop loadFromFile() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream((new FileInputStream("saveShop.txt")));
        Shop shop = (Shop) ois.readObject();
        ois.close();
        return shop;
    }
}

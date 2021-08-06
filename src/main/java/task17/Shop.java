package task17;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Shop implements Serializable {
    private final int capacity;
    private final List<Product> products = new ArrayList<>();
    private final ShopIndexSearch sis = new ShopIndexSearch();
    private static Shop shop;

    private Shop(int capacity) {
        this.capacity = capacity;
    }

    public  static Shop create(int capacity) {
        if (shop == null) {
            shop = new Shop(capacity);
        }
        return shop;
    }

    public void add(Product product) {
        products.add(product);
        sis.addIndex(product);
    }

    public void delOfNameProduct(String str) throws ShopNotHaveThisProduct {
        boolean isShopNotHaveThisProduct = true;

        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getNameProduct().equals(str)) {
                isShopNotHaveThisProduct = false;
                System.out.println(products.get(i).getNameProduct() + " успешно удален");
                sis.removeIndex(products.get(i));
                products.remove(products.get(i));
            }
        }

        if (isShopNotHaveThisProduct) {
            System.out.println(str + " не удален");
            throw new ShopNotHaveThisProduct("Продукт " + str + " не найден в магазине, удаление не возможно");
        }
    }

    public void showShopIndex() {
        System.out.println(sis.toString());
        System.out.println("--------------");
    }

    public void searchWithShopIndex(String str) {
        sis.searchWithIndex(str);
    }

    public void searchWithPredicate(String str) {
        sis.searchWithPredicate(s -> s.equals(str));
    }

    public void searchWithStars(String str) {
        sis.searchWithStars(str);
    }

    public void removeWithPredicate(Product product) {
        System.out.println("Удаление по предикату: " + product.getNameProduct());
        sis.removeWithPredicate(s -> s.equals(product));
    }

    public Stream searchWithStream(Product product) {
        return sis.searchWithStream(product);
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

package task22.menus;

import task22.DAO.ShopDAO;
import task22.Product;
import task22.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShopMenu {
    private User user;
    private Scanner sc = new Scanner(System.in);
    CartMenu cartMenu = CartMenu.create();
    private List<Product> listProductsTemp = new ArrayList<>();
    int choice = 0;

    public ShopMenu(User user) {
        this.user = user;
    }

    public void run() throws SQLException {
        System.out.println("-------------------");
        System.out.println("Меню товаров:");
        System.out.println("Выберите категорию товаров по номеру:");
        showCategoryProducts();
        System.out.println("Выберите товар по номеру, чтобы добавить в корзину:");
        System.out.println();


    }

    private void showCategoryProducts() throws SQLException {

        List<String> listCategory = ShopDAO.create().getCategoryProducts();
        for (int i = 0; i < listCategory.size(); i++) {
            System.out.println(i + 1 + ".    " + listCategory.get(i));
        }
        System.out.println();
        System.out.println("Для перехода назад цифра -2");


        getProducts();
    }

    private void getProducts() throws SQLException {

        if (choice==0){choice= sc.nextInt();}
        if (choice == -1) {
            run();
        }
        if (choice == -2) {
            AccountMenu.create(user).run();
        }
        listProductsTemp = ShopDAO.create().getProducts(choice);
        for (int i = 0; i < listProductsTemp.size(); i++) {
            System.out.println(i + 1 + ".    " + listProductsTemp.get(i));
        }
        System.out.println();
        System.out.println("Для перехода назад цифра -1");
        addToCart();
    }

    private void addToCart() throws SQLException {
        int index = sc.nextInt();
        if (index == -1) {
            run();
        }
        if (index == -2) {
            AccountMenu.create(user).run();
        }
        CartMenu.create().getCart().add(listProductsTemp.get(index - 1));
        System.out.println(listProductsTemp.get(index - 1).toString() + " добавлен в корзину");
        getProducts();

    }
}

package task22.menus;


import task22.entity.Product;
import task22.entity.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CartMenu {
    private List<Product> cart = new ArrayList<>();
    private static CartMenu cartMenu;
    private Scanner sc = new Scanner(System.in);
    private User user;

    private CartMenu(User user) {
        this.user = user;
    }

    public static CartMenu create(User user) {
        if (cartMenu == null) {
            cartMenu = new CartMenu(user);
        }
        return cartMenu;
    }

    public void run() throws SQLException {
        System.out.println("---------------------");
        System.out.println("Моя корзина");
        System.out.println(getCart().toString());
        System.out.println("");
        System.out.println("1.  Оплатить");
        System.out.println("2.  Очистить корзину");
        System.out.println("");
        System.out.println("Чтобы вернуться -1");

        int choice = sc.nextInt();
        if (choice == 1) {
            OrderMenu.create(user).addOrder(cart);
            OrderMenu.create(user).run();
            System.out.println("Товары оплачены, сформирован заказ");
        } else if (choice == 2) {
            clear();

        } else if (choice == -1) {

        } else {
            System.out.println("Выберите правильный пункт меню");
            try {
                Thread.sleep(200);
            } catch (Exception e) {
            }
            run();
        }
    }

    public List<Product> getCart() {
        return cart;
    }

    public void setCart(List<Product> cart) {
        this.cart = cart;
    }

    private void buy() {
    }

    private void clear() {
        cart.clear();
        System.out.println("Корзина с товарами отчищена");
    }
}

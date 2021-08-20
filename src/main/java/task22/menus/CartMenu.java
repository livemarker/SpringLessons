package task22.menus;


import task22.Product;

import java.util.ArrayList;
import java.util.List;

public class CartMenu {
    private List<Product> cart = new ArrayList<>();
    private static CartMenu cartMenu;

    private CartMenu() {
    }

    public static CartMenu create() {
        if (cartMenu == null) {
            cartMenu = new CartMenu();
        }
        return cartMenu;
    }

    public List<Product> getCart() {
        return cart;
    }

    public void setCart(List<Product> cart) {
        this.cart = cart;
    }
}

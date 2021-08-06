package task17;

public class ShopIsFull extends RuntimeException {
    public ShopIsFull() {
        super();
        System.err.println("Магазин переполнен");
    }
}

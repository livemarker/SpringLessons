package task19;

public class ShopIsFull extends RuntimeException {
    public ShopIsFull() {
        super();
        System.err.println("Магазин переполнен");
    }
}

package task19;

public class ShopNotHaveThisProduct extends Exception {
    public ShopNotHaveThisProduct(String msg) {
        super(msg);
    }
}
/**
 * Наверно лучше сделать проверяемое исключение, чтобы программа не завершалась, от того, что нет удаляемого элемента и продолжила работать
 */

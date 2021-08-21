package task22.entity;

public class Order {
    private int orderNumber;
    private String nameProduct;
    private double price;
    private String category;
    private String status;

    public Order(int orderNumber, String nameProduct, double price, String category, String status) {
        this.orderNumber = orderNumber;
        this.nameProduct = nameProduct;
        this.price = price;
        this.category = category;
        this.status = status;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "\n" +
                "orderNumber=" + orderNumber +
                ", nameProduct='" + nameProduct + '\'' +
                ", price=" + price +
                ", Category='" + category + '\'' +
                ", status='" + status + '\'';
    }
}

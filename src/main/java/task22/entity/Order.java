package task22.entity;

public class Order {
    private int orderNumber;
    private String nameProduct;
    private double price;
    private String category;
    private String first_name;
    private String last_name;
    private String status;

    public Order(int orderNumber, String nameProduct, double price, String category, String first_name, String last_name, String status) {
        this.orderNumber = orderNumber;
        this.nameProduct = nameProduct;
        this.price = price;
        this.category = category;
        this.first_name = first_name;
        this.last_name = last_name;
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

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNumber=" + orderNumber +
                ", nameProduct='" + nameProduct + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}

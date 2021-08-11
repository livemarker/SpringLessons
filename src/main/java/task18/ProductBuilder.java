package task18;

public class ProductBuilder {
    private String name;
    private int price;
    private double weight;
    private int shelfLifeDaysOfProduct;

    boolean legalState() {
        return name != null && price > 0 && weight > 0;
    }

    public Product build() {
        if (legalState() && getName().contains("Книга ")) {
            return new Book(getName(), getPrice(), getWeight());
        }
        if (legalState() && getName().contains("Мыло ")) {
            return new Soap(getName(), getPrice(), getWeight());
        }
        if (legalState() && getName().contains("Торт ")) {
            return new Cake(getName(), getPrice(), getWeight(), getShelfLifeDaysOfProduct());
        } else {
            throw new IllegalStateException();
        }
    }

    private String getName() {
        return name;
    }

    public ProductBuilder setName(String name) {
        this.name = name;
        return this;
    }

    private int getPrice() {
        return price;
    }

    public ProductBuilder setPrice(int price) {
        this.price = price;
        return this;
    }

    private double getWeight() {

        return weight;
    }

    public ProductBuilder setWeight(double weight) {
        this.weight = weight;
        return this;
    }

    private int getShelfLifeDaysOfProduct() {
        return shelfLifeDaysOfProduct;
    }

    public ProductBuilder setShelfLifeDaysOfProduct(int shelfLifeDaysOfProduct) {
        this.shelfLifeDaysOfProduct = shelfLifeDaysOfProduct;
        return this;
    }

}

package task17;

public class FakeCakeFactory implements CakeCreator {
    CakeCreator creator;

    public FakeCakeFactory(CakeCreator creator) {
        this.creator = creator;
    }

    @Override
    public Cake create() {
        Cake cake = creator.create();
        System.out.println("Было: " + cake.toString());

        cake.setNameProduct("Не торт, просто булка из металла");
        cake.setPriceProduct(9999);
        cake.setWeightProduct(9999);
        cake.setShelfLifeDaysOfProduct(99);

        System.out.print("Стало: ");
        return cake;
    }
}

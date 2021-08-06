package task17;

public class Main {
    public static void main(String[] args) {

//        паттерн singleton
        Shop shop = Shop.create(10);

//        паттерн builder
        Book book1 = (Book) new ProductBuilder().setName("Книга Ахматова сборник стихотворений")
                .setPrice(785)
                .setWeight(1)
                .build();
        System.out.println(book1);

        Soap soap = (Soap) new ProductBuilder().setName("Мыло Dove")
                .setPrice(50)
                .setWeight(0.2)
                .build();
        System.out.println(soap);

//         паттерн factory
        Cake cake = new CakeFactory().create();
        System.out.println(cake);

        Cake cake1 = new CakeFactory().create();
        System.out.println(cake1);

//        паттерн decorator классы CakeCreator and FakeCakeFactory
        CakeCreator creator = new CakeFactory();
        Cake cake2 = new FakeCakeFactory(creator).create();
        System.out.println(cake2);
        System.out.println();

//        Принцип подстановки Барбары Лисков L из SOLID
//        Наследование разных видов продуктов от класса Product соответствует данному принципу,
//        а также методы в классе Shop, используемые для работы с ними.

//        Принцип открытости-закрытости O из SOLID
//        Возможность расширения не нарушена и закрыта к модификации данных
    }
}

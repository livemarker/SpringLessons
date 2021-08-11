package task18;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) throws ShopNotHaveThisProduct {
        ApplicationContext context = new ClassPathXmlApplicationContext("task18/Configuration.xml");
        Book book = (Book) context.getBean("book");
        Cake cake = context.getBean(CakeFactory.class).create();
        Cake cake1 = context.getBean(CakeFactory.class).create();

        DeliveryProductsService dp = context.getBean(DeliveryProductsService.class);
        dp.add(book);
        dp.add(cake);
        dp.add(cake1);

        BuyProductService bp = context.getBean(BuyProductService.class);
        bp.buy(cake);
        bp.buy(book);
    }
}

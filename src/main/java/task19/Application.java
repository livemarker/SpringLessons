package task19;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import java.beans.ConstructorProperties;

@SpringBootApplication

public class Application {
    public static void main(String[] args) throws ShopNotHaveThisProduct {
        final ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

        Book book = context.getBean(Book.class);
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

    @Bean
    public Shop shop() {
        return new Shop(10);
    }

    @Bean
    public Book book() {
        return new Book("war", 125, 2);
    }
}

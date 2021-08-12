package task19;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public Shop shop(){
        return new Shop(10);
    }
    @Bean
    public Book book(){
        return new Book("123",12,12);
    }
    @Bean
    public CakeFactory cakeFactory() {
        return new CakeFactory();
    }
    @Bean
    public DeliveryProductsService deliveryProductsService(Shop shop) {
        return new DeliveryProductsService(shop);
    }
    @Bean
    public BuyProductService buyProductService(Shop shop) {
        return new BuyProductService(shop);
    }

}

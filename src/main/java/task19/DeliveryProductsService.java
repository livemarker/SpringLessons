package task19;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Service;

import java.util.Locale;


public class DeliveryProductsService  {
    private Shop shop;
    ApplicationContext context;

    public DeliveryProductsService(Shop shop) {
        this.shop = shop;
    }

    public void add(Product product) {

        System.out.print("Доставили:");
        System.out.println(product);
        shop.add(product);

    }

    @Autowired
    public void setApplicationContext(ConfigurableApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }
}

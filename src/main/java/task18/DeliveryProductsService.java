package task18;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Locale;


public class DeliveryProductsService implements ApplicationContextAware {
    private Shop shop;
    ApplicationContext context;

    public DeliveryProductsService(Shop shop) {
        this.shop = shop;
    }

    public void add(Product product) {
        Locale locale = Locale.US;
        System.out.print(context.getMessage("delivery", new Object[0], locale));
        System.out.println(product);
        shop.add(product);

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }
}

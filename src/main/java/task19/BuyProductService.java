package task19;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class BuyProductService implements ApplicationContextAware {
    private Shop shop;
    private ApplicationContext context;

    public BuyProductService(Shop shop) {
        this.shop = shop;
    }

    public void buy(Product product) throws ShopNotHaveThisProduct {
        System.out.print("Купили:");
        System.out.println(product);
        shop.del(product);
        context.publishEvent(new FNSservice(FNSservice.Info.of
                ("Покупка:" + product.getNameProduct() + " цена:" + product.getPriceProduct(),
                        "Ндс за покупку составит: " + (double) product.getPriceProduct() * 0.2)));
    }

    @Autowired
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }
}

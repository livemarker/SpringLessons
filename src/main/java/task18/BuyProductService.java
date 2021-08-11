package task18;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Locale;

public class BuyProductService implements ApplicationContextAware {
    private Shop shop;
    private ApplicationContext context;

    public BuyProductService(Shop shop) {
        this.shop = shop;
    }

    public void buy(Product product) throws ShopNotHaveThisProduct {
        Locale locale = Locale.US;
        System.out.print(context.getMessage("buy", new Object[0], locale));
        //локаль рабочая, не хочется весь магазин переделывать под 2 языка

        System.out.println(product);
        shop.del(product);
        context.publishEvent(new FNSservice(FNSservice.Info.of
                ("Покупка:" + product.getNameProduct() + " цена:" + product.getPriceProduct(),
                        "Ндс за покупку составит: " + (double) product.getPriceProduct() * 0.2)));
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }
}

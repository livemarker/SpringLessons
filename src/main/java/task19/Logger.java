package task19;

import org.springframework.context.ApplicationListener;

public class Logger implements ApplicationListener<FNSservice> {
    @Override
    public void onApplicationEvent(FNSservice event) {
        FNSservice.Info info = (FNSservice.Info) event.getSource();
        System.out.println(String.format("Событие: %s \n Доп. информация: %s", info.getTitle(), info.getInfo()));
    }
}

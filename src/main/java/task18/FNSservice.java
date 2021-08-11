package task18;

import org.springframework.context.ApplicationEvent;

public class FNSservice extends ApplicationEvent {
    public FNSservice(Info info) {
        super(info);
    }

    public static class Info {
        public final String title;
        public final String info;

        private Info(String title, String info) {
            this.title = title;
            this.info = info;
        }

        public String getTitle() {
            return title;
        }

        public String getInfo() {
            return info;
        }

        public static Info of(String title, String info) {
            return new Info(title, info);
        }
    }
}
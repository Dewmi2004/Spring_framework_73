package lk.ijse;

import lk.ijse.been.Boy;
import lk.ijse.been.Girl;
import lk.ijse.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppInitializer2 {
    public static void main(String[] args) {
     AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
     context.register(AppConfig.class);
        context.refresh();
        Boy boy = context.getBean(Boy.class);
     boy.ChatWithBoy();
     context.registerShutdownHook();

    }
}
package lk.ijse;

import lk.ijse.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;
import java.util.Properties;

public class AppInitializer6 {
    public static void main(String[] args) {
     AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
     context.register(AppConfig.class);
        context.refresh();
        //------------Environment variables types--------------//


        //System variable - our laptop OS Related details

//        Map<String,String> systemvariables = System.getenv();
//        for(String name : systemvariables.keySet()){
//            System.out.println(name+":"+systemvariables.get(name));
//        }

        //Java Properties - Java Language Related details

//        Properties properties = System.getProperties();
//        for(Object key : properties.keySet()){
//            System.out.println(key+":"+properties.get(key));
//        }

        //Resource Bundle(.env , .properties , .yml , .yaml) - Application Related



     context.registerShutdownHook();

    }
}

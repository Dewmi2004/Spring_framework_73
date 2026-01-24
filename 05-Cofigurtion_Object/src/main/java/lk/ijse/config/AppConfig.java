package lk.ijse.config;

import lk.ijse.bean.SpringBean;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan(basePackages = "lk.ijse.bean")
@Import({AppConfig1.class,AppConfig2.class})//Import multiple configuration classes
@ImportResource("classpath:hibernate.cfg.xml")// import (call) xml base resources in project
//@ImportResource("file: path to file...")// import (call) xml base resources in another place in computer
public class AppConfig {
public  AppConfig(){
    System.out.println("AppConfig");
}

    @Bean
    public SpringBean getSpringBean(){
        System.out.println("getSpringBean");
        return new SpringBean();
    }
}

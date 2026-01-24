package lk.ijse.config;

import lk.ijse.bean.SpringBean;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = "lk.ijse.bean")
//@ImportResource("classpath:hibernate.cfg.xml")// import (call) xml base resources in project
public class AppConfig {
public AppConfig(){
    System.out.println("AppConfig");
}

}

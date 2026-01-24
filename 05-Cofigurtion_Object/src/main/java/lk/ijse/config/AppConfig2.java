package lk.ijse.config;

import lk.ijse.bean.A;
import lk.ijse.bean.C;
import lk.ijse.bean.D;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "lk.ijse.bean")
public class AppConfig2 {
public AppConfig2(){
    System.out.println("AppConfig2");
}

@Bean
public C getC(){
    System.out.println("getC");
return new C();
}
@Bean
public D getD(){
    System.out.println("getD");
return new D();
}
}

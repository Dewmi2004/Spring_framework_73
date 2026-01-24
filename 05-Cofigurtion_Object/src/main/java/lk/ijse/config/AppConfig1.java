package lk.ijse.config;

import lk.ijse.bean.A;
import lk.ijse.bean.B;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "lk.ijse.bean")
public class AppConfig1 {
public AppConfig1(){
    System.out.println("AppConfig1");
}

@Bean
public A getA(){
    System.out.println("getA");
return new A();
}
@Bean
public B getB(){
    System.out.println("getB");
return new B();
}
}

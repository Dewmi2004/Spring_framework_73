package lk.ijse.config;

import lk.ijse.bean.SpringBean1;
import lk.ijse.bean.SpringBean2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
@Configuration
@ComponentScan(basePackages = "lk.ijse.bean")
public class AppConfig {
//// full mode - bean method defined inside a configuration class
//@Bean
//public SpringBean1 springBean1(){
//    //Inter Bean dependency - satisfy inter bean dependency in full mode (call a bean inside another bean)
//    SpringBean2 sp1 = springBean2();
//    SpringBean2 sp2 = springBean2();
//    System.out.println(sp1);
//    System.out.println(sp2);
//    return new SpringBean1();
//}
//    @Bean
//    public SpringBean2 springBean2(){
//        return new SpringBean2();
//    }
}

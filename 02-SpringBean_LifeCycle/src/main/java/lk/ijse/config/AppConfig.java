package lk.ijse.config;

import lk.ijse.bean.SpringBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration // The components(spring Beans) put into the Spring container
@ComponentScan(basePackages = {"lk.ijse.bean"})// Scan and link the components which in the projects
public class AppConfig {
//    @Bean
//    SpringBean springBean() {
//        return new SpringBean();
//    }
    public AppConfig() {
        System.out.println("AppConfig called");
    }
}

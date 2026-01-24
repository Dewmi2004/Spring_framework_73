package lk.ijse.config;

import lk.ijse.bean.MyConnection;
import lk.ijse.newBeans.NewTestBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration // The components(spring Beans) put into the Spring container
@ComponentScan(basePackages = {"lk.ijse.bean", "lk.ijse.newBeans"})// Scan and link the components which in the projects
//@ComponentScan(basePackageClasses =  {NewTestBean.class})//can use class name like this insted of above Annotation
public class AppConfig {
    public AppConfig() {
        System.out.println("AppConfig called");
    }
    @Bean("connection") // use for 3 rd party classes which developer is not created
    MyConnection myyConnection(){// this is Bean name
        return new MyConnection();
    }
}

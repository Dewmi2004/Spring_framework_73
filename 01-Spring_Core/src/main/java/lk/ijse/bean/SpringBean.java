package lk.ijse.bean;

import org.springframework.stereotype.Component;

@Component // Create Bean object automatically
public class SpringBean {
    public SpringBean() {
        System.out.println("SpringBean is Created");
    }
}

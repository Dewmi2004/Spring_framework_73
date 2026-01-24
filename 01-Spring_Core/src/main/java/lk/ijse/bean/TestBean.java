package lk.ijse.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("exampleBean")
@Scope("prototype")// prevent singleton - when if it is a large scale project , can have 100+ data inputs.
//so we can use @Scope("prototype") to prevent creating single bean object but create multiple objects when calling
public class TestBean {
    public TestBean() {
        System.out.println("TestBean is created");
    }
    public void printMassage() {
        System.out.println("printMassage method called");
    }
}

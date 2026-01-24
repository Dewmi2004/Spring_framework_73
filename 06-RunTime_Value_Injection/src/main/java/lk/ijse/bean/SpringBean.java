package lk.ijse.bean;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SpringBean{
//   public SpringBean(){
//
//   }
    // if one constructor autowire required false - it says that do not use this constructor
    //if all constructors have autowire required false - now the constructor with more values executes by the Spring
    //if all constructors have autowire required false and all parameters count are same - now the constructor which can reach easily executes by the Spring
@Autowired(required = false)
public SpringBean( @Value("Dewmi")String name,@Value("21")int age) {
        System.out.println(name);
        System.out.println(age);
    }
    @Autowired(required = false)
//    @Autowired// use this constructor - satisfy this constructor - only can use for one constructor
    public SpringBean( @Value("Dewmi")String nameList[],@Value("12")int age,@Value("panadura")String address) {
        System.out.println(nameList.length);
        System.out.println(age);
        System.out.println(address);
    }
}

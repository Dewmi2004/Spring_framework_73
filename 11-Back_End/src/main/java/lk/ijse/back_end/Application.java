package lk.ijse.back_end;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@SpringBootApplication = @Configuration / @EnableAutoConfiguration / @ComponentScan
@SpringBootApplication //initialize the base project
@RequestMapping
@RestController
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
//@GetMapping
//    public String index(){
//        return "index";
//}
}

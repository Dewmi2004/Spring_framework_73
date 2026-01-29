package lk.ijse.controller;

import org.springframework.web.bind.annotation.*;

@RestController// says it is a controller->when comes a request return to ui
@RequestMapping(path = "api/v1/customer")//map url for controller->localhost:8080/webappexploded/customer
public class CustomerController {
    public CustomerController() {
        System.out.println("CustomerController constructor");
    }
    @GetMapping("index1")//get the request
    public String index1() {
        return "Hello World!- index1";
    }
    @DeleteMapping("index2")//get the request
    public String index2() {
        return "Hello World!- index2";
    }
    @PutMapping("index3")//get the request
    public String index3() {
        return "Hello World!- index3";
    }
    @PostMapping
    public String index4() {
        return "Hello World!- index4";
    }

}

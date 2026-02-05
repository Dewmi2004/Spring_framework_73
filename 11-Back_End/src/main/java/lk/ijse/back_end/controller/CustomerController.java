package lk.ijse.back_end.controller;

import lk.ijse.back_end.dto.CustomerDTO;
import lk.ijse.back_end.service.CustomerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/customer")
public class CustomerController {
    private final CustomerServiceImpl customerService;
//public CustomerController(CustomerServiceImpl customerService){
//    this.customerService=customerService;
//}
    @PostMapping
    public void saveCustomer(@RequestBody CustomerDTO customerDTO) {
        //@RequestBody - read request body
        System.out.println("saveCustomer");
//        System.out.println(customerDTO.getId());
//        System.out.println(customerDTO.getName());
//        System.out.println(customerDTO.getAge());
//        System.out.println(customerDTO.getAddress());

        customerService.saveCustomer(customerDTO);
    }
}

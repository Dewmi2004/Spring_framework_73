package lk.ijse.back_end.controller;

import lk.ijse.back_end.dto.CustomerDTO;
import lk.ijse.back_end.entity.CustomerEntity;
import lk.ijse.back_end.service.impl.CustomerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/customer")
@CrossOrigin
public class CustomerController {
    private final CustomerServiceImpl customerService;

    @PostMapping
    public void saveCustomer(@RequestBody CustomerDTO customerDTO) {
        //@RequestBody - read request body
        System.out.println("saveCustomer");

        customerService.saveCustomer(customerDTO);
    }
    @PutMapping
    public void UpdateCustomer(@RequestBody CustomerDTO customerDTO) {
        System.out.println("UpdateCustomer");
        customerService.updateCustomer(customerDTO);
    }
    @DeleteMapping
    public void DeleteCustomer(@RequestBody CustomerDTO customerDTO) {
        System.out.println("DeleteCustomer");
        customerService.deleteCustomer(customerDTO);
    }
    @GetMapping
    public List<CustomerEntity> getAllCustomers() {
        return customerService.getAllCustomers();

    }
}

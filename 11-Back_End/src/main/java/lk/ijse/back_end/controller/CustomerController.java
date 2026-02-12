package lk.ijse.back_end.controller;

import lk.ijse.back_end.dto.CustomerDTO;
import lk.ijse.back_end.entity.CustomerEntity;
import lk.ijse.back_end.service.impl.CustomerServiceImpl;
import lk.ijse.back_end.util.APIResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/customer")
@CrossOrigin
//@Validated
public class CustomerController {
    private final CustomerServiceImpl customerService;

    @PostMapping
    public ResponseEntity<APIResponse<String>> saveCustomer(@RequestBody CustomerDTO customerDTO) {

        System.out.println("saveCustomer");
        customerService.saveCustomer(customerDTO);


        return new ResponseEntity<>(new APIResponse<> (200,"Customer Saved",null),HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<APIResponse<String>> UpdateCustomer(@RequestBody CustomerDTO customerDTO) {
        System.out.println("UpdateCustomer");
        customerService.updateCustomer(customerDTO);
        return new ResponseEntity<>(new APIResponse<> (200,"Customer Updated",null),HttpStatus.OK);
    }
    @DeleteMapping
    public ResponseEntity<APIResponse<String>> DeleteCustomer(@RequestBody CustomerDTO customerDTO) {
        System.out.println("DeleteCustomer");
        customerService.deleteCustomer(customerDTO);
        return new ResponseEntity<>(new APIResponse<> (200,"Customer Deleted",null),HttpStatus.OK);

    }
    @GetMapping
    public List<CustomerEntity> getAllCustomers() {
        return customerService.getAllCustomers();

    }
}

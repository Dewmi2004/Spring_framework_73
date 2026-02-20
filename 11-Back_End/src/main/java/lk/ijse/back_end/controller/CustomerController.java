package lk.ijse.back_end.controller;

import lk.ijse.back_end.dto.CustomerDTO;
import lk.ijse.back_end.service.CustomerService;
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
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<APIResponse<String>> saveCustomer(@RequestBody CustomerDTO customerDTO) {
        customerService.saveCustomer(customerDTO);
        return new ResponseEntity<>(new APIResponse<>(200, "Customer Saved", null), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<APIResponse<String>> updateCustomer(@RequestBody CustomerDTO customerDTO) {
        customerService.updateCustomer(customerDTO);
        return new ResponseEntity<>(new APIResponse<>(200, "Customer Updated", null), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<APIResponse<String>> deleteCustomer(@RequestBody CustomerDTO customerDTO) {
        customerService.deleteCustomer(customerDTO);
        return new ResponseEntity<>(new APIResponse<>(200, "Customer Deleted", null), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<APIResponse<List<CustomerDTO>>> getAllCustomers() {
        List<CustomerDTO> customers = customerService.getAllCustomers();
        return new ResponseEntity<>(new APIResponse<>(200, "Success", customers), HttpStatus.OK);
    }
}
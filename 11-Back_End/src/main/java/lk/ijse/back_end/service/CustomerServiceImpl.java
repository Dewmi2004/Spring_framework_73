package lk.ijse.back_end.service;

import lk.ijse.back_end.dto.CustomerDTO;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Override
    public void saveCustomer(CustomerDTO customerDTO) {
        System.out.println("saveCustomer in customerService");
        System.out.println(customerDTO.getId());
        System.out.println(customerDTO.getName());
        System.out.println(customerDTO.getAge());
        System.out.println(customerDTO.getAddress());
    }
}

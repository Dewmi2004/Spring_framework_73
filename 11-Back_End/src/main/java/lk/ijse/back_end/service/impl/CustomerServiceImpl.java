package lk.ijse.back_end.service.impl;

import lk.ijse.back_end.dto.CustomerDTO;
import lk.ijse.back_end.entity.CustomerEntity;
import lk.ijse.back_end.repository.CustomerRepository;
import lk.ijse.back_end.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {
private final CustomerRepository customerRepository;


    @Override
    public void saveCustomer(CustomerDTO customerDTO) {
        customerRepository.save(new CustomerEntity(customerDTO.getId(), customerDTO.getName(), customerDTO.getAge(),  customerDTO.getAddress()));
    }

    @Override
    public void updateCustomer(CustomerDTO customerDTO) {
        customerRepository.save(new CustomerEntity(customerDTO.getId(), customerDTO.getName(), customerDTO.getAge(), customerDTO.getAddress()));
    }
    @Override
    public void deleteCustomer(CustomerDTO customerDTO) {
        customerRepository.deleteById(customerDTO.getId());
    }
    @Override
    public List<CustomerEntity> getAllCustomers() {
        return customerRepository.findAll();
    }
}

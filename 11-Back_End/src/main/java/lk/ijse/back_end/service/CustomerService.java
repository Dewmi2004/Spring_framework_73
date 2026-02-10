package lk.ijse.back_end.service;

import lk.ijse.back_end.dto.CustomerDTO;
import lk.ijse.back_end.entity.CustomerEntity;

import java.util.List;

public interface CustomerService {
    public void saveCustomer(CustomerDTO customerDTO);
    public void updateCustomer(CustomerDTO customerDTO);
    public void deleteCustomer(CustomerDTO customerDTO);
    public List<CustomerEntity> getAllCustomers();
}

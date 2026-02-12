package lk.ijse.back_end.service.impl;

import lk.ijse.back_end.dto.CustomerDTO;
import lk.ijse.back_end.entity.CustomerEntity;

import lk.ijse.back_end.repository.CustomerRepository;
import lk.ijse.back_end.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {
private final CustomerRepository customerRepository;

private final ModelMapper modelMapper;
@Override
public void saveCustomer(CustomerDTO customerDTO) {
    CustomerEntity entity = modelMapper.map(customerDTO, CustomerEntity.class);
    entity.setId(0);
    customerRepository.save(entity);

}


    @Override
    public void updateCustomer(CustomerDTO customerDTO) {

        CustomerEntity existingCustomer = customerRepository
                .findById(customerDTO.getId())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Customer not found"
                ));

        modelMapper.map(customerDTO, existingCustomer);

        customerRepository.save(existingCustomer);
    }




    @Override
    public void deleteCustomer(CustomerDTO customerDTO) {
        if (!customerRepository.existsById(customerDTO.getId())) {
            throw new RuntimeException("Customer not found");
        }
        customerRepository.deleteById(customerDTO.getId());
    }

    @Override
    public List<CustomerEntity> getAllCustomers() {

        List<CustomerEntity> list = customerRepository.findAll();

        return modelMapper.map(
                list,
                new TypeToken<List<CustomerDTO>>() {}.getType()
        );
    }

}

package lk.ijse.spring_test_logs_and_api_docs.service.impl;

import lk.ijse.spring_test_logs_and_api_docs.entity.ProductEntity;
import lk.ijse.spring_test_logs_and_api_docs.repositery.ProductRepositery;
import lk.ijse.spring_test_logs_and_api_docs.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepositery productRepo;

    @Override
    public ProductEntity save(ProductEntity product) {
       return productRepo.save(product);
    }

    @Override
    public List<ProductEntity> findAll() {
        return productRepo.findAll();
    }
}

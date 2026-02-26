package lk.ijse.spring_test_logs_and_api_docs.service;

import lk.ijse.spring_test_logs_and_api_docs.entity.ProductEntity;

import java.util.List;

public interface ProductService {
    ProductEntity save(ProductEntity product);
    List<ProductEntity> findAll();
}

package lk.ijse.spring_test_logs_and_api_docs.repositery;

import lk.ijse.spring_test_logs_and_api_docs.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepositery extends JpaRepository<ProductEntity,Long> {
}

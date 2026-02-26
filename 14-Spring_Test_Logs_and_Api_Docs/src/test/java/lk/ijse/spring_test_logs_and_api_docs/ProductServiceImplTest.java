package lk.ijse.spring_test_logs_and_api_docs;

import lk.ijse.spring_test_logs_and_api_docs.entity.ProductEntity;
import lk.ijse.spring_test_logs_and_api_docs.repositery.ProductRepositery;
import lk.ijse.spring_test_logs_and_api_docs.service.ProductService;
import lk.ijse.spring_test_logs_and_api_docs.service.impl.ProductServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProductServiceImplTest {
    private ProductEntity productEntity;
    @InjectMocks
    private ProductServiceImpl productService;
    @Mock
    private ProductRepositery productRepositery;

    @BeforeEach
    public void setup(){
        productEntity = ProductEntity.builder().id(1).name("TestName").description("TestDescription").build();
    }
    @Test
    void saveProductTestCase(){
        //arrange
        when(productRepositery.save(any(ProductEntity.class))).thenReturn(productEntity);

        //action
      ProductEntity saveproduct =  productService.save(productEntity);


        //assert methods
        Assertions.assertEquals("TestName",saveproduct.getName());
        Assertions.assertNotNull(saveproduct);
        Assertions.assertEquals(productEntity,saveproduct);
        verify(productRepositery,times(1)).save(any(ProductEntity.class));
    }
}

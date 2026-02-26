package lk.ijse.spring_test_logs_and_api_docs.controller;

import lk.ijse.spring_test_logs_and_api_docs.entity.ProductEntity;
import lk.ijse.spring_test_logs_and_api_docs.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/product")
@CrossOrigin
@Slf4j //add logs
public class ProductController {
    private final ProductService productService;
    @PostMapping("add")
    public void saveProduct(@RequestBody ProductEntity product) {

        //log methods important to know where is the error and when it happened
        //research about elastic search

        log.info("information log ");
        log.debug("debug log {}", product);
        log.warn("warning log  ");
        log.error("error log  ");//in try catch
        log.trace("warning trace log  ");

        productService.save(product);
    }

    @GetMapping("get-all")
    public List<ProductEntity> findAll() {
        log.info("Get all products");
        return productService.findAll();
    }
}

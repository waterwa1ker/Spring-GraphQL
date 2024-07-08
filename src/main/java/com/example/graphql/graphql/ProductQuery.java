package com.example.graphql.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.graphql.model.Product;
import com.example.graphql.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductQuery implements GraphQLQueryResolver {

    private final ProductService productService;

    @Autowired
    public ProductQuery(ProductService productService) {
        this.productService = productService;
    }

    public List<Product> products() {
        return productService.findAll();
    }

    public Product product(long id) {
        return productService.findById(id).orElse(null);
    }
}

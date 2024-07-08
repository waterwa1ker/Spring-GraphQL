package com.example.graphql.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.graphql.model.Product;
import com.example.graphql.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductMutation implements GraphQLMutationResolver {

    private final ProductService productService;

    @Autowired
    public ProductMutation(ProductService productService) {
        this.productService = productService;
    }

    public Product createProduct(Product product) {
        return productService.save(product);
    }
}

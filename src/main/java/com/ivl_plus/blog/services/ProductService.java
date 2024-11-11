package com.ivl_plus.blog.services;

import com.ivl_plus.blog.models.Product;
import com.ivl_plus.blog.repo.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    private List<Product> products = new ArrayList<>();
    private long ID = 0;

    public List<Product> list() {
        return productRepository.findAll();
    }
    public void saveProduct(Product product){
        product.setId(++ID);
        products.add(product);
    }

    public void deleteProduct(Long id){
        products.removeIf(product -> product.getId().equals(id));
    }
}

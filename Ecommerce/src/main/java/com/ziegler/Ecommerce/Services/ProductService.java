package com.ziegler.Ecommerce.Services;

import com.ziegler.Ecommerce.Model.Product;
import com.ziegler.Ecommerce.Repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public List<Product> getAll() {
        return repo.findAll();
    }

    public Product save(Product product) {
        return repo.save(product);
    }

    public List<Product> getByCategoryId(Long categoryId) {
        return repo.findAll().stream()
                .filter(p -> p.getCategory().getId().equals(categoryId))
                .toList();
    }
}
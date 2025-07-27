package com.ziegler.Ecommerce.Repositories;

import com.ziegler.Ecommerce.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

package com.ziegler.Ecommerce.Repositories;

import com.ziegler.Ecommerce.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
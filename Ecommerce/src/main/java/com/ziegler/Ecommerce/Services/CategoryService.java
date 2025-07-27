package com.ziegler.Ecommerce.Services;

import com.ziegler.Ecommerce.Model.Category;
import com.ziegler.Ecommerce.Repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository repo;

    public CategoryService(CategoryRepository repo) {
        this.repo = repo;
    }

    public List<Category> getAll() {
        return repo.findAll();
    }

    public Category save(Category category) {
        return repo.save(category);
    }
}
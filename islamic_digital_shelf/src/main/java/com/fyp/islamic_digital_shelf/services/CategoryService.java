package com.fyp.islamic_digital_shelf.services;

import com.fyp.islamic_digital_shelf.category.bean.CategoryRequest;
import com.fyp.islamic_digital_shelf.category.bean.CategoryView;

import java.util.List;

public interface CategoryService {
    CategoryView createCategory(CategoryRequest request);
    List<CategoryView> getAllCategories();
    CategoryView getCategoryById(Long id);
    CategoryView updateCategory(Long id, CategoryRequest request);
    String deleteCategory(Long id);
}

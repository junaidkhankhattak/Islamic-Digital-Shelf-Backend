package com.fyp.islamic_digital_shelf.services.imple;

import com.fyp.islamic_digital_shelf.category.bean.CategoryRequest;
import com.fyp.islamic_digital_shelf.category.bean.CategoryView;
import com.fyp.islamic_digital_shelf.model.Category;
import com.fyp.islamic_digital_shelf.repo.CategoryRepo;
import com.fyp.islamic_digital_shelf.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepo categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepo categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryView createCategory(CategoryRequest request) {
        Category category = new Category(request.getName(), request.getDescription());
        category = categoryRepository.save(category);
        return convertToView(category);
    }

    @Override
    public List<CategoryView> getAllCategories() {
        return categoryRepository.findAll().stream()
                .map(this::convertToView)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryView getCategoryById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        return convertToView(category);
    }

    @Override
    public CategoryView updateCategory(Long id, CategoryRequest request) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        category.setName(request.getName());
        category.setDescription(request.getDescription());
        category = categoryRepository.save(category);
        return convertToView(category);
    }

    @Override
    public String deleteCategory(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        categoryRepository.delete(category);
        return "Category deleted successfully";
    }

    private CategoryView convertToView(Category category) {
        CategoryView view = new CategoryView();
        view.setId(category.getId());
        view.setName(category.getName());
        view.setDescription(category.getDescription());
        view.setCreatedDate(category.getCreatedDate());
        return view;
    }
}

package services;


import dto.CategoryDto;
import models.Category;
import repository.CategoryRepository;

import javax.inject.Inject;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Inject
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public CompletionStage<Category> createCategory(CategoryDto categoryDTO) {
        Category category = new Category(categoryDTO.getName());
        return categoryRepository.create(category);
    }

    public List<Category> findAllCategories() {
        return categoryRepository.findAll();
    }

}


package com.poly.service;

import com.poly.entity.Category;
import com.poly.repository.CategoryRepository;

import java.util.List;

public class CategoryService {
    CategoryRepository categoryRepository = new CategoryRepository();
    public List<Category> getAllCategory(){
        return categoryRepository.getAllCategory();
    }
    public Category getCategoryByID(int id){
        return categoryRepository.getCategoryByID(id);
    }
    public boolean addCategory(Category category){
        List<Category> categories = categoryRepository.getAllCategory();
        categories.sort((c1, c2) -> c1.getId() < c2.getId() ? 1 : -1);
        if (category.getName() != null){
            return categoryRepository.addCategory(category);
        }
        return false;
    }
    public boolean updateCategory(Category category){
        List<Category> categories = categoryRepository.getAllCategory();
        for (Category categoryList : categories) {
            if (categoryList.getId() == category.getId()){
                return categoryRepository.updateCategory(category);
            }
        }
        return false;
    }
    public boolean deleteCategory(int id){
        List<Category> categories = categoryRepository.getAllCategory();
        for (Category category : categories) {
            if (category.getId() == id){
                return categoryRepository.deleteCategory(id);
            }
        }
        return false;
    }
}

package dao;

import entity.Category;

import java.util.List;

public interface CategoryDAO {
    List<Category> getAllCategory();
    boolean addCagegory(Category category);

    Category findByID(int id);

    boolean updateCategory(Category category);
    void deleteCategory(int id);

    List<Category> searchByName(String keyword);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ispit.dao;

import com.mycompany.ispit.entity.Category;
import java.util.List;

/**
 *
 * @author Mirai
 */
public interface CategoryDao {

    public List<Category> getListCategory();

    public Category addCategory(Category category);

    public Category getCategoryById(Integer categoryId);

    public boolean deleteCategory(Category category);
}

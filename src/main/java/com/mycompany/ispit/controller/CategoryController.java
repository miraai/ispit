/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ispit.controller;

import com.mycompany.ispit.dao.CategoryDao;
import com.mycompany.ispit.entity.Category;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Mirai
 */
@Controller
public class CategoryController {
    
    @Autowired
    private CategoryDao categoryDao;
    
    @RequestMapping(value = "/addCategory", method = RequestMethod.GET)
    public String addCategory(Model model){
        model.addAttribute("category", new Category());
        List categories = categoryDao.getListCategory();
        model.addAttribute("categories", categories);
        return "addCategory";
    }
    
    @RequestMapping(value = "/addCategory", method = RequestMethod.POST)
    public ModelAndView addCategory(@ModelAttribute("category") Category category, ModelAndView model){
        category = categoryDao.addCategory(category);
        model.addObject("successMsg", "Category added!");
        model.addObject("category", new Category());
        List categories = categoryDao.getListCategory();
        model.addObject("categories", categories);
        return model;
    }
    
    @RequestMapping(value = "/editCategory/{categoryId}", method = RequestMethod.GET)
    public String editCategory(@PathVariable("categoryId") int categoryId, Model model){
        Category category = categoryDao.getCategoryById(categoryId);
        model.addAttribute("category", category);
        List categories = categoryDao.getListCategory();
        model.addAttribute("categories", categories);
        return "addCategory";
        
    }
    
    @RequestMapping(value = "/deleteCategory/{categoryId}", method = RequestMethod.GET)
    public String deleteCategory(@PathVariable("categoryId") int categoryId, HttpServletRequest request){
        Category category = categoryDao.getCategoryById(categoryId);
        if(category == null){
            String referer = request.getHeader("Referer");
            return "redirect:" + referer;
        }
        categoryDao.deleteCategory(category);
        String referer = request.getHeader("Referer");
        return "redirect:" + referer;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ispit.dao.impl;

import com.mycompany.ispit.dao.CategoryDao;
import com.mycompany.ispit.entity.Category;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Mirai
 */
@Repository("categoryDao")
@Service
public class CategoryDaoImpl implements CategoryDao {

    @Autowired
    private SessionFactory sessionFactory;

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    @SuppressWarnings("unchecked")
    public List<Category> getListCategory() {
        return getSession().createCriteria(Category.class).list();
    }

    @Override
    @Transactional
    @SuppressWarnings("unchecked")
    public Category addCategory(Category category) {
        return (Category) getSession().merge(category);
    }

    @Override
    @Transactional
    @SuppressWarnings("unchecked")
    public Category getCategoryById(Integer categoryId) {
        return (Category) getSession().createCriteria(Category.class).add(Restrictions.eq("categoryId", categoryId)).uniqueResult();
    }

    @Override
    @Transactional
    @SuppressWarnings("unchecked")
    public boolean deleteCategory(Category category) {
        try {
            getSession().delete(category);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}

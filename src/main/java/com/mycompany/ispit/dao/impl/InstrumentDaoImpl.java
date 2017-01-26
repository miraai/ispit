/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ispit.dao.impl;

import com.mycompany.ispit.dao.InstrumentDao;
import com.mycompany.ispit.entity.Category;
import com.mycompany.ispit.entity.Instrument;
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
@Repository("instrumentDao")
@Service
public class InstrumentDaoImpl implements InstrumentDao {

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
    public List<Instrument> getListInstrument() {
        return getSession().createCriteria(Instrument.class).list();
    }

    @Override
    @Transactional
    @SuppressWarnings("unchecked")
    public Instrument addInstrument(Instrument instrument) {
        return (Instrument) getSession().merge(instrument);
    }

    @Override
    @Transactional
    @SuppressWarnings("unchecked")
    public Instrument getInstrumentById(Integer instrumentId) {
        return (Instrument) getSession().createCriteria(Instrument.class).add(Restrictions.eq("instrumentId", instrumentId)).uniqueResult();
    }

    @Override
    @Transactional
    @SuppressWarnings("unchecked")
    public boolean deleteInstrument(Instrument instrument) {
         try {
            getSession().delete(instrument);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Instrument> instrumentsByIdCategory(Integer instrumentId) {
        try {
            Category cat = (Category) getSession().createCriteria(Category.class).add(Restrictions.eq("instrumentId", instrumentId)).uniqueResult();
            List instru = getSession().createCriteria(Instrument.class).add(Restrictions.eq("categoryId", cat)).list();
            return instru;
        } catch (Exception ex) {
            return null;
        }
    }

}

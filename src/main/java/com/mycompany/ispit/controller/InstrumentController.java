/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ispit.controller;

import com.mycompany.ispit.dao.CategoryDao;
import com.mycompany.ispit.dao.InstrumentDao;
import com.mycompany.ispit.entity.Instrument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Mirai
 */
@Controller
public class InstrumentController {
    
    @Autowired
    private CategoryDao categoryDao;
    
    @Autowired
    private InstrumentDao instrumentDao;
    
    @RequestMapping(name = "/addInstrument", method = RequestMethod.GET)
    public String addInstrument(Model model){
        model.addAttribute("instrument", new Instrument());
        model.addAttribute("instruments", instrumentDao.getListInstrument());
        model.addAttribute("categories", categoryDao.getListCategory());
        return "addInstrument";
    }
}

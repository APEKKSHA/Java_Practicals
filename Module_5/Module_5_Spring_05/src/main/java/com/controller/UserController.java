package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dao.UserDao;
import com.model.UserModel;

@Controller
public class UserController 
{
	@Autowired
	UserDao dao;
	
	@RequestMapping("/adduser")
	public String showform(Model m){    
        m.addAttribute("command", new UserModel());  
        return "adduser";   
    } 
	
	/*It saves object into database. The @ModelAttribute puts request data  
     *  into model object. You need to mention RequestMethod.POST method   
     *  because default request is GET*/    
    @RequestMapping(value="/save",method = RequestMethod.POST)    
    public String save(@ModelAttribute("emp") UserModel emp){    
        dao.save(emp);    
        return "redirect:/viewuser";//will redirect to viewemp request mapping    
    }  
    
    @RequestMapping("/viewuser")    
    public String viewemp(Model m){    
        List<UserModel> list=dao.getUser();    
        m.addAttribute("list",list);  
        return "viewuser";    
    } 
    
    @RequestMapping(value="/edituser/{id}")    
    public String edit(@PathVariable int id, Model m){    
        UserModel emp=dao.getUserById(id);    
        m.addAttribute("command",emp);  
        return "edituser";    
    } 
    
    @RequestMapping(value="/editsave",method = RequestMethod.POST)    
    public String editsave(@ModelAttribute("emp") UserModel emp){    
        dao.update(emp);    
        return "redirect:/viewuser";    
    } 
    @RequestMapping(value="/deleteuser/{id}",method = RequestMethod.GET)    
    public String delete(@PathVariable int id){    
        dao.delete(id);    
        return "redirect:/viewuser";    
    } 
}

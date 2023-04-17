package com.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.dao.UserAdminDao;
import com.model.UserModel1;

@Controller
public class UserController 
{
	@Autowired
	UserAdminDao dao;
	
	  private static final String UPLOAD_DIRECTORY ="/images";  
      
	    
	@RequestMapping("/login")
	public String showform(Model m){    
        m.addAttribute("command", new UserModel1());  
        return "login";   
    } 
	@RequestMapping("/userregister")
	public String showuser(Model m){    
        m.addAttribute("command", new UserModel1());  
        return "userregister";   
    } 
	
	/*It saves object into database. The @ModelAttribute puts request data  
     *  into model object. You need to mention RequestMethod.POST method   
     *  because default request is GET*/    
    @RequestMapping(value="/save",method = RequestMethod.POST)    
    public String save(@ModelAttribute("emp") UserModel1 emp){    
        dao.save(emp);    
        return "redirect:/userprofile";//will redirect to viewemp request mapping    
    }  
    
    @RequestMapping("/userregister")  
    public ModelAndView uploadForm(){  
        return new ModelAndView("userregister");    
    }
    @RequestMapping(value="/save",method=RequestMethod.POST)  
    public ModelAndView upload(@RequestParam CommonsMultipartFile file,HttpSession session){  
            String path=session.getServletContext().getRealPath("/");  
            String filename=file.getOriginalFilename();  
              
            System.out.println(path+" "+filename);  
            try{  
            byte barr[]=file.getBytes();  
              
            BufferedOutputStream bout=new BufferedOutputStream(  
                     new FileOutputStream(path+"/"+filename));  
            bout.write(barr);  
            bout.flush();  
            bout.close();  
              
            }catch(Exception e){System.out.println(e);}  
            return new ModelAndView("upload-success","filename",path+"/"+filename);  
        }  
    
    @RequestMapping("/viewuser")    
    public String viewemp(Model m){    
        List<UserModel1> list=dao.getUser();    
        m.addAttribute("list",list);  
        return "viewuser";    
    } 
    
    @RequestMapping(value="/edituser/{id}")    
    public String edit(@PathVariable int id, Model m){    
        UserModel1 emp=dao.getUserById(id);    
        m.addAttribute("command",emp);  
        return "edituser";    
    } 
    
    @RequestMapping(value="/editsave",method = RequestMethod.POST)    
    public String editsave(@ModelAttribute("emp") UserModel1 emp){    
        dao.update(emp);    
        return "redirect:/userprofile";    
    } 
    @RequestMapping(value="/deleteuser/{id}",method = RequestMethod.GET)    
    public String delete(@PathVariable int id){    
        dao.delete(id);    
        return "redirect:/viewuser";    
    } 
}

package com.pg.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pg.entity.RegData;
import com.pg.repository.RegDataRepository;
import com.pg.service.RegDataService;

@Controller 
public class TrackStatus {
	
	@Autowired
	RegDataService regDataService; 

	@Autowired
	RegDataRepository registerRepository;
	
	@RequestMapping("/track")
	public String track() {  
		return "track";  
	} 
	
	@RequestMapping("/viewstatus") 
	public String view() {
		return "viewstatus";   
	} 
	
	@PostMapping("/trackstatus")
    public String track(@ModelAttribute("register") RegData register,Model model,RedirectAttributes redirectAttributes ) {
    	
    	RegData reg = regDataService.reg(register.getTrackId());
    
    	if(reg==null) 
    	{
    		redirectAttributes.addFlashAttribute("error","Grievance ID not found");
			return "redirect:/track";
    	}
    	
    	String trackIdString = reg.getTrackId(); 
    	RegData alldetails = registerRepository.getDetails(trackIdString);
    	System.out.println(alldetails);
    		
         model.addAttribute("listgrievances",alldetails);
    		
    	 return "viewstatus";		 
    	}  
    	
   
	  
		@RequestMapping(value = {"/logout"}, method = RequestMethod.POST)
	    public String logoutDo(HttpServletRequest request,HttpServletResponse response) 
	    {
	        return "redirect:/track"; 
	    } 

}  
     
      
package com.pg.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pg.entity.User;
import com.pg.reuse.Aes;
import com.pg.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping("/login")
	public String login(Model model)
	{
		model.addAttribute("user", new User());
		return "login";
	}
	@RequestMapping("/dash") 
	public String dash() 
	{
		return "dash";
	} 
 
	  
	@PostMapping("/login")
	public String processLogin(@Valid @ModelAttribute User user, BindingResult result,RedirectAttributes redirectAttributes)
	{
		String returnValue = "login";
		if(result.hasErrors())
		{
			System.out.println(result); 

	 	 	return "login";  
		}else { 
				String decryptPassword;
				try {
					User getUser = loginService.findByUser(user.getEmail());
					if(getUser == null)
					{
						redirectAttributes.addFlashAttribute("error","Not authorized to login!");
						return "redirect:/login";
					}
					
					else  {
		 				decryptPassword = Aes.decrypt(getUser.getPassword(),"password");
						if(user.getPassword().equalsIgnoreCase(decryptPassword)) {
							returnValue = "redirect:/dash";
						}else {
							
							redirectAttributes.addFlashAttribute("error","Incorrect credentials");
							return "redirect:/login";
						}
					}
					
					
					System.out.println(getUser); 
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		} 
		return returnValue;
	}  
	
	
}
 
  
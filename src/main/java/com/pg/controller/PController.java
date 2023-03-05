package com.pg.controller;
 
import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.pg.entity.Admindetails;
import com.pg.entity.Officer;
import com.pg.entity.RegData;
import com.pg.gender.Gender;
import com.pg.repository.ViewAdminDetailsRepository;
import com.pg.repository.ViewOfficerRepository;
import com.pg.service.RegDataService;
import com.pg.service.ViewService;
 
@Controller
public class PController {
	
	@Autowired 
	RegDataService logDataService; 
	 
	@Autowired 
	ViewService ViewDataService;  
	
/*	@GetMapping("/PendingGriev/page/{pageNumber}")
	public String getOnePage(Model model, @PathVariable("pageNumber") int currentPage){
	    Page<RegData> page = ViewDataService.findPage(currentPage);
	    int totalPages = page.getTotalPages();
	    long totalItems = page.getTotalElements();

	    model.addAttribute("currentPage", currentPage);
	    model.addAttribute("totalPages", totalPages);
	    model.addAttribute("totalItems", totalItems);

	    return "/PendingGriev";
	}
 */
	@Autowired
    ViewOfficerRepository ViewOfficer;
	
	@Autowired
	ViewAdminDetailsRepository ViewAdminDetails;
	
	@GetMapping("/admin_details")
	   public String viewAdminPage(Model model) {
	   List<Admindetails> listadmin = ViewDataService.listssAll();
	   model.addAttribute("listadmin", listadmin);
	   System.out.print("Get / ");
	   return "admin_details";
	   }
	
	@GetMapping("/viewofficers")
	   public String viewOfficerPage(Model model) {
	   List<Officer> listofficer = ViewDataService.listsAll();
	   model.addAttribute("listofficer", listofficer);
	   System.out.print("Get / ");
	   return "viewofficers";
	   }
	
	@GetMapping("/PendingGriev")
	   public String viewRegPage(Model model) {
	   List<RegData> listgerievance = ViewDataService.listAll();
	   model.addAttribute("listgerievance", listgerievance);
	   System.out.print("Get / ");
	   return "PendingGriev";
	   }
	
	@RequestMapping("/index")
	public String index(Model model) throws IOException 
	{
		model.addAttribute("RegData", new RegData());
		model.addAttribute("gender_value", Gender.values());
		
		return "index"; 
	} 
	
	@RequestMapping("/redressallist")
	public String redressallist() {
		return "redressallist"; 
	}
	
	@RequestMapping("/HalfRedressalList")
	public String HalfRedressalList() {
		return "HalfRedressalList"; 
	}
	
	@RequestMapping("/delete/{id}")
    public String deleteofficer(@PathVariable(name = "id") int id) {
		ViewDataService.delete(id);
        return "redirect:/viewofficers";
    }
	 
	@RequestMapping("/PendingGriev")
	public String PendingGriev() {
		return "PendingGriev"; 
	}


	 
	@PostMapping("/addPg")
	public String processForm(@Valid @ModelAttribute("RegData") RegData register, BindingResult result, Model model,@RequestParam("files") MultipartFile file) throws IOException
	{   
		if(result.hasErrors())  
		{
	 		System.out.println(result);
			model.addAttribute("gender_value",Gender.values());
	
			return "index";
 
		} 
		else  
		{ 
				if(file.isEmpty()==true)
				{
					
					logDataService.saveContent(null, register);
				
				}
				else {
					
			 		logDataService.saveContent(file, register);
				}
				 
		}
		return "redirect:/index"; 
	}  
	    
}  
             
    

   
         
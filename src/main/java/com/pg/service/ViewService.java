package com.pg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.pg.entity.Officer;
import com.pg.entity.RegData;
import com.pg.entity.Admindetails;
import com.pg.repository.RegDataRepository;
import com.pg.repository.ViewAdminDetailsRepository;
import com.pg.repository.ViewOfficerRepository;



@Service
public class ViewService {

	@Autowired
    private RegDataRepository repo;
	
	@Autowired
	private ViewOfficerRepository viewOfficer;
	
	@Autowired
	private ViewAdminDetailsRepository admin_details;
	
    public List<RegData> listAll() {
        return repo.findAll();
    } 
    
    public List<Officer> listsAll(){
    	return viewOfficer.findAll();
    }
    
    public void delete(Integer id) {
    	viewOfficer.deleteById(id);
    }
  
    public List<Admindetails> listssAll(){
    	return admin_details.findAll();
    }
}

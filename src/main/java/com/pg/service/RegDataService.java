package com.pg.service;

import java.io.IOException;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
 
import com.pg.entity.Doc;
import com.pg.entity.RegData;
import com.pg.repository.DocRepository;
import com.pg.repository.RegDataRepository;

@Service
public class RegDataService {
	
	@Autowired
	RegDataRepository regDataDao;
	
	@Autowired
	DocRepository docRepository;
	
	
	@Autowired
	private EmailSenderService senderService; 
	

	
	public void saveContent(MultipartFile file, RegData register) throws IOException {
		
		 String trackcode = "";
		   if(file == null)
		    {
		    	register.setDoc(null);
				regDataDao.save(register);
			      
					String state = register.getState();
				    String district = register.getDistrict();
				    String s1 = state.substring(0,2);
					String s2 = district.substring(0,2);
					String str = s1.toUpperCase();
					String str2 = s2.toUpperCase();
					Integer id = register.getId();
					LocalDate date = LocalDate.now();
				 	int yr = date.getYear();
					System.out.println(date);
					trackcode = str+str2+yr+id;
					System.out.println(trackcode);
					register.setTrackId(trackcode);
					regDataDao.save(register); 
		     }
		    else {
			    	String docname = file.getOriginalFilename();
					Doc doc = new Doc(docname,file.getBytes());
					docRepository.save(doc);
					register.setDoc(doc);
					doc.setRegister(register);
					regDataDao.save(register);
					
	 				String state = register.getState();
				    String district = register.getDistrict();
				    String s1 = state.substring(0,2);
					String s2 = district.substring(0,2);
					String str = s1.toUpperCase();
					String str2 = s2.toUpperCase();
					Integer id = register.getId();
					LocalDate date = LocalDate.now();
					int yr = date.getYear();
					System.out.println(date);
					trackcode = str+str2+yr+id;
					System.out.println(trackcode);
					register.setTrackId(trackcode);
					regDataDao.save(register); 
				  }
		   sendMail(register.getEmail(),trackcode);
		   
		   }
	
	public void sendMail(String email,String id) {
		senderService.sendEmail(email,
				"Your Grievance Tack Id","Your grievance has been registered successfully."
				+ "Kindly, note your greivance track id for all further information.\r\n"
				+ "\r\nGrievance Track Id "+id);
	}
	 

	public RegData reg(String trackId) {
		
		RegData register = regDataDao.findByTrackId(trackId);
		return register;
	} 
}
 
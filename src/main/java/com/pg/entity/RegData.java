package com.pg.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "register")
public class RegData {        
 
	@Id    
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id; 
 
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "doc_id")
    private Doc  doc;  
	
	@NotBlank(message = "District cannot be empty")
	@Size(max = 50)
	private String district;  

	@NotBlank(message = "State cannot be empty")
	@Size(max = 50)
	private String state;  
           
	              
	public RegData()  {      
		super();         
		// TODO Auto-generated constructor stub
	}     
          
	@NotBlank(message = "Name cannot be empty")
	@Size(min = 3, max = 99,message = "minimum 3 to 50 charcters")
	@Pattern(regexp = "^[a-zA-Z\\s]+$", message = "alphabets A-Z or a-z are allowed")
	@Column(unique = true)
	private String name;
	 
	@Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$",message = "please enter a valid email")
	@NotBlank(message = "Email cannot be empty")
	@Size(max = 100)
	private String email;      
 
	@NotBlank(message = "Mobile cannot be empty")
	@Pattern(regexp ="(^[6-9]{1}[0-9]{9})",message="must be a valid mobile number")
	@Column(unique = true)
	@Size(max = 10)
	private String mobile;  
	   
	@NotBlank(message = "Category cannot be empty")
	@Size(max = 50)
	private String category;    
	 
	@NotBlank(message = "Please write your grievance here")     
	@Size(max = 500)
	private String grievance;     
	  
	@NotBlank(message = "Pincode cannot be empty") 
	@Pattern(regexp = "(^[1-9]{1}[0-9]{5})", message="must be a valid pincode")
	@Size(max = 6)
	private String pincode; 

	@NotBlank(message = "please select the gender")   
	private String gender;  
	
	private String status="Pending";
	
	private String trackId;
 
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) { 
		this.id = id;
	}
	public String getGender() {      
		return gender;              
	}               
         
	public void setGender(String gender) {         
		this.gender = gender; 
	}      
         
	public String getMobile() {         
		return mobile;       
	}            
           
	public void setMobile(String mobile) { 
		this.mobile = mobile;        
	}          
           
	public String getCategory() {     
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getGrievance() {
		return grievance;
	}

	public void setGrievance(String grievance) {
		this.grievance = grievance;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getName() {
		return name;
	}

	public String getTrackId() {
		return trackId;
	}

	public void setTrackId(String trackId) {
		this.trackId = trackId;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}   
    
	public void setEmail(String email) { 
		this.email = email;
	}
	
	public Doc getDoc() {
		return doc;
	}

	public void setDoc(Doc doc) {
		this.doc = doc;
	}
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	

	

	@Override
	public String toString() {
		
		return "Register [id=" + id + ", doc=" + doc + ", district=" + district + ", state=" + state + ", name=" + name
				+ ", email=" + email + ", mobile=" + mobile + ", category=" + category + ", grievance=" + grievance
				+ ", pincode=" + pincode + ", gender=" + gender + ", status=" + status
				+ ", trackId=" + trackId + "]";
	}

	public RegData(Integer id, Doc doc, 
			@NotBlank(message = "Name cannot be empty") @Size(min = 3, max = 50, message = "minimum 3 to 50 charcters") @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "alphabets A-Z or a-z are allowed") String name,
			@Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "please enter a valid email") @NotBlank(message = "Email cannot be empty") String email,
			@NotBlank(message = "Mobile cannot be empty") @Pattern(regexp = "(^[6-9]{1}[0-9]{9})", message = "must be a valid mobile number") String mobile,
			@NotBlank(message = "Category cannot be empty") String category,
			@NotBlank(message = "Please write your grievance here") String grievance,
			@NotBlank(message = "Pincode cannot be empty") @Pattern(regexp = "(^[1-9]{1}[0-9]{5})", message = "must be a valid pincode") String pincode,
			@NotBlank(message = "please select the gender") String gender, String status, String trackId,String state,String district) {
		super();
		this.id = id;
		this.doc = doc;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.category = category;
		this.grievance = grievance;
		this.pincode = pincode;
		this.gender = gender;
		this.status = status;
		this.trackId = trackId; 
		this.state = state;
		this.district = district; 
	}	      
	
}

package com.pg.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "Docs")
public class Doc {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private String docname;

	/*@Lob
	@Type(type = "org.hibernate.type.BinaryType")
	private byte[] data; */
	
	@Lob
	@Type(type = "org.hibernate.type.BinaryType")
	private byte[] data;
	
	@OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL, mappedBy = "doc")
	private RegData register;
	 
	public Doc() {
		super();
		// TODO Auto-generated constructor stub
	} 

	public Doc(String docname, byte[] data) {
		super();
		this.docname = docname;
		this.data = data;
	}

	public Integer getId() { 
		return id;
	} 
 
	public void setId(Integer id) {
		this.id = id;
	}

	public String getDocname() {
		return docname;
	}

	public void setDocname(String docname) {
		this.docname = docname;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public RegData getRegister() {
		return register;
	}
	public void setRegister(RegData register) {
		this.register = register;
	}

	
}

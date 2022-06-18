package com.carinsurance.springboot.entity;

import javax.persistence.*;

@Entity
@Table(name = "customers", schema="insurance")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name", nullable = false, length = 50)
	private String name;
	
	@Column(name =  "gender")
	private String gender;

	@Column(nullable=false, length=50, unique=true)
	private String email;
	
	@Column(nullable=false, length=50, unique=true)
	private String password;

	@Column(nullable=false)
	private String address;
	
	@Column(nullable=false)
	private String dob;
	
	@Column(length=10, unique=true)
	private String phoneno;
	
	private boolean enabled;
	
	public Customer() {
		super();
	}
	
	public Customer(String name, String gender, String email, String password, String address, String dob,
			String phoneno, boolean enabled) {
		super();
		this.name = name;
		this.gender = gender;
		this.email = email;
		this.password = password;
		this.address = address;
		this.dob = dob;
		this.phoneno = phoneno;
		this.enabled = enabled;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", gender=" + gender + ", email=" + email + ", password="
				+ password + ", address=" + address + ", dob=" + dob + ", phoneno=" + phoneno + ",  enabled=" + enabled + "]";
	}
	
		
}

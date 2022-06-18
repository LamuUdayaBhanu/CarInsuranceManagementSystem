package com.carinsurance.springboot.entity;

import javax.persistence.*;

@Entity
@Table(name="cars",schema = "insurance")
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name ="c_name", nullable=false,unique=true)
	private String c_name;
	
	@Column(nullable=false)
	private String insu_Policy;
	
	@Column(nullable=false)
	private String category;
	
	@Column(nullable=false)
	private String reg_date;
	
	@Column(nullable=false)
	private String duration;
	
	@Column(nullable=false)
	private String car_regNo;

	@Column(nullable=false)
	private String car_model;
	
	@Column(nullable=false)
	private String exp_date;

	@Column(nullable=false)
	private String cost;
	
	@Column(nullable=false)
	private String chassisno;
	
	@Column(nullable=false)
	private String status;
	
	public Car() {
		super();
	}
	
	
	public Car(String c_name, String insu_Policy, String category, String reg_date, String duration, String car_regNo,
			String car_model, String exp_date, String cost, String chassisno, String status) {
		super();
		this.c_name = c_name;
		this.insu_Policy = insu_Policy;
		this.category = category;
		this.reg_date = reg_date;
		this.duration = duration;
		this.car_regNo = car_regNo;
		this.car_model = car_model;
		this.exp_date = exp_date;
		this.cost = cost;
		this.chassisno = chassisno;
		this.status = status;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public String getInsu_Policy() {
		return insu_Policy;
	}

	public void setInsu_Policy(String insu_Policy) {
		this.insu_Policy = insu_Policy;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getReg_date() {
		return reg_date;
	}

	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getCar_regNo() {
		return car_regNo;
	}

	public void setCar_regNo(String car_regNo) {
		this.car_regNo = car_regNo;
	}

	public String getCar_model() {
		return car_model;
	}

	public void setCar_model(String car_model) {
		this.car_model = car_model;
	}

	public String getExp_date() {
		return exp_date;
	}

	public void setExp_date(String exp_date) {
		this.exp_date = exp_date;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public String getChassisno() {
		return chassisno;
	}

	public void setChassisno(String chassisno) {
		this.chassisno = chassisno;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", c_name=" + c_name + ", insu_Policy=" + insu_Policy + ", category=" + category
				+ ", reg_date=" + reg_date + ", duration=" + duration + ", car_regNo=" + car_regNo + ", car_model="
				+ car_model + ", exp_date=" + exp_date + ", cost=" + cost + ", chassisno=" + chassisno + ", status="
				+ status + "]";
	}
	
	
}

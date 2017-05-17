package com.meetUps.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	@NotEmpty(message="firstName Should not be empty")
	private String userName;
	@NotEmpty(message="firstName Should not be empty")
	private String name;
	@NotEmpty(message="email Should not be empty")
	private String email;
	@NotEmpty(message="password Should not be empty")
	private String password;
	@NotEmpty(message="companyName Should not be empty")
	private String companyName;
	@NotEmpty(message="CompanyAddress Should not be empty")
	private String companyAddress;
	@NotEmpty(message="mobile Should not be empty")
	private String mobileNo;
	@NotEmpty(message="technicalCapabilities Should not be empty")
	private String technicalCapabilities;
	@NotEmpty(message="yrsOfExperience Should not be empty")
	private String yrsOfExperience;
	private String role;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getName() {
		return name;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyAddress() {
		return companyAddress;
	}
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getTechnicalCapabilities() {
		return technicalCapabilities;
	}
	public void setTechnicalCapabilities(String technicalCapabilities) {
		this.technicalCapabilities = technicalCapabilities;
	}
	public String getYrsOfExperience() {
		return yrsOfExperience;
	}
	public void setYrsOfExperience(String yrsOfExperience) {
		this.yrsOfExperience = yrsOfExperience;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	

}

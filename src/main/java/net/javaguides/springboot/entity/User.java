package net.javaguides.springboot.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.Collection;

import javax.persistence.*;

@Entity
@javax.persistence.Table(name="users")
public class User {
	@Id
	@Column(name="email")
	private String email;

	@Column(name="_password")
	private String password;

	@Column(name="name")
	private String fullName;

	@Column(name="business_name")
	private String business;

	@Column(name="phone")
	private String phone;

	@Column(name="_role")
	private String role;

	@OneToMany(mappedBy ="users",fetch = FetchType.LAZY)
	private Collection<Menu> menu;
	@OneToMany(mappedBy ="users",fetch = FetchType.LAZY)
	private Collection<PaymentHistory> paymentHistories;

	@OneToMany(mappedBy ="users",fetch = FetchType.LAZY)
	private Collection<DataOfCustomer> dataOfCustomers;

	public User() {
	}

	public User( String email, String password, String fullName, String business, String phone, String role, Collection<Menu> menu, Collection<PaymentHistory> paymentHistories) {
		this.email = email;
		this.password = password;
		this.fullName = fullName;
		this.business = business;
		this.phone = phone;
		this.role = role;
		this.menu = menu;
		this.paymentHistories = paymentHistories;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getBusiness() {
		return business;
	}

	public void setBusiness(String business) {
		this.business = business;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}


}


package net.javaguides.springboot.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.sql.Date;
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

	@Column(name="date_of_birth")
	private Date dateOfBirth;

	@Column(name="gender")
	private String gender;

	@Column(name="_address")
	private String address;

	@Column(name="created_date")
	private Date createdDate;

	@Column(name="created_by")
	private String createdBy;

	@OneToMany(mappedBy ="users",fetch = FetchType.LAZY)
	private Collection<Menu> menu;
	@OneToMany(mappedBy ="users",fetch = FetchType.LAZY)
	private Collection<PaymentHistory> paymentHistories;

	@OneToMany(mappedBy ="users",fetch = FetchType.LAZY)
	private Collection<DataOfCustomer> dataOfCustomers;

	public User() {
	}

	public User(String email, String password, String fullName, String business, String phone, String role, Date dateOfBirth, String gender, String address, Date createdDate, String createdBy, Collection<Menu> menu, Collection<PaymentHistory> paymentHistories, Collection<DataOfCustomer> dataOfCustomers) {
		this.email = email;
		this.password = password;
		this.fullName = fullName;
		this.business = business;
		this.phone = phone;
		this.role = role;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.address = address;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.menu = menu;
		this.paymentHistories = paymentHistories;
		this.dataOfCustomers = dataOfCustomers;
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

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
}


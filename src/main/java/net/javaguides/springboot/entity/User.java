package net.javaguides.springboot.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.Collection;

import javax.persistence.*;

@Entity
@javax.persistence.Table(name="users")
public class User {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name="email")
	private String email;

	@Column(name="_password")
	private String password;

	@Column(name="name")
	private String name_user;

	@Column(name="business_name")
	private String business;

	@Column(name="phone")
	private String phone;

	@Column(name="_role")
	private String role;

	@JsonManagedReference
	@OneToMany(mappedBy ="users",fetch = FetchType.LAZY)
	private Collection<Menu> menu;

	@JsonManagedReference
	@OneToMany(mappedBy ="users",fetch = FetchType.LAZY)
	private Collection<PaymentHistory> paymentHistories;

	public User() {
	}

	public User(int id, String email, String password, String name_user, String business, String phone, String role, Collection<Menu> menu, Collection<PaymentHistory> paymentHistories) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.name_user = name_user;
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

	public String getName_user() {
		return name_user;
	}

	public void setName_user(String name_user) {
		this.name_user = name_user;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Collection<Menu> getMenu() {
		return menu;
	}

	public void setMenu(Collection<Menu> menu) {
		this.menu = menu;
	}
}


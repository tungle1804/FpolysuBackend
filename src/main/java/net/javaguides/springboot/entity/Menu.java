package net.javaguides.springboot.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@javax.persistence.Table(name="menu")
public class Menu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name="name_menu")
	private String name_menu;

	@Column(name="color_menu")
	private String color_menu;

	@Column(name="_status")
	private boolean status;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="email")
	private User users;

	@JsonManagedReference
	@OneToMany(mappedBy = "menu",fetch = FetchType.LAZY)
	private Collection<Button> button;

	public Menu() {
	}

	public Menu(int id, String name_menu, String color_menu, boolean status, User users, Collection<Button> button) {
		this.id = id;
		this.name_menu = name_menu;
		this.color_menu = color_menu;
		this.status = status;
		this.users = users;
		this.button = button;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Collection<Button> getButton() {
		return button;
	}

	public void setButton(Collection<Button> button) {
		this.button = button;
	}

	public String getName_menu() {
		return name_menu;
	}

	public void setName_menu(String name_menu) {
		this.name_menu = name_menu;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public User getUsers() {
		return users;
	}

	public void setUsers(User users) {
		this.users = users;
	}

	public String getColor_menu() {
		return color_menu;
	}

	public void setColor_menu(String color_menu) {
		this.color_menu = color_menu;
	}
	
	
	
	
	
}

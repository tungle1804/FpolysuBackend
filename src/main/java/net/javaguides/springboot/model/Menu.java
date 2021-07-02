package net.javaguides.springboot.model;

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
	@Column(name="id_menu")
	private int id_menu;
	@Column(name="name_menu")
	private String name_menu;
	@Column(name="_status")
	private boolean status;
	@Column(name="color_menu")
	private String color_menu;
	@ManyToOne
	@JoinColumn(name="email")
	private User users;
	@OneToMany(mappedBy = "menu",fetch = FetchType.LAZY)
	private Collection<Button> button;
	public int getId_menu() {
		return id_menu;
	}
	public void setId_menu(int id_menu) {
		this.id_menu = id_menu;
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

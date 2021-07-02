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
@javax.persistence.Table(name="button")
public class Button {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_button")
	private int id_button;
	@Column(name="name_button")
	private String name_button;
	@Column(name="color_text")
	private String color_text;
	@Column(name="color_background")
	private String color_background;
	@Column(name="color_icon")
	private String color_icon;
	@Column(name="link")
	private String link;
	@Column(name="icon")
	private String icon;
	@ManyToOne
	@JoinColumn(name="id_menu")
	private Menu menu;

	public int getId_button() {
		return id_button;
	}

	public void setId_button(int id_button) {
		this.id_button = id_button;
	}

	public String getName_button() {
		return name_button;
	}

	public void setName_button(String name_button) {
		this.name_button = name_button;
	}

	

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getColor_text() {
		return color_text;
	}

	public void setColor_text(String color_text) {
		this.color_text = color_text;
	}

	public String getColor_background() {
		return color_background;
	}

	public void setColor_background(String color_background) {
		this.color_background = color_background;
	}

	public String getColor_icon() {
		return color_icon;
	}

	public void setColor_icon(String color_icon) {
		this.color_icon = color_icon;
	}
		
	
	

}

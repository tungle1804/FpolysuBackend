package net.javaguides.springboot.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Entity@Getter@Setter@AllArgsConstructor@NoArgsConstructor
@javax.persistence.Table(name="button")
public class Button {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name="type_button")
	private String TypeButton;

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

//@JsonIgnore
	@ManyToOne
	@JoinColumn(name="id_menu")
	private Menu menu;

<<<<<<< HEAD
=======
	@OneToMany(mappedBy ="buttons",fetch = FetchType.LAZY)
	private Collection<Modal> modal;

	public Button() {
	}

	public Button(int id, String name_button, String color_text, String color_background, String color_icon, String link, String icon, Menu menu) {
		this.id = id;
		this.name_button = name_button;
		this.color_text = color_text;
		this.color_background = color_background;
		this.color_icon = color_icon;
		this.link = link;
		this.icon = icon;
		this.menu = menu;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
>>>>>>> 7ef1f7ecc7cdcc20e9b8d4b4ce73c2365e381a2a

	
	

}

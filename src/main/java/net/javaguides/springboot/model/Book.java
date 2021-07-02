package net.javaguides.springboot.model;

import java.util.ArrayList;
import java.util.List;

public class Book {
	private List<Menu> menu = new ArrayList<>();

    private List<Button> button = new ArrayList<>();


	public List<Menu> getMenu() {
		return menu;
	}


	public void setMenu(List<Menu> menu) {
		this.menu = menu;
	}



	public List<Button> getButton() {
		return button;
	}


	public void setButton(List<Button> button) {
		this.button = button;
	}



	public Book() {
    }
}

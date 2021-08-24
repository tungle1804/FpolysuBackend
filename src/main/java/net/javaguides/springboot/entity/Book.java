package net.javaguides.springboot.entity;

import java.util.ArrayList;
import java.util.List;

public class Book {

    private List<Menu> menu = new ArrayList<>();

    private List<Button> button = new ArrayList<>();

    public Book() {
    }

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
}

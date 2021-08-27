package net.javaguides.springboot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@Entity
@javax.persistence.Table(name = "menu")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name_menu")
    private String name_menu;
    @Column(name = "color_menu")
    private String color_menu;
    @Column(name = "_status")
    private boolean status;
    @Column(name = "menu_type")
    private String menuType;
    @Column(name = "menu_location")
    private String menuLocation;


    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "email")
    private User users;


    @OneToMany(mappedBy = "menu", fetch = FetchType.LAZY)
    private Collection<Button> button;

    public Menu() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }

    public String getMenuLocation() {
        return menuLocation;
    }

    public void setMenuLocation(String menuLocation) {
        this.menuLocation = menuLocation;
    }

}

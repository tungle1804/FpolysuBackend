package net.javaguides.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@javax.persistence.Table(name = "button")
public class Button {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "type_button")
    private String TypeButton;

    @Column(name = "name_button")
    private String name_button;

    @Column(name = "color_text")
    private String color_text;

    @Column(name = "color_background")
    private String color_background;

    @Column(name = "color_icon")
    private String color_icon;

    @Column(name = "link")
    private String link;

    @Column(name = "icon")
    private String icon;

    //@JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_menu")
    private Menu menu;


    public Button() {

    }
}

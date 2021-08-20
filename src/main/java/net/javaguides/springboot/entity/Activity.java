package net.javaguides.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@javax.persistence.Table(name="activity")
public class Activity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name = "created_at")
    private Date CreatedAt = new Date();
@Column(name = "fromUrl")
private String fromUrl;
@Column(name ="id_button")
    private int buttonId;
    public Activity(int buttonId) {
        this.buttonId = buttonId;
    }
}

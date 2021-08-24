package net.javaguides.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@javax.persistence.Table(name = "users")
public class User {
    @Id
    @Column(name = "email")
    private String email;

    @Column(name = "_password")
    private String password;

    @Column(name = "name")
    private String fullName;

    @Column(name = "business_name")
    private String business;

    @Column(name = "phone")
    private String phone;

    @Column(name = "_role")
    private String role;

    @OneToMany(mappedBy = "users", fetch = FetchType.LAZY)
    private Collection<Menu> menu;
    @OneToMany(mappedBy = "users", fetch = FetchType.LAZY)
    private Collection<PaymentHistory> paymentHistories;

    @OneToMany(mappedBy = "users", fetch = FetchType.LAZY)
    private Collection<DataOfCustomer> dataOfCustomers;


}


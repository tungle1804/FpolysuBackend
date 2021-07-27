package net.javaguides.springboot.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Collection;

@Entity
@javax.persistence.Table(name="servicefee")
public class ServiceFee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name_service")
    private String nameService;

    @Column(name = "price")
    private int price;

    @JsonManagedReference
    @OneToMany(mappedBy ="serviceFee",fetch = FetchType.LAZY)
    private Collection<PaymentHistory> paymentHistories;

    public int getId() {
        return id;
    }

    public ServiceFee() {
    }

    public ServiceFee(int id, String nameService, int price, Collection<PaymentHistory> paymentHistories) {
        this.id = id;
        this.nameService = nameService;
        this.price = price;
        this.paymentHistories = paymentHistories;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

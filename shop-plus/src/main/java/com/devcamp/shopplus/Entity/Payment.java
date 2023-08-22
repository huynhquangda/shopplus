package com.devcamp.shopplus.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "check_number")
    private String checkNumber;
    @Column(name = "pament_date")
    private Date paymentDate;
    private double ammount;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCheckNumber() {
        return checkNumber;
    }

    public void setCheckNumber(String checkNumber) {
        this.checkNumber = checkNumber;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public double getAmmount() {
        return ammount;
    }

    public void setAmmount(double ammount) {
        this.ammount = ammount;
    }

    // public Customer getCustomer() {
    // return customer;
    // }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Payment(long id, String checkNumber, Date paymentDate, double ammount, Customer customer) {
        this.id = id;
        this.checkNumber = checkNumber;
        this.paymentDate = paymentDate;
        this.ammount = ammount;
        this.customer = customer;
    }

    public Payment() {
    }

}

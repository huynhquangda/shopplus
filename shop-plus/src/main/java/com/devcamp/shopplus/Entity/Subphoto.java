package com.devcamp.shopplus.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sub_photo")
public class Subphoto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "sub_photo")
    private String subPhoto;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubPhoto() {
        return subPhoto;
    }

    public void setSubPhoto(String subPhoto) {
        this.subPhoto = subPhoto;
    }

    // public Product getProduct() {
    // return product;
    // }
    public void setProduct(Product product) {
        this.product = product;
    }

    public Subphoto(int id, String subPhoto, Product product) {
        this.id = id;
        this.subPhoto = subPhoto;
        this.product = product;
    }

    public Subphoto() {
    }

}

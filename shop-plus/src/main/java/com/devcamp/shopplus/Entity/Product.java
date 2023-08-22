package com.devcamp.shopplus.Entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "product_code")
    private String productCode;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "product_description")
    private String productDescription;
    @Column(name = "product_scale")
    private String productScale;
    @Column(name = "product_vendor")
    private String productVendor;
    @Column(name = "quantity_in_stock")
    private int quantityInStock;
    @Column(name = "buy_price")
    private double buyPrice;
    @OneToMany(mappedBy = "product")
    private Set<OrderDetail> orderDetails;
    @ManyToOne
    @JoinColumn(name = "product_line_id")
    private ProductLine productLine;
    @Column(name = "price_sale")
    private double priceSale;
    private String color;
    private int rating;

    private String photo;
    @OneToMany(mappedBy = "product")
    private Set<Subphoto> subphotos;
    // @ManyToOne
    // @JoinColumn(name = "cart_id")
    // private Cart cart;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductScale() {
        return productScale;
    }

    public void setProductScale(String productScale) {
        this.productScale = productScale;
    }

    public String getProductVendor() {
        return productVendor;
    }

    public void setProductVendor(String productVendor) {
        this.productVendor = productVendor;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(double buyPrice) {
        this.buyPrice = buyPrice;
    }

    public Set<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(Set<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    // public ProductLine getProductLine() {
    // return productLine;
    // }

    public void setProductLine(ProductLine productLine) {
        this.productLine = productLine;
    }

    public double getPriceSale() {
        return priceSale;
    }

    public void setPriceSale(double priceSale) {
        this.priceSale = priceSale;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    // public Set<String> getSubPhoto() {
    // return subPhoto;
    // }

    // public void setSubPhoto(Set<String> subPhoto) {
    // this.subPhoto = subPhoto;
    // }

    // public Cart getCart() {
    // return cart;
    // }

    // public void setCart(Cart cart) {
    // this.cart = cart;
    // }

    public Set<Subphoto> getSubphotos() {
        return subphotos;
    }

    public void setSubphotos(Set<Subphoto> subphotos) {
        this.subphotos = subphotos;
    }

    public Product(long id, String productCode, String productName, String productDescription, String productScale,
            String productVendor, int quantityInStock, double buyPrice, Set<OrderDetail> orderDetails,
            ProductLine productLine, double priceSale, String color, int rating, String photo,
            Set<Subphoto> subphotos) {
        this.id = id;
        this.productCode = productCode;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productScale = productScale;
        this.productVendor = productVendor;
        this.quantityInStock = quantityInStock;
        this.buyPrice = buyPrice;
        this.orderDetails = orderDetails;
        this.productLine = productLine;
        this.priceSale = priceSale;
        this.color = color;
        this.rating = rating;
        this.photo = photo;
        this.subphotos = subphotos;
    }

    public Product() {
    }

}

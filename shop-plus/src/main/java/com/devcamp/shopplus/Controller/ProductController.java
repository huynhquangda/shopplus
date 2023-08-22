package com.devcamp.shopplus.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devcamp.shopplus.Entity.Product;
import com.devcamp.shopplus.Entity.ProductLine;
import com.devcamp.shopplus.Repository.ProductLineRepository;
import com.devcamp.shopplus.Repository.ProductRepository;

@CrossOrigin
@RestController
@RequestMapping("/")
public class ProductController {
    @Autowired
    ProductLineRepository productLineRepository;
    @Autowired
    ProductRepository productRepository;

    @GetMapping("/product")
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable("id") long id) {
        return productRepository.findById(id).get();
    }

    @PostMapping("/product/{id}")
    public ResponseEntity<Product> createProduct(@PathVariable("id") long id, @RequestBody Product pProduct) {
        try {
            Optional<ProductLine> productLineData = productLineRepository.findById(id);
            Product productData = new Product();
            productData.setBuyPrice(pProduct.getBuyPrice());
            productData.setOrderDetails(pProduct.getOrderDetails());
            productData.setProductLine(productLineData.get());
            productData.setProductCode(pProduct.getProductCode());
            productData.setProductDescription(pProduct.getProductDescription());
            productData.setProductName(pProduct.getProductName());
            productData.setProductScale(pProduct.getProductScale());
            productData.setProductVendor(pProduct.getProductVendor());
            productData.setQuantityInStock(pProduct.getQuantityInStock());
            productData.setColor(pProduct.getColor());
            productData.setPhoto(pProduct.getPhoto());
            productData.setPriceSale(pProduct.getPriceSale());
            productData.setSubphotos(pProduct.getSubphotos());
            productData.setRating(pProduct.getRating());
            return new ResponseEntity<>(productRepository.save(productData), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") long id, @RequestBody Product pProduct) {
        try {
            Optional<Product> productData = productRepository.findById(id);
            if (productData.isPresent()) {
                productData.get().setBuyPrice(pProduct.getBuyPrice());

                productData.get().setProductCode(pProduct.getProductCode());
                productData.get().setProductDescription(pProduct.getProductDescription());
                productData.get().setProductName(pProduct.getProductName());
                productData.get().setProductScale(pProduct.getProductScale());
                productData.get().setProductVendor(pProduct.getProductVendor());
                productData.get().setQuantityInStock(pProduct.getQuantityInStock());
                return new ResponseEntity<>(productRepository.save(productData.get()), HttpStatus.CREATED);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable("id") long id) {
        productRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

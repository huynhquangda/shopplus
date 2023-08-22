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

import com.devcamp.shopplus.Entity.ProductLine;
import com.devcamp.shopplus.Repository.ProductLineRepository;

@CrossOrigin
@RestController
@RequestMapping("/")
public class ProductLineController {
    @Autowired
    ProductLineRepository productLineRepository;

    @GetMapping("/productLine")
    public List<ProductLine> getAllProductLine() {
        return productLineRepository.findAll();
    }

    @GetMapping("/productLine/{id}")
    public ProductLine getProductLineById(@PathVariable("id") long id) {
        return productLineRepository.findById(id).get();
    }

    @PostMapping("/productLine")
    public ResponseEntity<ProductLine> createProductLine(@RequestBody ProductLine pProductLine) {
        try {
            ProductLine productLine = new ProductLine();
            productLine.setDescription(pProductLine.getDescription());
            productLine.setProductLine(pProductLine.getProductLine());
            productLine.setProducts(pProductLine.getProducts());
            return new ResponseEntity<>(productLineRepository.save(productLine), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/productLine/{id}")
    public ResponseEntity<ProductLine> updateProductLine(@PathVariable("id") long id,
            @RequestBody ProductLine pProductLine) {
        try {
            Optional<ProductLine> productLine = productLineRepository.findById(id);
            if (productLine.isPresent()) {
                productLine.get().setDescription(pProductLine.getDescription());
                productLine.get().setProductLine(pProductLine.getProductLine());
                productLine.get().setProducts(pProductLine.getProducts());
                return new ResponseEntity<>(productLineRepository.save(productLine.get()), HttpStatus.CREATED);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/productLine/{id}")
    public ResponseEntity<ProductLine> deleteProductLine(@PathVariable("id") long id) {
        productLineRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

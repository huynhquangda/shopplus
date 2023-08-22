package com.devcamp.shopplus.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devcamp.shopplus.Entity.demo;
import com.devcamp.shopplus.Repository.DemoRepository;

@CrossOrigin
@RestController
@RequestMapping("/")
public class DemoController {
    @Autowired
    DemoRepository demoRepository;

    @GetMapping("/demo")
    public List<demo> getAllDemo() {
        return demoRepository.findAll();
    }

}

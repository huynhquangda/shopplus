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

import com.devcamp.shopplus.Entity.Employee;
import com.devcamp.shopplus.Repository.EmployeeRepository;

@CrossOrigin
@RestController
@RequestMapping("/")
public class EmployeeController {
    @Autowired
    EmployeeRepository emlpoyeeRepository;

    @GetMapping("/employee")
    public List<Employee> getAllEmployee() {
        return emlpoyeeRepository.findAll();
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable("id") long id) {
        return emlpoyeeRepository.findById(id).get();
    }

    @PostMapping("/employee")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee pEmployee) {
        try {
            Employee employeeData = new Employee();
            employeeData.setEmail(pEmployee.getEmail());
            employeeData.setExtension(pEmployee.getExtension());
            employeeData.setFirstName(pEmployee.getFirstName());
            employeeData.setJobTitle(pEmployee.getJobTitle());
            employeeData.setLastName(pEmployee.getLastName());
            employeeData.setOfficeCode(pEmployee.getOfficeCode());
            employeeData.setReportTo(pEmployee.getReportTo());
            return new ResponseEntity<Employee>(emlpoyeeRepository.save(employeeData), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id, @RequestBody Employee pEmployee) {
        try {
            Optional<Employee> employeeData = emlpoyeeRepository.findById(id);
            if (employeeData.isPresent()) {
                employeeData.get().setEmail(pEmployee.getEmail());
                employeeData.get().setExtension(pEmployee.getExtension());
                employeeData.get().setFirstName(pEmployee.getFirstName());
                employeeData.get().setJobTitle(pEmployee.getJobTitle());
                employeeData.get().setLastName(pEmployee.getLastName());
                employeeData.get().setOfficeCode(pEmployee.getOfficeCode());
                employeeData.get().setReportTo(pEmployee.getReportTo());
                return new ResponseEntity<Employee>(emlpoyeeRepository.save(employeeData.get()), HttpStatus.CREATED);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") long id) {
        emlpoyeeRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

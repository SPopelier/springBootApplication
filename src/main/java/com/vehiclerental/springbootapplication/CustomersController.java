package com.vehiclerental.springbootapplication;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomersController {

    private final CustomerService customerService;

    public CustomersController(CustomerService customerService) { this.customerService = customerService; }

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> displayCustomers() {
        return ResponseEntity.ok().body(customerService.getCustomers());
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<Customer> displayCustomer(@PathVariable(value = "id") int customerId) {
        return ResponseEntity.ok().body(customerService.getCustomer(customerId));
    }

    @PostMapping("/customer/addCustomer")
    public ResponseEntity<Customer> addingCustomer(@Validated @RequestBody Customer customer) {
        customerService.addingCustomer(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(customer);
    }

    @PutMapping("/customer/toModifyCustomer/{id}")
    public ResponseEntity<Customer> toModifyCustomer(@PathVariable(value = "id") int customerId, @Validated @RequestBody Customer customer) {
        Customer customerUpdated = customerService.toModifyCustomer(customerId, customer);
        return ResponseEntity.ok(customerUpdated);
    }

    @DeleteMapping("/deleteCustomer/{id}")
    public ResponseEntity<Customer> deleteCustomer (@PathVariable(value = "id") int customerId) {
        for (int i = 0; i < customerService.getCustomers().size(); i++) {
            if (customerService.getCustomers().get(i).getId() == customerId) {
                customerService.deleteCustomer(customerService.getCustomers().get(i));
                return new ResponseEntity<Customer>(HttpStatus.GONE);
            }
        }
        return null;
    }
}

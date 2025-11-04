package com.vehiclerental.springbootapplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    //initialisation de la liste des Customers
    static List<Customer> customers = new ArrayList<>();


    //méthode pour fournir la liste des Customers
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    //méthode pour fournir la liste d'un Customer selon son id
    public Customer getCustomer(int id) {
        //for (int i = 0; i < customers.size(); i++) {
        //    if (customers.get(i).getId() == id) {
        //        customers.get(i).setId(0);
        //    }
        return customerRepository.findById(id);
    }

    //méthode pour ajouter un Customer
    public void addingCustomer(Customer customer) {
        RestTemplate restTemplate = new RestTemplate();
        String apiUrl = "http://localhost:8081/licenses/drivingLicense?customerId=" + customer.getDrivingLicense();
        boolean result = restTemplate.getForObject(apiUrl, Boolean.class);
        if (result) {
            System.out.println(customer);
            customerRepository.save(customer);
        } else {
            throw new IllegalArgumentException("The drivingLicense is not valid !");
        }
    }

    //méthode pour modifier un Customer
    public Customer toModifyCustomer(int idCustomerActual, Customer customerBodyRequest) {
        Customer existingCustomer = customerRepository.findById(idCustomerActual);
        existingCustomer.setId(idCustomerActual);
        existingCustomer.setFirstName(customerBodyRequest.getFirstName());
        existingCustomer.setLastName(customerBodyRequest.getLastName());
        existingCustomer.setDateOfBirth(customerBodyRequest.getDateOfBirth());
        existingCustomer.setDrivingLicense(customerBodyRequest.getDrivingLicense());
        customerRepository.save(existingCustomer);
        return existingCustomer;
    }


    //méthode pour supprimer un Customer
    public void deleteCustomer(int id) {
        customerRepository.deleteById(id);
    }
}

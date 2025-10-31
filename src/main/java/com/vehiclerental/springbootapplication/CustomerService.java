package com.vehiclerental.springbootapplication;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CustomerService {

    //initialisation de la liste des Customers
    static List <Customer> customers = List.of(new Customer(0, "Leïla", "Popelier", LocalDate.of(2016,06,28),"A1B2C3D78"),
            new Customer(1, "Raphaël", "Makaryan", LocalDate.of(2004, 02,10), "A1B2C3D79"));

    //méthode pour fournir la liste des Customers
    public List<Customer> getCustomers() { return customers; }

    //méthode pour fournir la liste d'un Customer selon son id
    public Customer getCustomer(int id) {
        for (int i = 0; i < customers.size() ; i++ ) {
            if (customers.get(i).getId() == id) {
                customers.get(i).setId(0);
            }
        }
        return null;
    }

    //méthode pour ajouter un Customer
    public void addingCustomer(Customer customer) {
        customers.add(customer);
    }

    //méthode pour modifier un Customer
    public Customer toModifyCustomer(int id, Customer updatedCustomer) {
        for (int i = 0; i < customers.size() ; i++ ) {
            Customer existingCustomer = customers.get(i);

            if (existingCustomer.getId() == id) {
                existingCustomer.setId(existingCustomer.getId());
                existingCustomer.setFirstName(existingCustomer.getFirstName());
                existingCustomer.setLastName(existingCustomer.getLastName());
                existingCustomer.setDateOfBirth(existingCustomer.getDateOfBirth());
                existingCustomer.setDrivingLicense(existingCustomer.getDrivingLicense());

                return existingCustomer;
            }
        }
        throw new RuntimeException("Client with ID " + id + " not found.");
    }

    //méthode pour supprimer un Customer
    public void deleteCustomer(Customer customer) {
        customers.remove(customer);
    }
}

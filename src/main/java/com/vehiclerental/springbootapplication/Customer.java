package com.vehiclerental.springbootapplication;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customer {

    /////////////////////ATTRIBUTS/////////////////////
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected int id;
    protected String firstName;
    protected String lastName;
    protected LocalDate dateOfBirth;
    protected String drivingLicense;



    /////////////////////CONSTRUCTEUR/////////////////////
    public Customer(int id, String firstName, String lastName, LocalDate dateOfBirth, String drivingLicense) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.drivingLicense = drivingLicense;
    }

    public Customer() {
    }



    /////////////////////GETTER/////////////////////
    public int getId() { return id;}
    public String getFirstName() { return firstName;}
    public String getLastName() { return lastName; }
    public LocalDate getDateOfBirth() { return dateOfBirth; }
    public String getDrivingLicense() { return drivingLicense; }

    /////////////////////SETTER/////////////////////
    public void setId(int id) { this.id = id;}
    public void setFirstName(String firstName) { this.firstName = firstName;}
    public void setLastName(String lastName) { this.lastName = lastName;}
    public void setDateOfBirth(LocalDate dateOfBirth) { this.dateOfBirth = dateOfBirth; }
    public void setDrivingLicense(String drivingLicense) { this.drivingLicense = drivingLicense;}
}

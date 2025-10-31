package com.vehiclerental.springbootapplication;

import java.time.LocalDate;
import java.util.Date;

public class Customer {
    /////////////////////ATTRIBUTS/////////////////////
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

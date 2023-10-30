package com.example.lab03;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class BuddyInfo {
    private String name;
    private String phoneNumber;

    @Id
    private Long id;

    public BuddyInfo(Long id, String name, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;

    }

    public BuddyInfo(){
    }
    public String getPhoneNumber() {
        return this.phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Id: "+ this.id +"Name: " + this.name + ", Phone Number: " + this.phoneNumber ;
    }
}

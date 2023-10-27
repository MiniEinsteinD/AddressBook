package com.example.lab03;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class AddressBook {

    @OneToMany(cascade = CascadeType.ALL)
    private List<BuddyInfo> buddyList;

    @Id
    private String owner;

    public AddressBook() {
        this.buddyList = new ArrayList<>();
    }
    public AddressBook(String owner) {
        this.owner = owner;
        this.buddyList = new ArrayList<>();
    }
    public String getOwner() {
        return this.owner;
    }
    public void setOwner(String owner) {
        this.owner = owner;
    }
    public void addBuddy(BuddyInfo buddy) {
        buddyList.add(buddy);
    }
    public void removeBuddy(BuddyInfo buddy) {
        buddyList.remove(buddy);
    }

    public List<BuddyInfo> getBuddyList() {
        return buddyList;
    }
    public void setBuddyList(List<BuddyInfo> buddyList) {
        this.buddyList = buddyList;
    }
    @Override
    public String toString() {
        /*
        StringBuilder s = new StringBuilder();
        s.append("Owner: ").append(owner).append("\n");
        for (BuddyInfo buddyInfo : buddyList) {
            s.append(buddyInfo).append("\n");
        }
         */
        return "Owner: " + this.owner ;
    }
}

package com.packt.cardatabase.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Owner {
    //fields for Owner table
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ownerid;
    private String firstname, lastname;

    // One to many link with Car table
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private List<Car> cars;

    public Owner() {
    }

    public Owner(String firstname, String lastname) {
        super();
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public long getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(long ownerid) {
        this.ownerid = ownerid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname() {
        this.lastname = lastname;
    }
}

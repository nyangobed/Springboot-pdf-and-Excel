package com.pos.demo.Entities;

import org.springframework.scheduling.support.SimpleTriggerContext;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="firstname",nullable = false)
    @NotEmpty
    private  String firstname;
    @Column(name="lastname",nullable = false)
    @NotEmpty
    private String lastname;
    @Column(name="username", nullable = false)
    @NotEmpty
    private String username;
    @Column(name="password",nullable = false)
    @NotNull
    private String password;
    /*..................constructor with and without parameters........................*/
    public Admin(){}

    public Admin(@NotEmpty String lastname, @NotEmpty String username, @NotNull String password) {
        this.lastname = lastname;
        this.username = username;
        this.password = password;
    }

    /*..................getters and setters.......................*/

    public String getFirstname() {
        return firstname;
    }

    public Admin setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public Admin setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public Admin setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Admin setPassword(String password) {
        this.password = password;
        return this;
    }
    /*..................to string........................*/

    @Override
    public String toString() {
        return "Admin{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

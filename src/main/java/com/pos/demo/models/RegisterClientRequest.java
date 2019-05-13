package com.pos.demo.models;


import java.util.Date;

public class RegisterClientRequest {
    private long id;
    private String username;
    private String email;
    private String password;
    private String Firstname;
    private String Lastname;
    private String phone;
    private Date CreatedOn;

public  RegisterClientRequest()
{}

    public RegisterClientRequest(long id, String username, String email, String password, String firstname, String lastname, String phone, Date createdOn) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        Firstname = firstname;
        Lastname = lastname;
        this.phone = phone;
        CreatedOn = createdOn;
    }


    public long getId() {
        return id;
    }

    public RegisterClientRequest setId(long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public RegisterClientRequest setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public RegisterClientRequest setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public RegisterClientRequest setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getFirstname() {
        return Firstname;
    }

    public RegisterClientRequest setFirstname(String firstname) {
        Firstname = firstname;
        return this;
    }

    public String getLastname() {
        return Lastname;
    }

    public RegisterClientRequest setLastname(String lastname) {
        Lastname = lastname;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public RegisterClientRequest setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public Date getCreatedOn() {
        return CreatedOn;
    }

    public RegisterClientRequest setCreatedOn(Date createdOn) {
        CreatedOn = createdOn;
        return this;
    }


}

package com.pos.demo.Entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
@Table(name="client")
public class client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="username")
    @NotEmpty
    private String username;
    @NotEmpty
    @Column(name="email")
    private String email;
    @NotEmpty
    @Column(name="password")
    private String password;
    @NotEmpty
    @Column(name="Firstname")
    private String Firstname;
    @NotEmpty
    @Column(name="Lastname")
    private String Lastname;
    @NotEmpty
    @Column(name="phone")
    private String phone;
    @NotEmpty
    @Column(name="CreatedOn")
    private Date CreatedOn;

    public client() {

    }
           /*................constructor with parameters..................*/
    public client(@NotEmpty String username, @NotEmpty String email, @NotEmpty String password, @NotEmpty String firstname, @NotEmpty String lastname, @NotEmpty String phone, @NotEmpty Date createdOn) {
        this.username = username;
        this.email = email;
        this.password = password;
        Firstname = firstname;
        Lastname = lastname;
        this.phone = phone;
        CreatedOn = createdOn;
    }
        /*.............setters and getters..........................*/

    public String getUsername() {
        return username;
    }

    public client setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public client setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public client setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getFirstname() {
        return Firstname;
    }

    public client setFirstname(String firstname) {
        Firstname = firstname;
        return this;
    }

    public String getLastname() {
        return Lastname;
    }

    public client setLastname(String lastname) {
        Lastname = lastname;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public client setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public Date getCreatedOn() {
        return CreatedOn;
    }

    public client setCreatedOn(Date createdOn) {
        CreatedOn = createdOn;
        return this;
    }
   /*................................to string........................*/

    @Override
    public String toString() {
        return "client{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", Firstname='" + Firstname + '\'' +
                ", Lastname='" + Lastname + '\'' +
                ", phone='" + phone + '\'' +
                ", CreatedOn=" + CreatedOn +
                '}';
    }
}

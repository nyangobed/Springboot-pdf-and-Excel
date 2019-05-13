package com.pos.demo.Entities;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="customers")
public class customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Pattern(regexp="^0-9}*",message = "please enter the name correct format")// validate name to take only  string
    @Column(name="name" , nullable = false)
    @NotEmpty
    private String name;

    @Column(name="code",nullable = false)
    @NotEmpty
    private String code;

    @NotEmpty
    @Column(name="region", nullable = false)
    private String region;

    @NotNull
//    @Pattern(regexp = "([a-zA-Z])",message="Enter only numbers")
    @Column(name="phone",nullable = false)
    private int  phone;
    @NotEmpty
    @Column(name="company",nullable = false)
    private String company;
    @NotEmpty

    @Email(message="Please provide a valid email address")
    @Pattern(regexp = "^([^ @])+@([^ \\.@]+\\.)+([^ \\.@])+$", message="Please provide a valid email address")
    @Column(name="email",nullable = false)
    private String email;
    @NotEmpty
    @Column(name="contactPerson",nullable = false)
    private String contactPerson;

    @Column(name="fileName")
    private String fileName;
    /*.................constructors with and without parameters...........................*/
       public customer(){

}


    public customer(@NotEmpty String name, @NotEmpty String code, @NotEmpty String region, @NotNull int phone, @NotEmpty String company, @NotEmpty String email, @NotEmpty String contactPerson, String fileName) {
        this.name = name;
        this.code = code;
        this.region = region;
        this.phone = phone;
        this.company = company;
        this.email = email;
        this.contactPerson = contactPerson;
        this.fileName = fileName;
    }




    /*.................getters and setters...........................*/
    public long getId() {
        return id;
    }

    public customer setId(long id) {
        this.id = id;
        return this;
    }


    public String getFileName() {
        return fileName;
    }

    public customer setFileName(String fileName) {
        this.fileName = fileName;
        return this;
    }

    public String getName() {
        return name;
    }

    public customer setName(String name) {
        this.name = name;
        return this;
    }

    public String getCode() {
        return code;
    }

    public customer setCode(String code) {
        this.code = code;
        return this;
    }

    public String getRegion() {
        return region;
    }

    public customer setRegion(String region) {
        this.region = region;
        return this;
    }

    public int getPhone() {
        return phone;
    }

    public customer setPhone(int phone) {
        this.phone = phone;
        return this;
    }

    public String getCompany() {
        return company;
    }

    public customer setCompany(String company) {
        this.company = company;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public customer setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public customer setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
        return this;
    }
    /*.................TO STRING METHOD...........................*/


    @Override
    public String toString() {
        return "customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", region='" + region + '\'' +
                ", phone=" + phone +
                ", company='" + company + '\'' +
                ", email='" + email + '\'' +
                ", contactPerson='" + contactPerson + '\'' +
                ", fileName='" + fileName + '\'' +
                '}';
    }
}

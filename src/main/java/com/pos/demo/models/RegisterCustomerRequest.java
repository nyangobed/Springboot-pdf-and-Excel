package com.pos.demo.models;

import com.pos.demo.Entities.customer;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

public class RegisterCustomerRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="name")
    @NotNull
    private String name;

    @Column(name="code" )
    @NotNull
    private String code;

    @NotNull
    @Column(name="region")
    private String region;
    @NotNull
    @Column(name="phone")
    private int  phone;
    @NotNull
    @Column(name="company")
    private String company;
    @NotNull
    @Column(name="email")
    private String email;
    @NotNull
    @Column(name="contactPerson")
    private String contactPerson;
    /*.................constructors with and without parameters...........................*/
    public RegisterCustomerRequest(){

    }

    public RegisterCustomerRequest(@NotNull String code, @NotNull String region, @NotNull int phone, @NotNull String company, @NotNull String email, @NotNull String contactPerson) {
        this.code = code;
        this.region = region;
        this.phone = phone;
        this.company = company;
        this.email = email;
        this.contactPerson = contactPerson;

    }
    /*.................getters and setters...........................*/

    public String getName() {
        return name;
    }

    public RegisterCustomerRequest setName(String name) {
        this.name = name;
        return this;
    }

    public String getCode() {
        return code;
    }

    public RegisterCustomerRequest setCode(String code) {
        this.code = code;
        return this;
    }

    public String getRegion() {
        return region;
    }

    public RegisterCustomerRequest setRegion(String region) {
        this.region = region;
        return this;
    }

    public int getPhone() {
        return phone;
    }

    public RegisterCustomerRequest setPhone(int phone) {
        this.phone = phone;
        return this;
    }

    public String getCompany() {
        return company;
    }

    public RegisterCustomerRequest setCompany(String company) {
        this.company = company;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public RegisterCustomerRequest setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public RegisterCustomerRequest setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
        return this;
    }
    /*.................TO STRING METHOD...........................*/


    @Override
    public String toString() {
        return "customer{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", region='" + region + '\'' +
                ", phone=" + phone +
                ", company='" + company + '\'' +
                ", email='" + email + '\'' +
                ", contactPerson='" + contactPerson + '\'' +
                '}';
    }
}

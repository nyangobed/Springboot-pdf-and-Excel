package com.pos.demo.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;


@Entity
public class RegisterTerminalRequest {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String manufacturer;
    private String make;
    private String owner;
    private String partnumber;
    private String serialnumber;
    private Date CreatedOn;
public  RegisterTerminalRequest(){

}
    public RegisterTerminalRequest(String manufacturer, String make, String owner, String partnumber, String serialnumber, Date createdOn) {
        this.manufacturer = manufacturer;
        this.make = make;
        this.owner = owner;
        this.partnumber = partnumber;
        this.serialnumber = serialnumber;
        CreatedOn = createdOn;
    }

    public Long getId() {
        return id;
    }

    public RegisterTerminalRequest setId(Long id) {
        this.id = id;
        return this;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public RegisterTerminalRequest setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
        return this;
    }

    public String getMake() {
        return make;
    }

    public RegisterTerminalRequest setMake(String make) {
        this.make = make;
        return this;
    }

    public String getOwner() {
        return owner;
    }

    public RegisterTerminalRequest setOwner(String owner) {
        this.owner = owner;
        return this;
    }

    public String getPartnumber() {
        return partnumber;
    }

    public RegisterTerminalRequest setPartnumber(String partnumber) {
        this.partnumber = partnumber;
        return this;
    }

    public String getSerialnumber() {
        return serialnumber;
    }

    public RegisterTerminalRequest setSerialnumber(String serialnumber) {
        this.serialnumber = serialnumber;
        return this;
    }

    public Date getCreatedOn() {
        return CreatedOn;
    }

    public RegisterTerminalRequest setCreatedOn(Date createdOn) {
        CreatedOn = createdOn;
        return this;
    }

    @Override
    public String toString() {
        return "RegisterTerminalRequest{" +
                "id=" + id +
                ", manufacturer='" + manufacturer + '\'' +
                ", make='" + make + '\'' +
                ", owner='" + owner + '\'' +
                ", partnumber='" + partnumber + '\'' +
                ", serialnumber='" + serialnumber + '\'' +
                ", CreatedOn=" + CreatedOn +
                '}';
    }
}

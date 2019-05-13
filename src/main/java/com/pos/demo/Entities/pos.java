package com.pos.demo.Entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
@Entity
@Table(name="pos")
public class pos {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @NotNull
    @Size(max = 12,min=12)
    private String manufacturer;
    private String make;
    private String owner;
    private String partnumber;
    private String serialnumber;
    private Date CreatedOn;
 public  pos(){

 }
    /*.................constructors with and without parameters...........................*/
    public pos(String manufacturer, String make, String owner, String partnumber, String serialnumber, Date createdOn) {
        this.manufacturer = manufacturer;
        this.make = make;
        this.owner = owner;
        this.partnumber = partnumber;
        this.serialnumber = serialnumber;
        CreatedOn = createdOn;
    }
    /*.................setters and getters...........................*/
    public long getId() {
        return id;
    }

    public pos setId(long id) {
        this.id = id;
        return this;
    }
    public String getManufacturer() {
        return manufacturer;
    }

    public pos setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
        return this;
    }

    public String getMake() {
        return make;
    }

    public pos setMake(String make) {
        this.make = make;
        return this;
    }

    public String getOwner() {
        return owner;
    }

    public pos setOwner(String owner) {
        this.owner = owner;
        return this;
    }

    public String getPartnumber() {
        return partnumber;
    }

    public pos setPartnumber(String partnumber) {
        this.partnumber = partnumber;
        return this;
    }

    public String getSerialnumber() {
        return serialnumber;
    }

    public pos setSerialnumber(String serialnumber) {
        this.serialnumber = serialnumber;
        return this;
    }

    public Date getCreatedOn() {
        return CreatedOn;
    }

    public pos setCreatedOn(Date createdOn) {
        CreatedOn = createdOn;
        return this;
    }
    /*.................to string...........................*/

    @Override
    public String toString() {
        return "pos{" +
                "manufacturer='" + manufacturer + '\'' +
                ", make='" + make + '\'' +
                ", owner='" + owner + '\'' +
                ", partnumber='" + partnumber + '\'' +
                ", serialnumber='" + serialnumber + '\'' +
                ", CreatedOn=" + CreatedOn +
                '}';
    }
}

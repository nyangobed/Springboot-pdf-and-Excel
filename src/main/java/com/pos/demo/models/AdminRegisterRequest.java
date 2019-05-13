package com.pos.demo.models;

public class AdminRegisterRequest {
    private long id;
    private String Firstname;
    private String lastname;
    private String username;
    private String password;

    /*............. constructors..............*/
    public AdminRegisterRequest(){

    }

    public AdminRegisterRequest(String firstname, String lastname, String username, String password) {
        Firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
    }
    /*............. getters and setters..............*/

    public String getFirstname() {
        return Firstname;
    }

    public AdminRegisterRequest setFirstname(String firstname) {
        Firstname = firstname;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public AdminRegisterRequest setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public AdminRegisterRequest setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public AdminRegisterRequest setPassword(String password) {
        this.password = password;
        return this;
    }
    /*............. to string..............*/

    @Override
    public String toString() {
        return "AdminRegisterRequest{" +
                "Firstname='" + Firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

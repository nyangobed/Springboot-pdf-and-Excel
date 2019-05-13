package com.pos.demo.models;

public class AdminLoginRequest {
    private String username;
    private String password;
    /*.................constructors....................*/
    public AdminLoginRequest(){ }

    public AdminLoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }
    /*..................getters and setters...............*/

    public String getUsername() {
        return username;
    }

    public AdminLoginRequest setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public AdminLoginRequest setPassword(String password) {
        this.password = password;
        return this;
    }
    /*..............to string.............................*/

    @Override
    public String toString() {
        return "AdminLoginRequest{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

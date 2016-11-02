package com.kainos.training.login.service.model;


import java.util.HashSet;
import java.util.Set;

public class User  {

    private String userName;
    private String password;


    public User() {}

    public User(String username, String password) {
        this();
        setPassword(password);
        setUserName(username);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof User) {
            User user = (User) obj;
            if (this.getUserName().toLowerCase().equals(user.getUserName().toLowerCase()) && this.getPassword().equals(user.getPassword())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return userName + ","+ password;
    }
}

package edu.traning.web.entity;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private String role;
    private int id;
    private String token;

    public User() {

    }

    public User(int id) {
        this.id = id;
    }

    public User(String token) {
        this.token = token;
    }

    public User(String name, String role, int id, String token) {
        this.name = name;
        this.role = role;
        this.id = id;
        this.token = token;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(name, user.name) && Objects.equals(role, user.role) && Objects.equals(token, user.token);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, role, id, token);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", id=" + id +
                ", token='" + token + '\'' +
                '}';
    }

}
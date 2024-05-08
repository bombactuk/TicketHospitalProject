package edu.traning.web.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class UserRegistrationInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String login;
    private String password;
    private String name;
    private LocalDate birthday;
    private String country;
    private String role;
    private String token;

    public UserRegistrationInfo() {

    }

    public UserRegistrationInfo(String login, String password,
                                String name, LocalDate birthday, String country, String role) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.birthday = birthday;
        this.country = country;
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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
        UserRegistrationInfo that = (UserRegistrationInfo) o;
        return Objects.equals(login, that.login) && Objects.equals(password, that.password) && Objects.equals(name, that.name) && Objects.equals(birthday, that.birthday) && Objects.equals(country, that.country) && Objects.equals(role, that.role) && Objects.equals(token, that.token);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password, name, birthday, country, role, token);
    }

    @Override
    public String toString() {
        return "UserRegistrationInfo{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", country='" + country + '\'' +
                ", role='" + role + '\'' +
                ", token='" + token + '\'' +
                '}';
    }

}

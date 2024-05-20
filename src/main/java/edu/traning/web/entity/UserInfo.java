package edu.traning.web.entity;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class UserInfo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String name;
    private String login;
    private LocalDate birthday;
    private String country;

    public UserInfo() {

    }

    public UserInfo(String name, String login, LocalDate birthday, String country) {
        this.name = name;
        this.login = login;
        this.birthday = birthday;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserInfo userInfo = (UserInfo) o;
        return Objects.equals(name, userInfo.name) && Objects.equals(login, userInfo.login) && Objects.equals(birthday, userInfo.birthday) && Objects.equals(country, userInfo.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, login, birthday, country);
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", birthday=" + birthday +
                ", country='" + country + '\'' +
                '}';
    }

}

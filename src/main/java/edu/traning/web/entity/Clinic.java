package edu.traning.web.entity;

import java.io.Serializable;
import java.util.Objects;

public class Clinic implements Serializable {

    private static final long serialVersionUID = 1L;

    private int idClinic;
    private String name;
    private String country;
    private String city;
    private String address;
    private String registrationNumber;
    private String generalInformation;
    private String structure;
    private String schedule;

    public Clinic(){

    }

    public Clinic(String name, String country, String city, String address){
        this.name = name;
        this.country = country;
        this.city = city;
        this.address = address;
    }

    public Clinic(int idClinic, String name, String country, String city, String address){
        this(name, country, city, address);
        this.idClinic = idClinic;
    }

    public Clinic(int idClinic, String name, String country, String city, String address, String registrationNumber,
                  String generalInformation, String structure, String schedule){
        this(idClinic, name, country, city, address);
        this.registrationNumber = registrationNumber;
        this.generalInformation = generalInformation;
        this.structure = structure;
        this.schedule = schedule;
    }

    public int getIdClinic() {
        return idClinic;
    }

    public void setIdClinic(int idClinic) {
        this.idClinic = idClinic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getGeneralInformation() {
        return generalInformation;
    }

    public void setGeneralInformation(String generalInformation) {
        this.generalInformation = generalInformation;
    }

    public String getStructure() {
        return structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clinic clinic = (Clinic) o;
        return idClinic == clinic.idClinic && Objects.equals(name, clinic.name) && Objects.equals(country, clinic.country) && Objects.equals(city, clinic.city) && Objects.equals(address, clinic.address) && Objects.equals(registrationNumber, clinic.registrationNumber) && Objects.equals(generalInformation, clinic.generalInformation) && Objects.equals(structure, clinic.structure) && Objects.equals(schedule, clinic.schedule);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idClinic, name, country, city, address, registrationNumber, generalInformation, structure, schedule);
    }

    @Override
    public String toString() {
        return "Clinic{" +
                "idClinic=" + idClinic +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", generalInformation='" + generalInformation + '\'' +
                ", structure='" + structure + '\'' +
                ", schedule='" + schedule + '\'' +
                '}';
    }

}

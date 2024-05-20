package edu.traning.web.entity;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class Doctor implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private int idDoctor;
    private int idClinic;
    private String fio;
    private String profession;
    private String description;
    private String jobName;

    public Doctor() {
    }

    public Doctor(int idClinic, String fio, String profession, String description) {

        this.idClinic = idClinic;
        this.fio = fio;
        this.profession = profession;
        this.description = description;

    }

    public Doctor(int idDoctor, int idClinic, String fio, String profession, String description) {

        this(idClinic, fio, profession, description);
        this.idDoctor = idDoctor;

    }

    public Doctor(int idDoctor, int idClinic, String fio, String profession, String description, String jobName) {

        this(idDoctor, idClinic, fio, profession, description);
        this.jobName = jobName;

    }

    public Doctor(int idDoctor) {
        this.idDoctor = idDoctor;
    }

    public int getIdClinic() {
        return idClinic;
    }

    public void setIdClinic(int idClinic) {
        this.idClinic = idClinic;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(int idDoctor) {
        this.idDoctor = idDoctor;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return idDoctor == doctor.idDoctor && idClinic == doctor.idClinic && Objects.equals(fio, doctor.fio) && Objects.equals(profession, doctor.profession) && Objects.equals(description, doctor.description) && Objects.equals(jobName, doctor.jobName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDoctor, idClinic, fio, profession, description, jobName);
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "idDoctor=" + idDoctor +
                ", idClinic=" + idClinic +
                ", fio='" + fio + '\'' +
                ", profession='" + profession + '\'' +
                ", description='" + description + '\'' +
                ", jobName='" + jobName + '\'' +
                '}';
    }

}

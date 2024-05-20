package edu.traning.web.entity;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class ContactsCommunications implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private int id;
    private String img;
    private String link;

    public ContactsCommunications() {

    }

    public ContactsCommunications(String img, String link) {
        this.img = img;
        this.link = link;
    }

    public ContactsCommunications(int id, String img, String link) {
        this(img, link);
        this.id = id;
    }

    public ContactsCommunications(int id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactsCommunications that = (ContactsCommunications) o;
        return id == that.id && Objects.equals(img, that.img) && Objects.equals(link, that.link);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, img, link);
    }

    @Override
    public String toString() {
        return "ContactsCommunications{" +
                "id=" + id +
                ", img='" + img + '\'' +
                ", link='" + link + '\'' +
                '}';
    }

}

package edu.traning.web.entity;

import java.io.Serializable;
import java.util.Objects;

public class ContactsCommunications implements Serializable {

    private static final long serialVersionUID = 1L;

    private String img;
    private String link;

    public ContactsCommunications() {

    }

    public ContactsCommunications(String img, String link) {
        this.img = img;
        this.link = link;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactsCommunications that = (ContactsCommunications) o;
        return Objects.equals(img, that.img) && Objects.equals(link, that.link);
    }

    @Override
    public int hashCode() {
        return Objects.hash(img, link);
    }

    @Override
    public String toString() {
        return "ContactsCommunications{" +
                "img='" + img + '\'' +
                ", link='" + link + '\'' +
                '}';
    }

}

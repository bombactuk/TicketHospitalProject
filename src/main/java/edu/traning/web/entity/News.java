package edu.traning.web.entity;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class News implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private int id;
    private String title;
    private String brief;
    private String img;
    private String link;

    public News() {
    }

    public News(String title, String brief, String img, String link) {
        this.title = title;
        this.brief = brief;
        this.img = img;
        this.link = link;
    }

    public News(int id, String title, String brief, String img, String link) {
        this(title, brief, img, link);
        this.id = id;
    }

    public News(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
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
        News news = (News) o;
        return id == news.id && Objects.equals(title, news.title) && Objects.equals(brief, news.brief) && Objects.equals(img, news.img) && Objects.equals(link, news.link);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, brief, img, link);
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", brief='" + brief + '\'' +
                ", img='" + img + '\'' +
                ", link='" + link + '\'' +
                '}';
    }

}

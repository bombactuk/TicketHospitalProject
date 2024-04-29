package edu.traning.web.entity;

import java.io.Serializable;
import java.util.Objects;

public class News implements Serializable {

    private static final long serialVersionUID = 1L;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        News news = (News) o;
        return Objects.equals(title, news.title) && Objects.equals(brief, news.brief) && Objects.equals(img, news.img) && Objects.equals(link, news.link);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, brief, img, link);
    }

    @Override
    public String toString() {
        return "News{" +
                "title='" + title + '\'' +
                ", brief='" + brief + '\'' +
                ", img='" + img + '\'' +
                ", link='" + link + '\'' +
                '}';
    }

}

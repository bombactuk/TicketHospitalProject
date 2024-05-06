package edu.traning.web.entity;

import java.io.Serializable;
import java.util.Objects;

public class AboutInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String title;
    private String text;

    public AboutInfo() {

    }

    public AboutInfo(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AboutInfo aboutInfo = (AboutInfo) o;
        return Objects.equals(title, aboutInfo.title) && Objects.equals(text, aboutInfo.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, text);
    }

    @Override
    public String toString() {
        return "AboutInfo{" +
                "title='" + title + '\'' +
                ", text='" + text + '\'' +
                '}';
    }

}

package com.ssn.prototype.servicelink.entity;

import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import java.util.Objects;

public class Link {

    @Id
    public String id;

    @NotNull
    public String longLink;

    @NotNull
    public String shortLink;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLongLink() {
        return longLink;
    }

    public void setLongLink(String longLink) {
        this.longLink = longLink;
    }

    public String getShortLink() {
        return shortLink;
    }

    public void setShortLink(String shortLink) {
        this.shortLink = shortLink;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Link link = (Link) o;
        return Objects.equals(longLink, link.longLink) &&
                Objects.equals(shortLink, link.shortLink);
    }

    @Override
    public int hashCode() {

        return Objects.hash(longLink, shortLink);
    }
}

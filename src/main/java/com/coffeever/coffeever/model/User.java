package com.coffeever.coffeever.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user1")
public class User {

    @Id
    private String google_id;

    @Column
    private String name;

    @Column
    private String mail;

    @Column
    private String favorites;

    public void addFavorites(String favorites) {
        String newEntry = favorites + ", ";
        this.favorites += newEntry;
    }

    public void deleteFavorite(String slug){
        String toBeDeleted = slug + ", ";
        this.favorites = this.favorites.replace(toBeDeleted, "");
    }

    public User(String google_id, String favorites) {
        this.google_id = google_id;
        this.favorites = favorites;
    }

    public String getGoogle_id() {
        return google_id;
    }

    public void setGoogle_id(String google_id) {
        this.google_id = google_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getFavorites() {
        return favorites;
    }

    public void setFavorites(String favorites) {
        this.favorites = favorites;
    }
}

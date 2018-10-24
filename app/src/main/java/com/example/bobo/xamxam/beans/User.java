package com.example.bobo.xamxam.beans;


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.io.Serializable;

@Entity
public class User implements Serializable {

    @PrimaryKey
    @NonNull
    private int idUser;

    private String username;

    private String password;


    private boolean active;

    private String lienPhoto;


    @NonNull
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(@NonNull int idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }


    public String getLienPhoto() {
        return lienPhoto;
    }

    public void setLienPhoto(String lienPhoto) {
        this.lienPhoto = lienPhoto;
    }

    public User(@NonNull int idUser, String username, String password, boolean active) {
        this.idUser = idUser;
        this.username = username;
        this.password = password;
        this.active = active;
    }

    public User() {
    }
}
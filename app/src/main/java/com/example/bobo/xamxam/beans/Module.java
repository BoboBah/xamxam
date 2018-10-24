package com.example.bobo.xamxam.beans;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class Module {



    @PrimaryKey
    @NonNull
    private int idModule;

    private String nomModule;


    private String lienPhoto;





    public int getIdModule() {
        return idModule;
    }

    public void setIdModule(int idModule) {
        this.idModule = idModule;
    }

    public String getNomModule() {
        return nomModule;
    }

    public void setNomModule(String nomModule) {
        this.nomModule = nomModule;
    }



    public Module() {
    }


    public String getLienPhoto() {
        return lienPhoto;
    }

    public void setLienPhoto(String lienPhoto) {
        this.lienPhoto = lienPhoto;
    }

    public Module(@NonNull int idModule, String nomModule, String lienPhoto) {
        this.idModule = idModule;
        this.nomModule = nomModule;
        this.lienPhoto = lienPhoto;
    }

    @Override
    public String toString() {
        return getNomModule();
    }
}
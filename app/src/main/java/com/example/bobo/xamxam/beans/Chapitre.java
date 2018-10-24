package com.example.bobo.xamxam.beans;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(foreignKeys = @ForeignKey(entity = Module.class, parentColumns = "idModule" , childColumns = "idModule"))
public class Chapitre {

    @PrimaryKey
    @NonNull
    private int idChapitre;

    private String titre;

    private String video;

    private String lien;



    private int idModule;


    public int getIdChapitre() {
        return idChapitre;
    }

    public void setIdChapitre(int idChapitre) {
        this.idChapitre = idChapitre;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public int getIdModule() {
        return idModule;
    }

    public void setIdModule(int idModule) {
        this.idModule = idModule;
    }


    public String getLien() {
        return lien;
    }

    public void setLien(String lien) {
        this.lien = lien;
    }



    public Chapitre(@NonNull int idChapitre, String titre, String video, String lien, int idModule) {
        this.idChapitre = idChapitre;
        this.titre = titre;
        this.video = video;
        this.lien = lien;
        this.idModule = idModule;
    }

    public Chapitre() {
    }
}

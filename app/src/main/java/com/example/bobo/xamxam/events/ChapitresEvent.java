package com.example.bobo.xamxam.events;

import com.example.bobo.xamxam.beans.Chapitre;

import java.util.List;

public class ChapitresEvent {
    private List<Chapitre> chapitres;

    public List<Chapitre> getChapitres() {
        return chapitres;
    }

    public void setChapitres(List<Chapitre> chapitres) {
        this.chapitres = chapitres;
    }

    public ChapitresEvent(List<Chapitre> chapitres) {
        this.chapitres = chapitres;
    }
}

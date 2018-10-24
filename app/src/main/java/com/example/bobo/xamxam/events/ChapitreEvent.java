package com.example.bobo.xamxam.events;

import com.example.bobo.xamxam.beans.Chapitre;

public class ChapitreEvent {
    private Chapitre chapitre;


    public Chapitre getChapitre() {
        return chapitre;
    }

    public void setChapitre(Chapitre chapitre) {
        this.chapitre = chapitre;
    }

    public ChapitreEvent(Chapitre chapitre) {
        this.chapitre = chapitre;
    }
}

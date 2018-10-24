package com.example.bobo.xamxam.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.bobo.xamxam.beans.Chapitre;

import java.util.List;

@Dao
public interface ChapitreDao {


    @Insert
    void insert(Chapitre chapitre);


    @Query("select count(*) from Chapitre")
    int totalChapitres();

    @Query("select * from Chapitre")
    List<Chapitre> getAllChapitre();


    @Query("select * from Chapitre where idModule =:param")
    List<Chapitre> getAllChapitre(int param);



    @Query("select * from Chapitre where idChapitre =:param")
    Chapitre findById(int param);






}

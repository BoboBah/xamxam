package com.example.bobo.xamxam.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.bobo.xamxam.beans.Module;

import java.util.List;

@Dao
public interface ModuleDao {

    @Insert
    void insert(Module module);

    @Query("select count(*) from module")
    int totalModule();

    @Query("select * from module")
    List<Module> getAllModules();

    @Query("select * from module where  idModule =:param")
    Module findById(int param);


    @Query("select * from module where nomModule =:param")
    Module findByNomModule(String param);

}

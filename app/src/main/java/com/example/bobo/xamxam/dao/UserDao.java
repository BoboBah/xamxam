package com.example.bobo.xamxam.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;

import com.example.bobo.xamxam.beans.User;

@Dao
public interface UserDao {

    @Insert
    void insert(User user);
}
package com.example.bobo.xamxam.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.bobo.xamxam.beans.Question;

import java.util.List;

@Dao
public interface QuestionDao {

    @Insert
    void insert(Question question);


    @Query("select count(*) from question")
    int totalQuestion();


    @Query("select * from question")
    List<Question> getAllQuestion();

    @Query("select * from question where idModule =:idModule")
    List<Question> getAllQuestion(int idModule);

    @Query("select * from question where id=:param")
    Question getOne(int param);


    @Query("delete from question")
    void deleteAll();




    @Delete
    void delete(Question question);




}
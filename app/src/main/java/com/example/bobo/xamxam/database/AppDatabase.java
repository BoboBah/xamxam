package com.example.bobo.xamxam.database;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.bobo.xamxam.beans.Chapitre;
import com.example.bobo.xamxam.beans.Module;
import com.example.bobo.xamxam.beans.Question;
import com.example.bobo.xamxam.beans.User;
import com.example.bobo.xamxam.dao.ChapitreDao;
import com.example.bobo.xamxam.dao.ModuleDao;
import com.example.bobo.xamxam.dao.QuestionDao;

@Database(entities = {Module.class, Chapitre.class, Question.class, User.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase instance;

    public abstract ModuleDao moduleDao();

    public abstract ChapitreDao chapitreDao();

    public abstract QuestionDao questionDao();

    public static AppDatabase getInstance(final Context context)
    {
        if (instance == null) {
            synchronized (AppDatabase.class)
            {
                if (instance == null) {
                    instance = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "XamXam5"
                    ).fallbackToDestructiveMigration()
                           .allowMainThreadQueries()
                            .build();
                }
            }
        }

        return instance;
    }

    public static void destroyInstance()
    {
        instance = null;
    }
}

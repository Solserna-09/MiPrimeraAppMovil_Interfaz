package com.josesantosdev.miprimerapp.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.josesantosdev.miprimerapp.User;

@Database

        (entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}

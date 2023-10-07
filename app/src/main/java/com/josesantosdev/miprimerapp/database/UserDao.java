package com.josesantosdev.miprimerapp.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.josesantosdev.miprimerapp.User;
@Dao
public interface UserDao {

    @Insert
    void insert(User user);

    @Query("SELECT * FROM user WHERE  user_name = :userName")
    User getUserByUserName(String userName);

    @Query("SELECT * FROM user WHERE  document_number = :identification")
    User getUserByUserIdentification(String identification);

}

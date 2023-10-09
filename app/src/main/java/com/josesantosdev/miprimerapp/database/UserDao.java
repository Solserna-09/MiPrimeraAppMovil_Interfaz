package com.josesantosdev.miprimerapp.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.josesantosdev.miprimerapp.User;

import java.util.List;

@Dao
public interface UserDao {

    @Insert
    void insert(User user);

    @Query("SELECT * FROM user WHERE  user_name = :userName")
    User getUserByUserName(String userName);

    @Query("SELECT * FROM user WHERE  document_number = :identification")
    User getUserByUserIdentification(String identification);

    @Query("SELECT * FROM user")
    List<User> getAllUsers();

    @Query("SELECT * FROM user WHERE document_number LIKE '%' || :documentNumber || '%'")
    List<User> getUserForDocumentNumber(String documentNumber);

    @Query("DELETE FROM user WHERE document_number = :documentNumber")
    void deleteUserByDocument(String documentNumber);

    @Query("UPDATE user SET names=:name, email =:email WHERE document_number = :documentNumber")
    void updateUser(String name, String email, String documentNumber);

}

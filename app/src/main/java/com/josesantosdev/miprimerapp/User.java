package com.josesantosdev.miprimerapp;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

@Entity
public class User {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    public int id;
    @ColumnInfo(name = "names")
    public String names;
    @ColumnInfo(name = "last_names")
    public String lastNames;
    @ColumnInfo(name = "email")
    public String email;
    @ColumnInfo(name = "user_name")

    public String userName;
    @ColumnInfo(name = "password")

    public String password;
    @ColumnInfo(name = "document_number")
    public String documentNumber;


    public User(String names, String lastNames, String email, String userName, String password, String documentNumber) {
        this.names = names;
        this.lastNames = lastNames;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.documentNumber = documentNumber;
    }
}

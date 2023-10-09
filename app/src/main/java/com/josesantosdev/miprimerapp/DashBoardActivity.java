package com.josesantosdev.miprimerapp;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.josesantosdev.miprimerapp.database.AppDatabase;

import java.util.List;

public class DashBoardActivity extends AppCompatActivity implements OnItemClickListener{

    TextView textViewName;
    SearchView searchView;
    RecyclerView recyclerView;
    UsersAdapter adapter;
    AppDatabase database;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        String username = getIntent().getStringExtra("userName");
        database = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "first-database").allowMainThreadQueries().build();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewUsers);
        textViewName = (TextView) findViewById(R.id.textViewUserNameDashBoard);
        searchView = (SearchView) findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                if(!s.isEmpty()) {
                    List<User> usersFiltered = database.userDao().getUserForDocumentNumber(s);
                    adapter.updateUsers(usersFiltered);
                } else {
                    List<User> allUsers = database.userDao().getAllUsers();
                    adapter.updateUsers(allUsers);
                }
                return false;
            }
        });
        textViewName.setText(username);
        loadUser();
    }

    public void loadUser() {
        List<User> users = database.userDao().getAllUsers();
        adapter = new UsersAdapter(users, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(OperationType operationType, User user) {
        switch (operationType) {
            case EDIT:
                Dialog dialog = new Dialog(DashBoardActivity.this);

                dialog.setContentView(R.layout.dialog);
                dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                dialog.setCancelable(false);

                EditText tvName = dialog.findViewById(R.id.txtName);
                EditText tvEmail = dialog.findViewById(R.id.txtEmail);
                Button btnConfirm = dialog.findViewById(R.id.btnConfirm);
                Button btnCancel = dialog.findViewById(R.id.btnCancel);

                btnConfirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(!tvName.getText().toString().isEmpty() && !tvEmail.getText().toString().isEmpty()) {
                            database.userDao().updateUser(
                                    tvName.getText().toString(),
                                    tvEmail.getText().toString(),
                                    user.documentNumber
                            );
                            List<User> usersUpdated = database.userDao().getAllUsers();
                            adapter.updateUsers(usersUpdated);
                            dialog.dismiss();
                        } else {
                            Toast.makeText(DashBoardActivity.this, "Los campos son oblogatorios", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                btnCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
                break;
            case DELETE:
                database.userDao().deleteUserByDocument(user.documentNumber);
                adapter.removeUser(user);
                break;
        }
    }
}

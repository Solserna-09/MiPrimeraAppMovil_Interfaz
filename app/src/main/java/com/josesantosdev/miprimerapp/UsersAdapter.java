package com.josesantosdev.miprimerapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.MyViewHolder> {
    private List<User> users;
    private OnItemClickListener listener;

    public UsersAdapter(List<User> users, OnItemClickListener listener) {
        this.users = users;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_users_adapter, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        User user = users.get(position);
        holder.bind(user);
    }

    public void removeUser(User user) {
        users.remove(user);
        notifyDataSetChanged();
    }

    public void updateUsers(List<User> users) {
        this.users.clear();
        this.users.addAll(users);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textViewContent;
        ImageView imgEdit, imgDelete;

        public MyViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            textViewContent = (TextView) view.findViewById(R.id.textViewContent);
            imgEdit = (ImageView) view.findViewById(R.id.imageViewEdit);
            imgDelete = (ImageView) view.findViewById(R.id.imageViewDelete);
        }

        public void bind(User user) {
            textViewContent.setText(user.names + "\n" + user.documentNumber +"\n" +user.email);

            imgEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(OperationType.EDIT, user);
                }
            });

            imgDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(OperationType.DELETE, user);
                }
            });
        }

    }
}

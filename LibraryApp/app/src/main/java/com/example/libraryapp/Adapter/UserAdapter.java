package com.example.libraryapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.libraryapp.Model.User;
import com.example.libraryapp.R;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    ArrayList<User> users;
    Context context;
    int layoutid;

    public UserAdapter(ArrayList<User> users, Context context, int layoutid) {
        this.users = users;
        this.context = context;
        this.layoutid = layoutid;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(layoutid,parent,false);
        return new UserHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        UserHolder userHolder = (UserHolder) holder;
        User user = users.get(position);
        userHolder.useravt.setImageResource(context.getResources().getIdentifier(user.getAvatar(),"drawable"
        ,context.getPackageName()));
        userHolder.username.setText(user.getUsername());
        userHolder.userrole.setText(user.getRole());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class UserHolder extends RecyclerView.ViewHolder
    {
        ImageView useravt;
        TextView userrole,username;
        CheckBox checkBox;
        Button detailbtn;
        public UserHolder(@NonNull View itemView) {
            super(itemView);
            useravt = itemView.findViewById(R.id.account_item_avatar);
            userrole = itemView.findViewById(R.id.account_item_role);
            username = itemView.findViewById(R.id.account_item_username);
            checkBox = itemView.findViewById(R.id.account_item_chkbox);
            detailbtn = itemView.findViewById(R.id.account_item_detailbtn);
        }
    }
}

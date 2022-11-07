package com.example.levanhieu_2050531200143;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    Context context;
    ArrayList<User1> list;

    public MyAdapter(Context context, ArrayList<User1> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.userentry,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        User1 user1 = list.get(position);
        holder.name.setText(user1.getName());
        holder.email.setText(user1.getEmail());
        holder.age.setText(user1.getAge());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name,email,age;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name  = itemView.findViewById(R.id.textName);
            email  = itemView.findViewById(R.id.textemail);
            age  = itemView.findViewById(R.id.textage);
        }
    }
}

package com.example.mark_4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    ArrayList<ToDoList> myList = new ArrayList<ToDoList>();
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.custom_recycle, parent, false);
        return new MyViewHolder(view);
    }
    public void addText(ArrayList<ToDoList> list){
        myList.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.onBind(myList.get(position));


    }

    @Override
    public int getItemCount() {
        return myList.size();
    }
    public void addItem(ToDoList toDoList){
        myList.add(toDoList);
        notifyDataSetChanged();

    }
}

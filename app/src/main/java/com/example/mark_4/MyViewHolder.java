package com.example.mark_4;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {
    TextView textView_1;
    TextView textView_2;
    TextView textView_3;
    TextView textView_4;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        textView_1 = itemView.findViewById(R.id.title_1);
        textView_2 = itemView.findViewById(R.id.description);
        textView_3 = itemView.findViewById(R.id.num);
        textView_4 = itemView.findViewById(R.id.date);
    }

    public void onBind(ToDoList myList) {
        textView_1.setText(myList.title);
        textView_2.setText(myList.description);
        textView_3.setText("" + (1 + getAdapterPosition()));
        textView_4.setText(myList.date);

    }
}

package com.example.mark_4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    MyAdapter adapter;
    ArrayList<ToDoList> list;
    RecyclerView recyclerView;
    EditText editText_1;
    EditText editText_2;
    Button button_1;
    boolean notEmpty = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText_1 = findViewById(R.id.edit_txt_1);
        editText_2 = findViewById(R.id.edit_txt_2);
        button_1 = findViewById(R.id.btn_1);
        recyclerView = findViewById(R.id.rec_view);
        adapter = new MyAdapter();

        recyclerView.setAdapter(adapter);


        RecyclerView.LayoutManager manager = new LinearLayoutManager(this,
                RecyclerView.VERTICAL, false);

        recyclerView.setLayoutManager(manager);

        list = new ArrayList<>();

        editText_1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {



            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.toString().isEmpty()){
                    notEmpty = false;
                } else {
                    notEmpty = true;
                    button_1.setEnabled(true);
                }

            }
        });
        button_1.setOnClickListener(view -> {
            String edit_1 = null;
            String edit_2 = null;
            if (editText_1 != null && editText_2 != null){
                edit_1 = editText_1.getText().toString();
                edit_2 = editText_2.getText().toString();
            }

            long currentInMillis = System.currentTimeMillis();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String format = simpleDateFormat.format(currentInMillis);

            if (!edit_1.equals("") && !edit_2.equals("")){
                adapter.addItem(new ToDoList(edit_1, edit_2, format));
            }

        });


    }

}
package com.example.webapiintegrationb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv;
    ImageView add;
    MyAdapter adapter;
    List<MyContact> ls;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv=findViewById(R.id.rv);
        add=findViewById(R.id.add);
        RecyclerView.LayoutManager lm=new LinearLayoutManager(MainActivity.this);
        ls=new ArrayList<>();
        adapter=new MyAdapter(MainActivity.this,ls);
        rv.setAdapter(adapter);
        rv.setLayoutManager(lm);

        ls.add(new MyContact("sdvfd","dvd","dsvfv"));
        ls.add(new MyContact("sdvfd","dvd","dsvfv"));
        ls.add(new MyContact("sdvfd","dvd","dsvfv"));
        ls.add(new MyContact("sdvfd","dvd","dsvfv"));
        ls.add(new MyContact("sdvfd","dvd","dsvfv"));
        ls.add(new MyContact("sdvfd","dvd","dsvfv"));


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Add.class));
            }
        });
    }
}
package com.example.ex14;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton c1 = (ImageButton) findViewById(R.id.c1);
        ImageButton d1 = (ImageButton) findViewById(R.id.cplus1);
        ImageButton e1 = (ImageButton) findViewById(R.id.j1);
        ImageButton f1 = (ImageButton) findViewById(R.id.p1);
        ImageButton g1 = (ImageButton) findViewById(R.id.html1);
        ImageButton h1 = (ImageButton) findViewById(R.id.css1);
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Cactivity.class);
                startActivity(intent);
            }
        });
        e1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Javact.class);
                startActivity(intent);
            }
        });
    }
}

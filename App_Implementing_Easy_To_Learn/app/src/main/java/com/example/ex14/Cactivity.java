package com.example.ex14;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Cactivity extends AppCompatActivity {
    String s1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cactivity);
        Button b1=findViewById(R.id.button2);
        Button b2=findViewById(R.id.button6);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1="cintro.pdf";
                Intent intent =new Intent(Cactivity.this,PdfactActivity.class);
                intent.putExtra("c1",s1);
                startActivity(intent);
            }
        });
    }
}

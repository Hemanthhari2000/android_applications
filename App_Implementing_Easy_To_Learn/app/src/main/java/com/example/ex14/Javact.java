package com.example.ex14;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Javact extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_javaact);
        Button b2=findViewById(R.id.button2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s2="javaintro.pdf";
                Intent intent =new Intent(Javact.this,PdfactActivity.class);
                intent.putExtra("c1",s2);
                startActivity(intent);
            }
        });
    }
}

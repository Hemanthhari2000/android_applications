package com.example.ex8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    EditText e1;
    Button write, read, clear;
    TextView tv;
    String filename = "";
    String filepath = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1 = findViewById(R.id.editText);
        write = findViewById(R.id.write);
        read = findViewById(R.id.read);
        clear = findViewById(R.id.clear);
        tv = findViewById(R.id.tv);

        filename = "myFile.txt";
        filepath = "myFileDir";

        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Log.d("Success", "All set");
                String data = e1.getText().toString();
                try{
                    String rootPath = getExternalFilesDir(null).getAbsolutePath() + filepath;
                    System.out.println(rootPath);
                    File f = new File(rootPath + filename);
                    f.createNewFile();
                    FileOutputStream fout = new FileOutputStream(f);
                    fout.write(data.getBytes());
                    fout.close();


                    Toast.makeText(getBaseContext(), "Data Written onto SDCARD", Toast.LENGTH_LONG).show();

                    e1.setText("");
                }catch (Exception e){
                    Toast.makeText(getBaseContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        });

        read.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String data;
                String buf = "";
                try {
                    String rootPath = getExternalFilesDir(null).getAbsolutePath() + filepath;
                    File f = new File(rootPath + filename);
                    FileInputStream fin = new FileInputStream(f);
                    BufferedReader br = new BufferedReader(new InputStreamReader(fin));
                    while((data = br.readLine()) != null){
                        buf += data;
                    }
                    tv.setText("");
                    tv.setText(buf);
                    br.close();
                    fin.close();

                    Toast.makeText(getBaseContext(), "Data Received from SDCARD", Toast.LENGTH_LONG).show();

                }catch (Exception e){
                    Toast.makeText(getBaseContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e1.setText("");
            }
        });

    }
}
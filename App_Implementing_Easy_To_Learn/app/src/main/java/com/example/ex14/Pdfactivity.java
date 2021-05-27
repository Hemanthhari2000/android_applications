package com.example.ex14;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class PdfactActivity extends AppCompatActivity {
    PDFView pdfView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pdfactivity);
        pdfView=(PDFView) findViewById(R.id.pdfView);
        Intent in=getIntent();
        String pdf=in.getStringExtra("c1");
        pdfView.fromAsset(pdf.toString()).load();
    }
}

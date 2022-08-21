package com.example.trainonintentandactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityB extends AppCompatActivity {
    TextView text_view1 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        // inflate
        text_view1 = findViewById(R.id.textView);
        Intent intent = getIntent();
        text_view1.setText(intent.getStringExtra("text1"));

    }
}
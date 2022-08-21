package com.example.trainonintentandactivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;






public class MainActivity extends AppCompatActivity {
    // declaration
    Button triangle_btn , rectangle_btn;
    TextView area_result_tv;

    // macros
    // determine which activity you came from to the main activity
    private static final int REQUEST_CODE_TRIANGLE = 1;
    private static final int REQUEST_CODE_RECTANGLE = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // inflate
        triangle_btn  = findViewById(R.id.tr_bt_id);
        rectangle_btn = findViewById(R.id.rec_bt_id);
        area_result_tv= findViewById(R.id.area_tv_id);

        triangle_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             //   Toast.makeText(getBaseContext(), "triangle", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getBaseContext(), TriangleActivity.class);
                startActivityForResult(intent, REQUEST_CODE_TRIANGLE); // used when you back from the target activity
            }
        });

        rectangle_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            //    Toast.makeText(getBaseContext(), "rectangle", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getBaseContext(), RectangleActivity.class);
            startActivityForResult(intent, REQUEST_CODE_RECTANGLE); // used when you back from the target activity
            }
        });


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getBaseContext(), "on destroy", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        String old_text = area_result_tv.getText().toString();
        area_result_tv.setText(old_text+"\n");

        // returned from triangle activity
        if(requestCode == REQUEST_CODE_TRIANGLE){

            // check for the result code that set on the triangle activity
            if(resultCode == TriangleActivity.RESULT_CODE_CASE_1){
                area_result_tv.setText("Triangle Area: " + data.getDoubleExtra("area", 0));
            }else if(resultCode == TriangleActivity.RESULT_CODE_CASE_2){
                area_result_tv.setText("base: "+data.getIntExtra("base", 0)+"\t\theight: "+data.getIntExtra("height", 0));
            }
        }
        // returned from rectangle activity
        else if(requestCode == REQUEST_CODE_RECTANGLE){
            // check for the result code that set on the rectangle activity
            if(resultCode == RectangleActivity.RESULT_CODE_CASE_1){
                area_result_tv.setText("Rectangle Area: "+data.getIntExtra("area", 0));
            }else if(resultCode == RectangleActivity.RESULT_CODE_CASE_2){
                area_result_tv.setText("width: "+data.getIntExtra("width", 0) + " \t\t|\t\t height: "+data.getIntExtra("height", 0));
            }
        }

    }
}


















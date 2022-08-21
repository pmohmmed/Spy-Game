package com.example.trainonintentandactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TriangleActivity extends AppCompatActivity {
    // declaration
    EditText base_edt_text, height_edt_text;
    Button calculate_btn;

    // macros
    // define some cases to work with
    public static final int RESULT_CODE_CASE_1 = 1; // positive area
    public static final int RESULT_CODE_CASE_2 = 2; // negative area


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangle);

        // inflate
        base_edt_text   = findViewById(R.id.base_edt_id);
        height_edt_text = findViewById(R.id.height_edt_id);
        calculate_btn   = findViewById(R.id.calc_btn_id);


        calculate_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!base_edt_text.getText().toString().equals("") && !height_edt_text.getText().toString().equals("") ) {

                    double area = 0.5 * Integer.parseInt(base_edt_text.getText().toString()) * Integer.parseInt(height_edt_text.getText().toString());
                    Intent data = new Intent();

                    // store data on the intent
                    data.putExtra("base"  , Integer.parseInt(base_edt_text.getText().toString()));
                    data.putExtra("height", Integer.parseInt(height_edt_text.getText().toString()));
                    data.putExtra("area"  , area);

                    if(area>0){
                        setResult(RESULT_CODE_CASE_1, data);

                    }
                    else
                        setResult(RESULT_CODE_CASE_2, data);

                    finish();
                }
            }
        });

    }
}














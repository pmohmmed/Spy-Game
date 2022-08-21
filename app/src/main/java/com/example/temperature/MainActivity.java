package com.example.temperature;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.util.Log;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button calcButton = (Button)findViewById(R.id.button);


    }



    public void disable(View  v){
        EditText ed1 = (EditText) findViewById(R.id.num1);
        EditText ed2 = (EditText) findViewById(R.id.num2);
        TextView tv  = (TextView) findViewById(R.id.result);

        if(!ed1.getText().toString().equals("") && !ed2.getText().toString().equals("") ){
            int num1= Integer.parseInt(ed1.getText().toString());
            int num2= Integer.parseInt(ed2.getText().toString());

            tv.setText(String.valueOf(num1 + num2));
            ed1.getText().clear();
            ed2.getText().clear();
            Log.d("testing", "done");
        }
        else
        {
            Toast.makeText(getBaseContext(), "please complete all fields", Toast.LENGTH_LONG).show();
        }



    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getBaseContext(), "on start", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getBaseContext(), "on Restart", Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        Toast.makeText(getBaseContext(), "on save", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Toast.makeText(getBaseContext(), "on Restore", Toast.LENGTH_LONG).show();

    }
}
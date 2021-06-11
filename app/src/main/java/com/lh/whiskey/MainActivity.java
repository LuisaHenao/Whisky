package com.lh.whiskey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageButton btnWhisky;
    private ImageButton btnDestileria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnWhisky = findViewById(R.id.btnWhisky);
        btnDestileria = findViewById(R.id.btnDestileria);

        btnWhisky.setOnClickListener(this);
        btnDestileria.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnWhisky){
            Intent Myintent = new Intent(this, list_whisky.class );
            startActivity(Myintent);
        }

        if (v.getId() == R.id.btnDestileria){
            Intent Myintent = new Intent(this, list_destileria.class );
            startActivity(Myintent);
        }
    }
}
package com.example.explicitintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SubActivityOne extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_one);
        Button btnQuayxe = findViewById(R.id.btnQuay);
        btnQuayxe.setOnClickListener(MHinh);
    }
        View.OnClickListener MHinh = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent MH1 = new Intent(SubActivityOne.this,MainActivity.class);
                startActivity(MH1);
            }
        };

}
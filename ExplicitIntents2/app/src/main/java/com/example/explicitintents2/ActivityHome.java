package com.example.explicitintents2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ActivityHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
       TextView tvUsername = findViewById(R.id.edtName);

        //Lấy dữ liệu từ Intent
        String username = getIntent().getStringExtra("username");

        //Gán vào TextView
        tvUsername.setText("Chào mừng: " + username);
    }
}
package com.example.explicitintents2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        EditText edtDangnhap = findViewById(R.id.edtDN);
        EditText edtMatkhau= findViewById(R.id.edtMK);
        EditText edtEmail = findViewById(R.id.edtEmail);

        Button btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtDangnhap.getText().toString().isEmpty()) {
                    Toast.makeText(ActivityLogin.this, "Vui lòng nhập tên đăng nhập", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(edtMatkhau.getText().toString().isEmpty()) {
                    Toast.makeText(ActivityLogin.this, "Vui lòng nhập mật khẩu", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(edtEmail.getText().toString().isEmpty()) {
                    Toast.makeText(ActivityLogin.this, "Vui lòng nhập email", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Chuyển sang ActivityHome
                startActivity(new Intent(ActivityLogin.this, ActivityHome.class));
                String username = edtDangnhap.getText().toString();
                Intent intent = new Intent(ActivityLogin.this, ActivityHome.class);
                intent.putExtra("username", username);
                startActivity(intent);
            }
        });
    }

}
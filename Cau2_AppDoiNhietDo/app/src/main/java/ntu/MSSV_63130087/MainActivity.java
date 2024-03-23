package ntu.MSSV_63130087;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText edtF,edtC;
    Button btnF,btnC,btnClear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Tim id
        edtC = findViewById(R.id.edt_C);
        edtF = findViewById(R.id.edt_F);
        btnC = findViewById(R.id.btn_C);
        btnF = findViewById(R.id.btn_F);
        btnClear = findViewById(R.id.btn_Clear);
        //xu ly Click
        //Tu F sang C
        btnF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Chuyen kieu dlieu tu String sang int
                int C = Integer.parseInt(edtC.getText().toString());
                Double F = C * 1.8 + 32;
                edtF.setText(F+"");
            }
        });
        //Tu C sang F
        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int F = Integer.parseInt(edtF.getText().toString());
                Double C = (F-32)/1.8;
                edtC.setText(C+"");
            }
        });
        //btn Clear
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtC.setText("");
                edtF.setText("");
            }
        });
    }
}
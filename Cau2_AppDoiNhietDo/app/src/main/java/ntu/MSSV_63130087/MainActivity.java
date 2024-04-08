package ntu.MSSV_63130087;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
        //Chuyen Doi Tu C sang F
        btnF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Ktra dieu kien
                String Cm = edtC.getText().toString();
                if (Cm.isEmpty()) {//Neu bo trong thi xuat ra thong bao
                    Toast.makeText(MainActivity.this, "Vui lòng nhập giá trị C", Toast.LENGTH_SHORT).show();
                    return;
                }
                //Chuyen kieu dlieu tu String sang int
                int C = Integer.parseInt(edtC.getText().toString());
                Double F = C * 1.8 + 32;
                edtF.setText(F+"");//xóa giá trị của F để hiện thị kết quả mới
            }
        });
        //Chuyen Doi Tu F sang C
        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Ktra dieu kien
                String Fm = edtF.getText().toString();
                if (Fm.isEmpty()) {//Neu bo trong thi xuat ra thong bao
                    Toast.makeText(MainActivity.this, "Vui lòng nhập giá trị F", Toast.LENGTH_SHORT).show();
                    return;
                }
                //Chuyen kieu dlieu tu String sang int
                int F = Integer.parseInt(edtF.getText().toString());
                Double C = (F-32)/1.8;
                edtC.setText(C+"");
            }
        });
        //btn Clear
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Truyền dữ liệu vào chỗ nhập một chuỗi rỗng để xóa bỏ giá trị hiện tại
                edtC.setText("");
                edtF.setText("");
            }
        });
    }
}
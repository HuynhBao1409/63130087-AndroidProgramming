package GBao.cong;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //gan layout
        setContentView(R.layout.activity_main);
    }

    //xu ly su kien onclick nut tinh cong
    public void  XuLyCong(View view){
    //Tim tham chieu den control
        EditText editTextSoA = findViewById(R.id.edtA);//strA = 3
        EditText editTextSoB = findViewById(R.id.edtB);//StrB = 5
        EditText editTextKQ = findViewById(R.id.edtKQ);
        //Lay du lieu o cac so
        String strA= editTextSoA.getText().toString();
        String strB= editTextSoB.getText().toString();
        //Chuyen du lieu sang dang so
        int so_A = Integer.parseInt(strA);
        int so_B = Integer.parseInt(strB);
        //Tinh
           int tong=so_A+so_B;
           String strTong= String.valueOf(tong); //Chuyen sang dang chuoi
        //Xuat
        editTextKQ.setText(strTong);
    }
}
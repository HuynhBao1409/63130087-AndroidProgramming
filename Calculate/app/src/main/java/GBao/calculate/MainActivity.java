package GBao.calculate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editTextSo1;
    EditText editTextSo2;
    EditText editTextKQ;
    Button nutCong,nutTru,nutNhan,nutChia;
    void TimDK(){
        editTextSo1= (EditText)findViewById(R.id.edtSo1);
        editTextSo2= (EditText)findViewById(R.id.edtSo2);
        editTextKQ = (EditText)findViewById(R.id.edtKQ);
        nutCong = (Button) findViewById(R.id.btnCong);
        nutTru = (Button) findViewById(R.id.btnTru);
        nutNhan = (Button) findViewById(R.id.btnNhan);
        nutChia = (Button) findViewById(R.id.btnChia);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TimDK();
    }

    public void XuLyCong(View v){
    //Tim du lieu
        //Lay du lieu
        String so1= editTextSo1.getText().toString();
        String so2= editTextSo2.getText().toString();
        //Chuyen chuoi sang so
        float soA= Float.parseFloat(so1);
        float soB= Float.parseFloat(so2);
        //Tinh
        float tong= soA+soB;
        //Xuat
        String chuoiKQ = String.valueOf(tong);
        editTextKQ.setText(chuoiKQ);
    }
    public void XuLyTru(View v){
    String so1= editTextSo1.getText().toString();
    String so2= editTextSo2.getText().toString();
    float soA= Float.parseFloat(so1);
    float soB=Float.parseFloat(so2);
    float hieu=soA-soB;
    String chuoiKQ= String.valueOf(hieu);
    editTextKQ.setText(chuoiKQ);
    }
    public void XuLyNhan(View v){
        String so1= editTextSo1.getText().toString();
        String so2= editTextSo2.getText().toString();
        float soA= Float.parseFloat(so1);
        float soB=Float.parseFloat(so2);
        float tich=soA*soB;
        String chuoiKQ= String.valueOf(tich);
        editTextKQ.setText(chuoiKQ);
    }
    public void XuLyChia(View v){
        String so1= editTextSo1.getText().toString();
        String so2= editTextSo2.getText().toString();
        float soA= Float.parseFloat(so1);
        float soB=Float.parseFloat(so2);
        float thuong=soA/soB;
        String chuoiKQ= String.valueOf(thuong);
        editTextKQ.setText(chuoiKQ);
    }
}
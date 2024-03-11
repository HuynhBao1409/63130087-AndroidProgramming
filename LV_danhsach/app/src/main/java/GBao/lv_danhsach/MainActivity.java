package GBao.lv_danhsach;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //khai bao
    ArrayList<String> dsTen;
    ArrayAdapter<String> adapterThanh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Hien thi list view

        dsTen = new ArrayList<String>();
        //them du lieu
        dsTen.add("Hà Nội");
        dsTen.add("Thành phố HCM");
        dsTen.add("Nha Trang");
        dsTen.add("Đồng Nai");
        adapterThanh = new ArrayAdapter<>(this, android.R.layout
                    .simple_list_item_1 , dsTen);
        //tim va gan du lieu
        ListView lvTenTinhThanh  = findViewById(R.id.lvDS);
        lvTenTinhThanh.setAdapter(adapterThanh);
        lvTenTinhThanh.setOnItemClickListener(BoLangNghe);
    }
    AdapterView.OnItemClickListener BoLangNghe = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            //Code hien gia tri duoc chon
            String strTenTinh= dsTen.get(i);
            Toast.makeText(MainActivity.this, strTenTinh, Toast.LENGTH_LONG).show();
        }
    };
    public void ThemPhanTu (View v){
        //Lay du lieu tu dieu khien
        EditText edtTenMoi = (EditText)findViewById(R.id.edtNhap);
        String tenNhap = edtTenMoi.getText().toString();
        //Them vao ds ten
        dsTen.add(tenNhap);
        adapterThanh.notifyDataSetChanged();
    }
}
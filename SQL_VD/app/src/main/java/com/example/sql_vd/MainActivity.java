package com.example.sql_vd;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Tạo hoặc mở CSDL
        db = openOrCreateDatabase("MyBook.db", MODE_PRIVATE, null);

        // Câu lệnh tạo bảng
        String sqltaobangneudaco = "DROP TABLE IF EXISTS BOOKS;";
        String sqltaobang = "CREATE TABLE BOOKS(BookID integer PRIMARY KEY,"
                + "BookName text,"
                + "Page integer,"
                + "Price Float,"
                + "Description text);";
        // Thực hiện lệnh SQL
        db.execSQL(sqltaobangneudaco);
        db.execSQL(sqltaobang);

        // Thêm một số dòng dữ liệu vào bảng
        String sqlThem1 = "INSERT INTO Books VALUES(1, 'Java', 100, 9.99, 'sách về java');";
        String sqlThem2 = "INSERT INTO Books VALUES(2, 'Android', 320, 19.00, 'Android cơ bản');";
        String sqlThem3 = "INSERT INTO Books VALUES(3, 'Học làm giàu', 120, 0.99, 'sách đọc cho vui');";
        String sqlThem4 = "INSERT INTO Books VALUES(4, 'Tử điển Anh-Việt', 1000, 29.50, 'Từ điển 100.000 từ');";
        String sqlThem5 = "INSERT INTO Books VALUES(5, 'CNXH', 1, 1, 'chuyện cổ tích');";
        db.execSQL(sqlThem1);
        db.execSQL(sqlThem2);
        db.execSQL(sqlThem3);
        db.execSQL(sqlThem4);
        db.execSQL(sqlThem5);

        // Đóng CSDL
        db.close();

        // Truy vấn SELECT
        // B1. Mở CSDL
        db = openOrCreateDatabase("MyBook.db", MODE_PRIVATE, null);

        // B2. Thực thi câu lệnh select
        String sqlSelect = "SELECT * FROM Books;";
        Cursor cs = db.rawQuery(sqlSelect, null);

// B3: Đổ vào biến nào đó để xử lý
        ArrayList<Book> dsSach = new ArrayList<>();
        while (cs.moveToNext()) {
            int idSach = cs.getInt(0);
            String tenSach = cs.getString(1);
            int soTrang = cs.getInt(2);
            float gia = cs.getFloat(3);
            String mota = cs.getString(4);
            Book b = new Book(idSach, tenSach, soTrang, gia, mota);
            dsSach.add(b);
        }

// Đóng CSDL
        db.close();

        // B4, Hiển thị lên ListView
        ArrayList<String> dsThongTinSach = new ArrayList<>();
        for (Book book : dsSach) {
            String thongTinSach = "ID sách: " + book.getBookID()
                    + "\nTên sách: " + book.getBookName()
                    + "\nSố trang: " + book.getPage()
                    + "\nGiá sách: " + book.getPrice()
                    + "\nMô tả sách: " + book.getDescription();
            dsThongTinSach.add(thongTinSach);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dsThongTinSach);
        ListView listViewBooks = findViewById(R.id.listViewBooks);
        listViewBooks.setAdapter(adapter);
    }
}
package baithi.bao63130087;

import static android.content.Context.MODE_PRIVATE;
import static android.database.sqlite.SQLiteDatabase.openOrCreateDatabase;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class Cau4Fragment extends Fragment {


    public Cau4Fragment() {
        // Required empty public constructor
    }



    public static Cau4Fragment newInstance(String param1, String param2) {
        Cau4Fragment fragment = new Cau4Fragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Bước 0. Tạo file cơ sở dữ liệu
//        SQLiteDatabase db = getActivity().openOrCreateDatabase("QLSach.db", // tên file = tên DB
//                                                    MODE_PRIVATE,  // giới hạn truy cập
//                                                     null          // con trỏ bản ghi
//                                                 );
//        // B1. Tạo bảng
//          // câu lêệnh tạo bảng
//        String sqlXoaBangNeuDaCo="DROP TABLE IF EXISTS Books;";
//
//        String sqlTaoBang = "CREATE TABLE Books( BookID integer PRIMARY KEY, " +
//                                                "BookName text, " +
//                                                "Page integer, " +
//                                                "Price Float, " +
//                                                "Description text);";
//        // thực hiện lệnh sql
//        db.execSQL(sqlXoaBangNeuDaCo);
//        db.execSQL(sqlTaoBang);
//        // Thêm một số dòng dữ liệu vào bảng
//        String sqlThem1 = "INSERT INTO Books VALUES(1, 'Java', 100, 9.99, 'sách về java');";
//        String sqlThem2 = "INSERT INTO Books VALUES(2, 'Android', 320, 19.00, 'Android cơ bản');";
//        String sqlThem3 = "INSERT INTO Books VALUES(3, 'Học làm giàu', 120, 0.99, 'sách đọc cho vui');";
//        String sqlThem4 = "INSERT INTO Books VALUES(4, 'Tử điển Anh-Việt', 1000, 29.50, 'Từ điển 100.000 từ');";
//        String sqlThem5 = "INSERT INTO Books VALUES(5, 'CNXH', 1, 1, 'chuyện cổ tích');";
//        db.execSQL(sqlThem1);
//        db.execSQL(sqlThem2);
//        db.execSQL(sqlThem3);
//        db.execSQL(sqlThem4);
//        db.execSQL(sqlThem5);
//
//        // Ta đóng lại để check
//        db.close();
        // B1. Mở CSDL
        SQLiteDatabase db = getActivity().openOrCreateDatabase("QLSach.db", MODE_PRIVATE, null);

        // B2. Thực thi câu lệnh select
        String sqlSelect = "SELECT * FROM Books;";
        Cursor cs = db.rawQuery(sqlSelect, null);
        cs.moveToFirst();//đưa bản ghi về hàng đầu tiên
        // B3: Đổ vào biến nào đó để xử lý
        ArrayList<Book> dsSach =new ArrayList<Book>();
        //Duyet qua lần lượt từng bản ghi
        while (cs.moveToNext())
        {
            //Lấy dữ liệu từng cột
        int idSach = cs.getInt(0);
        String tenSach= cs.getString( 1);
        int soTrang = cs.getInt(2);
        float gia = cs.getFloat(3);
        String mota = cs.getString(4);
        //Tạo một đối tượng sách và thêm vào danh sách
            Book b= new Book(idSach,tenSach, soTrang,gia, mota);
            dsSach.add(b);
        }
// Nháp
      // B4, Hiển thị lên ListView
        ArrayList<String> dsTenSach = new ArrayList<String>();
        for (Book book : dsSach) {
            String thongTinSach = "ID sách: " + book.getBookID()
                    + "\nTên sách: " + book.getBookName()
                    + "\nSố trang: " + book.getPage()
                    + "\nGiá sách: " + book.getPrice()
                    + "\nMô tả sách: " + book.getDescription();
            dsTenSach.add(thongTinSach);
        }

        //B5:Hiện thị danh sách
        // Inflate the layout for this fragment
        View viewCau4= inflater.inflate(R.layout.fragment_cau4, container, false);

        ArrayAdapter<String> adapterTenSach= new ArrayAdapter<String>(
                getContext(),
                android.R.layout.simple_list_item_1,
                dsTenSach);
        //Tìm điều khiển cho list
        ListView listView = viewCau4.findViewById(R.id.Lv_danhsach);
        listView.setAdapter(adapterTenSach);
        // Lắng nghe và xử lý
        return viewCau4;
    }
}

//        //B4, Hiển thị lên ListView
//                ArrayList<String> dsTenSach = new ArrayList<String>();
//        for(int i=0;i<dsSach.size();i++)
//            dsTenSach.add(dsSach.get(i).getBookName());
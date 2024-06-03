package thi.Bao63130087.Dethi2;

import static android.content.Context.MODE_PRIVATE;

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


public class SubjectsFragment extends Fragment {



    public SubjectsFragment() {
        // Required empty public constructor
    }


    public static SubjectsFragment newInstance(String param1, String param2) {
        SubjectsFragment fragment = new SubjectsFragment();
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
//        SQLiteDatabase db = getActivity().openOrCreateDatabase("Subject.db", MODE_PRIVATE,null);
//
//        String sqlTaoBang = "CREATE TABLE Subjects( IDMon integer PRIMARY KEY, " +
//                                               "MaMon integer, " +
//                                               "BookName text);";
//        db.execSQL(sqlTaoBang);
//        String sqlThem1 = "INSERT INTO Subjects VALUES(1, 133, 'Lich su Dang');";
//        String sqlThem2 = "INSERT INTO Subjects VALUES(2, 153, 'Ky thuat lap trinh');";
//        String sqlThem3 = "INSERT INTO Subjects VALUES(3, 236, 'Lap trinh Web');";
//        String sqlThem4 = "INSERT INTO Subjects VALUES(4, 398, 'Co so du lieu');";
//        String sqlThem5 = "INSERT INTO Subjects VALUES(5, 8, 'He dieu hanh');";
//        db.execSQL(sqlThem1);
//        db.execSQL(sqlThem2);
//        db.execSQL(sqlThem3);
//        db.execSQL(sqlThem4);
//        db.execSQL(sqlThem5);
//        db.close();

        SQLiteDatabase db = getActivity().openOrCreateDatabase("Subject.db", MODE_PRIVATE, null);
        String sqlSelect = "SELECT * FROM Subjects;";
        Cursor cs = db.rawQuery(sqlSelect, null);
        cs.moveToFirst();
        ArrayList<Subject> dsMon =new ArrayList<Subject>();
        while (cs.moveToNext())
        {
            //Lấy dữ liệu từng cột
            int IDMon = cs.getInt(0);
            String BookName= cs.getString( 1);
            int MaMon = cs.getInt(2);
            //Tạo một đối tượng sách và thêm vào danh sách
            Subject b= new Subject(IDMon,MaMon, BookName);
            dsMon.add(b);
        }

        ArrayList<String> dsTenMon= new ArrayList<String>();
        for (Subject book : dsMon) {
            String thongTinSach = "ID Mon: " + book.getIDMon()
                    + "\nMa Mon: " + book.getMaMon()
                    + "\nTên Mon: " + book.getBookName();
            dsTenMon.add(thongTinSach);
        }
        // Inflate the layout for this fragment
         View view= inflater.inflate(R.layout.fragment_subjects, container, false);
        ArrayAdapter<String> adapterTenMon= new ArrayAdapter<String>(
                getContext(),
                android.R.layout.simple_list_item_1,
                dsTenMon);
        //Tìm điều khiển cho list
        ListView listView = view.findViewById(R.id.Lv_danhsach);
        listView.setAdapter(adapterTenMon);
        return view;
    }
}
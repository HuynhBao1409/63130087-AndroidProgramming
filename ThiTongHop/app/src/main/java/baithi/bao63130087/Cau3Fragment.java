package baithi.bao63130087;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class Cau3Fragment extends Fragment {
    //1. Khai báo các biến
    LandScapeAdapter adapter;
    ArrayList<LandScape> list;
    RecyclerView recyclerViewLandScape;

    public Cau3Fragment() {
        // Required empty public constructor
    }

    public static Cau3Fragment newInstance(String param1, String param2) {
        Cau3Fragment fragment = new Cau3Fragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //3. Chuẩn bị dữ liệu cho list
        list = new ArrayList<LandScape>();
        list.add(new LandScape("test", "ic_banner"));
        list.add(new LandScape("test", "ic_banner"));
        list.add(new LandScape("test", "ic_banner"));
        list.add(new LandScape("test", "ic_banner"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cau3, container, false);
//4. Tìm điều khiển Recycler
        recyclerViewLandScape = view.findViewById(R.id.recylerViewDS);
        //5. Tạo layout manager để đặt bố cục cho Recycler
        RecyclerView.LayoutManager layoutLinear = new LinearLayoutManager(view.getContext());
        recyclerViewLandScape.setLayoutManager(layoutLinear);
        //6. Tạo adapter gắn vào nguồn dữ liệu
        adapter = new LandScapeAdapter(view.getContext(), list);
        //7, Gắn adapter vào Recycler
        recyclerViewLandScape.setAdapter(adapter);
        return view;
    }
}
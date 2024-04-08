package Bao.ntu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    LandAdapter landAdapter;
    ArrayList<LandScape> recyclerData;
    RecyclerView recyclerViewLandScape;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //3
        recyclerData = getDataForRecyclerView();
        //4
        recyclerViewLandScape = findViewById(R.id.recyclerLand);
        //5
        RecyclerView.LayoutManager layoutLiner = new LinearLayoutManager(this);
        recyclerViewLandScape.setLayoutManager(layoutLiner);
        //6
        landAdapter = new LandAdapter(this,recyclerData);
        //7
        recyclerViewLandScape.setAdapter(landAdapter);
    }
    ArrayList<LandScape> getDataForRecyclerView() {
        ArrayList<LandScape> dsDuLieu = new ArrayList<LandScape>();
        LandScape lS1 = new LandScape("1183450","Ảnh Fantatic");
        dsDuLieu.add(lS1);
        dsDuLieu.add(new LandScape("Anh 4k", "bla bla"));
        dsDuLieu.add(new LandScape("12345", "Fanta"));
    return dsDuLieu;
    }
}
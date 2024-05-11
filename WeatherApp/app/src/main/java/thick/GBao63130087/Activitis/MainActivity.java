package thick.GBao63130087.Activitis;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import thick.GBao63130087.Adapters.HourlyAdapter;
import thick.GBao63130087.Domains.Hourly;
import thick.GBao63130087.R;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapterHourly;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecyclerView();
    }

    private void initRecyclerView() {
        ArrayList<Hourly> items=new ArrayList<>();
        // thêm vào danh sách Hourly
        items.add(new Hourly("10 pm",28,"cloudy"));
        items.add(new Hourly("11 pm",29,"sun"));
        items.add(new Hourly("12 pm",30,"wind"));
        items.add(new Hourly("1 am",29,"sun"));
        items.add(new Hourly("2 am",27,"cloudy"));
        items.add(new Hourly("3 am",27,"cloudy"));
        items.add(new Hourly("4 am",27,"storm"));
        items.add(new Hourly("5 am",27,"rainy"));
        items.add(new Hourly("6 am",27,"rainy"));
        items.add(new Hourly("7 am",27,"cloudy"));

        recyclerView=findViewById(R.id.view1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        adapterHourly = new HourlyAdapter(items); // Tạo adapter và chuyển danh sách items vào
        recyclerView.setAdapter(adapterHourly); // Gán adapter cho RecyclerView

    }
}
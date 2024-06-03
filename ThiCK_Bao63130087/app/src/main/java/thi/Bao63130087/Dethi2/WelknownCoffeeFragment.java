package thi.Bao63130087.Dethi2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class WelknownCoffeeFragment extends Fragment {


    LandScapeAdapter adapter;
    ArrayList<LandScape> list;
    RecyclerView recyclerViewLandScape;
    public WelknownCoffeeFragment() {
        // Required empty public constructor
    }


    public static WelknownCoffeeFragment newInstance(String param1, String param2) {
        WelknownCoffeeFragment fragment = new WelknownCoffeeFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        list = new ArrayList<LandScape>();
        list.add(new LandScape("Cafe demo", "Address 1", "toothless"));
        list.add(new LandScape("Cafe Pho", "Address 2", "download"));
        list.add(new LandScape("Cafe House", "Address 3", "logocafe"));
        list.add(new LandScape("Cafe Vuon", "Address 3", "logocafe"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_welknown_coffee, container, false);
        recyclerViewLandScape = view.findViewById(R.id.recylerViewDS);

        RecyclerView.LayoutManager layoutLinear = new LinearLayoutManager(view.getContext());
        recyclerViewLandScape.setLayoutManager(layoutLinear);

        adapter = new LandScapeAdapter(view.getContext(), list);

        recyclerViewLandScape.setAdapter(adapter);
        return view;
    }
}
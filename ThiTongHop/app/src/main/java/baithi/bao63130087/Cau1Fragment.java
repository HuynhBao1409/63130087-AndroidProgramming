package baithi.bao63130087;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Cau1Fragment extends Fragment {
    //Khai báo
    EditText edt_Meter, edt_KM;
    Button btn_Doi;

    public Cau1Fragment() {
        // Required empty public constructor
    }

    public static Cau1Fragment newInstance(String param1, String param2) {
        Cau1Fragment fragment = new Cau1Fragment();
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
        // Inflate the layout for this fragment
        View viewCau1 = inflater.inflate(R.layout.fragment_cau1, container, false);
        // ánh xạ điều khiển view
        edt_Meter = viewCau1.findViewById(R.id.edt_Meter);
        edt_KM = viewCau1.findViewById(R.id.edt_KM);
        btn_Doi = viewCau1.findViewById(R.id.btn_Doi);

        //nút
        btn_Doi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertUnits();
            }
        });

        return viewCau1;
    }
    private void convertUnits() {
        String meterText = edt_Meter.getText().toString();
        String kmText = edt_KM.getText().toString();
        //m->km
        if (!meterText.isEmpty()) {
            double meter = Double.parseDouble(meterText);
            double km = meter / 1000;
            edt_KM.setText(String.valueOf(km));

            // km->m
        } else if (!kmText.isEmpty()) {
            double km = Double.parseDouble(kmText);
            double meter = km * 1000;
            edt_Meter.setText(String.valueOf(meter));

        } else {
            Toast.makeText(getContext(), "Nhập số liệu", Toast.LENGTH_SHORT).show();
        }
    }
}
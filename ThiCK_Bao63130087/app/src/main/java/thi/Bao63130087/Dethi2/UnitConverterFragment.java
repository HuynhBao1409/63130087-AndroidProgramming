package thi.Bao63130087.Dethi2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class UnitConverterFragment extends Fragment {

    EditText edt_Meter, edt_KM,edt_Kg,edt_g,edt_byte,edt_bit;
    Button btn_Doi;

    public UnitConverterFragment() {
        // Required empty public constructor
    }


    public static UnitConverterFragment newInstance(String param1, String param2) {
        UnitConverterFragment fragment = new UnitConverterFragment();
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
         View view= inflater.inflate(R.layout.fragment_unit_converter, container, false);
        edt_Meter = view.findViewById(R.id.edt_Meter);
        edt_KM = view.findViewById(R.id.edt_KM);
        btn_Doi = view.findViewById(R.id.btn_Doi);
        edt_Kg = view.findViewById(R.id.edt_Kg);
        edt_g = view.findViewById(R.id.edt_g);
        edt_byte = view.findViewById(R.id.edt_byte);
        edt_bit = view.findViewById(R.id.edt_bit);

        //nút
        btn_Doi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertUnits();
            }
        });

        return view;
    }
    private void convertUnits() {
        String meterText = edt_Meter.getText().toString();
        String kmText = edt_KM.getText().toString();
        String kgText = edt_Kg.getText().toString();
        String gText = edt_g.getText().toString();
        String byteText = edt_byte.getText().toString();
        String bitText = edt_bit.getText().toString();
        // Mét <-> Kilômét
        if (!meterText.isEmpty() && kmText.isEmpty()) {
            double meter = Double.parseDouble(meterText);
            double km = meter / 1000;
            edt_KM.setText(String.valueOf(km));
        } else if (meterText.isEmpty() && !kmText.isEmpty()) {
            double km = Double.parseDouble(kmText);
            double meter = km * 1000;
            edt_Meter.setText(String.valueOf(meter));
        }

        // Kilôgam <-> Gam
        if (!kgText.isEmpty() && gText.isEmpty()) {
            double kg = Double.parseDouble(kgText);
            double g = kg * 1000;
            edt_g.setText(String.valueOf(g));
        } else if (kgText.isEmpty() && !gText.isEmpty()) {
            double g = Double.parseDouble(gText);
            double kg = g / 1000;
            edt_Kg.setText(String.valueOf(kg));
        }

        // Byte <-> Bit
        if (!byteText.isEmpty() && bitText.isEmpty()) {
            double byteValue = Double.parseDouble(byteText);
            double bitValue = byteValue * 8;
            edt_bit.setText(String.valueOf(bitValue));
        } else if (byteText.isEmpty() && !bitText.isEmpty()) {
            double bitValue = Double.parseDouble(bitText);
            double byteValue = bitValue / 8;
            edt_byte.setText(String.valueOf(byteValue));
        }

    }
}
package com.example.fragments;

import static android.app.PendingIntent.getActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        return inflater.inflate(R.layout.fragment_2, container, false);
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//
//        DisplayMetrics display = this.getResources().getDisplayMetrics();
//        int width = display.widthPixels; int height = display.heightPixels;
//        if (width> height) {
//            Fragment1 fragment1 = new Fragment1();
//
//            fragmentTransaction.replace(android.R.id.content, fragment1);
//        }
//        else {
//            Fragment2 fragment2 = new Fragment2();
//            fragmentTransaction.replace(android.R.id.content, fragment2);
//        }
//        fragmentTransaction.commit();
        @Override
        public void onStart() {
            super.onStart();
            Button btnGetText = (Button) getActivity().findViewById(R.id.btnGetText); //---Button view---
            btnGetText.setOnClickListener(new View.OnClickListener() { //---Button click--
                public void onClick(View v) {

                    TextView lbl = (TextView) getActivity().findViewById(R.id.fragment1);
                    TextView statusarea = (TextView) getActivity().findViewById(R.id.lblStatus);
                    statusarea.setText("Fragment#1's text shows: " + lbl.getText());
                }
            });

        }
        }
}
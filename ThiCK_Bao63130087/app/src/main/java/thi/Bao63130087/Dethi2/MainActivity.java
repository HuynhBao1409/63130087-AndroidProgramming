package thi.Bao63130087.Dethi2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //bottom naviga
        BottomNavigationView bottomNav =findViewById(R.id.bottomNavigationView);
        bottomNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener(){

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment selectedFragment = null;
                int itemId = item.getItemId();
                if (itemId == R.id.nagvigation_welcome) {
                    selectedFragment = new WelcomeFragment();
                }else if (itemId == R.id.nagvigation_Unit) {
                    selectedFragment = new UnitConverterFragment();
                } else if (itemId == R.id.nagvigation_Welknown) {
                    selectedFragment = new WelknownCoffeeFragment();
                } else if (itemId == R.id.nagvigation_Subject) {
                    selectedFragment = new SubjectsFragment();
                }else if (itemId == R.id.nagvigation_MyCV) {
                    selectedFragment = new MyCVFragment();
                }
                //It will help to replace the one  fragment to other
                if(selectedFragment != null){
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentSpace,selectedFragment).commit();
                }
                return true;

            }
        });
    }
}
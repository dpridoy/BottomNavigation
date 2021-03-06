package com.dma_bd.bottomnavigation;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNav=findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new HomeFragment()).commit();

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener=new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment selectedFrag=null;

            switch (menuItem.getItemId()){
                case R.id.nav_home:
                    selectedFrag=new HomeFragment();
                    break;

                case R.id.nav_fav:
                    selectedFrag=new FavoritesFragment();
                    break;

                case R.id.nav_search:
                    selectedFrag=new SearchFragment();
                    break;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    selectedFrag).commit();
            return true;
        }
    };
}

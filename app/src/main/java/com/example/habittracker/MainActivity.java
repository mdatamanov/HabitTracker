package com.example.habittracker;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    @Override protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);
        BottomNavigationView nav = findViewById(R.id.bottomNav);
        nav.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.nav_home) { load(new HomeFragment()); return true; }
            if (id == R.id.nav_stats) { load(new StatsFragment()); return true; }
            if (id == R.id.nav_profile) { load(new ProfileFragment()); return true; }
            return false;
        });
        if (b == null) load(new HomeFragment());
    }
    private void load(Fragment f) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, f).commit();
    }
}
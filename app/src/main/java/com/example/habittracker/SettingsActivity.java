package com.example.habittracker;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {
    @Override protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_settings);
        findViewById(R.id.btnNotify).setOnClickListener(v ->
                Toast.makeText(this, "Уведомления включены", Toast.LENGTH_SHORT).show());
        findViewById(R.id.btnTheme).setOnClickListener(v ->
                Toast.makeText(this, "Тема пока одна", Toast.LENGTH_SHORT).show());
    }
}
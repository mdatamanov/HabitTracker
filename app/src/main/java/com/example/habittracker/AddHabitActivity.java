package com.example.habittracker;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.textfield.TextInputEditText;
import java.util.List;
import java.util.UUID;

public class AddHabitActivity extends AppCompatActivity {
    @Override protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_add_habit);
        TextInputEditText name = findViewById(R.id.habitNameInput);
        TextInputEditText desc = findViewById(R.id.habitDescInput);
        Button save = findViewById(R.id.saveBtn);
        save.setOnClickListener(v -> {
            String n = String.valueOf(name.getText()).trim();
            String d = String.valueOf(desc.getText()).trim();
            if (n.isEmpty()) { Toast.makeText(this, "Введите название", Toast.LENGTH_SHORT).show(); return; }
            List<Habit> list = HabitStorage.getHabits(this);
            list.add(new Habit(UUID.randomUUID().toString(), n, d));
            HabitStorage.saveHabits(this, list);
            Toast.makeText(this, "Привычка добавлена", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}
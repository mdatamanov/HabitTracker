package com.example.habittracker;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;

public class HabitDetailActivity extends AppCompatActivity {
    private Habit habit;

    @Override protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_habit_detail);
        String id = getIntent().getStringExtra("habit_id");
        List<Habit> list = HabitStorage.getHabits(this);
        for (Habit h : list) if (h.getId().equals(id)) { habit = h; break; }
        if (habit == null) { finish(); return; }

        TextView name = findViewById(R.id.detailName);
        TextView desc = findViewById(R.id.detailDesc);
        TextView streak = findViewById(R.id.detailStreak);
        Button done = findViewById(R.id.btnDone);
        Button del = findViewById(R.id.btnDelete);

        name.setText(habit.getName());
        desc.setText(habit.getDescription().isEmpty() ? "Без описания" : habit.getDescription());
        updateStreak(streak);

        done.setOnClickListener(v -> {
            if (habit.isCompletedToday()) {
                Toast.makeText(this, "Уже выполнено сегодня", Toast.LENGTH_SHORT).show();
                return;
            }
            habit.setCompletedToday(true);
            habit.setStreak(habit.getStreak() + 1);
            persist();
            updateStreak(streak);
            Toast.makeText(this, "Молодец!", Toast.LENGTH_SHORT).show();
        });
        del.setOnClickListener(v -> {
            list.remove(habit);
            HabitStorage.saveHabits(this, list);
            Toast.makeText(this, "Удалено", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
    private void updateStreak(TextView t) {
        t.setText("🔥 Серия: " + habit.getStreak() +
                (habit.isCompletedToday() ? "\n✅ Выполнено сегодня" : "\n⏳ Ещё не выполнено"));
    }
    private void persist() {
        List<Habit> list = HabitStorage.getHabits(this);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(habit.getId())) { list.set(i, habit); break; }
        }
        HabitStorage.saveHabits(this, list);
    }
}
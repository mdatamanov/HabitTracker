package com.example.habittracker;

import android.os.Bundle;
import android.view.*;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import java.util.List;

public class StatsFragment extends Fragment {
    @Override public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup c, Bundle b) {
        View v = inflater.inflate(R.layout.fragment_stats, c, false);
        List<Habit> list = HabitStorage.getHabits(getContext());
        int total = list.size();
        int done = 0, totalStreak = 0;
        for (Habit h : list) { if (h.isCompletedToday()) done++; totalStreak += h.getStreak(); }
        TextView t = v.findViewById(R.id.statsText);
        t.setText("Всего привычек: " + total +
                "\nВыполнено сегодня: " + done +
                "\nОбщая серия: " + totalStreak +
                "\nПроцент выполнения: " + (total == 0 ? 0 : (done * 100 / total)) + "%");
        return v;
    }
}
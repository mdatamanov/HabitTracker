package com.example.habittracker;

import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class HomeFragment extends Fragment {
    private HabitAdapter adapter;
    private List<Habit> habits;
    private RecyclerView rv;
    private TextView empty;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup c, Bundle b) {
        View v = inflater.inflate(R.layout.fragment_home, c, false);
        rv = v.findViewById(R.id.recyclerView);
        empty = v.findViewById(R.id.emptyView);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        habits = HabitStorage.getHabits(getContext());
        adapter = new HabitAdapter(habits, habit -> {
            Intent i = new Intent(getContext(), HabitDetailActivity.class);
            i.putExtra("habit_id", habit.getId());
            startActivity(i);
        });
        rv.setAdapter(adapter);
        v.findViewById(R.id.fab).setOnClickListener(x ->
                startActivity(new Intent(getContext(), AddHabitActivity.class)));
        updateEmpty();
        return v;
    }

    @Override public void onResume() {
        super.onResume();
        habits = HabitStorage.getHabits(getContext());
        if (adapter != null) adapter.updateList(habits);
        updateEmpty();
    }
    private void updateEmpty() {
        if (habits == null || habits.isEmpty()) {
            empty.setVisibility(View.VISIBLE);
            rv.setVisibility(View.GONE);
        } else {
            empty.setVisibility(View.GONE);
            rv.setVisibility(View.VISIBLE);
        }
    }
}
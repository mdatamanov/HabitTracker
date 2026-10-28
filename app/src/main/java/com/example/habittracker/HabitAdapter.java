package com.example.habittracker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class HabitAdapter extends RecyclerView.Adapter<HabitAdapter.VH> {
    public interface OnHabitClick { void onClick(Habit h); }
    private List<Habit> data;
    private final OnHabitClick listener;

    public HabitAdapter(List<Habit> data, OnHabitClick l) { this.data = data; this.listener = l; }

    public void updateList(List<Habit> newData) { this.data = newData; notifyDataSetChanged(); }

    @NonNull @Override
    public VH onCreateViewHolder(@NonNull ViewGroup p, int v) {
        View view = LayoutInflater.from(p.getContext()).inflate(R.layout.item_habit, p, false);
        return new VH(view);
    }
    @Override public void onBindViewHolder(@NonNull VH h, int i) {
        Habit habit = data.get(i);
        h.name.setText(habit.getName());
        h.desc.setText(habit.getDescription());
        h.streak.setText("🔥 Серия: " + habit.getStreak());
        h.itemView.setOnClickListener(v -> listener.onClick(habit));
    }
    @Override public int getItemCount() { return data == null ? 0 : data.size(); }

    static class VH extends RecyclerView.ViewHolder {
        TextView name, desc, streak;
        VH(View v) {
            super(v);
            name = v.findViewById(R.id.habitName);
            desc = v.findViewById(R.id.habitDesc);
            streak = v.findViewById(R.id.habitStreak);
        }
    }
}
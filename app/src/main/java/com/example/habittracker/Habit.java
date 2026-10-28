package com.example.habittracker;

public class Habit {
    private String id;
    private String name;
    private String description;
    private int streak;
    private boolean completedToday;

    public Habit() {}
    public Habit(String id, String name, String description) {
        this.id = id; this.name = name; this.description = description;
        this.streak = 0; this.completedToday = false;
    }
    public String getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public int getStreak() { return streak; }
    public boolean isCompletedToday() { return completedToday; }
    public void setCompletedToday(boolean v) { this.completedToday = v; }
    public void setStreak(int s) { this.streak = s; }
    public void setName(String n) { this.name = n; }
    public void setDescription(String d) { this.description = d; }
}
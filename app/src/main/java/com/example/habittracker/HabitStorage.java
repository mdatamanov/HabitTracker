package com.example.habittracker;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class HabitStorage {
    private static final String PREF = "habit_prefs";
    private static final String KEY_HABITS = "habits";
    private static final String KEY_LOGIN = "logged_in";
    private static final String KEY_EMAIL = "email";

    public static List<Habit> getHabits(Context ctx) {
        SharedPreferences sp = ctx.getSharedPreferences(PREF, Context.MODE_PRIVATE);
        String json = sp.getString(KEY_HABITS, null);
        if (json == null) return new ArrayList<>();
        Type t = new TypeToken<List<Habit>>(){}.getType();
        List<Habit> list = new Gson().fromJson(json, t);
        return list != null ? list : new ArrayList<>();
    }

    public static void saveHabits(Context ctx, List<Habit> habits) {
        SharedPreferences sp = ctx.getSharedPreferences(PREF, Context.MODE_PRIVATE);
        sp.edit().putString(KEY_HABITS, new Gson().toJson(habits)).apply();
    }

    public static void setLoggedIn(Context ctx, boolean v) {
        ctx.getSharedPreferences(PREF, Context.MODE_PRIVATE).edit().putBoolean(KEY_LOGIN, v).apply();
    }
    public static boolean isLoggedIn(Context ctx) {
        return ctx.getSharedPreferences(PREF, Context.MODE_PRIVATE).getBoolean(KEY_LOGIN, false);
    }
    public static void setEmail(Context ctx, String e) {
        ctx.getSharedPreferences(PREF, Context.MODE_PRIVATE).edit().putString(KEY_EMAIL, e).apply();
    }
    public static String getEmail(Context ctx) {
        return ctx.getSharedPreferences(PREF, Context.MODE_PRIVATE).getString(KEY_EMAIL, "user@mail.com");
    }
}
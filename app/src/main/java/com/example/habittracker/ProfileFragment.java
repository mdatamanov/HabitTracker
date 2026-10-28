package com.example.habittracker;

import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment {
    @Override public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup c, Bundle b) {
        View v = inflater.inflate(R.layout.fragment_profile, c, false);
        TextView email = v.findViewById(R.id.profileEmail);
        email.setText("Email: " + HabitStorage.getEmail(getContext()));
        v.findViewById(R.id.btnSettings).setOnClickListener(x ->
                startActivity(new Intent(getContext(), SettingsActivity.class)));
        v.findViewById(R.id.btnAbout).setOnClickListener(x ->
                startActivity(new Intent(getContext(), AboutActivity.class)));
        v.findViewById(R.id.btnLogout).setOnClickListener(x -> {
            HabitStorage.setLoggedIn(getContext(), false);
            Intent i = new Intent(getContext(), LoginActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(i);
        });
        return v;
    }
}
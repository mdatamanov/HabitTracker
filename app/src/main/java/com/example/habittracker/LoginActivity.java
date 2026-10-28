package com.example.habittracker;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {
    @Override protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_login);
        TextInputEditText email = findViewById(R.id.emailInput);
        TextInputEditText pass = findViewById(R.id.passwordInput);
        Button login = findViewById(R.id.loginBtn);
        Button reg = findViewById(R.id.registerBtn);

        login.setOnClickListener(v -> {
            String e = email.getText() == null ? "" : email.getText().toString().trim();
            String p = pass.getText() == null ? "" : pass.getText().toString().trim();
            if (e.isEmpty() || p.isEmpty()) { Toast.makeText(this, "Заполните все поля", Toast.LENGTH_SHORT).show(); return; }
            if (p.length() < 4) { Toast.makeText(this, "Пароль минимум 4 символа", Toast.LENGTH_SHORT).show(); return; }
            HabitStorage.setLoggedIn(this, true);
            HabitStorage.setEmail(this, e);
            startActivity(new Intent(this, MainActivity.class));
            finish();
        });
        reg.setOnClickListener(v -> startActivity(new Intent(this, RegisterActivity.class)));
    }
}
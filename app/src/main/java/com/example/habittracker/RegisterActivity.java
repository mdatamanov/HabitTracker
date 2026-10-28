package com.example.habittracker;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.textfield.TextInputEditText;

public class RegisterActivity extends AppCompatActivity {
    @Override protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_register);
        TextInputEditText name = findViewById(R.id.nameInput);
        TextInputEditText email = findViewById(R.id.emailInput);
        TextInputEditText pass = findViewById(R.id.passwordInput);
        TextInputEditText pass2 = findViewById(R.id.password2Input);
        Button reg = findViewById(R.id.registerSubmit);

        reg.setOnClickListener(v -> {
            String n = String.valueOf(name.getText()).trim();
            String e = String.valueOf(email.getText()).trim();
            String p = String.valueOf(pass.getText()).trim();
            String p2 = String.valueOf(pass2.getText()).trim();
            if (n.isEmpty() || e.isEmpty() || p.isEmpty()) { Toast.makeText(this, "Заполните поля", Toast.LENGTH_SHORT).show(); return; }
            if (!p.equals(p2)) { Toast.makeText(this, "Пароли не совпадают", Toast.LENGTH_SHORT).show(); return; }
            HabitStorage.setLoggedIn(this, true);
            HabitStorage.setEmail(this, e);
            Toast.makeText(this, "Аккаунт создан", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, MainActivity.class));
            finish();
        });
    }
}
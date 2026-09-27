package com.example.lekc;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText imie;
    private EditText nazwisko;
    private EditText email;
    private EditText haslo;
    private Button zarejestruj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        imie = findViewById(R.id.imie);
        nazwisko = findViewById(R.id.nazwisko);
        email = findViewById(R.id.email);
        haslo = findViewById(R.id.haslo);
        zarejestruj = findViewById(R.id.zarejestruj);

        zarejestruj.setOnClickListener(v -> {
            String imie_tekst = String.valueOf(imie.getText()).trim();
            String nazwisko_tekst = String.valueOf(nazwisko.getText()).trim();
            String email_tekst = String.valueOf(email.getText()).trim();
            String haslo_tekst = String.valueOf(haslo.getText()).trim();

            if(imie_tekst.isEmpty() || nazwisko_tekst.isEmpty() || email_tekst.isEmpty() || haslo_tekst.isEmpty()){
                Toast.makeText(this, "Uzupełnij wszystkie pola", Toast.LENGTH_SHORT).show();
            } else if (!email_tekst.contains("@") || !email_tekst.contains(".")) {
                Toast.makeText(this, "Podaj poprawny adres email", Toast.LENGTH_SHORT).show();
            } else if(haslo_tekst.length() < 8 || !haslo_tekst.matches(".*[a-z].*") || !haslo_tekst.matches(".*[A-Z].*") || !haslo_tekst.matches(".*[a-zA-z0-9].*")){
                Toast.makeText(this, "Hasło musi mieć conajmniej 8 znaków, dużą/małą literę, znak specjalny", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Wszystkie dane są poprawne", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
package com.example.hesapmakinesi;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etSayi1, etSayi2;
    Button btnTopla, btnCikar, btnCarp, btnBol, btnTemizle;
    TextView txtSonuc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etSayi1 = findViewById(R.id.etSayi1);
        etSayi2 = findViewById(R.id.etSayi2);
        btnTopla = findViewById(R.id.btnTopla);
        btnCikar = findViewById(R.id.btnCikar);
        btnCarp = findViewById(R.id.btnCarp);
        btnBol = findViewById(R.id.btnBol);
        btnTemizle = findViewById(R.id.btnTemizle);
        txtSonuc = findViewById(R.id.txtSonuc);

        btnTopla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hesapla("+");
            }
        });

        btnCikar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hesapla("-");
            }
        });

        btnCarp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hesapla("*");
            }
        });

        btnBol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hesapla("/");
            }
        });

        btnTemizle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etSayi1.setText("");
                etSayi2.setText("");
                txtSonuc.setText("Sonuç: 0");
                etSayi1.requestFocus();
            }
        });
    }

    public void hesapla(String islemTuru) {
        String s1 = etSayi1.getText().toString();
        String s2 = etSayi2.getText().toString();

        if (!s1.isEmpty() && !s2.isEmpty()) {
            double sayi1 = Double.parseDouble(s1);
            double sayi2 = Double.parseDouble(s2);
            double sonuc = 0;

            if (islemTuru.equals("+")) {
                sonuc = sayi1 + sayi2;
            } else if (islemTuru.equals("-")) {
                sonuc = sayi1 - sayi2;
            } else if (islemTuru.equals("*")) {
                sonuc = sayi1 * sayi2;
            } else if (islemTuru.equals("/")) {
                if (sayi2 != 0) {
                    sonuc = sayi1 / sayi2;
                } else {
                    Toast.makeText(this, "Sayı 0'a bölünemez!", Toast.LENGTH_SHORT).show();
                    return;
                }
            }

            txtSonuc.setText("Sonuç: " + sonuc);
        } else {
            Toast.makeText(this, "Lütfen sayıları giriniz.", Toast.LENGTH_SHORT).show();
        }
    }
}
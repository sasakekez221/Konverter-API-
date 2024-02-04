package com.example.konverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private EditText euroUpis;
    private TextView HRK, RSD, BAM, HUF, RON;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        euroUpis = findViewById(R.id.euroUpis);
        HRK = findViewById(R.id.HRK);
        RSD = findViewById(R.id.RSD);
        BAM = findViewById(R.id.BAM);
        HUF = findViewById(R.id.HUF);
        RON = findViewById(R.id.RON);

        euroUpis.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                try {
                    double inputEuro = Double.parseDouble(s.toString());

                    // Konverzija u HRK
                    double hrkRate = 7.5345;
                    double hrkValue = inputEuro * hrkRate;
                    HRK.setText(String.format(Locale.getDefault(), "HRK: %.2f", hrkValue));

                    // Konverzija u RON
                    double ronRate = 4.97;
                    double ronValue = inputEuro * ronRate;
                    RON.setText(String.format(Locale.getDefault(), "RON: %.2f", ronValue));

                    // Konverzija u RSD
                    double rsdRate = 117.22;
                    double rsdValue = inputEuro * rsdRate;
                    RSD.setText(String.format(Locale.getDefault(), "RSD: %.2f", rsdValue));

                    // Konverzija u BAM
                    double bamRate = 1.94;
                    double bamValue = inputEuro * bamRate;
                    BAM.setText(String.format(Locale.getDefault(), "BAM: %.2f", bamValue));

                    // Konverzija u HUF
                    double hufRate = 384.20;
                    double hufValue = inputEuro * hufRate;
                    HUF.setText(String.format(Locale.getDefault(), "HUF: %.2f", hufValue));

                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
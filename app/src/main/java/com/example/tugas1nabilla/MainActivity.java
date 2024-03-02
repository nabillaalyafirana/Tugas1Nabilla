package com.example.tugas1nabilla;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private RadioGroup serviceRadioGroup, membershipRadioGroup;
    private RadioButton hairTreatmentRadioButton, facialRadioButton, pedicureRadioButton, manicureRadioButton;
    private RadioButton platinumRadioButton, goldRadioButton, silverRadioButton;
    private Button calculateButton;
    private TextView totalTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        serviceRadioGroup = findViewById(R.id.serviceRadioGroup);
        membershipRadioGroup = findViewById(R.id.membershipRadioGroup);
        hairTreatmentRadioButton = findViewById(R.id.hairTreatmentRadioButton);
        pedicureRadioButton = findViewById(R.id.pedicureRadioButton);
        manicureRadioButton = findViewById(R.id.manicureRadioButton);
        facialRadioButton = findViewById(R.id.facialRadioButton);
        platinumRadioButton = findViewById(R.id.platinumRadioButton);
        goldRadioButton = findViewById(R.id.goldRadioButton);
        silverRadioButton = findViewById(R.id.silverRadioButton);
        calculateButton = findViewById(R.id.calculateButton);
        totalTextView = findViewById(R.id.totalTextView);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateTotal();
            }
        });
    }

    private void calculateTotal() {
        double totalPrice = 0.0;
        double discount=0.0;
        double priceText;
        // Menghitung harga layanan
        if (hairTreatmentRadioButton.isChecked()) {
            totalPrice += 50000; // Harga hair treatment
        }
        if (pedicureRadioButton.isChecked()) {
            totalPrice += 80000; // Harga pedicure
        }
        if (manicureRadioButton.isChecked()) {
            totalPrice += 100000; // Harga manicure
        }
        if (facialRadioButton.isChecked()) {
            totalPrice += 60000; // Harga facial
        }


        if (platinumRadioButton.isChecked()) {
            discount = totalPrice * 0.2; // Diskon 20% untuk platinum
        } else if (goldRadioButton.isChecked()) {
            discount = totalPrice * 0.15; // Diskon 15% untuk gold
        } else if (silverRadioButton.isChecked()) {
            discount = totalPrice * 0.1; // Diskon 10% untuk silver
        }

        double finalPrice = totalPrice - discount;


        // Menampilkan diskon dan harga pada TextView
        totalTextView.setText("Total Price: Rp" + String.format("%.0f", finalPrice) + "\nDiscount: " + Math.round((discount / totalPrice) * 100) + "%");





    }


}
package com.example.farecalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.math.BigDecimal;
import java.text.NumberFormat;

public class DashboardActivity extends AppCompatActivity {

    private EditText kilometersEditText;
    private EditText mileageEditText;
    private EditText priceEditText;
    private TextView fareTextView;
    private Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        kilometersEditText = findViewById(R.id.Kilometers);
        mileageEditText = findViewById(R.id.Mileage);
        priceEditText = findViewById(R.id.Price);
        fareTextView = findViewById(R.id.Fare);
        calculateButton = findViewById(R.id.Calculate);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateFare();
            }
        });
    }

    private void calculateFare() {
        String kms = kilometersEditText.getText().toString();
        double distance = Double.parseDouble(kms);

        String avg = mileageEditText.getText().toString();
        double average = Double.parseDouble(avg);

        String rs = priceEditText.getText().toString();
        double petrol = Double.parseDouble(rs);

        BigDecimal myExpense = BigDecimal.valueOf(distance / average).multiply(BigDecimal.valueOf(petrol));
        BigDecimal fare = myExpense.add(myExpense);

        String formattedFare = NumberFormat.getCurrencyInstance().format(fare);
        fareTextView.setText(getString(R.string.Total, formattedFare));
    }
}

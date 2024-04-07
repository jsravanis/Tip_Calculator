package edu.uncc.tipcalculator;

import static edu.uncc.tipcalculator.MainActivity.BILL_KEY;
import static edu.uncc.tipcalculator.MainActivity.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.text.DecimalFormat;

public class BillSummaryActivity extends AppCompatActivity {

    TextView textViewBillAmount, textViewTipPercentage, textViewTipAmount, textViewTotalBill;
    DecimalFormat decimalFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_summary);

        decimalFormat = new DecimalFormat("#.##");

        textViewBillAmount = findViewById(R.id.textViewBillAmount);
        textViewTipPercentage = findViewById(R.id.textViewTipPercentage);
        textViewTipAmount = findViewById(R.id.textViewTipAmount);
        textViewTotalBill = findViewById(R.id.textViewTotalBill);

        if(getIntent() != null && getIntent().hasExtra(BILL_KEY) && getIntent().getSerializableExtra(BILL_KEY) != null){
            Bill bill = (Bill) getIntent().getSerializableExtra(BILL_KEY);
            Log.d(TAG, "onCreate of Bill Summary: " + bill);
            textViewBillAmount.setText("$" + decimalFormat.format(bill.getBillAmount()));
            textViewTipPercentage.setText(bill.getTipPercent() + "%");
            double tipAmount = bill.getBillAmount() * bill.getTipPercent() * 0.01;
            double totalBill = bill.getBillAmount() + tipAmount;
            textViewTipAmount.setText(decimalFormat.format(tipAmount));
            textViewTotalBill.setText(decimalFormat.format(totalBill));
        }

        findViewById(R.id.buttonBack).setOnClickListener(v -> {
            Intent intent = new Intent(BillSummaryActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }
}
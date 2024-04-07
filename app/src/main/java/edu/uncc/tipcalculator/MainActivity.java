package edu.uncc.tipcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static final String BILL_KEY = "BILL";
    public static final String TAG = "Tip_Calculator";
    TextView textViewSelectedTip;
    EditText editTextBillAmount;

    ActivityResultLauncher<Intent> startTipCalculator = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if (result.getResultCode() == RESULT_OK && result.getData() != null && result.getData().getSerializableExtra(BILL_KEY) != null){
                Bill bill = (Bill) result.getData().getSerializableExtra(BILL_KEY);
                Log.d(TAG, "onActivityResult: " + bill);
                textViewSelectedTip.setText(bill.getTipPercent() + "%");
            }
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewSelectedTip = findViewById(R.id.textViewSelectedTip);
        editTextBillAmount = findViewById(R.id.editTextBillAmount);

        findViewById(R.id.buttonSelectTip).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SelectTipActivity.class);
            startTipCalculator.launch(intent);
        });

        findViewById(R.id.buttonCalculate).setOnClickListener(v -> {
            if(editTextBillAmount.getText().toString().isEmpty() || textViewSelectedTip.getText().toString().equals("N/A"))
                Toast.makeText(this, "Bill amount and Tip shouldn't be empty", Toast.LENGTH_SHORT).show();
            else {
                double billAmount = Double.parseDouble(editTextBillAmount.getText().toString());
                int tipPercent = Integer.parseInt(textViewSelectedTip.getText().toString().split("%")[0]);
                Bill bill = new Bill(billAmount, tipPercent);
                Intent intent = new Intent(MainActivity.this, BillSummaryActivity.class);
                intent.putExtra(BILL_KEY, bill);
                Log.d(TAG, "onClick of Calculate: " + bill);
                startActivity(intent);
            }
        });

        findViewById(R.id.buttonReset).setOnClickListener(v -> {
            editTextBillAmount.setText("");
            textViewSelectedTip.setText("N/A");
        });
    }
}
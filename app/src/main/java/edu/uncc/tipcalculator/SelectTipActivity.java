package edu.uncc.tipcalculator;

import static edu.uncc.tipcalculator.MainActivity.BILL_KEY;
import static edu.uncc.tipcalculator.MainActivity.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

public class SelectTipActivity extends AppCompatActivity {

    SeekBar seekBar;
    TextView textViewProgress;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_tip);

        radioGroup = findViewById(R.id.radioGroup);
        textViewProgress = findViewById(R.id.textViewProgress);
        seekBar = findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textViewProgress.setText(progress + "%");
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        findViewById(R.id.buttonSubmit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int checkedRadioButtonId = radioGroup.getCheckedRadioButtonId();
                int tipPercent;
                if(checkedRadioButtonId == R.id.radioButtonCustom){
                    tipPercent = seekBar.getProgress();
                }
                else{
                    RadioButton selectedTipRadio = findViewById(checkedRadioButtonId);
                    tipPercent = Integer.parseInt(selectedTipRadio.getText().toString().split("%")[0]);
                }
                Bill bill = new Bill(tipPercent);
                Intent intent = new Intent();
                intent.putExtra(BILL_KEY, bill);
                Log.d(TAG, "onClick of Tip Submit: " + bill);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        findViewById(R.id.buttonCancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
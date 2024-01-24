package com.learning.bmicalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // making variables using the same id name, to prevent any confusion
        TextView txtResult;
        EditText edtHeightIn, edtHeightFt, edtWeight;
        Button btnCalc;
        LinearLayout llMain;

        // making the variables find their ids from the activity_main.xml file
        edtWeight = findViewById(R.id.edtWeight);
        edtHeightIn = findViewById(R.id.edtHeightIn);
        edtHeightFt = findViewById(R.id.edtHeightFt);
        btnCalc = findViewById(R.id.btnCalc);
        txtResult = findViewById(R.id.txtResult);
        llMain = findViewById(R.id.llMain);

        // adding Click effect on the button in order to perform an action
        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int wt = Integer.parseInt(edtWeight.getText().toString());
                int ft = Integer.parseInt(edtHeightFt.getText().toString());
                int in = Integer.parseInt(edtHeightIn.getText().toString());

                int totalIn = ft*12 +in;
                double totalCm = totalIn*2.53;

                double totalMt = totalCm/100;

                double bmi = wt/(totalMt*totalMt);

                if(bmi>25){
                    txtResult.setText(R.string.overweight);
                    llMain.setBackgroundColor(getResources().getColor(R.color.red));
                }
                else if(bmi<18){
                    txtResult.setText(R.string.underweight);
                    llMain.setBackgroundColor(getResources().getColor(R.color.yellow));
                }
                else{
                    txtResult.setText(R.string.healthy);
                    llMain.setBackgroundColor(getResources().getColor(R.color.blue));
                }
            }
        });

    }
}
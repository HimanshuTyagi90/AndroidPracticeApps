package com.example.bmichecker;
import static android.graphics.Color.parseColor;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCalculate = findViewById(R.id.btnCalculate);
        EditText edtwt = findViewById(R.id.edtWeight);
        EditText edtHtF = findViewById(R.id.edtHeightFt);
        EditText edtHtI = findViewById(R.id.edtHeightIn);
        TextView txtResult = findViewById(R.id.txtResult);

      btnCalculate.setOnClickListener(v -> {
          double weight = Double.parseDouble(String.valueOf(edtwt.getText()));
          double heightFt = Double.parseDouble(String.valueOf(edtHtF.getText()));
          double heightInch = Double.parseDouble(String.valueOf(edtHtI.getText()));

          double totalInches = heightFt * 12 + heightInch;
          double totalCm = totalInches * 2.53;
          double totalM = totalCm / 100;
          double BMI = weight / (Math.pow(totalM, 2));


          if (BMI > 25) {

              txtResult.setText(R.string.OVERWEIGHT);
              txtResult.setTextColor(parseColor("#de141e"));

          } else if(BMI < 25 && BMI > 18) {
              txtResult.setText(R.string.HEALTHY);
              txtResult.setTextColor(parseColor("#48cf46"));
          }else if(BMI<18){
              txtResult.setText(R.string.UNDERWEIGHT);
              txtResult.setTextColor(parseColor("#46c1cf"));
          }
          });

    }
}
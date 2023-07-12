package com.example.unconvert;

import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
//import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private EditText userinp,calout;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


         userinp = findViewById(R.id.userinp);
         calout = findViewById(R.id.caldat);
        Button convert = findViewById(R.id.convbtn);

        convert.setOnClickListener(v -> {
//                Toast.makeText(MainActivity.this, "clicked on calculate", Toast.LENGTH_SHORT).show();
            Log.d("when clicked", "onClick: clicked on calculate ");

            String str = userinp.getText().toString();
            double inch= Double.parseDouble(str);
            double cms = 2.54 * inch;
            calout.setText(Double.toString(cms));
        });
    }
}
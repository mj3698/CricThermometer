package com.example.cricthermometer;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    TextView tvInfo,tvResult;
    EditText etInput;
    RadioButton radiobtnCelsius,radiobtnFarenheit;
    Button btnSubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvInfo=findViewById(R.id.tvInfo);
        tvResult=findViewById(R.id.tvResult);
        etInput=findViewById(R.id.etInput);
        btnSubmit=findViewById(R.id.btnSubmit);
        radiobtnCelsius=findViewById(R.id.radiobtnCelsius);
        radiobtnFarenheit=findViewById((R.id.radiobtnFarenheit));

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etInput.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this,"Please Enter all the fields!",Toast.LENGTH_SHORT).show();
                }
                else {

                    double result;
                    DecimalFormat formatter = new DecimalFormat("#0.0");
                    int number = Integer.parseInt(etInput.getText().toString().trim());
                    if (radiobtnCelsius.isChecked()) {
                        result = (number / 3.0) + 4;
                        tvResult.setText("The Aprroximate Temperature outside is" + "\n" +
                                formatter.format(result) + " degree Celsius");
                    } else if (radiobtnFarenheit.isChecked()) {
                        result = (number + 40);
                        tvResult.setText("The Aprroximate Temperature outside is" + "\n" +
                                formatter.format(result) + " degree Farenheit");
                    }
                }

            }
        });
    }
}
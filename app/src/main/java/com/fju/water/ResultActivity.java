package com.fju.water;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    TextView month;
    ImageView backG;
    ImageView bill;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent intent = getIntent();
        double month2 = intent.getDoubleExtra("MONTH2",0);
        Log.d("resultActivity",month2+"");
        month = findViewById(R.id.month);
        int m = (int) (month2 + 0.5f);
        month.setText(m+"元");
        bill = findViewById(R.id.bill);
    }
}

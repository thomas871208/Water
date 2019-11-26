package com.fju.water;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
    EditText month;
    EditText next;
    int month1;
    int next1;
    Switch Switch1;
    double month2;
    double next2;
    int monthlength;
    int nextlength;
    Boolean isNext = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        month = findViewById(R.id.month);
        next = findViewById(R.id.next);


        Button button = new Button(this);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                money();
                Intent intent = new Intent(MainActivity.this,ResultActivity.class);
                intent.putExtra(getString(R.string.extra_MONTH2), month2);
                startActivity(intent);
                Switch sw = findViewById(R.id.switch1);
                sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        isNext = isChecked;
                        month.setText(R.string.monthly);
                        if(isNext = false){
                            //Monthly
                        }else{
                            //next
                        }
                    }
                });
            }
        });


       FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    public  void money(){
        try {
            month1 = Integer.parseInt(month.getText().toString());
        }catch (Exception e){
            month1 = 0;
        }
        try {
            next1 = Integer.parseInt(next.getText().toString());
        }catch (Exception e){
            next1 = 0;
        }
        if(month1 >= 1 && month1 <= 10){
            month2 = month1*7.35;
        }else if(month1 >= 11 && month1 <= 30){
            month2 = (month1*9.45)-21;
        }else if(month1 >= 31 && month1 <=50){
            month2 = (month1*11.55)-84;
        }else if(month1 >= 51){
            month2 = (month1*12.075)-110.25;
        }

        if(next1 >= 1 && next1 <= 20){
            next2 = next1*7.35;
        }else if(next1 >= 21 && next1 <= 60){
            next2 = (next1*9.45)-42;
        }else if(next1 >= 61 && next1 <= 100){
            next2 = (next1*11.55)-168;
        }else if(next1 >= 101){
            next2 = (next1*12.075)-220.5;
        }
    }
    public  void  count(View view){
        monthlength = month.getText().toString().length();
        nextlength = next.getText().toString().length();
        money();



        if(monthlength != 0 && nextlength == 0){
        /*    Intent intent = new Intent(this,ResultActivity.class);
            startActivity(intent);*/

            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("每月抄表")
                    .setMessage("費用"+month2+"元")
                    .setPositiveButton(getString(R.string.OK), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            month.setText("");
                            next.setText("");
                        }
                    })
                    .show();
        }else if(nextlength !=0 && monthlength ==0) {
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("隔月抄表")
                    .setMessage("費用"+next2+"元")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            month.setText("");
                            next.setText("");
                        }
                    })
                    .show();
        }else {
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("警告")
                    .setMessage("未輸入數字，無法計算")
                    .setPositiveButton("OK",null)
                    .show();
        }


    }

    @Override


    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

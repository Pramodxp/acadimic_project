package com.map.app.sactest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DriverOptionActivity extends AppCompatActivity {

    String driver;
    Button selectpick,startpick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_option);
        Intent intent = getIntent();
        driver=intent.getStringExtra("drivername").toString();
        selectpick = (Button) findViewById(R.id.buttonviewpick);
        startpick = (Button) findViewById(R.id.buttonstartpick);

        selectpick.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent intent = new Intent(DriverOptionActivity.this, DriverSelectActivity.class);
                intent.putExtra("drivername", driver);
                //in//tent.putExtra("userid", displayText);
                startActivity(intent);

            }
        });

        startpick.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent intent = new Intent(DriverOptionActivity.this, TestMapActivity.class);
                intent.putExtra("drivername", driver);
                //in//tent.putExtra("userid", displayText);
                startActivity(intent);

            }
        });


    }
}

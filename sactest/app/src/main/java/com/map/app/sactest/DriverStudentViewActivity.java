package com.map.app.sactest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

public class DriverStudentViewActivity extends AppCompatActivity {

    TextView pickupdetails;
    String displayText;
    String driver,pickupid,pickde;
    Button accept,cancle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_student_view);

        pickupdetails = (TextView) findViewById(R.id.textView5);
        accept = (Button) findViewById(R.id.buttonac);
        cancle = (Button) findViewById(R.id.buttoncl);


        Intent intent = getIntent();
        driver=intent.getStringExtra("drivername").toString();
        pickupid=intent.getStringExtra("pickupid").toString();
        pickde=intent.getStringExtra("details").toString();

        pickupdetails.setText(pickde);

        accept.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                AsyncCallWS task = new AsyncCallWS();
                task.execute();

            }
        });

        cancle.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent intent = new Intent(DriverStudentViewActivity.this, DriverSelectActivity.class);
                intent.putExtra("drivername", driver);
                //in//tent.putExtra("userid", displayText);
                startActivity(intent);

            }
        });
    }


    private class AsyncCallWS extends AsyncTask<String, Void, Void> {
        @Override
        protected Void doInBackground(String... params) {

            displayText = WebService.invokedriverselectstu(driver,pickupid,"driverselectstudentpickup");
            return  null;
        }

        @Override
        protected void onPostExecute(Void result) {

            //Toast.makeText(getApplicationContext(), "REsult is :"+displayText, Toast.LENGTH_LONG).show();

            System.out.println(displayText);

            if(displayText.equals("fail") || displayText.equals("Error occured") ){

                Toast.makeText(getApplicationContext(), "Login Failed ! Try Again", Toast.LENGTH_LONG).show();
                ///Toast.makeText(getApplicationContext(), "REsult is :"+displayText, Toast.LENGTH_LONG).show();

            }
            else{

                //Toast.makeText(getApplicationContext(), "stilll :"+displayText, Toast.LENGTH_LONG).show();



                Intent intent = new Intent(DriverStudentViewActivity.this, DriverSelectActivity.class);
                intent.putExtra("drivername", driver);
                //in//tent.putExtra("userid", displayText);
                startActivity(intent);


            }

        }


        @Override
        protected void onPreExecute() {

        }

        @Override
        protected void onProgressUpdate(Void... values) {


        }

    }
}

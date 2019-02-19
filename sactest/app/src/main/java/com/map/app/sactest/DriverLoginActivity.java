package com.map.app.sactest;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DriverLoginActivity extends AppCompatActivity {

    Button stulogin;
    String displayText;
    EditText drivernametxt,driverpasstxt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_login);

        stulogin = (Button) findViewById(R.id.driverlogin);
        drivernametxt = (EditText)findViewById(R.id.drivernametxt);
        driverpasstxt = (EditText)findViewById(R.id.driverpasstxt);

        stulogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
               AsyncCallWS task = new AsyncCallWS();
                task.execute();

            }
        });
    }

    private class AsyncCallWS extends AsyncTask<String, Void, Void> {
        @Override
        protected Void doInBackground(String... params) {

            displayText = WebService.invokedriverlogin(drivernametxt.getText().toString(),driverpasstxt.getText().toString(),"driverlogin");
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


                Intent intent = new Intent(DriverLoginActivity.this, DriverOptionActivity.class);
                intent.putExtra("drivername", drivernametxt.getText().toString());
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

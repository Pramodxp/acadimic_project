package com.map.app.sactest;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.os.AsyncTask;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String displayText;
    Button stulogin,driverlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stulogin = (Button) findViewById(R.id.studentLogin);

        stulogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
               //AsyncCallWS task = new AsyncCallWS();

               // task.execute();
                Intent myIntent = new Intent(MainActivity.this,
                        StudentLoginActivity.class);
                startActivity(myIntent);
            }
        });

        driverlogin = (Button) findViewById(R.id.DriverLogin);

        driverlogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                //AsyncCallWS task = new AsyncCallWS();

                // task.execute();
                Intent myIntent = new Intent(MainActivity.this,
                        DriverLoginActivity.class);
                startActivity(myIntent);
            }
        });



        //Toast.makeText(getApplicationContext(), "Login Service", Toast.LENGTH_LONG).show();
        //	 Intent intent = new Intent(MainActivity.this, HomeActivity.class);
        //       intent.putExtra("usn", usn.getText().toString());
        //      intent.putExtra("userid", "1");
        // 	startActivity(intent);




    }




    private class AsyncCallWS extends AsyncTask<String, Void, Void> {
        @Override
        protected Void doInBackground(String... params) {

            displayText = WebService.invokeHelloWorldWS("hello");
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {



                Toast.makeText(getApplicationContext(), "Login Failed ! Try Again"+displayText, Toast.LENGTH_LONG).show();





        }

        @Override
        protected void onPreExecute() {
        }

        @Override
        protected void onProgressUpdate(Void... values) {


        }

    }




}

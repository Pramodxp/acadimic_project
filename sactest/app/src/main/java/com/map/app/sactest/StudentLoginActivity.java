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
import android.widget.EditText;
import android.widget.Toast;

public class StudentLoginActivity extends AppCompatActivity {

    Button stulogin;
    String displayText;
    EditText usntxt,stupa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);

        stulogin = (Button) findViewById(R.id.stulogin);
        usntxt = (EditText)findViewById(R.id.stuusntxt);
        stupa = (EditText)findViewById(R.id.stupasstxt);

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

            displayText = WebService.invokelogin(usntxt.getText().toString(),stupa.getText().toString(),"studentlogin");
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


                Intent intent = new Intent(StudentLoginActivity.this, StudentMapActivity.class);
                intent.putExtra("stuusn", usntxt.getText().toString());
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

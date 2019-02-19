package com.map.app.sactest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.os.AsyncTask;
import android.content.Intent;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;


public class StudentMapActivity extends AppCompatActivity {

    private TextView get_location;
    public static Context context;
    int PLACE_PICKER_REQUEST = 1;
    Button submitPickUp;
    String Lat;
    String Lang;
    String place;
    String stuusn;
    String displayText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_map);
        Intent intent = getIntent();
        stuusn = intent.getStringExtra("stuusn").toString();
        get_location = (TextView)findViewById(R.id.textView3);
        get_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();

                try {
                    Intent intents = builder.build(StudentMapActivity.this);
                    startActivityForResult(intents, PLACE_PICKER_REQUEST);
                } catch (GooglePlayServicesRepairableException e) {
                    e.printStackTrace();
                } catch (GooglePlayServicesNotAvailableException e) {
                    e.printStackTrace();
                }
            }
        });

        submitPickUp = (Button) findViewById(R.id.stupickupsubn);
        submitPickUp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
               // String toastMsg = String.format("Place: %s", get_location.getText());
                String toastMsg =Lat+" - "+Lang+" - "+place+" - "+stuusn;
                Toast.makeText(getApplicationContext(),toastMsg, Toast.LENGTH_LONG).show();
                AsyncCallWS task = new AsyncCallWS();
                task.execute();
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==PLACE_PICKER_REQUEST){
            if(resultCode == RESULT_OK){
                Place selectedplace = PlacePicker.getPlace(data,this);
                String Latlang[] =  selectedplace.getLatLng().toString().split(",");
                Lat=Latlang[0].replace("lat/lng: (","");
                Lang=Latlang[1].replace(")","");
                place = selectedplace.getAddress().toString();

                //String pickupaddress = String.format("Place : %s", selectedplace.getAddress());
                //String toastMsg = String.format("Place: %s", selectedplace.getName());
                //Toast.makeText(this, toastMsg, Toast.LENGTH_LONG).show();
                get_location.setText(selectedplace.getAddress());

            }
        }

    }


    private class AsyncCallWS extends AsyncTask<String, Void, Void> {
        @Override
        protected Void doInBackground(String... params) {

            displayText = WebService.invokeinsertlang(Lat,Lang,place,stuusn,"insertlatlangdata");
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

                Toast.makeText(getApplicationContext(), "Pick up submited", Toast.LENGTH_LONG).show();


                //Intent intent = new Intent(StudentLoginActivity.this, StudentMapActivity.class);
                //intent.putExtra("stuusn", usntxt.getText().toString());
                //in//tent.putExtra("userid", displayText);
               // startActivity(intent);


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

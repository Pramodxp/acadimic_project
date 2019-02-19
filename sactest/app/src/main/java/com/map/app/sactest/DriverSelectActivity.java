package com.map.app.sactest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Build;

import static java.lang.Integer.valueOf;

public class DriverSelectActivity extends AppCompatActivity {

    TextView pickupdetails;
    private int pickupid;

    String displayText;
    ArrayList<String> pickuplist=new ArrayList<String>();
    private ListView lv;
    String driver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_select);
        Intent intent = getIntent();
        driver=intent.getStringExtra("drivername").toString();
        AsyncCallWS task = new AsyncCallWS();
        //Call execute
        task.execute();

    }

    private class AsyncCallWS extends AsyncTask<String, Void, Void> {
        @Override
        protected Void doInBackground(String... params) {

            displayText = WebService.invokegetstupicklist("stuacceptedlist");
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {

            try{


                lv = (ListView) findViewById(R.id.qstioncategory);

                JSONArray jsonarr = new JSONArray(displayText);

                // System.out.println("Array length :  " + jsonarr.length());
                //  Toast.makeText(getApplicationContext(), "array length is : "+jsonarr.length(), Toast.LENGTH_LONG).show();


                for (int i = 0; i < jsonarr.length(); i++) {

                    JSONObject jsonobj = jsonarr.getJSONObject(i);

                    HashMap<String, String>map=new HashMap<String, String>();
                    // map.put("id",jsonobj.getString("categoryid"));
                    //  map.put("name", jsonobj.getString("categoryname"));
                    pickuplist.add(jsonobj.getString("stupikid")+"-"+jsonobj.getString("stupikplace"));
                    // Toast.makeText(getApplicationContext(), "the value is : "+jsonobj.getString("categoryname"), Toast.LENGTH_LONG).show();

                }
                //   Toast.makeText(getApplicationContext(), "the value is : "+catlist.size(), Toast.LENGTH_LONG).show();

                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(DriverSelectActivity.this,android.R.layout.simple_list_item_1,pickuplist );

                lv.setAdapter(arrayAdapter);

                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> parent, final View view,
                                            int position, long id) {
                        String item[] = parent.getItemAtPosition(position).toString().split("-");

                       // WebService.invokedriverselectstu(driver,item[0],"driverselectstudentpickup");
                        //AsyncCallWS task = new AsyncCallWS();
                        //Call execute
                       // task.execute();
                        //Toast.makeText(getApplicationContext(), "clicked id is : "+item[0], Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(DriverSelectActivity.this, DriverStudentViewActivity.class);
                        intent.putExtra("drivername", driver);
                        intent.putExtra("pickupid", item[0]);
                        intent.putExtra("details",item[1]);
                        startActivity(intent);


                    }

                });





            }
            catch(Exception e){
                Toast.makeText(getApplicationContext(), "Error Occured!", Toast.LENGTH_LONG).show();

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

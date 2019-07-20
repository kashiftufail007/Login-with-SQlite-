package com.example.loginwithsqllite;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
     DataBaseHelper db;
    EditText e1,e2,e3;
    Button button,view, login;
    String user_name, email_address,user_password,user_contact;
    Integer user_id,user_type,user_status;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DataBaseHelper(this);
        e1 = (EditText) findViewById(R.id.email);
        e2 = (EditText) findViewById(R.id.password);
        e3 = (EditText) findViewById(R.id.cpassword);
       button = (Button) findViewById(R.id.button);
        view = (Button) findViewById(R.id.view);
        login = (Button) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
            view.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
               Log.d("Database "," Second Activity ...................................... ........");
                startActivity(intent);

            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String  s1 = e1.getText().toString();
                String  s2 = e2.getText().toString();
                String  s3 = e3.getText().toString();
                if (s1.equals("" )|| s2.equals("") || s3.equals("")){
                    Toast.makeText(getApplicationContext(), "Fill upper Fields First ", Toast.LENGTH_SHORT).show();
                }else if(!s2.toString().equals( s3.toString())) {
                    Toast.makeText(getApplicationContext(), "Password Does not match", Toast.LENGTH_SHORT).show();

                }else {

                        Boolean check_email = db.check_email(s1);
                        if (check_email == false){
                            Toast.makeText(getApplicationContext(), "Email Already Exists ", Toast.LENGTH_SHORT).show();

                        }else

                            Toast.makeText(getApplicationContext(), "New User Added ", Toast.LENGTH_SHORT).show();

                            db.insert(0, s1, s2, 1 );
                }

            }
        });

    }

}

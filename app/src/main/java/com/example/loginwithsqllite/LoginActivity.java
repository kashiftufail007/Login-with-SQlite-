package com.example.loginwithsqllite;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    Button  login;
    TextView email,password;
    DataBaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = (TextView)findViewById(R.id.email);
        password = (TextView)findViewById(R.id.password);
        login = (Button)findViewById(R.id.login);
        db = new DataBaseHelper(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursor = db.alldata();
                if (cursor.getCount() == 0) {
                    Toast.makeText(getApplicationContext(), "SQLite Empty ", Toast.LENGTH_SHORT).show();

                } else if (cursor.moveToFirst()){
                    String ema = email.getText().toString();
                    String pass = password.getText().toString();
                    for (int i=0 ; i<cursor.getCount();i++){

                        if ((ema.equals(cursor.getString(2).toString())) && (pass.equals(cursor.getString(3).toString()))) {

                            Toast.makeText(getApplicationContext(), "WELCOME", Toast.LENGTH_SHORT).show();

                            Intent intent = new Intent(LoginActivity.this, SecondActivity.class);

                            startActivity(intent);
                        }
                        cursor.moveToNext();

                    }
                }
            }
        });

    }
}

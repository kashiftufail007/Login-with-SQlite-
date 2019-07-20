package com.example.loginwithsqllite;

import android.database.Cursor;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    DataBaseHelper db;
    LinearLayout m_ll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        m_ll = (LinearLayout)findViewById(R.id.lay);
        db = new DataBaseHelper(this);
        Cursor cursor = db.alldata();
        if (cursor.getCount() == 0) {
            Toast.makeText(getApplicationContext(), "empaty ", Toast.LENGTH_SHORT).show();

        } else if (cursor.moveToFirst()){
           for (int i=0 ; i<cursor.getCount();i++){

                    TextView text = new TextView(this);
                    text.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                    LinearLayout.LayoutParams rel_button1 = new LinearLayout.LayoutParams(1500, 400);
                    rel_button1.setMargins(40, 200, 40, 200);
                    text.setText("  User #  "+i+ ":\n                     Email :   "+cursor.getString(2).toString()+"\n                     Password :"   +cursor.getString(3).toString() );
                    Toast.makeText(getApplicationContext(), cursor.getString(0), Toast.LENGTH_SHORT).show();
                    m_ll.addView(text);
                    cursor.moveToNext();
            }
        }


    }

}
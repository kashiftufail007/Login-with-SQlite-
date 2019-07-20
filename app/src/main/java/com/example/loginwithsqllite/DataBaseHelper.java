package com.example.loginwithsqllite;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataBaseHelper extends SQLiteOpenHelper {
    public DataBaseHelper(Context context) {

        super(context, "Store_User_Detail_SQLite", null, 1, null);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table user_detail(serial_number INTEGER  PRIMARY KEY AUTOINCREMENT, user_id INTEGER   , email_address text , user_password text, user_status INTEGER )");
        Log.d("Database Helper ", "Table  Created ........");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop  table if exists user_detail");
    }
    //    public void delete(){
//        SQLiteDatabase db = this.getWritableDatabase();
//        db.delete("user_detail", null, null);
//    }
    //insertion in database
    public  void insert (Integer user_id , String email_address , String user_password, Integer user_status){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues  = new ContentValues();
        contentValues.put("user_id", user_id);
        contentValues.put("email_address", email_address);
        contentValues.put("user_password", user_password);

        contentValues.put("user_status", user_status);

        long ins = db.insert("user_detail" , null , contentValues);
        Log.d("Database Helper ", " Data Inserted ........"+ user_id +     email_address+ "     " + user_password + user_status);
        if (ins == -1)
            Log.d(" sqlite ", " contain nothing................................................ ");
        else

            Log.d(" sqlite ", " have data .........................................");;
    }
    // check it either it already exist or not
    public  Boolean check_email(String email){
        SQLiteDatabase  db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from user_detail where email_address = ?",new String[]{email});
        Log.d("Database Helper ", "Check Email  ........");
        if (cursor.getCount()>0) return false;
        else return true;

    }
    public Cursor alldata(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from user_detail ", null);
        Log.d("Database Helper ", "All Data ........");
        return cursor;
    }

}

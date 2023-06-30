package com.example.demo;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import org.jetbrains.annotations.NotNull;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "data";
    private static final int DB_VER = 1;

    public DBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VER);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE users(first_name VARCHAR(20) Not Null, last_name TEXT NOT NUll ,address TEXT Not Null,city TEXT NOT NULL, state TEXT NOT NULL,pincode INT NOT NULL,Manufacturer TEXT NOT NULL, model TEXT NOT NULL, manu_year INT NOT NULL, mob Varchar(10) PRIMARY KEY, email TEXT)";
        sqLiteDatabase.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS data");
        onCreate(sqLiteDatabase);

    }

    public boolean registerUser(String tl1, String tl2, String tl3, String tl4, String tl5, String tl6, String tl7, String tl8, String tl9) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        try {
            contentValues.put("first_name", tl1);
            contentValues.put("last_name", tl2);
            contentValues.put("address", tl3);
            contentValues.put("city", tl4);
            contentValues.put("state", tl5);
            contentValues.put("pincode", Integer.parseInt(tl6));
            contentValues.put("Manufacturer", tl7);
            contentValues.put("model ", tl8);
            contentValues.put("manu_year ", tl9);
            sqLiteDatabase.insert("data", null, contentValues);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            sqLiteDatabase.close();
        }
    }

    @org.jetbrains.annotations.Nullable
    public Boolean storedetails(String mtl1, String etl2) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        try {
            contentValues.put("mob ", mtl1);
            contentValues.put("email ", etl2);
            sqLiteDatabase.insert("data", null, contentValues);
            return true;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        finally {
            {
                sqLiteDatabase.close();
            }
        }

    }
}

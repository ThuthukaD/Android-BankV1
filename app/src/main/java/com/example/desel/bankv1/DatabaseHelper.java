package com.example.desel.bankv1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper
{
    // VARIABLES

    // Database Related
    public static final String DATABASE_NAME = "bank.db";
    public static final String TABLE_NAME = "bank_data";
    public static final String COL1 = "ID";
    public static final String COL2 = "FirstAmount";
    public static final String COL3 = "Location";
    public static final String COL4 = "SecondAmount";
    public static final String COL5 = "Category";


    public DatabaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        Log.i("DatabaseHelper", "Creating Table");

        String createTable = ("CREATE TABLE " + TABLE_NAME +
                "(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "FirstAmount REAL," +
                "Location TEXT," +
                "SecondAmount REAL," +
                "Category TEXT)");
        db.execSQL(createTable);

        Log.i("DatabaseHelper", "Table Created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        Log.i("DatabaseHelper", "Dropped Table");

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean addData(double fAmount, String location, double sAmount,
                           String category)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        Log.i("DatabaseHelper", "Adding Data");
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, fAmount);
        contentValues.put(COL3, location);
        contentValues.put(COL4, sAmount);
        contentValues.put(COL5, category);

        Log.i("DatabaseHelper", "Potentially successful");

        long result = db.insert(TABLE_NAME, null, contentValues);

        if(result == -1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public Cursor getListContent()
    {
        SQLiteDatabase db = this.getWritableDatabase();

        Log.i("DatabaseHelper", "Getting Content from db");
        //Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME,null);
        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME + " ORDER BY " + COL1 + " DESC",null);
        //Cursor data = db.query("SELECT * FROM" + TABLE_NAME, rank, null, null, null, null, COL1 + "DESC");
        return data;
    }

    public Cursor getLastValue()
    {
        SQLiteDatabase db = this.getWritableDatabase();

        Log.i("DatabaseHelper", "Getting Content from db");
        //Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME,null);
        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME + " ORDER BY " + COL1 + " DESC LIMIT 1",null);
        //Cursor data = db.query("SELECT * FROM" + TABLE_NAME, rank, null, null, null, null, COL1 + "DESC");
        return data;
    }
}

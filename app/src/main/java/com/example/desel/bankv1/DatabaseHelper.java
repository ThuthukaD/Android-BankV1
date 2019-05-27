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
    public static final String DATABASE_NAME = "bank7.db";
    public static final String TABLE_NAME_CHEQUE = "cheque_data";
    public static final String COL1 = "ID";
    public static final String COL2 = "FirstAmount";
    public static final String COL3 = "Location";
    public static final String COL4 = "SecondAmount";
    public static final String COL5 = "Category";
    public static final String COL6 = "InitialAmount";
    public static final String COL7 = "Date";
    public static final String COL8 = "Card";
    public static final String COL9 = "CardNo";

    // Debugging
    private static final String TAG = "DatabaseHelper";


    public DatabaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        Log.i(TAG, "Creating Table");

        String createTable = ("CREATE TABLE " + TABLE_NAME_CHEQUE +
                "(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "FirstAmount REAL," +
                "Location TEXT," +
                "SecondAmount REAL," +
                "Category TEXT," +
                "InitialAmount REAL," +
                "Date TEXT," +
                "Card TEXT," +
                "CardNo TEXT)");
        db.execSQL(createTable);

        Log.i(TAG, TABLE_NAME_CHEQUE + " Table Created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        Log.i(TAG,  TABLE_NAME_CHEQUE + " Table Dropped");

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_CHEQUE);
        onCreate(db);
    }

    public boolean addData(double fAmount, String location, double sAmount,
                           String category, double iAmount, String date, String card,
                           String cardNo)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        Log.i(TAG, "Adding Data to " + TABLE_NAME_CHEQUE);
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL2, fAmount);
        contentValues.put(COL3, location);
        contentValues.put(COL4, sAmount);
        contentValues.put(COL5, category);
        contentValues.put(COL6, iAmount);
        contentValues.put(COL7, date);
        contentValues.put(COL8, card);
        contentValues.put(COL9, cardNo);

        long result = db.insert(TABLE_NAME_CHEQUE, null, contentValues);

        if(result == -1)
        {
            Log.i(TAG, "addData: Table Does Not Exist");
            return false;
        }
        else
        {
            Log.i(TAG, "addData: Successfully Inserted Data");
            return true;
        }
    }

    // Method for getting List Content for the Transaction History
    public Cursor getListContent()
    {
        SQLiteDatabase db = this.getWritableDatabase();

        Log.i(TAG, "Getting Content from " + TABLE_NAME_CHEQUE + " Table");

        // Used for the Cheque Transaction History
        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME_CHEQUE + " ORDER BY " +
                COL1 + " DESC",null);
        return data;

        // Future Tables can be placed here...
    }

    // Method for getting last Values for Available balances
    public Cursor getLastValue()
    {
        SQLiteDatabase db = this.getWritableDatabase();

        // Used for the Cheque Available Balances
        Log.i(TAG, "Getting Content from db");
        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME_CHEQUE +
                " ORDER BY " + COL1 + " DESC LIMIT 1",null);
        return data;

        // Future Tables can be placed here...
    }
}
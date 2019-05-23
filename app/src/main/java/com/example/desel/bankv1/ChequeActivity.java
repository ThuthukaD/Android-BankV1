package com.example.desel.bankv1;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class ChequeActivity extends AppCompatActivity
{
    // VARIABLES

    // Database Related
    DatabaseHelper myDB;

    // Buttons
    Button btnAdd;
    Button btnView;

    // Edit Texts
    EditText etFAmount;
    EditText etLocation;
    EditText etSAmount;
    EditText etCategory;
    EditText etDate;
    EditText etSpent;

    // Storing
    double fAmount;
    String location;
    double sAmount;
    String category;

    // Other
    ListView lvList;
    Spinner spinOptions;
    ArrayAdapter<CharSequence> adapterForSpinner;
    private static final String TAG = "ChequeActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheque);

        // INITIALISING

        // Database Related
        myDB = new DatabaseHelper(this);

        // Buttons
        btnAdd = findViewById(R.id.btnAdd);

        // Edit Texts
        etFAmount = findViewById(R.id.etFAmount);
        etLocation = findViewById(R.id.etLocation);
        etSAmount = findViewById(R.id.etSAmount);
        etCategory = findViewById(R.id.etCategory);
        etDate = findViewById(R.id.etDate);
        etSpent = findViewById(R.id.etSpent);

        // Other
        lvList = findViewById(R.id.lvChequeTransactions);
        spinOptions = findViewById(R.id.spinOptions);
        adapterForSpinner = ArrayAdapter.createFromResource(this, R.array.purchaseOptions,
                android.R.layout.simple_spinner_item);

        view();
        Log.i(TAG, "onCreate: List View Viewing");
    }

    private void view()
    {
        ArrayList<String> theList = new ArrayList<>();
        Cursor data = myDB.getListContent();

        if (data.getCount() == 0)
        {
            Toast.makeText
                    (this, "The database is empty",
                            Toast.LENGTH_SHORT).show();
        }
        else
        {
            while(data.moveToNext())
            {
                // This value is the column ID for the Items
                theList.add("    R" + data.getString(1) + " PURCHASE TO '" +
                        data.getString(2) + "' \n    R" +
                        data.getString(3) + " IS THE REMAINING AMOUNT \n" +
                        "    SPEND CATEGORY IS \'" +
                        data.getString(4) + "\'");

                ListAdapter listAdapter = new ArrayAdapter<>
                        // the list style which  is changeable
                        (this, android.R.layout.simple_expandable_list_item_1, theList);

                lvList.setAdapter(listAdapter);
            }
        }
    }
}
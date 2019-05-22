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
import android.widget.TextView;
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

        add();
        Log.i(TAG, "onCreate: Data Possibly Added");
        view();
        Log.i(TAG, "onCreate: List View Viewing");
        spinner();
        Log.i(TAG, "onCreate: Spinner Working");
    }

    private void add()
    {
        Log.i(TAG, "add: Button Clicked");
        btnAdd.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                fAmount = Double.parseDouble(etFAmount.getText().toString());
                location = etLocation.getText().toString();
                sAmount = Double.parseDouble(etSAmount.getText().toString());
                category = etCategory.getText().toString();

                if (etFAmount.length() != 0 && etLocation.length() != 0 &&
                        etSAmount.length() != 0 && etCategory.length() != 0)
                {
                    addData(fAmount, location, sAmount, category);
                    Log.i(TAG, "onClick: Data adding to db");

                    etFAmount.setText(null);
                    etLocation.setText(null);
                    etSAmount.setText(null);
                    etCategory.setText(null);

                    Log.i(TAG, "onClick: Fields Emptied");

                    view();

                    Log.i(TAG, "onClick: List View Updated again");
                }
                else
                {
                    Toast.makeText
                            (ChequeActivity.this, "Fields are empty!",
                                    Toast.LENGTH_SHORT).show();
                }
            }
        });
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
                theList.add("R" + data.getString(1) + " PURCHASE TO '" +
                        data.getString(2) + "' \nR" +
                        data.getString(3) + " IS THE REMAINING AMOUNT \n" +
                        "SPEND CATEGORY IS \'" +
                        data.getString(4) + "\'");

                ListAdapter listAdapter = new ArrayAdapter<>
                        // the list style which  is changeable
                        (this, android.R.layout.simple_list_item_1, theList);

                lvList.setAdapter(listAdapter);
            }
        }
    }

    public void addData(double fAmount, String location, double sAmount, String category)
    {
        boolean isInserted = myDB.addData(fAmount, location, sAmount, category);

        if (isInserted)
        {
            Toast.makeText
                    (this, "Successful",
                            Toast.LENGTH_SHORT).show();
            Log.i(TAG, "addData: Data was inserted");
        }
        else
        {
            Toast.makeText
                    (this, "Unsuccessful",
                            Toast.LENGTH_SHORT).show();
            Log.i(TAG, "addData: Data failed to insert");
        }
    }

    public void spinner()
    {
        adapterForSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinOptions.setAdapter(adapterForSpinner);
        spinOptions.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {

                if (parent.getItemIdAtPosition(position) == 1)
                {
                    Intent intent = new Intent
                            (ChequeActivity.this,
                                    ChequeAirtimeActivity.class);
                    startActivity(intent);

                    Toast.makeText
                            (getBaseContext(), parent.getItemAtPosition(position) +
                                    " is selected", Toast.LENGTH_LONG).show();
                }
                else if (parent.getItemIdAtPosition(position) == 2)
                {
                    Intent intent = new Intent
                            (ChequeActivity.this,
                                    ChequeDataActivity.class);
                    startActivity(intent);

                    Toast.makeText
                            (getBaseContext(), parent.getItemAtPosition(position) +
                                    " is selected", Toast.LENGTH_LONG).show();
                }
                else if (parent.getItemIdAtPosition(position) == 3)
                {
                    Intent intent = new Intent
                            (ChequeActivity.this,
                                    ChequeElectricityActivity.class);
                    startActivity(intent);

                    Toast.makeText
                            (getBaseContext(), parent.getItemAtPosition(position) +
                                    " is selected", Toast.LENGTH_LONG).show();
                }
                else if (parent.getItemIdAtPosition(position) == 4)
                {
                    Intent intent = new Intent
                            (ChequeActivity.this,
                                    ChequeFoodActivity.class);
                    startActivity(intent);

                    Toast.makeText
                            (getBaseContext(), parent.getItemAtPosition(position) +
                                    " is selected", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });
    }
}
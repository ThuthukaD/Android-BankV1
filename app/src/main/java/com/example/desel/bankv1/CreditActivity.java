package com.example.desel.bankv1;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CreditActivity extends AppCompatActivity
{
    // VARIABLES

    // Database Related
    DatabaseHelper myDB;

    // Text Views
    TextView tvAmount;

    // Edit Texts
    EditText etIAmount;

    // Other
    ListView lvList;

    // Debugging
    private static final String TAG = "CreditActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit);

        // INITIALISING

        // Database Related
        myDB = new DatabaseHelper(this);

        // Text Views
        tvAmount = findViewById(R.id.tvAmount);

        // Edit Texts
        etIAmount = findViewById(R.id.etIAmount);

        // Other
        lvList = findViewById(R.id.lvChequeTransactions);

        viewTransactionHistory();
        Log.i(TAG, "onCreate: List View Viewing");
        viewAmount();
    }

    private void viewTransactionHistory()
    {
        ArrayList<String> theList = new ArrayList<>();
        Cursor data = myDB.getListContentCredit();

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
                theList.add("\n    " + String.format("R%.2f", data.getDouble(5)) + " WAS HOW MUCH YOU HAD\n" +
                        "    " + String.format("R%.2f", data.getDouble(1)) + " PURCHASE MADE TO '" +
                        data.getString(2) + "\'\n" +
                        "'   " + String.format("R%.2f", data.getDouble(3)) + " IS THE REMAINING AMOUNT \n" +
                        "    SPEND CATEGORY IS \'" +
                        data.getString(4) + "\'\n" +
                        "    ON \'" + data.getString(7) + "\' ACCOUNT\n" +
                        "    ACCOUNT NO. '" + data.getString(8) + "\'\n" +
                        "    TIMESTAMP WAS \'" + data.getString(6) + "\'\n");

                ListAdapter listAdapter = new ArrayAdapter<>
                        // the list style which  is changeable
                        (this, android.R.layout.simple_list_item_1, theList);

                lvList.setAdapter(listAdapter);
            }
        }
    }

    private void viewAmount()
    {
        Cursor data = myDB.getLastValueCredit();

        if (data.getCount() == 0)
        {
            Toast.makeText
                    (this, "The database is empty",
                            Toast.LENGTH_SHORT).show();
        }
        else
        {
            while (data.moveToNext())
            {
                // This value is the column ID for the Items
                etIAmount.setText("" + String.format("R%.2f", data.getDouble(3)));

                tvAmount.setText("" + etIAmount.getText().toString());
            }
        }
    }
}
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

    // Text Views
    TextView tvAmount;

    // Edit Texts
    EditText etIAmount;

    // Other
    ListView lvList;
    private static final String TAG = "ChequeActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheque);

        // INITIALISING

        // Database Related
        myDB = new DatabaseHelper(this);

        // Text Views
        tvAmount = findViewById(R.id.tvAmount);

        // Edit Texts
        etIAmount = findViewById(R.id.etIAmount);

        // Other
        lvList = findViewById(R.id.lvChequeTransactions);

        view();
        Log.i(TAG, "onCreate: List View Viewing");
        viewAmount();
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
                theList.add("\n    R" + data.getString(5) + " WAS HOW MUCH YOU HAD\n" +
                        "    R" + data.getString(1) + " PURCHASE MADE TO '" +
                        data.getString(2) + "\'\n" +
                        "'   R" + data.getString(3) + " IS THE REMAINING AMOUNT \n" +
                        "    SPEND CATEGORY IS \'" +
                        data.getString(4) + "\'\n" +
                        "    ON \'" + data.getString(7) + "\' ACCOUNT\n" +
                        "    ACCOUNT NO. XXXX XXXX XXXX XXXX \n" +
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
        Cursor data = myDB.getLastValue();

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
                etIAmount.setText("" + data.getString(3));

                tvAmount.setText("R" + etIAmount.getText().toString());
            }
        }
    }
}
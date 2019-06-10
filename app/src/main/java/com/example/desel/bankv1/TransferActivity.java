package com.example.desel.bankv1;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Date;

public class TransferActivity extends AppCompatActivity
{
    // VARIABLES

    // Database Related
    DatabaseHelper myDB;

    // Spinners
    Spinner spinOptionsCard1;
    Spinner spinOptionsCard2;
    ArrayAdapter<CharSequence> adapterForSpinnerCard;

    // Text Views
    TextView tvAmount1;
    TextView tvAmount2;
    TextView tvConfirmation;

    // Edit Texts
    EditText etTransferAmount;
    EditText etIAmount1;
    EditText etIAmount2;
    EditText etCard1;
    EditText etCard2;
    EditText etCardNo1;
    EditText etCardNo2;
    EditText etFAmount;
    EditText etLocation;
    EditText etSAmount;
    EditText etCategory;
    EditText etDate;
    EditText etSpent;

    // Buttons
    Button btnBuy;

    // Storing
    double iAmount;
    double fAmount;
    String location;
    double sAmount;
    String category;
    double spent;
    String date = DateFormat.getDateTimeInstance()
            .format(new Date());
    String card;
    String cardNo;

    // Debugging
    private static final String TAG = "BuyActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer);

        // INITIALISING

        // Database Related
        myDB = new DatabaseHelper(this);

        // Spinners
        spinOptionsCard1 = findViewById(R.id.spinOptionsCard1);
        spinOptionsCard2 = findViewById(R.id.spinOptionsCard2);
        adapterForSpinnerCard = ArrayAdapter.createFromResource(this, R.array.cardOptions,
                android.R.layout.simple_spinner_item);

        // Text Views
        tvAmount1 = findViewById(R.id.tvAmount1);
        tvAmount2 = findViewById(R.id.tvAmount2);
        tvConfirmation = findViewById(R.id.tvConfirmation);

        // Edit Texts
        etTransferAmount = findViewById(R.id.etTransferAmount);
        etIAmount1 = findViewById(R.id.etIAmount1);
        etIAmount2 = findViewById(R.id.etIAmount2);
        etCard1 = findViewById(R.id.etCard1);
        etCard2 = findViewById(R.id.etCard2);
        etCardNo1 = findViewById(R.id.etCardNo1);
        etCardNo2 = findViewById(R.id.etCardNo2);
        etFAmount = findViewById(R.id.etFAmount);
        etLocation = findViewById(R.id.etLocation);
        etSAmount = findViewById(R.id.etSAmount);
        etCategory = findViewById(R.id.etCategory);
        etDate = findViewById(R.id.etDate);
        etSpent = findViewById(R.id.etSpent);

        // Buttons
        btnBuy = findViewById(R.id.btnBuy);

        spinnerCardSelection1();
        spinnerCardSelection2();

        etDate.setText(date);
        etCategory.setText("Transfer");

        getThings();
    }

    public void spinnerCardSelection1()
    {
        adapterForSpinnerCard.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinOptionsCard1.setAdapter(adapterForSpinnerCard);

        spinOptionsCard1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {

                if (parent.getItemIdAtPosition(position) == 0)
                {
                    Log.i(TAG, "onItemSelected: " + parent.getItemAtPosition(position)
                            + " selected");
                }
                else if (parent.getItemIdAtPosition(position) == 1)
                {
                    Log.i(TAG, "onItemSelected: " + parent.getItemAtPosition(position)
                            + " selected");

                    viewChequeAmount1();

                    Toast.makeText
                            (getBaseContext(), parent.getItemAtPosition(position) +
                                    " is selected", Toast.LENGTH_LONG).show();

                    etCard1.setText("" + parent.getItemAtPosition(position));
                    etCardNo1.setText("6252 5166 0967 5245");
                    etLocation.setText("" + parent.getItemAtPosition(position));

                    spinOptionsCard2.setVisibility(View.VISIBLE);
                }
                else if (parent.getItemIdAtPosition(position) == 2)
                {
                    Log.i(TAG, "onItemSelected: " + parent.getItemAtPosition(position)
                            + " selected");

                    viewCreditAmount1();

                    etCard1.setText("" + parent.getItemAtPosition(position));
                    etCardNo1.setText("8763 4125 0069 7366");
                    etLocation.setText("" + parent.getItemAtPosition(position));

                    spinOptionsCard2.setVisibility(View.VISIBLE);
                }
                else if (parent.getItemIdAtPosition(position) == 3)
                {
                    Log.i(TAG, "onItemSelected: " + parent.getItemAtPosition(position)
                            + " selected");

                    viewSavingsAmount1();

                    etCard1.setText("" + parent.getItemAtPosition(position));
                    etCardNo1.setText("6564 7512 7984 7245");
                    etLocation.setText("" + parent.getItemAtPosition(position));

                    spinOptionsCard2.setVisibility(View.VISIBLE);
                }
                else if (parent.getItemIdAtPosition(position) == 4)
                {
                    Log.i(TAG, "onItemSelected: " + parent.getItemAtPosition(position)
                            + " selected");

                    viewBusinessAmount1();

                    etCard1.setText("" + parent.getItemAtPosition(position));
                    etCardNo1.setText("7152 5363 9541 5625");
                    etLocation.setText("" + parent.getItemAtPosition(position));

                    spinOptionsCard2.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });
    }

    public void spinnerCardSelection2()
    {
        adapterForSpinnerCard.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinOptionsCard2.setAdapter(adapterForSpinnerCard);

        spinOptionsCard2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {

                if (parent.getItemIdAtPosition(position) == 0)
                {
                    Log.i(TAG, "onItemSelected: " + parent.getItemAtPosition(position)
                            + " selected");
                }
                else if (parent.getItemIdAtPosition(position) == 1)
                {
                    Log.i(TAG, "onItemSelected: " + parent.getItemAtPosition(position)
                            + " selected");

                    viewChequeAmount2();

                    Toast.makeText
                            (getBaseContext(), parent.getItemAtPosition(position) +
                                    " is selected", Toast.LENGTH_LONG).show();

                    etCard2.setText("" + parent.getItemAtPosition(position));
                    etCardNo2.setText("6252 5166 0967 5245");

                    btnBuy.setVisibility(View.VISIBLE);
                }
                else if (parent.getItemIdAtPosition(position) == 2)
                {
                    Log.i(TAG, "onItemSelected: " + parent.getItemAtPosition(position)
                            + " selected");

                    viewCreditAmount2();

                    etCard2.setText("" + parent.getItemAtPosition(position));
                    etCardNo2.setText("8763 4125 0069 7366");

                    btnBuy.setVisibility(View.VISIBLE);
                }
                else if (parent.getItemIdAtPosition(position) == 3)
                {
                    Log.i(TAG, "onItemSelected: " + parent.getItemAtPosition(position)
                            + " selected");

                    viewSavingsAmount2();

                    etCard2.setText("" + parent.getItemAtPosition(position));
                    etCardNo2.setText("6564 7512 7984 7245");

                    btnBuy.setVisibility(View.VISIBLE);
                }
                else if (parent.getItemIdAtPosition(position) == 4)
                {
                    Log.i(TAG, "onItemSelected: " + parent.getItemAtPosition(position)
                            + " selected");

                    viewBusinessAmount2();

                    etCard2.setText("" + parent.getItemAtPosition(position));
                    etCardNo2.setText("7152 5363 9541 5625");

                    btnBuy.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });
    }

    private void viewChequeAmount1()
    {
        Cursor data = myDB.getLastValueCheque();

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
                Log.i(TAG, "viewChequeAmount: Setting the initial amount");

                // This value is the column ID for the Items
                // Sets the etIAmount and tvAmount
                etIAmount1.setText("" + String.format("%.2f", data.getDouble(3)));

                tvAmount1.setText("R" + etIAmount1.getText().toString());
            }
        }
    }

    private void viewChequeAmount2()
    {
        Cursor data = myDB.getLastValueCheque();

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
                Log.i(TAG, "viewChequeAmount: Setting the initial amount");

                // This value is the column ID for the Items
                // Sets the etIAmount and tvAmount
                etIAmount2.setText("" + String.format("%.2f", data.getDouble(3)));

                tvAmount2.setText("R" + etIAmount2.getText().toString());
            }
        }
    }

    private void viewCreditAmount1()
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
            while(data.moveToNext())
            {
                Log.i(TAG, "viewCreditAmount: Setting the initial amount");

                // This value is the column ID for the Items
                // Sets the etIAmount and tvAmount
                etIAmount1.setText("" + String.format("%.2f", data.getDouble(3)));

                tvAmount1.setText("R" + etIAmount1.getText().toString());
            }
        }
    }

    private void viewCreditAmount2()
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
            while(data.moveToNext())
            {
                Log.i(TAG, "viewCreditAmount: Setting the initial amount");

                // This value is the column ID for the Items
                // Sets the etIAmount and tvAmount
                etIAmount2.setText("" + String.format("%.2f", data.getDouble(3)));

                tvAmount2.setText("R" + etIAmount2.getText().toString());
            }
        }
    }

    private void viewSavingsAmount1()
    {
        Cursor data = myDB.getLastValueSavings();

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
                Log.i(TAG, "viewSavingsAmount: Setting the initial amount");

                // This value is the column ID for the Items
                // Sets the etIAmount and tvAmount
                etIAmount1.setText("" + String.format("%.2f", data.getDouble(3)));

                tvAmount1.setText("R" + etIAmount1.getText().toString());
            }
        }
    }

    private void viewSavingsAmount2()
    {
        Cursor data = myDB.getLastValueSavings();

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
                Log.i(TAG, "viewSavingsAmount: Setting the initial amount");

                // This value is the column ID for the Items
                // Sets the etIAmount and tvAmount
                etIAmount2.setText("" + String.format("%.2f", data.getDouble(3)));

                tvAmount2.setText("R" + etIAmount2.getText().toString());
            }
        }
    }

    private void viewBusinessAmount1()
    {
        Cursor data = myDB.getLastValueBusiness();

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
                Log.i(TAG, "viewBusinessAmount: Setting the initial amount");

                // This value is the column ID for the Items
                // Sets the etIAmount and tvAmount
                etIAmount1.setText("" + String.format("%.2f", data.getDouble(3)));

                tvAmount1.setText("R" + etIAmount1.getText().toString());
            }
        }
    }

    private void viewBusinessAmount2()
    {
        Cursor data = myDB.getLastValueBusiness();

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
                Log.i(TAG, "viewBusinessAmount: Setting the initial amount");

                // This value is the column ID for the Items
                // Sets the etIAmount and tvAmount
                etIAmount2.setText("" + String.format("%.2f", data.getDouble(3)));

                tvAmount2.setText("R" + etIAmount2.getText().toString());
            }
        }
    }

    public void getThings()
    {
        Log.i(TAG, "getThings: Attempting to get Extras from MainActivity");

        Bundle extras = getIntent().getExtras();
        if (extras != null)
        {
            String location = extras.getString("location");
            String category = extras.getString("category2");
            double spent = extras.getDouble("spent");
            String card = extras.getString("card2");
            int btnOn = extras.getInt("buttonOn");
            String cardNo = extras.getString("cardNo3");
            String data = extras.getString("data", "nothing selected yet");
            double iamount = extras.getDouble("iamount2");

            etLocation.setText(location);
            etCategory.setText(category);
            etSpent.setText("" + spent);
            etCard1.setText(card);
            etCardNo1.setText(cardNo);
            etCardNo2.setText(cardNo);
            etIAmount1.setText("" + String.format("%.2f", iamount));

            if (etCategory.getText().toString().equals("Airtime"))
            {
                tvConfirmation.setText("Are you sure you want to purchase " +
                        category + " worth " + String.format("R%.2f", spent) + " on your " +
                        card + " account?");
            }
            else if (etCategory.getText().toString().equals("Data"))
            {
                tvConfirmation.setText("Are you sure you want to purchase " +
                        category + " of " + data + " worth " + String.format("R%.2f", spent) +
                        " on your " + card + " account?");
            }
            else if (etCategory.getText().toString().equals("Electricity"))
            {
                tvConfirmation.setText("Are you sure you want to purchase " +
                        category + " worth " + String.format("R%.2f", spent) + " on your " +
                        card + " account?");
            }
            else if (etCategory.getText().toString().equals("Food"))
            {
                tvConfirmation.setText("Are you sure you want to purchase " +
                        category + " worth " + String.format("R%.2f", spent) + " on your " +
                        card + " account?");
            }
            else
            {
                // does nothing
                Log.i(TAG, "getThings: No Data Found in data Yet");
            }


            Log.i(TAG, "getThings: Receiving Extras Successful");

            // Check to see if requirements were met to activate the Buy button
            if (btnOn == 9999)
            {
                Log.i(TAG, "getThings: btnBuy Requirements Were Met");

                btnBuy.setVisibility(View.VISIBLE);
                tvConfirmation.setVisibility(View.VISIBLE);
            }
            else
            {
                // Does nothing
                Log.i(TAG, "getThings: btnBuy Requirements Were Not Met");
            }

            // Sets the default Initial Amount to R99999.99 if db was empty
            if (etIAmount1.getText().toString().equals("0.00"))
            {
                Log.i(TAG, "getThings: Initial Amount Set to R99999.99 for Database");
                etIAmount1.setText("" + 99999.99);
            }
        }
    }
}

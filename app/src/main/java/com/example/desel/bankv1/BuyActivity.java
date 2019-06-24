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
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Date;

public class BuyActivity extends AppCompatActivity
{
    // VARIABLES

    // Database Related
    DatabaseHelper myDB;

    // Spinners
    Spinner spinOptions;
    Spinner spinOptionsCard;
    ArrayAdapter<CharSequence> adapterForSpinner;
    ArrayAdapter<CharSequence> adapterForSpinnerCard;

    // Text Views
    TextView tvAmount;
    TextView tvConfirmation;

    // Edit Texts
    EditText etIAmount;
    EditText etFAmount;
    EditText etLocation;
    EditText etSAmount;
    EditText etCategory;
    EditText etDate;
    EditText etSpent;
    EditText etCard;
    EditText etCardNo;

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
    String cardTransferredTo = "null";

    // Debugging
    private static final String TAG = "BuyActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy);

        // INITIALISING

        // Database Related
        myDB = new DatabaseHelper(this);

        // Spinners
        spinOptions = findViewById(R.id.spinOptions);
        spinOptionsCard = findViewById(R.id.spinOptionsCard);
        adapterForSpinner = ArrayAdapter.createFromResource(this, R.array.purchaseOptions,
                android.R.layout.simple_spinner_item);
        adapterForSpinnerCard = ArrayAdapter.createFromResource(this, R.array.cardOptions,
                android.R.layout.simple_spinner_item);

        // Text Views
        tvAmount = findViewById(R.id.tvAmount);
        tvConfirmation = findViewById(R.id.tvConfirmation);

        // Edit Texts
        etIAmount = findViewById(R.id.etIAmount);
        etFAmount = findViewById(R.id.etFAmount);
        etLocation = findViewById(R.id.etLocation);
        etSAmount = findViewById(R.id.etSAmount);
        etCategory = findViewById(R.id.etCategory);
        etDate = findViewById(R.id.etDate);
        etSpent = findViewById(R.id.etSpent);
        etCard = findViewById(R.id.etCard);
        etCardNo = findViewById(R.id.etCaardNo);

        // Buttons
        btnBuy = findViewById(R.id.btnBuy);

        add();
        spinnerCardSelection();
        spinnerPurchaseSelection();
        //viewChequeAmount();
        getThings();

        etDate.setText(date);
    }

    private void add()
    {
        btnBuy.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Log.i(TAG, "add: btnAdd Clicked");
                Log.i(TAG, "onClick: Pulling Initial Text");

                // Pulling initial text
                iAmount = Double.parseDouble(etIAmount.getText().toString());
                location = etLocation.getText().toString();
                category = etCategory.getText().toString();
                spent = Double.parseDouble(etSpent.getText().toString());

                Log.i(TAG, "onClick: Pulled Initial Text");
                Log.i(TAG, "onClick: Setting Text for fAmount");

                // Setting text for fAmount
                fAmount = spent;
                etFAmount.setText("" + fAmount);

                Log.i(TAG, "onClick: Set Text for fAmount");
                Log.i(TAG, "onClick: Setting Text for sAmount");

                // Setting text for sAmount
                sAmount = iAmount - fAmount;
                etSAmount.setText("" + sAmount);

                Log.i(TAG, "onClick: Set Text for sAmount");
                Log.i(TAG, "onClick: Pulling Additional Text");

                // Pulling new text
                fAmount = Double.parseDouble(etFAmount.getText().toString());
                sAmount = Double.parseDouble(etSAmount.getText().toString());
                card = etCard.getText().toString();
                cardNo = etCardNo.getText().toString();

                Log.i(TAG, "onClick: Successfully Pulled All Text");
                Log.i(TAG, "onClick: Checking for any Blank Fields");

                if (etFAmount.length() != 0 && etLocation.length() != 0 &&
                        etSAmount.length() != 0 && etCategory.length() != 0 &&
                        etSpent.length() != 0 && etCard.length() != 0 && etCardNo.length() != 0)
                {
                    Log.i(TAG, "onClick: Fields Are Not Empty");

                    if (etCard.getText().toString().equals("Cheque"))
                    {
                        addDataCheque(fAmount, location, sAmount, category, iAmount, date, card,
                                cardNo, cardTransferredTo);

                        Log.i(TAG, "onClick: Data Adding to Database");

                        etIAmount.setText(null);
                        etFAmount.setText(null);
                        etLocation.setText(null);
                        etSAmount.setText(null);
                        etCategory.setText(null);
                        etSpent.setText(null);
                        etCard.setText(null);
                        etCardNo.setText(null);

                        Log.i(TAG, "onClick: Fields Emptied");
                        Log.i(TAG, "onClick: Closing All Old Activities");

//                    Intent intent = new Intent
//                        (BuyActivity.this, MainActivity.class);
//                    startActivity(intent);

                        // Intent to close all other activities except for main and login
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        intent.putExtra("EXIT", true);
                        startActivity(intent);
                    }
                    else if (etCard.getText().toString().equals("Credit"))
                    {
                        addDataCredit(fAmount, location, sAmount, category, iAmount, date, card,
                                cardNo, cardTransferredTo);

                        Log.i(TAG, "onClick: Data Adding to Database");

                        etIAmount.setText(null);
                        etFAmount.setText(null);
                        etLocation.setText(null);
                        etSAmount.setText(null);
                        etCategory.setText(null);
                        etSpent.setText(null);
                        etCard.setText(null);
                        etCardNo.setText(null);

                        Log.i(TAG, "onClick: Fields Emptied");
                        Log.i(TAG, "onClick: Closing All Old Activities");

//                    Intent intent = new Intent
//                        (BuyActivity.this, MainActivity.class);
//                    startActivity(intent);

                        // Intent to close all other activities except for main and login
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        intent.putExtra("EXIT", true);
                        startActivity(intent);
                    }
                    else if (etCard.getText().toString().equals("Savings"))
                    {
                        addDataSavings(fAmount, location, sAmount, category, iAmount, date, card,
                                cardNo, cardTransferredTo);

                        Log.i(TAG, "onClick: Data Adding to Database");

                        etIAmount.setText(null);
                        etFAmount.setText(null);
                        etLocation.setText(null);
                        etSAmount.setText(null);
                        etCategory.setText(null);
                        etSpent.setText(null);
                        etCard.setText(null);
                        etCardNo.setText(null);

                        Log.i(TAG, "onClick: Fields Emptied");
                        Log.i(TAG, "onClick: Closing All Old Activities");

//                    Intent intent = new Intent
//                        (BuyActivity.this, MainActivity.class);
//                    startActivity(intent);

                        // Intent to close all other activities except for main and login
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        intent.putExtra("EXIT", true);
                        startActivity(intent);
                    }
                    else if (etCard.getText().toString().equals("Business"))
                    {
                        addDataBusiness(fAmount, location, sAmount, category, iAmount, date, card,
                                cardNo, cardTransferredTo);

                        Log.i(TAG, "onClick: Data Adding to Database");

                        etIAmount.setText(null);
                        etFAmount.setText(null);
                        etLocation.setText(null);
                        etSAmount.setText(null);
                        etCategory.setText(null);
                        etSpent.setText(null);
                        etCard.setText(null);
                        etCardNo.setText(null);

                        Log.i(TAG, "onClick: Fields Emptied");
                        Log.i(TAG, "onClick: Closing All Old Activities");

//                    Intent intent = new Intent
//                        (BuyActivity.this, MainActivity.class);
//                    startActivity(intent);

                        // Intent to close all other activities except for main and login
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        intent.putExtra("EXIT", true);
                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(BuyActivity.this,
                                "No matching cards were found",
                                Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Log.i(TAG, "onClick: Some Fields Were Empty");

                    Toast.makeText
                            (BuyActivity.this, "Fields are empty!",
                                    Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void addDataCheque(double fAmount, String location, double sAmount, String category,
                        double iAmount, String date, String card, String cardNo, String cardTransferredTo)
    {
        boolean isInserted = myDB.addDataCheque(fAmount, location, sAmount, category,
                iAmount, date, card, cardNo, cardTransferredTo);

        if (isInserted)
        {
            Toast.makeText
                    (this, "Successful",
                            Toast.LENGTH_SHORT).show();

            Log.i(TAG, "addData: The Data Was Added Successfully to the Database");
        }
        else
        {
            Toast.makeText
                    (this, "Unsuccessful",
                            Toast.LENGTH_SHORT).show();

            Log.i(TAG, "addData: The Data Could Not Be Added to the Database");
        }
    }

    public void addDataCredit(double fAmount, String location, double sAmount, String category,
                              double iAmount, String date, String card, String cardNo, String cardTransferredTo)
    {
        boolean isInserted = myDB.addDataCredit(fAmount, location, sAmount, category,
                iAmount, date, card, cardNo, cardTransferredTo);

        if (isInserted)
        {
            Toast.makeText
                    (this, "Successful",
                            Toast.LENGTH_SHORT).show();

            Log.i(TAG, "addData: The Data Was Added Successfully to the Database");
        }
        else
        {
            Toast.makeText
                    (this, "Unsuccessful",
                            Toast.LENGTH_SHORT).show();

            Log.i(TAG, "addData: The Data Could Not Be Added to the Database");
        }
    }

    public void addDataSavings(double fAmount, String location, double sAmount, String category,
                              double iAmount, String date, String card, String cardNo, String cardTransferredTo)
    {
        boolean isInserted = myDB.addDataSavings(fAmount, location, sAmount, category,
                iAmount, date, card, cardNo, cardTransferredTo);

        if (isInserted)
        {
            Toast.makeText
                    (this, "Successful",
                            Toast.LENGTH_SHORT).show();

            Log.i(TAG, "addData: The Data Was Added Successfully to the Database");
        }
        else
        {
            Toast.makeText
                    (this, "Unsuccessful",
                            Toast.LENGTH_SHORT).show();

            Log.i(TAG, "addData: The Data Could Not Be Added to the Database");
        }
    }

    public void addDataBusiness(double fAmount, String location, double sAmount, String category,
                              double iAmount, String date, String card, String cardNo, String cardTransferredTo)
    {
        boolean isInserted = myDB.addDataBusiness(fAmount, location, sAmount, category,
                iAmount, date, card, cardNo, cardTransferredTo);

        if (isInserted)
        {
            Toast.makeText
                    (this, "Successful",
                            Toast.LENGTH_SHORT).show();

            Log.i(TAG, "addData: The Data Was Added Successfully to the Database");
        }
        else
        {
            Toast.makeText
                    (this, "Unsuccessful",
                            Toast.LENGTH_SHORT).show();

            Log.i(TAG, "addData: The Data Could Not Be Added to the Database");
        }
    }

    public void spinnerCardSelection()
    {
        adapterForSpinnerCard.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinOptionsCard.setAdapter(adapterForSpinnerCard);
        spinOptionsCard.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
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

                    viewChequeAmount();

                    Toast.makeText
                            (getBaseContext(), parent.getItemAtPosition(position) +
                                    " is selected", Toast.LENGTH_LONG).show();

                    Bundle extras = getIntent().getExtras();
                    if (extras != null)
                    {
                        Log.i(TAG, "onItemSelected: Got Values From Intent Extra");

                        String cardNoCheque = extras.getString("cardNoCheque");

                        etCardNo.setText(cardNoCheque);

                        etCard.setText("" + parent.getItemAtPosition(position));

                        spinOptions.setVisibility(View.VISIBLE);
                    }
                }
                else if (parent.getItemIdAtPosition(position) == 2)
                {
                    Log.i(TAG, "onItemSelected: " + parent.getItemAtPosition(position)
                            + " selected");

                    viewCreditAmount();

                    Bundle extras = getIntent().getExtras();
                    if (extras != null)
                    {
                        Log.i(TAG, "onItemSelected: Got Values From Intent Extra");

                        String cardNoCredit = extras.getString("cardNoCredit");

                        etCardNo.setText(cardNoCredit);

                        etCard.setText("" + parent.getItemAtPosition(position));

                        spinOptions.setVisibility(View.VISIBLE);
                    }
                }
                else if (parent.getItemIdAtPosition(position) == 3)
                {
                    Log.i(TAG, "onItemSelected: " + parent.getItemAtPosition(position)
                            + " selected");

                    viewSavingsAmount();

                    Bundle extras = getIntent().getExtras();
                    if (extras != null)
                    {
                        Log.i(TAG, "onItemSelected: Got Values From Intent Extra");

                        String cardNoSavings = extras.getString("cardNoSavings");

                        etCardNo.setText(cardNoSavings);

                        etCard.setText("" + parent.getItemAtPosition(position));

                        spinOptions.setVisibility(View.VISIBLE);
                    }
                }
                else if (parent.getItemIdAtPosition(position) == 4)
                {
                    Log.i(TAG, "onItemSelected: " + parent.getItemAtPosition(position)
                            + " selected");

                    viewBusinessAmount();

                    Bundle extras = getIntent().getExtras();
                    if (extras != null)
                    {
                        Log.i(TAG, "onItemSelected: Got Values From Intent Extra");

                        String cardNoBusiness = extras.getString("cardNoBusiness");

                        etCardNo.setText(cardNoBusiness);

                        etCard.setText("" + parent.getItemAtPosition(position));

                        spinOptions.setVisibility(View.VISIBLE);
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });
    }

    public void spinnerPurchaseSelection()
    {
        adapterForSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinOptions.setAdapter(adapterForSpinner);
        spinOptions.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {

                if (parent.getItemIdAtPosition(position) == 0)
                {
                    Log.i(TAG, "onItemSelected: " + parent.getItemAtPosition(position)
                            + " selected");

                    parent.setSelection(0);
                }
                else if (parent.getItemIdAtPosition(position) == 1)
                {
                    Log.i(TAG, "onItemSelected: " + parent.getItemAtPosition(position)
                            + " selected");
                    Log.i(TAG, "onItemSelected: Getting Category");

                    etCategory.setText(""+ parent.getItemAtPosition(position));

                    Intent intent = new Intent
                            (BuyActivity.this, BuyAirtimeActivity.class);
                    Bundle extras = new Bundle();

                    Log.i(TAG, "onItemSelected: Starting BuyAirtimeActivity");

                    extras.putString("category", etCategory.getText().toString());
                    extras.putString("card", etCard.getText().toString());
                    extras.putString("cardNo2", etCardNo.getText().toString());
                    extras.putDouble("iamount", Double.parseDouble(etIAmount.getText().toString()));

                    Log.i(TAG, "onItemSelected: Sending IAmount as " + Double.parseDouble(etIAmount.getText().toString()));
                    Log.i(TAG, "onItemSelected: Sending Category as: " + etCategory.getText().toString());
                    Log.i(TAG, "onItemSelected: Sending Card as: " + etCard.getText().toString());

                    intent.putExtras(extras);
                    startActivity(intent);
                    finish();

                    Toast.makeText
                            (getBaseContext(), parent.getItemAtPosition(position) +
                                    " is selected", Toast.LENGTH_LONG).show();

                    parent.setSelection(0);
                }
                else if (parent.getItemIdAtPosition(position) == 2)
                {
                    Log.i(TAG, "onItemSelected: " + parent.getItemAtPosition(position)
                            + " selected");
                    Log.i(TAG, "onItemSelected: Getting Category");

                    etCategory.setText(""+ parent.getItemAtPosition(position));

                    Intent intent = new Intent
                            (BuyActivity.this, BuyDataActivity.class);
                    Bundle extras = new Bundle();

                    Log.i(TAG, "onItemSelected: Starting BuyAirtimeActivity");

                    extras.putString("category", etCategory.getText().toString());
                    extras.putString("card", etCard.getText().toString());
                    extras.putString("cardNo2", etCardNo.getText().toString());
                    extras.putDouble("iamount", Double.parseDouble(etIAmount.getText().toString()));

                    Log.i(TAG, "onItemSelected: Sending IAmount as " + Double.parseDouble(etIAmount.getText().toString()));
                    Log.i(TAG, "onItemSelected: Sending Category as: " + etCategory.getText().toString());
                    Log.i(TAG, "onItemSelected: Sending Card as: " + etCard.getText().toString());

                    intent.putExtras(extras);
                    startActivity(intent);
                    finish();

                    Toast.makeText
                            (getBaseContext(), parent.getItemAtPosition(position) +
                                    " is selected", Toast.LENGTH_LONG).show();

                    parent.setSelection(0);
                }
                else if (parent.getItemIdAtPosition(position) == 3)
                {
                    Log.i(TAG, "onItemSelected: " + parent.getItemAtPosition(position)
                            + " selected");
                    Log.i(TAG, "onItemSelected: Getting Category");

                    etCategory.setText(""+ parent.getItemAtPosition(position));

                    Intent intent = new Intent
                            (BuyActivity.this, BuyElectricityActivity.class);
                    Bundle extras = new Bundle();

                    Log.i(TAG, "onItemSelected: Starting BuyAirtimeActivity");

                    extras.putString("category", etCategory.getText().toString());
                    extras.putString("card", etCard.getText().toString());
                    extras.putString("cardNo2", etCardNo.getText().toString());
                    extras.putDouble("iamount", Double.parseDouble(etIAmount.getText().toString()));

                    Log.i(TAG, "onItemSelected: Sending IAmount as " + Double.parseDouble(etIAmount.getText().toString()));
                    Log.i(TAG, "onItemSelected: Sending Category as: " + etCategory.getText().toString());
                    Log.i(TAG, "onItemSelected: Sending Card as: " + etCard.getText().toString());

                    intent.putExtras(extras);
                    startActivity(intent);
                    finish();

                    Toast.makeText
                            (getBaseContext(), parent.getItemAtPosition(position) +
                                    " is selected", Toast.LENGTH_LONG).show();

                    parent.setSelection(0);
                }
                else if (parent.getItemIdAtPosition(position) == 4)
                {
                    Log.i(TAG, "onItemSelected: " + parent.getItemAtPosition(position)
                            + " selected");
                    Log.i(TAG, "onItemSelected: Getting Category");

                    etCategory.setText(""+ parent.getItemAtPosition(position));

                    Intent intent = new Intent
                            (BuyActivity.this, BuyFoodActivity.class);
                    Bundle extras = new Bundle();

                    Log.i(TAG, "onItemSelected: Starting BuyAirtimeActivity");

                    extras.putString("category", etCategory.getText().toString());
                    extras.putString("card", etCard.getText().toString());
                    extras.putString("cardNo2", etCardNo.getText().toString());
                    extras.putDouble("iamount", Double.parseDouble(etIAmount.getText().toString()));

                    Log.i(TAG, "onItemSelected: Sending IAmount as " + Double.parseDouble(etIAmount.getText().toString()));
                    Log.i(TAG, "onItemSelected: Sending Category as: " + etCategory.getText().toString());
                    Log.i(TAG, "onItemSelected: Sending Card as: " + etCard.getText().toString());

                    intent.putExtras(extras);
                    startActivity(intent);
                    finish();

                    Toast.makeText
                            (getBaseContext(), parent.getItemAtPosition(position) +
                                    " is selected", Toast.LENGTH_LONG).show();

                    parent.setSelection(0);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });
    }

    private void viewChequeAmount()
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
                etIAmount.setText("" + String.format("%.2f", data.getDouble(3)));

                tvAmount.setText("R" + etIAmount.getText().toString());
            }
        }
    }

    private void viewCreditAmount()
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
                etIAmount.setText("" + String.format("%.2f", data.getDouble(3)));

                tvAmount.setText("R" + etIAmount.getText().toString());
            }
        }
    }

    private void viewSavingsAmount()
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
                etIAmount.setText("" + String.format("%.2f", data.getDouble(3)));

                tvAmount.setText("R" + etIAmount.getText().toString());
            }
        }
    }

    private void viewBusinessAmount()
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
                etIAmount.setText("" + String.format("%.2f", data.getDouble(3)));

                tvAmount.setText("R" + etIAmount.getText().toString());
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
            etCard.setText(card);
            etCardNo.setText(cardNo);
            etIAmount.setText("" + String.format("%.2f", iamount));

            if (etCategory.getText().toString().equals("Airtime"))
            {
                tvConfirmation.setText("Are you sure you want to purchase " +
                        category + " worth " + String.format("R%.2f", spent) + " on your " +
                        card + " account?");

                //etCategory.setVisibility(View.GONE);
                //etDate.setVisibility(View.GONE);
            }
            else if (etCategory.getText().toString().equals("Data"))
            {
                tvConfirmation.setText("Are you sure you want to purchase " +
                        category + " of " + data + " worth " + String.format("R%.2f", spent) +
                        " on your " + card + " account?");

                //etCategory.setVisibility(View.GONE);
                //etDate.setVisibility(View.GONE);
            }
            else if (etCategory.getText().toString().equals("Electricity"))
            {
                tvConfirmation.setText("Are you sure you want to purchase " +
                        category + " worth " + String.format("R%.2f", spent) + " on your " +
                        card + " account?");

                //etCategory.setVisibility(View.GONE);
                //etDate.setVisibility(View.GONE);
            }
            else if (etCategory.getText().toString().equals("Food"))
            {
                tvConfirmation.setText("Are you sure you want to purchase " +
                        category + " worth " + String.format("R%.2f", spent) + " on your " +
                        card + " account?");

                //etCategory.setVisibility(View.GONE);
                //etDate.setVisibility(View.GONE);
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
            if (etIAmount.getText().toString().equals("0.00"))
            {
                Log.i(TAG, "getThings: Initial Amount Set to R99999.99 for Database");
                etIAmount.setText("" + 99999.99);
            }
        }
    }
}
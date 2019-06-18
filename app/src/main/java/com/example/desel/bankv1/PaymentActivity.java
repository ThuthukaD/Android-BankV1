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

public class PaymentActivity extends AppCompatActivity
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
    EditText etPaymentAmount;
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
    private static final String TAG = "PaymentsActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        // INITIALISING

        // Database Related
        myDB = new DatabaseHelper(this);

        // Spinners
        spinOptions = findViewById(R.id.spinOptionsPayments);
        spinOptionsCard = findViewById(R.id.spinOptionsCard);
        adapterForSpinner = ArrayAdapter.createFromResource(this, R.array.paymentOptions,
                android.R.layout.simple_spinner_item);
        adapterForSpinnerCard = ArrayAdapter.createFromResource(this, R.array.cardOptions,
                android.R.layout.simple_spinner_item);

        // Text Views
        tvAmount = findViewById(R.id.tvAmount);
        tvConfirmation = findViewById(R.id.tvConfirmation);

        // Edit Texts
        etPaymentAmount = findViewById(R.id.etPaymentAmount);
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
        spinnerPaymentSelection();
        //viewChequeAmount();
        getThings();

        etDate.setText(date);
        etCategory.setText("Payment");
    }

    private void add()
    {
        btnBuy.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (etSpent.length() == 0 || Double.parseDouble(etSpent.getText().toString()) != spent)
                {
                    Log.i(TAG, "add: btnAdd Clicked");
                    Log.i(TAG, "onClick: Pulling Initial Text");

                    // Pulling initial text
                    iAmount = Double.parseDouble(etIAmount.getText().toString());
                    location = etLocation.getText().toString();
                    category = etCategory.getText().toString();
                    spent = Double.parseDouble(etPaymentAmount.getText().toString());
                    etSpent.setText("" + spent);

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

                    tvConfirmation.setVisibility(View.VISIBLE);
                    tvConfirmation.setText("Are you sure you want to perform a payment of " +
                            String.format("R%.2f", spent) + " from your " + card + " account ");

                    Log.i(TAG, "onClick: Successfully Pulled All Text");
                    Log.i(TAG, "onClick: Checking for any Blank Fields");
                }
                else
                {
                    if (etFAmount.length() != 0 && etLocation.length() != 0 &&
                            etSAmount.length() != 0 && etCategory.length() != 0 &&
                            etSpent.length() != 0 && etCard.length() != 0 &&
                            etCardNo.length() != 0 && etPaymentAmount.length() != 0)
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
                            Toast.makeText(PaymentActivity.this,
                                    "No matching cards were found",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                    {
                        Log.i(TAG, "onClick: Some Fields Were Empty");

                        Toast.makeText
                                (PaymentActivity.this, "Fields are empty!",
                                        Toast.LENGTH_SHORT).show();
                    }
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

                    etCard.setText("" + parent.getItemAtPosition(position));
                    etCardNo.setText("6252 5166 0967 5245");

                    spinOptions.setVisibility(View.VISIBLE);
                }
                else if (parent.getItemIdAtPosition(position) == 2)
                {
                    Log.i(TAG, "onItemSelected: " + parent.getItemAtPosition(position)
                            + " selected");

                    viewCreditAmount();

                    Log.i(TAG, "onItemSelected: " + parent.getItemAtPosition(position)
                            + " selected");

                    etCard.setText("" + parent.getItemAtPosition(position));
                    etCardNo.setText("8763 4125 0069 7366");

                    spinOptions.setVisibility(View.VISIBLE);
                }
                else if (parent.getItemIdAtPosition(position) == 3)
                {
                    Log.i(TAG, "onItemSelected: " + parent.getItemAtPosition(position)
                            + " selected");

                    viewSavingsAmount();

                    Log.i(TAG, "onItemSelected: " + parent.getItemAtPosition(position)
                            + " selected");

                    etCard.setText("" + parent.getItemAtPosition(position));
                    etCardNo.setText("6564 7512 7984 7245");

                    spinOptions.setVisibility(View.VISIBLE);
                }
                else if (parent.getItemIdAtPosition(position) == 4)
                {
                    Log.i(TAG, "onItemSelected: " + parent.getItemAtPosition(position)
                            + " selected");

                    viewBusinessAmount();

                    Log.i(TAG, "onItemSelected: " + parent.getItemAtPosition(position)
                            + " selected");

                    etCard.setText("" + parent.getItemAtPosition(position));
                    etCardNo.setText("7152 5363 9541 5625");

                    spinOptions.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });
    }

    public void spinnerPaymentSelection()
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
                }
                else if (parent.getItemIdAtPosition(position) == 1)
                {
                    Log.i(TAG, "onItemSelected: " + parent.getItemAtPosition(position)
                            + " selected");

                    Log.i(TAG, "onItemSelected: Getting Location");
                    etLocation.setText(""+ parent.getItemAtPosition(position));

                    Toast.makeText
                            (getBaseContext(), parent.getItemAtPosition(position) +
                                    " is selected", Toast.LENGTH_LONG).show();

                    etPaymentAmount.setVisibility(View.VISIBLE);
                    btnBuy.setVisibility(View.VISIBLE);
                }
                else if (parent.getItemIdAtPosition(position) == 2)
                {
                    Log.i(TAG, "onItemSelected: " + parent.getItemAtPosition(position)
                            + " selected");

                    Log.i(TAG, "onItemSelected: Getting Location");
                    etLocation.setText(""+ parent.getItemAtPosition(position));

                    Toast.makeText
                            (getBaseContext(), parent.getItemAtPosition(position) +
                                    " is selected", Toast.LENGTH_LONG).show();

                    etPaymentAmount.setVisibility(View.VISIBLE);
                    btnBuy.setVisibility(View.VISIBLE);
                }
                else if (parent.getItemIdAtPosition(position) == 3)
                {
                    Log.i(TAG, "onItemSelected: " + parent.getItemAtPosition(position)
                            + " selected");

                    Log.i(TAG, "onItemSelected: Getting Location");
                    etLocation.setText(""+ parent.getItemAtPosition(position));

                    Toast.makeText
                            (getBaseContext(), parent.getItemAtPosition(position) +
                                    " is selected", Toast.LENGTH_LONG).show();

                    etPaymentAmount.setVisibility(View.VISIBLE);
                    btnBuy.setVisibility(View.VISIBLE);
                }
                else if (parent.getItemIdAtPosition(position) == 4)
                {
                    Log.i(TAG, "onItemSelected: " + parent.getItemAtPosition(position)
                            + " selected");

                    Log.i(TAG, "onItemSelected: Getting Location");
                    etLocation.setText(""+ parent.getItemAtPosition(position));

                    Toast.makeText
                            (getBaseContext(), parent.getItemAtPosition(position) +
                                    " is selected", Toast.LENGTH_LONG).show();

                    etPaymentAmount.setVisibility(View.VISIBLE);
                    btnBuy.setVisibility(View.VISIBLE);
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
            if (etIAmount.getText().toString().equals("0.00"))
            {
                Log.i(TAG, "getThings: Initial Amount Set to R99999.99 for Database");
                etIAmount.setText("" + 99999.99);
            }
        }
    }
}
package com.example.desel.bankv1;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
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

    // Card Views
    CardView cvCard1;
    CardView cvCard2;

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
    EditText etCardTransferTo;
    EditText etLocation;
    EditText etCategory;
    EditText etSAmount1;
    EditText etSAmount2;
    EditText etFAmount1;
    EditText etFAmount2;
    EditText etDate;
    EditText etSpent;

    // Buttons
    Button btnBuy;

    // Storing
    double iAmount1;
    double iAmount2;
    double fAmount1;
    double fAmount2;
    double sAmount1;
    double sAmount2;
    String card1;
    String card2;
    String cardTransferredTo;
    String cardNo1;
    String cardNo2;
    String location;
    String category;
    double spent;
    double tAmount;
    String date = DateFormat.getDateTimeInstance()
            .format(new Date());

    // Debugging
    private static final String TAG = "TransferActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer);

        // INITIALISING

        // Card View
        cvCard1 = findViewById(R.id.cvCard1);
        cvCard2 = findViewById(R.id.cvCard2);

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
        etCardTransferTo = findViewById(R.id.etCardTransferredTo);
        etCardNo1 = findViewById(R.id.etCardNo1);
        etCardNo2 = findViewById(R.id.etCardNo2);
        etLocation = findViewById(R.id.etLocation);
        etSAmount1 = findViewById(R.id.etSAmount1);
        etSAmount2 = findViewById(R.id.etSAmount2);
        etFAmount1 = findViewById(R.id.etFAmount1);
        etFAmount2 = findViewById(R.id.etFAmount2);
        etCategory = findViewById(R.id.etCategory);
        etDate = findViewById(R.id.etDate);
        etSpent = findViewById(R.id.etSpent);

        // Buttons
        btnBuy = findViewById(R.id.btnBuy);

        add();
        spinnerCardSelection1();
        spinnerCardSelection2();

        etDate.setText(date);
        etCategory.setText("Transfer");

        getThings();

        if (etTransferAmount.isFocusableInTouchMode() == false)
        {
            etSpent.setOnClickListener(new View.OnClickListener()
            {
                boolean clicked = false;
                @Override
                public void onClick(View v)
                {
                    clicked = true;

                    if (clicked)
                    {
                        Toast.makeText(TransferActivity.this,
                                "Select it again", Toast.LENGTH_SHORT).show();
                    }

                    etSpent.setFocusableInTouchMode(true);
                }
            });
        }
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
                    tAmount = Double.parseDouble(etTransferAmount.getText().toString());
                    iAmount1 = Double.parseDouble(etIAmount1.getText().toString());
                    iAmount2 = Double.parseDouble(etIAmount2.getText().toString());
                    location = etLocation.getText().toString();
                    category = etCategory.getText().toString();
                    spent = tAmount;

                    Log.i(TAG, "onClick: Pulled Initial Text");
                    Log.i(TAG, "onClick: Setting Text for fAmount");

                    // Setting text for fAmount
                    etSpent.setText("" + Double.parseDouble(etTransferAmount.getText().toString()));
                    fAmount1 = spent;
                    fAmount2 = spent;
                    etFAmount1.setText("" + fAmount1);
                    etFAmount2.setText("" + fAmount2);

                    Log.i(TAG, "onClick: Set Text for fAmount");
                    Log.i(TAG, "onClick: Setting Text for sAmount");

                    // Setting text for sAmount
                    sAmount1 = iAmount1 - fAmount1;
                    sAmount2 = iAmount2 + fAmount2;
                    etSAmount1.setText("" + sAmount1);
                    etSAmount2.setText("" + sAmount2);

                    Log.i(TAG, "onClick: Set Text for sAmount");
                    Log.i(TAG, "onClick: Pulling Additional Text");

                    // Pulling new text
                    fAmount1 = Double.parseDouble(etFAmount1.getText().toString());
                    fAmount2 = Double.parseDouble(etFAmount2.getText().toString());
                    sAmount1 = Double.parseDouble(etSAmount1.getText().toString());
                    sAmount2 = Double.parseDouble(etSAmount2.getText().toString());
                    card1 = etCard1.getText().toString();
                    card2 = etCard2.getText().toString();
                    etCardTransferTo.setText(card2);
                    cardTransferredTo = etCardTransferTo.getText().toString();
                    cardNo1 = etCardNo1.getText().toString();
                    cardNo2 = etCardNo2.getText().toString();

                    Log.i(TAG, "onClick: Successfully Pulled All Text");
                    Log.i(TAG, "onClick: Checking for any Blank Fields");

                    //Toast.makeText(TransferActivity.this, "You Sure?", Toast.LENGTH_SHORT).show();

                    tvConfirmation.setVisibility(View.VISIBLE);
                    tvConfirmation.setText("Are you sure you want to transfer " +
                            String.format("R%.2f", spent) + " from your " + card1 + " account " +
                            "to your " + card2 + " account?");
                }
                else
                {
                    if (etFAmount1.length() != 0 && etFAmount2.length() != 0 &&
                            etSAmount1.length() != 0 && etSAmount1.length() != 0 &&
                            etCard1.length() != 0 && etCard2.length() != 0 &&
                            etLocation.length() != 0 && etCategory.length() != 0 &&
                            etCardNo1.length() != 0 && etCardNo2.length() != 0 &&
                            etSpent.length() != 0 && etCardTransferTo.length() != 0 &&
                            etTransferAmount.length() != 0)
                    {
                        Log.i(TAG, "onClick: Fields Are Not Empty");

                        if (etCard1.getText().toString().equals("Cheque"))
                        {
                            addDataCheque(fAmount1, location, sAmount1, category, iAmount1, date, card1,
                                    cardNo1, cardTransferredTo);

                            if (etCard2.getText().toString().equals("Cheque"))
                            {
                                Toast.makeText(TransferActivity.this,
                                        "You cant transfer to the same account", Toast.LENGTH_SHORT).show();
                            }
                            else if (etCard2.getText().toString().equals("Credit"))
                            {
                                addDataCredit(fAmount2, location, sAmount2, category, iAmount2, date, card2,
                                        cardNo1, cardTransferredTo);
                            }
                            else if (etCard2.getText().toString().equals("Savings"))
                            {
                                addDataSavings(fAmount2, location, sAmount2, category, iAmount2, date, card2,
                                        cardNo1, cardTransferredTo);
                            }
                            else if (etCard2.getText().toString().equals("Business"))
                            {
                                addDataBusiness(fAmount2, location, sAmount2, category, iAmount2, date, card2,
                                        cardNo1, cardTransferredTo);
                            }
                            else
                            {
                                Toast.makeText(TransferActivity.this,
                                        "Couldn't detect 2nd card", Toast.LENGTH_SHORT).show();
                            }

                            Log.i(TAG, "onClick: Data Adding to Database");

                            etIAmount1.setText(null);
                            etIAmount2.setText(null);
                            etFAmount1.setText(null);
                            etFAmount2.setText(null);
                            etSAmount1.setText(null);
                            etSAmount2.setText(null);
                            etCard1.setText(null);
                            etCard2.setText(null);
                            etCardNo1.setText(null);
                            etCardNo2.setText(null);
                            etLocation.setText(null);
                            etCategory.setText(null);
                            etSpent.setText(null);

                            Log.i(TAG, "onClick: Fields Emptied");
                            Log.i(TAG, "onClick: Closing All Old Activities");

                            Intent intent = new Intent
                                    (TransferActivity.this, MainActivity.class);
                            startActivity(intent);

//                        // Intent to close all other activities except for main and login
//                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                        intent.putExtra("EXIT", true);
//                        startActivity(intent);
                        }
                        else if (etCard1.getText().toString().equals("Credit"))
                        {
                            addDataCredit(fAmount1, location, sAmount1, category, iAmount1, date, card1,
                                    cardNo1, cardTransferredTo);

                            if (etCard2.getText().toString().equals("Cheque"))
                            {
                                addDataCheque(fAmount2, location, sAmount2, category, iAmount2, date, card2,
                                        cardNo1, cardTransferredTo);
                            }
                            else if (etCard2.getText().toString().equals("Credit"))
                            {
                                Toast.makeText(TransferActivity.this,
                                        "You cant transfer to the same account", Toast.LENGTH_SHORT).show();
                            }
                            else if (etCard2.getText().toString().equals("Savings"))
                            {
                                addDataSavings(fAmount2, location, sAmount2, category, iAmount2, date, card2,
                                        cardNo1, cardTransferredTo);
                            }
                            else if (etCard2.getText().toString().equals("Business"))
                            {
                                addDataBusiness(fAmount2, location, sAmount2, category, iAmount2, date, card2,
                                        cardNo1, cardTransferredTo);
                            }
                            else
                            {
                                Toast.makeText(TransferActivity.this,
                                        "Couldn't detect 2nd card", Toast.LENGTH_SHORT).show();
                            }

                            Log.i(TAG, "onClick: Data Adding to Database");

                            etIAmount1.setText(null);
                            etIAmount2.setText(null);
                            etFAmount1.setText(null);
                            etFAmount2.setText(null);
                            etSAmount1.setText(null);
                            etSAmount2.setText(null);
                            etCard1.setText(null);
                            etCard2.setText(null);
                            etCardNo1.setText(null);
                            etCardNo2.setText(null);
                            etLocation.setText(null);
                            etCategory.setText(null);
                            etSpent.setText(null);

                            Log.i(TAG, "onClick: Fields Emptied");
                            Log.i(TAG, "onClick: Closing All Old Activities");

                            Intent intent = new Intent
                                    (TransferActivity.this, MainActivity.class);
                            startActivity(intent);

//                        // Intent to close all other activities except for main and login
//                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                        intent.putExtra("EXIT", true);
//                        startActivity(intent);
                        }
                        else if (etCard1.getText().toString().equals("Savings"))
                        {
                            addDataSavings(fAmount1, location, sAmount1, category, iAmount1, date, card1,
                                    cardNo1, cardTransferredTo);

                            if (etCard2.getText().toString().equals("Cheque"))
                            {
                                addDataCheque(fAmount2, location, sAmount2, category, iAmount2, date, card2,
                                        cardNo1, cardTransferredTo);
                            }
                            else if (etCard2.getText().toString().equals("Credit"))
                            {
                                addDataCredit(fAmount2, location, sAmount2, category, iAmount2, date, card2,
                                        cardNo1, cardTransferredTo);
                            }
                            else if (etCard2.getText().toString().equals("Savings"))
                            {
                                Toast.makeText(TransferActivity.this,
                                        "You cant transfer to the same account", Toast.LENGTH_SHORT).show();
                            }
                            else if (etCard2.getText().toString().equals("Business"))
                            {
                                addDataBusiness(fAmount2, location, sAmount2, category, iAmount2, date, card2,
                                        cardNo1, cardTransferredTo);
                            }
                            else
                            {
                                Toast.makeText(TransferActivity.this,
                                        "Couldn't detect 2nd card", Toast.LENGTH_SHORT).show();
                            }

                            Log.i(TAG, "onClick: Data Adding to Database");

                            etIAmount1.setText(null);
                            etIAmount2.setText(null);
                            etFAmount1.setText(null);
                            etFAmount2.setText(null);
                            etSAmount1.setText(null);
                            etSAmount2.setText(null);
                            etCard1.setText(null);
                            etCard2.setText(null);
                            etCardNo1.setText(null);
                            etCardNo2.setText(null);
                            etLocation.setText(null);
                            etCategory.setText(null);
                            etSpent.setText(null);

                            Log.i(TAG, "onClick: Fields Emptied");
                            Log.i(TAG, "onClick: Closing All Old Activities");

                            Intent intent = new Intent
                                    (TransferActivity.this, MainActivity.class);
                            startActivity(intent);

//                        // Intent to close all other activities except for main and login
//                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                        intent.putExtra("EXIT", true);
//                        startActivity(intent);
                        }
                        else if (etCard1.getText().toString().equals("Business"))
                        {
                            addDataBusiness(fAmount1, location, sAmount1, category, iAmount1, date, card1,
                                    cardNo1, cardTransferredTo);

                            if (etCard2.getText().toString().equals("Cheque"))
                            {
                                addDataCheque(fAmount2, location, sAmount2, category, iAmount2, date, card2,
                                        cardNo1, cardTransferredTo);
                            }
                            else if (etCard2.getText().toString().equals("Credit"))
                            {
                                addDataCredit(fAmount2, location, sAmount2, category, iAmount2, date, card2,
                                        cardNo1, cardTransferredTo);
                            }
                            else if (etCard2.getText().toString().equals("Savings"))
                            {
                                addDataSavings(fAmount2, location, sAmount2, category, iAmount2, date, card2,
                                        cardNo1, cardTransferredTo);
                            }
                            else if (etCard2.getText().toString().equals("Business"))
                            {
                                Toast.makeText(TransferActivity.this,
                                        "You cant transfer to the same account", Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                Toast.makeText(TransferActivity.this,
                                        "Couldn't detect 2nd card", Toast.LENGTH_SHORT).show();
                            }

                            Log.i(TAG, "onClick: Data Adding to Database");

                            etIAmount1.setText(null);
                            etIAmount2.setText(null);
                            etFAmount1.setText(null);
                            etFAmount2.setText(null);
                            etSAmount1.setText(null);
                            etSAmount2.setText(null);
                            etCard1.setText(null);
                            etCard2.setText(null);
                            etCardNo1.setText(null);
                            etCardNo2.setText(null);
                            etLocation.setText(null);
                            etCategory.setText(null);
                            etSpent.setText(null);

                            Log.i(TAG, "onClick: Fields Emptied");
                            Log.i(TAG, "onClick: Closing All Old Activities");

                            Intent intent = new Intent
                                    (TransferActivity.this, MainActivity.class);
                            startActivity(intent);

//                        // Intent to close all other activities except for main and login
//                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                        intent.putExtra("EXIT", true);
//                        startActivity(intent);
                        }
                        else
                        {
                            Toast.makeText(TransferActivity.this,
                                    "No matching cards were found",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                    {
                        Log.i(TAG, "onClick: Some Fields Were Empty");

                        Toast.makeText
                                (TransferActivity.this, "Fields are empty!",
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

                    cvCard2.setVisibility(View.VISIBLE);
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

                    cvCard2.setVisibility(View.VISIBLE);
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

                    cvCard2.setVisibility(View.VISIBLE);
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

                    cvCard2.setVisibility(View.VISIBLE);
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

                    etTransferAmount.setVisibility(View.VISIBLE);
                    btnBuy.setVisibility(View.VISIBLE);
                }
                else if (parent.getItemIdAtPosition(position) == 2)
                {
                    Log.i(TAG, "onItemSelected: " + parent.getItemAtPosition(position)
                            + " selected");

                    viewCreditAmount2();

                    etCard2.setText("" + parent.getItemAtPosition(position));
                    etCardNo2.setText("8763 4125 0069 7366");

                    etTransferAmount.setVisibility(View.VISIBLE);
                    btnBuy.setVisibility(View.VISIBLE);
                }
                else if (parent.getItemIdAtPosition(position) == 3)
                {
                    Log.i(TAG, "onItemSelected: " + parent.getItemAtPosition(position)
                            + " selected");

                    viewSavingsAmount2();

                    etCard2.setText("" + parent.getItemAtPosition(position));
                    etCardNo2.setText("6564 7512 7984 7245");

                    etTransferAmount.setVisibility(View.VISIBLE);
                    btnBuy.setVisibility(View.VISIBLE);
                }
                else if (parent.getItemIdAtPosition(position) == 4)
                {
                    Log.i(TAG, "onItemSelected: " + parent.getItemAtPosition(position)
                            + " selected");

                    viewBusinessAmount2();

                    etCard2.setText("" + parent.getItemAtPosition(position));
                    etCardNo2.setText("7152 5363 9541 5625");

                    etTransferAmount.setVisibility(View.VISIBLE);
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

            if (etCategory.getText().toString().equals("Transfer"))
            {
                tvConfirmation.setVisibility(View.VISIBLE);
                tvConfirmation.setText("Are you sure you want to transfer " +
                        String.format("R%.2f", spent) + " from your " + card1 + " account " +
                        "to your " + card2 + "account?");
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
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

    // Buttons
    Button btnAdd;

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


    // Other
    Spinner spinOptions;
    Spinner spinOptionsCard;
    ArrayAdapter<CharSequence> adapterForSpinner;
    ArrayAdapter<CharSequence> adapterForSpinnerCard;
    private static final String TAG = "BuyActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy);

        // INITIALISING

        // Database Related
        myDB = new DatabaseHelper(this);

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

        // Buttons
        btnAdd = findViewById(R.id.btnAdd);

        // Other
        spinOptions = findViewById(R.id.spinOptions);
        spinOptionsCard = findViewById(R.id.spinOptionsCard);
        adapterForSpinner = ArrayAdapter.createFromResource(this, R.array.purchaseOptions,
                android.R.layout.simple_spinner_item);
        adapterForSpinnerCard = ArrayAdapter.createFromResource(this, R.array.cardOptions,
                android.R.layout.simple_spinner_item);

        add();
        Log.i(TAG, "onCreate: Data Possibly Added");
        spinnerCard();
        Log.i(TAG, "onCreate: Spinner Working");
        spinner();
        Log.i(TAG, "onCreate: Spinner Working");
        view();

        getSpent();
        etDate.setText(date);
    }

    private void add()
    {
        Log.i(TAG, "add: Button Clicked");
        btnAdd.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // Pulling initial Text
                iAmount = Double.parseDouble(etIAmount.getText().toString());
                location = etLocation.getText().toString();
                category = etCategory.getText().toString();
                spent = Double.parseDouble(etSpent.getText().toString());

                // Setting text for fAmount
                fAmount = spent;
                etFAmount.setText("" + fAmount);

                // Setting text for sAmount
                sAmount = iAmount - fAmount;
                etSAmount.setText("" + sAmount);

                // Pulling new text
                fAmount = Double.parseDouble(etFAmount.getText().toString());
                sAmount = Double.parseDouble(etSAmount.getText().toString());
                card = etCard.getText().toString();

                if (etFAmount.length() != 0 && etLocation.length() != 0 &&
                        etSAmount.length() != 0 && etCategory.length() != 0)
                {
                    addData(fAmount, location, sAmount, category, iAmount, date, card);
                    Log.i(TAG, "onClick: Data adding to db");

                    etIAmount.setText(null);
                    etFAmount.setText(null);
                    etLocation.setText(null);
                    etSAmount.setText(null);
                    etCategory.setText(null);
                    etSpent.setText(null);
                    etCard.setText(null);

                    Log.i(TAG, "onClick: Fields Emptied");

                    // view();

                    // Log.i(TAG, "onClick: List View Updated again");

                    Intent intent = new Intent
                            (BuyActivity.this, MainActivity.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText
                            (BuyActivity.this, "Fields are empty!",
                                    Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void addData(double fAmount, String location, double sAmount, String category,
                        double iAmount, String date, String card)
    {
        boolean isInserted = myDB.addData(fAmount, location, sAmount, category,
                iAmount, date, card);

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

    public void spinnerCard()
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

                }
                else if (parent.getItemIdAtPosition(position) == 1)
                {
                    Toast.makeText
                            (getBaseContext(), parent.getItemAtPosition(position) +
                                    " is selected", Toast.LENGTH_LONG).show();

                    etCard.setText("" + parent.getItemAtPosition(position));

                    spinOptions.setVisibility(View.VISIBLE);
                }
                else if (parent.getItemIdAtPosition(position) == 2)
                {
                    Toast.makeText
                            (getBaseContext(), parent.getItemAtPosition(position) +
                                    " is selected", Toast.LENGTH_LONG).show();

                    etCard.setText("" + parent.getItemAtPosition(position));

                    spinOptions.setVisibility(View.VISIBLE);
                }
                else if (parent.getItemIdAtPosition(position) == 3)
                {
                    Toast.makeText
                            (getBaseContext(), parent.getItemAtPosition(position) +
                                    " is selected", Toast.LENGTH_LONG).show();

                    etCard.setText("" + parent.getItemAtPosition(position));

                    spinOptions.setVisibility(View.VISIBLE);
                }
                else if (parent.getItemIdAtPosition(position) == 4)
                {
                    Toast.makeText
                            (getBaseContext(), parent.getItemAtPosition(position) +
                                    " is selected", Toast.LENGTH_LONG).show();

                    etCard.setText("" + parent.getItemAtPosition(position));

                    spinOptions.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });
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

                if (parent.getItemIdAtPosition(position) == 0)
                {
                    parent.setSelection(0);
                }
                else if (parent.getItemIdAtPosition(position) == 1)
                {

                    etCategory.setText(""+ parent.getItemAtPosition(position));

                    Intent intent = new Intent
                            (BuyActivity.this, BuyAirtimeActivity.class);
                    Bundle extras = new Bundle();

                    extras.putString("category", etCategory.getText().toString());
                    extras.putString("card", etCard.getText().toString());

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
                    etCategory.setText(""+ parent.getItemAtPosition(position));

                    Intent intent = new Intent
                            (BuyActivity.this, BuyAirtimeActivity.class);
                    Bundle extras = new Bundle();

                    extras.putString("category", etCategory.getText().toString());
                    extras.putString("card", etCard.getText().toString());

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
                    etCategory.setText(""+ parent.getItemAtPosition(position));

                    Intent intent = new Intent
                            (BuyActivity.this, BuyAirtimeActivity.class);
                    Bundle extras = new Bundle();

                    extras.putString("category", etCategory.getText().toString());
                    extras.putString("card", etCard.getText().toString());

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
                    etCategory.setText(""+ parent.getItemAtPosition(position));

                    Intent intent = new Intent
                            (BuyActivity.this, BuyAirtimeActivity.class);
                    Bundle extras = new Bundle();

                    extras.putString("category", etCategory.getText().toString());
                    extras.putString("card", etCard.getText().toString());

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

    private void view()
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
            while(data.moveToNext())
            {
                // This value is the column ID for the Items
                etIAmount.setText("" + data.getString(3));

                tvAmount.setText("R" + etIAmount.getText().toString());
            }
        }
    }

    public void getSpent()
    {
        Bundle extras = getIntent().getExtras();
        if (extras != null)
        {
            String location = extras.getString("location");
            String category = extras.getString("category2");
            double spent = extras.getDouble("spent");
            String card = extras.getString("card2");
            int btnOn = extras.getInt("buttonOn");

            etLocation.setText(location);
            etCategory.setText(category);
            etSpent.setText("" + spent);
            etCard.setText(card);
            tvConfirmation.setText("Are you sure you want to purchase " +
                    category + " worth R" + spent + "?");

            if (btnOn == 9999)
            {
                btnAdd.setVisibility(View.VISIBLE);
                tvConfirmation.setVisibility(View.VISIBLE);
            }
        }
    }
}
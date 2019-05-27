package com.example.desel.bankv1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    // VARIABLES

    // Floating Buttons
    FloatingActionButton fbtnPay;
    FloatingActionButton fbtnTransfer;
    FloatingActionButton fbtnBuy;
    FloatingActionButton fbtnBudget;
    FloatingActionButton fbtnTBD;

    // Card Views
    CardView cvCard1;
    CardView cvCard2;
    CardView cvCard3;
    CardView cvCard4;

    // Text Views
    TextView tvUserName;
    TextView tvMoneyCheque;
    TextView tvMoneyCredit;
    TextView tvMoneySavings;
    TextView tvMoneyBusiness;
    TextView tvCardNumberCheque;
    TextView tvCardNumberCredit;
    TextView tvCardNumberSavings;
    TextView tvCardNumberBusiness;

    // Edit Text
    EditText etIAmount;

    // Database Related
    DatabaseHelper myDB;

    // Debugging
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // INITIALISING

        // Database Related
        myDB = new DatabaseHelper(this);

        // Floating Buttons
        fbtnPay = findViewById(R.id.fbtnPay);
        fbtnTransfer = findViewById(R.id.fbtnTransfer);
        fbtnBuy = findViewById(R.id.fbtnBuy);
        fbtnBudget = findViewById(R.id.fbtnBudget);
        fbtnTBD = findViewById(R.id.fbtnTBD);

        // Card Views
        cvCard1 = findViewById(R.id.cvCard1);
        cvCard2 = findViewById(R.id.cvCard2);
        cvCard3 = findViewById(R.id.cvCard3);
        cvCard4 = findViewById(R.id.cvCard4);

        // Text Views
        tvUserName = findViewById(R.id.tvUserName);
        tvMoneyCheque = findViewById(R.id.tvMoney1);
        tvMoneyCredit = findViewById(R.id.tvMoney2);
        tvMoneySavings = findViewById(R.id.tvMoney3);
        tvMoneyBusiness = findViewById(R.id.tvMoney4);
        tvCardNumberCheque = findViewById(R.id.tvCardNumber1);
        tvCardNumberCredit = findViewById(R.id.tvCardNumber2);
        tvCardNumberSavings = findViewById(R.id.tvCardNumber3);
        tvCardNumberBusiness = findViewById(R.id.tvCardNumber4);

        // Edit Text
        etIAmount = findViewById(R.id.etIAmount);

        Log.i(TAG, "onCreate: MainActivity Loaded");
        Log.i(TAG, "onCreate: Fetching Text");
        try
        {
            Text();
            Log.i(TAG, "onCreate: Text Fetch Successful");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        floatButtons();
        cardViewClicks();
        viewChequeAvailableBalance();
    }

    private void floatButtons()
    {
        fbtnPay.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Log.i(TAG, "floatButtons: fbtnPay Clicked");

                Intent intent = new Intent
                        (MainActivity.this,
                                PaymentActivity.class);
                startActivity(intent);
            }
        });

        fbtnTransfer.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Log.i(TAG, "floatButtons: fbtnTransfer Clicked");

                Intent intent = new Intent
                        (MainActivity.this,
                                TransferActivity.class);
                startActivity(intent);
            }
        });

        fbtnBuy.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Log.i(TAG, "floatButtons: fbtnBuy Clicked");

                Intent intent = new Intent
                        (MainActivity.this,
                                BuyActivity.class);

                Bundle extras = new Bundle();

                Log.i(TAG, "onClick: Sending Card Number to BuyActivity");
                extras.putString("cardNoCheque", tvCardNumberCheque.getText().toString());
                extras.putString("cardNoCredit", tvCardNumberCredit.getText().toString());
                extras.putString("cardNoSavings", tvCardNumberSavings.getText().toString());
                extras.putString("cardNoBusiness", tvCardNumberBusiness.getText().toString());

                intent.putExtras(extras);
                startActivity(intent);

                Log.i(TAG, "onClick: Started BuyActivity");
            }
        });

        fbtnBudget.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Log.i(TAG, "floatButtons: fbtnBudget Clicked");

                Intent intent = new Intent
                        (MainActivity.this,
                                BudgetActivity.class);
                startActivity(intent);
            }
        });

        // Example button for upcoming features
        fbtnTBD.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Log.i(TAG, "floatButtons: fbtnTBD Clicked");

                Toast.makeText
                        (MainActivity.this, "Locked, Upcoming Feature",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void cardViewClicks()
    {
        cvCard1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Log.i(TAG, "onClick: Clicked cvCard1");

                Intent intent = new Intent
                        (MainActivity.this,
                                ChequeActivity.class);
                startActivity(intent);
            }
        });

        cvCard2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Log.i(TAG, "onClick: Clicked cvCard2");

                Intent intent = new Intent
                        (MainActivity.this,
                                CreditActivity.class);
                startActivity(intent);
            }
        });

        cvCard3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Log.i(TAG, "onClick: Clicked cvCard3");

                Intent intent = new Intent
                        (MainActivity.this,
                                SavingsActivity.class);
                startActivity(intent);
            }
        });

        cvCard4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Log.i(TAG, "onClick: Clicked cvCard4");

                Intent intent = new Intent
                        (MainActivity.this,
                                BusinessActivity.class);
                startActivity(intent);
            }
        });
    }

    // Method to view the correct amount for the phone
    private void viewChequeAvailableBalance()
    {
        Cursor data = myDB.getLastValue();

        Log.i(TAG, "viewChequeAvailableBalance: No Data found in the DB");
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

                Log.i(TAG, "viewChequeAvailableBalance: The value found is " +
                        data.getString(3));

                Double chequeAmount = Double.parseDouble(etIAmount.getText().toString());

                if (chequeAmount == null)
                {
                    // Used to set the Initial AMount to this value if DB is empty
                    chequeAmount = 99999.99;

                    // To make decimal in 2 places, use (String.format("%.2f"), value);
                    tvMoneyCheque.setText(String.format("R%.2f", chequeAmount));

                    Log.i(TAG, "viewChequeAvailableBalance: Formatted Text to have " +
                            "decimal places");
                    Log.i(TAG, "viewChequeAvailableBalance: Cheque Available Amount is "
                            + chequeAmount);
                }
                else
                {
                    // To make decimal in 2 places, use (String.format("%.2f"), value);
                    tvMoneyCheque.setText(String.format("R%.2f", chequeAmount));

                    Log.i(TAG, "viewChequeAvailableBalance: Formatted Text to have " +
                            "decimal places");
                    Log.i(TAG, "viewChequeAvailableBalance: Cheque Available Amount is "
                            + chequeAmount);
                }
            }
        }
    }

    // Get text method
    public void Text()
    {
        Log.i(TAG, "Text: Getting username text");
        // Calling prefs from RegisterActivity
        SharedPreferences prefs = getSharedPreferences("login", MODE_PRIVATE);

        // Passed string for user
        String username = prefs.getString("username", "Username");
        Log.i(TAG, "Text: Username is " + username);

        // Setting the current fields to the stored text
        tvUserName.setText(username);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
package com.example.desel.bankv1;

import android.content.Intent;
import android.content.SharedPreferences;
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
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // INITIALISING

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

        floatButtons();
        cardViewClicks();

        Log.i(TAG, "onCreate: Fetching text");
        try
        {
            Text();
            Log.i(TAG, "onCreate: Text fetch successful");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void floatButtons()
    {
        fbtnPay.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
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
                Intent intent = new Intent
                        (MainActivity.this,
                                BuyActivity.class);
                startActivity(intent);
            }
        });

        fbtnBudget.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
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
                Toast.makeText
                        (MainActivity.this, "Locked, Upcoming Feature",
                        Toast.LENGTH_SHORT).show();
            }
        });

        Log.i(TAG, "floatButtons: Floating Button Clicked");
    }

    private void cardViewClicks()
    {
        cvCard1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // Starting new Activity
                cvCard1.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        Intent intent = new Intent
                                (MainActivity.this,
                                        ChequeActivity.class);
                        startActivity(intent);
                    }
                });
            }
        });

        cvCard2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                cvCard2.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        Intent intent = new Intent
                                (MainActivity.this,
                                        CreditActivity.class);
                        startActivity(intent);
                    }
                });
            }
        });

        cvCard3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                cvCard3.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        Intent intent = new Intent
                                (MainActivity.this,
                                        SavingsActivity.class);
                        startActivity(intent);
                    }
                });
            }
        });

        cvCard4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                cvCard4.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        Intent intent = new Intent
                                (MainActivity.this,
                                        BusinessActivity.class);
                        startActivity(intent);
                    }
                });
            }
        });

        Log.i(TAG, "cardViewClicks: Card View Button Clicked");
    }

    // Get text method
    public void Text()
    {
        // Calling prefs from RegisterActivity
        SharedPreferences prefs = getSharedPreferences("login", MODE_PRIVATE);

        // Passed string for user
        String username = prefs.getString("username", "Username");

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

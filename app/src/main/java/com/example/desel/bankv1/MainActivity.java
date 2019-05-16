package com.example.desel.bankv1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
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

        floatButtons();
        cardViewClicks();
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
                finish();
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
                finish();
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
                finish();
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
                finish();
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
    }

    private void cardViewClicks()
    {
        cvCard1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                cvCard1.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        Intent intent = new Intent
                                (MainActivity.this,
                                        ChequeActivity.class);
                        startActivity(intent);
                        finish();
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
                        finish();
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
                        finish();
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
                        finish();
                    }
                });
            }
        });
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

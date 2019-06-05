package com.example.desel.bankv1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class BuyFoodActivity extends AppCompatActivity
{
    // VARIABLES

    // Image Buttons
    ImageButton ibtnBurgerKing;
    ImageButton ibtnChickenLicken;
    ImageButton ibtnFishaways;
    ImageButton ibtnKFC;
    ImageButton ibtnMcDonalds;
    ImageButton ibtnSteers;

    // Edit Texts
    EditText etSpent;

    // Buttons
    ImageButton ibtnOption1;
    ImageButton ibtnOption2;
    ImageButton ibtnOption3;
    ImageButton ibtnOption4;
    ImageButton ibtnOption5;
    ImageButton ibtnOption6;
    ImageButton ibtnOption7;
    ImageButton ibtnOption8;
    ImageButton ibtnOption9;
    ImageButton ibtnOption10;

    // Storage
    String category;
    String card;
    String cardNo;
    double iamount;

    // Other
    LinearLayout llOptions;

    private static final String TAG = "BuyFoodActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_food);

        // INITIALISING

        // Image Buttons
        ibtnBurgerKing = findViewById(R.id.ibtnBurgerKing);
        ibtnChickenLicken = findViewById(R.id.ibtnChickenLicken);
        ibtnFishaways = findViewById(R.id.ibtnFishaways);
        ibtnKFC = findViewById(R.id.ibtnKFC);
        ibtnMcDonalds = findViewById(R.id.ibtnMcDonalds);
        ibtnSteers = findViewById(R.id.ibtnSteers);

        // Edit Texts
        etSpent = findViewById(R.id.etSpent);

        // Buttons
        ibtnOption1 = findViewById(R.id.ibtnOption1);
        ibtnOption2 = findViewById(R.id.ibtnOption2);
        ibtnOption3 = findViewById(R.id.ibtnOption3);
        ibtnOption4 = findViewById(R.id.ibtnOption4);
        ibtnOption5 = findViewById(R.id.ibtnOption5);
        ibtnOption6 = findViewById(R.id.ibtnOption6);
        ibtnOption7 = findViewById(R.id.ibtnOption7);
        ibtnOption8 = findViewById(R.id.ibtnOption8);
        ibtnOption9 = findViewById(R.id.ibtnOption9);
        ibtnOption10 = findViewById(R.id.ibtnOption10);

        // Other
        llOptions = findViewById(R.id.llOptions);

        selection();
        getStuff();
    }

    public void selection()
    {
        Log.i(TAG, "selection: Selected a Carrier");

        BurgerKing();
        ChickenLicken();
        Fishaways();
        KFC();
        McDonalds();
        Steers();
    }

    public void BurgerKing()
    {
        Log.i(TAG, "CellC: Selected This Carrier");

        ibtnBurgerKing.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                final double opt1 = 10.00;
                final double opt2 = 29.00;
                final double opt3 = 50.00;
                final double opt4 = 100.00;
                final double opt5 = 200.00;

                Log.i(TAG, "onClick: Setting Button Texts");

                // Setting Text for the user
                ibtnOption1.setBackgroundResource(R.drawable.bank_logo_cellc);
                ibtnOption2.setBackgroundResource(R.drawable.bank_logo_cellc);
                ibtnOption3.setBackgroundResource(R.drawable.bank_logo_cellc);
                ibtnOption4.setBackgroundResource(R.drawable.bank_logo_cellc);
                ibtnOption5.setBackgroundResource(R.drawable.bank_logo_cellc);

                etSpent.setText(null);
                llOptions.setVisibility(View.VISIBLE);

                // Setting the visibility of some buttons
                ibtnOption1.setVisibility(View.VISIBLE);
                ibtnOption2.setVisibility(View.VISIBLE);
                ibtnOption3.setVisibility(View.VISIBLE);
                ibtnOption4.setVisibility(View.VISIBLE);
                ibtnOption5.setVisibility(View.VISIBLE);
                ibtnOption6.setVisibility(View.GONE);
                ibtnOption7.setVisibility(View.GONE);
                ibtnOption8.setVisibility(View.GONE);
                ibtnOption9.setVisibility(View.GONE);
                ibtnOption10.setVisibility(View.GONE);

                Log.i(TAG, "onClick: Cell C Buttons Set and " +
                        "Made Visible");

                ibtnOption1.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt1);

                        Intent intent = new Intent
                                (BuyFoodActivity.this, BuyActivity.class);
                        Bundle extras = new Bundle();

                        extras.putString("location", "Cell C");
                        extras.putString("category2", category);
                        extras.putDouble("spent", opt1);
                        extras.putString("card2", card);
                        extras.putInt("buttonOn", 9999);
                        extras.putString("cardNo3", cardNo);
                        extras.putDouble("iamount2", iamount);

                        Log.i(TAG, "onClick: Button Clicked " +
                                "with value of R" + opt1);

                        intent.putExtras(extras);
                        startActivity(intent);

                        Log.i(TAG, "onClick: Starting BuyActivity");
                    }
                });

                ibtnOption2.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt2);

                        Intent intent = new Intent
                                (BuyFoodActivity.this, BuyActivity.class);
                        Bundle extras = new Bundle();

                        extras.putString("location", "Cell C");
                        extras.putString("category2", category);
                        extras.putDouble("spent", opt2);
                        extras.putString("card2", card);
                        extras.putInt("buttonOn", 9999);
                        extras.putString("cardNo3", cardNo);
                        extras.putDouble("iamount2", iamount);

                        Log.i(TAG, "onClick: Button Clicked " +
                                "with value of R" + opt2);

                        intent.putExtras(extras);
                        startActivity(intent);

                        Log.i(TAG, "onClick: Starting BuyActivity");
                    }
                });

                ibtnOption3.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt3);

                        Intent intent = new Intent
                                (BuyFoodActivity.this, BuyActivity.class);
                        Bundle extras = new Bundle();

                        extras.putString("location", "Cell C");
                        extras.putString("category2", category);
                        extras.putDouble("spent", opt3);
                        extras.putString("card2", card);
                        extras.putInt("buttonOn", 9999);
                        extras.putString("cardNo3", cardNo);
                        extras.putDouble("iamount2", iamount);

                        Log.i(TAG, "onClick: Button Clicked " +
                                "with value of R" + opt3);

                        intent.putExtras(extras);
                        startActivity(intent);

                        Log.i(TAG, "onClick: Starting BuyActivity");
                    }
                });

                ibtnOption4.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt4);

                        Intent intent = new Intent
                                (BuyFoodActivity.this, BuyActivity.class);
                        Bundle extras = new Bundle();

                        extras.putString("location", "Cell C");
                        extras.putString("category2", category);
                        extras.putDouble("spent", opt4);
                        extras.putString("card2", card);
                        extras.putInt("buttonOn", 9999);
                        extras.putString("cardNo3", cardNo);
                        extras.putDouble("iamount2", iamount);

                        Log.i(TAG, "onClick: Button Clicked " +
                                "with value of R" + opt4);

                        intent.putExtras(extras);
                        startActivity(intent);

                        Log.i(TAG, "onClick: Starting BuyActivity");
                    }
                });

                ibtnOption5.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt5);

                        Intent intent = new Intent
                                (BuyFoodActivity.this, BuyActivity.class);
                        Bundle extras = new Bundle();

                        extras.putString("location", "Cell C");
                        extras.putString("category2", category);
                        extras.putDouble("spent", opt5);
                        extras.putString("card2", card);
                        extras.putInt("buttonOn", 9999);
                        extras.putString("cardNo3", cardNo);
                        extras.putDouble("iamount2", iamount);

                        Log.i(TAG, "onClick: Button Clicked " +
                                "with value of R" + opt5);

                        intent.putExtras(extras);
                        startActivity(intent);

                        Log.i(TAG, "onClick: Starting BuyActivity");
                    }
                });
            }
        });
    }

    public void ChickenLicken()
    {
        Log.i(TAG, "MTN: Selected This Carrier");

        ibtnChickenLicken.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                final double opt1 = 5.00;
                final double opt2 = 29.00;
                final double opt3 = 50.00;
                final double opt4 = 100.00;
                final double opt5 = 200.00;

                Log.i(TAG, "onClick: Setting Button Texts");

                // Setting Text for the user
                ibtnOption1.setBackgroundResource(R.drawable.bank_logo_cellc);
                ibtnOption2.setBackgroundResource(R.drawable.bank_logo_cellc);
                ibtnOption3.setBackgroundResource(R.drawable.bank_logo_cellc);
                ibtnOption4.setBackgroundResource(R.drawable.bank_logo_cellc);
                ibtnOption5.setBackgroundResource(R.drawable.bank_logo_cellc);

                etSpent.setText(null);
                llOptions.setVisibility(View.VISIBLE);

                // Setting the visibility of some buttons
                ibtnOption1.setVisibility(View.VISIBLE);
                ibtnOption2.setVisibility(View.VISIBLE);
                ibtnOption3.setVisibility(View.VISIBLE);
                ibtnOption4.setVisibility(View.VISIBLE);
                ibtnOption5.setVisibility(View.VISIBLE);
                ibtnOption6.setVisibility(View.GONE);
                ibtnOption7.setVisibility(View.GONE);
                ibtnOption8.setVisibility(View.GONE);
                ibtnOption9.setVisibility(View.GONE);
                ibtnOption10.setVisibility(View.GONE);

                Log.i(TAG, "onClick: MTN Buttons Set and " +
                        "Made Visible");

                ibtnOption1.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt1);

                        Intent intent = new Intent
                                (BuyFoodActivity.this, BuyActivity.class);
                        Bundle extras = new Bundle();

                        extras.putString("location", "MTN");
                        extras.putString("category2", category);
                        extras.putDouble("spent", opt1);
                        extras.putString("card2", card);
                        extras.putInt("buttonOn", 9999);
                        extras.putString("cardNo3", cardNo);
                        extras.putDouble("iamount2", iamount);

                        Log.i(TAG, "onClick: Button Clicked " +
                                "with value of R" + opt1);

                        intent.putExtras(extras);
                        startActivity(intent);

                        Log.i(TAG, "onClick: Starting BuyActivity");
                    }
                });

                ibtnOption2.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt2);

                        Intent intent = new Intent
                                (BuyFoodActivity.this, BuyActivity.class);
                        Bundle extras = new Bundle();

                        extras.putString("location", "MTN");
                        extras.putString("category2", category);
                        extras.putDouble("spent", opt2);
                        extras.putString("card2", card);
                        extras.putInt("buttonOn", 9999);
                        extras.putString("cardNo3", cardNo);
                        extras.putDouble("iamount2", iamount);

                        Log.i(TAG, "onClick: Button Clicked " +
                                "with value of R" + opt2);

                        intent.putExtras(extras);
                        startActivity(intent);

                        Log.i(TAG, "onClick: Starting BuyActivity");
                    }
                });

                ibtnOption3.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt3);

                        Intent intent = new Intent
                                (BuyFoodActivity.this, BuyActivity.class);
                        Bundle extras = new Bundle();

                        extras.putString("location", "MTN");
                        extras.putString("category2", category);
                        extras.putDouble("spent", opt3);
                        extras.putString("card2", card);
                        extras.putInt("buttonOn", 9999);
                        extras.putString("cardNo3", cardNo);
                        extras.putDouble("iamount2", iamount);

                        Log.i(TAG, "onClick: Button Clicked " +
                                "with value of R" + opt3);

                        intent.putExtras(extras);
                        startActivity(intent);

                        Log.i(TAG, "onClick: Starting BuyActivity");
                    }
                });

                ibtnOption4.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt4);

                        Intent intent = new Intent
                                (BuyFoodActivity.this, BuyActivity.class);
                        Bundle extras = new Bundle();

                        extras.putString("location", "MTN");
                        extras.putString("category2", category);
                        extras.putDouble("spent", opt4);
                        extras.putString("card2", card);
                        extras.putInt("buttonOn", 9999);
                        extras.putString("cardNo3", cardNo);
                        extras.putDouble("iamount2", iamount);

                        Log.i(TAG, "onClick: Button Clicked " +
                                "with value of R" + opt4);

                        intent.putExtras(extras);
                        startActivity(intent);

                        Log.i(TAG, "onClick: Starting BuyActivity");
                    }
                });

                ibtnOption5.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt5);

                        Intent intent = new Intent
                                (BuyFoodActivity.this, BuyActivity.class);
                        Bundle extras = new Bundle();

                        extras.putString("location", "MTN");
                        extras.putString("category2", category);
                        extras.putDouble("spent", opt5);
                        extras.putString("card2", card);
                        extras.putInt("buttonOn", 9999);
                        extras.putString("cardNo3", cardNo);
                        extras.putDouble("iamount2", iamount);

                        Log.i(TAG, "onClick: Button Clicked " +
                                "with value of R" + opt5);

                        intent.putExtras(extras);
                        startActivity(intent);

                        Log.i(TAG, "onClick: Starting BuyActivity");
                    }
                });
            }
        });
    }

    public void Fishaways()
    {
        Log.i(TAG, "Telkom: Selected This Carrier");

        ibtnFishaways.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                final double opt1 = 40.00;
                final double opt2 = 50.00;
                final double opt3 = 100.00;
                final double opt4 = 200.00;

                Log.i(TAG, "onClick: Setting Button Texts");

                // Setting Text for the user
                ibtnOption1.setBackgroundResource(R.drawable.bank_logo_cellc);
                ibtnOption2.setBackgroundResource(R.drawable.bank_logo_cellc);
                ibtnOption3.setBackgroundResource(R.drawable.bank_logo_cellc);
                ibtnOption4.setBackgroundResource(R.drawable.bank_logo_cellc);

                etSpent.setText(null);
                llOptions.setVisibility(View.VISIBLE);

                // Setting the visibility of some buttons
                ibtnOption1.setVisibility(View.VISIBLE);
                ibtnOption2.setVisibility(View.VISIBLE);
                ibtnOption3.setVisibility(View.VISIBLE);
                ibtnOption4.setVisibility(View.VISIBLE);
                ibtnOption5.setVisibility(View.GONE);
                ibtnOption6.setVisibility(View.GONE);
                ibtnOption7.setVisibility(View.GONE);
                ibtnOption8.setVisibility(View.GONE);
                ibtnOption9.setVisibility(View.GONE);
                ibtnOption10.setVisibility(View.GONE);

                Log.i(TAG, "onClick: Telkom Buttons Set and " +
                        "Made Visible");

                ibtnOption1.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt1);

                        Intent intent = new Intent
                                (BuyFoodActivity.this, BuyActivity.class);
                        Bundle extras = new Bundle();

                        extras.putString("location", "Telkom");
                        extras.putString("category2", category);
                        extras.putDouble("spent", opt1);
                        extras.putString("card2", card);
                        extras.putInt("buttonOn", 9999);
                        extras.putString("cardNo3", cardNo);
                        extras.putDouble("iamount2", iamount);

                        Log.i(TAG, "onClick: Button Clicked " +
                                "with value of R" + opt1);

                        intent.putExtras(extras);
                        startActivity(intent);

                        Log.i(TAG, "onClick: Starting BuyActivity");
                    }
                });

                ibtnOption2.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt2);

                        Intent intent = new Intent
                                (BuyFoodActivity.this, BuyActivity.class);
                        Bundle extras = new Bundle();

                        extras.putString("location", "Telkom");
                        extras.putString("category2", category);
                        extras.putDouble("spent", opt2);
                        extras.putString("card2", card);
                        extras.putInt("buttonOn", 9999);
                        extras.putString("cardNo3", cardNo);
                        extras.putDouble("iamount2", iamount);

                        Log.i(TAG, "onClick: Button Clicked " +
                                "with value of R" + opt2);

                        intent.putExtras(extras);
                        startActivity(intent);

                        Log.i(TAG, "onClick: Starting BuyActivity");
                    }
                });

                ibtnOption3.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt3);

                        Intent intent = new Intent
                                (BuyFoodActivity.this, BuyActivity.class);
                        Bundle extras = new Bundle();

                        extras.putString("location", "Telkom");
                        extras.putString("category2", category);
                        extras.putDouble("spent", opt3);
                        extras.putString("card2", card);
                        extras.putInt("buttonOn", 9999);
                        extras.putString("cardNo3", cardNo);
                        extras.putDouble("iamount2", iamount);

                        Log.i(TAG, "onClick: Button Clicked " +
                                "with value of R" + opt3);

                        intent.putExtras(extras);
                        startActivity(intent);

                        Log.i(TAG, "onClick: Starting BuyActivity");
                    }
                });

                ibtnOption4.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt4);

                        Intent intent = new Intent
                                (BuyFoodActivity.this, BuyActivity.class);
                        Bundle extras = new Bundle();

                        extras.putString("location", "Telkom");
                        extras.putString("category2", category);
                        extras.putDouble("spent", opt4);
                        extras.putString("card2", card);
                        extras.putInt("buttonOn", 9999);
                        extras.putString("cardNo3", cardNo);
                        extras.putDouble("iamount2", iamount);

                        Log.i(TAG, "onClick: Button Clicked " +
                                "with value of R" + opt4);

                        intent.putExtras(extras);
                        startActivity(intent);

                        Log.i(TAG, "onClick: Starting BuyActivity");
                    }
                });
            }
        });
    }

    public void KFC()
    {
        Log.i(TAG, "Vodacom: Selected This Carrier");

        ibtnKFC.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                final double opt1 = 5.00;
                final double opt2 = 29.00;
                final double opt3 = 50.00;
                final double opt4 = 100.00;
                final double opt5 = 200.00;

                Log.i(TAG, "onClick: Setting Button Texts");

                // Setting Text for the user
                ibtnOption1.setBackgroundResource(R.drawable.bank_logo_cellc);
                ibtnOption2.setBackgroundResource(R.drawable.bank_logo_cellc);
                ibtnOption3.setBackgroundResource(R.drawable.bank_logo_cellc);
                ibtnOption4.setBackgroundResource(R.drawable.bank_logo_cellc);
                ibtnOption5.setBackgroundResource(R.drawable.bank_logo_cellc);

                etSpent.setText(null);
                llOptions.setVisibility(View.VISIBLE);

                // Setting the visibility of some buttons
                ibtnOption1.setVisibility(View.VISIBLE);
                ibtnOption2.setVisibility(View.VISIBLE);
                ibtnOption3.setVisibility(View.VISIBLE);
                ibtnOption4.setVisibility(View.VISIBLE);
                ibtnOption5.setVisibility(View.VISIBLE);
                ibtnOption6.setVisibility(View.GONE);
                ibtnOption7.setVisibility(View.GONE);
                ibtnOption8.setVisibility(View.GONE);
                ibtnOption9.setVisibility(View.GONE);
                ibtnOption10.setVisibility(View.GONE);

                Log.i(TAG, "onClick: Vodacom Buttons Set and " +
                        "Made Visible");

                ibtnOption1.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt1);

                        Intent intent = new Intent
                                (BuyFoodActivity.this, BuyActivity.class);
                        Bundle extras = new Bundle();

                        extras.putString("location", "Vodacom");
                        extras.putString("category2", category);
                        extras.putDouble("spent", opt1);
                        extras.putString("card2", card);
                        extras.putInt("buttonOn", 9999);
                        extras.putString("cardNo3", cardNo);
                        extras.putDouble("iamount2", iamount);

                        Log.i(TAG, "onClick: Button Clicked " +
                                "with value of R" + opt1);

                        intent.putExtras(extras);
                        startActivity(intent);

                        Log.i(TAG, "onClick: Starting BuyActivity");
                    }
                });

                ibtnOption2.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt2);

                        Intent intent = new Intent
                                (BuyFoodActivity.this, BuyActivity.class);
                        Bundle extras = new Bundle();

                        extras.putString("location", "Vodacom");
                        extras.putString("category2", category);
                        extras.putDouble("spent", opt2);
                        extras.putString("card2", card);
                        extras.putInt("buttonOn", 9999);
                        extras.putString("cardNo3", cardNo);
                        extras.putDouble("iamount2", iamount);

                        Log.i(TAG, "onClick: Button Clicked " +
                                "with value of R" + opt2);

                        intent.putExtras(extras);
                        startActivity(intent);

                        Log.i(TAG, "onClick: Starting BuyActivity");
                    }
                });

                ibtnOption3.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt3);

                        Intent intent = new Intent
                                (BuyFoodActivity.this, BuyActivity.class);
                        Bundle extras = new Bundle();

                        extras.putString("location", "Vodacom");
                        extras.putString("category2", category);
                        extras.putDouble("spent", opt3);
                        extras.putString("card2", card);
                        extras.putInt("buttonOn", 9999);
                        extras.putString("cardNo3", cardNo);
                        extras.putDouble("iamount2", iamount);

                        Log.i(TAG, "onClick: Button Clicked " +
                                "with value of R" + opt3);

                        intent.putExtras(extras);
                        startActivity(intent);

                        Log.i(TAG, "onClick: Starting BuyActivity");
                    }
                });

                ibtnOption4.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt4);

                        Intent intent = new Intent
                                (BuyFoodActivity.this, BuyActivity.class);
                        Bundle extras = new Bundle();

                        extras.putString("location", "Vodacom");
                        extras.putString("category2", category);
                        extras.putDouble("spent", opt4);
                        extras.putString("card2", card);
                        extras.putInt("buttonOn", 9999);
                        extras.putString("cardNo3", cardNo);
                        extras.putDouble("iamount2", iamount);

                        Log.i(TAG, "onClick: Button Clicked " +
                                "with value of R" + opt4);

                        intent.putExtras(extras);
                        startActivity(intent);

                        Log.i(TAG, "onClick: Starting BuyActivity");
                    }
                });

                ibtnOption5.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt5);

                        Intent intent = new Intent
                                (BuyFoodActivity.this, BuyActivity.class);
                        Bundle extras = new Bundle();

                        extras.putString("location", "Vodacom");
                        extras.putString("category2", category);
                        extras.putDouble("spent", opt5);
                        extras.putString("card2", card);
                        extras.putInt("buttonOn", 9999);
                        extras.putString("cardNo3", cardNo);
                        extras.putDouble("iamount2", iamount);

                        Log.i(TAG, "onClick: Button Clicked " +
                                "with value of R" + opt5);

                        intent.putExtras(extras);
                        startActivity(intent);

                        Log.i(TAG, "onClick: Starting BuyActivity");
                    }
                });
            }
        });
    }

    public void McDonalds()
    {
        Log.i(TAG, "VirginMobile: Selected This Carrier");

        ibtnMcDonalds.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                final double opt1 = 10.00;
                final double opt2 = 29.00;
                final double opt3 = 50.00;
                final double opt4 = 100.00;
                final double opt5 = 200.00;

                Log.i(TAG, "onClick: Setting Button Texts");

                // Setting Text for the user
                ibtnOption1.setBackgroundResource(R.drawable.bank_logo_cellc);
                ibtnOption2.setBackgroundResource(R.drawable.bank_logo_cellc);
                ibtnOption3.setBackgroundResource(R.drawable.bank_logo_cellc);
                ibtnOption4.setBackgroundResource(R.drawable.bank_logo_cellc);
                ibtnOption5.setBackgroundResource(R.drawable.bank_logo_cellc);

                etSpent.setText(null);
                llOptions.setVisibility(View.VISIBLE);

                // Setting the visibility of some buttons
                ibtnOption1.setVisibility(View.VISIBLE);
                ibtnOption2.setVisibility(View.VISIBLE);
                ibtnOption3.setVisibility(View.VISIBLE);
                ibtnOption4.setVisibility(View.VISIBLE);
                ibtnOption5.setVisibility(View.VISIBLE);
                ibtnOption6.setVisibility(View.GONE);
                ibtnOption7.setVisibility(View.GONE);
                ibtnOption8.setVisibility(View.GONE);
                ibtnOption9.setVisibility(View.GONE);
                ibtnOption10.setVisibility(View.GONE);

                Log.i(TAG, "onClick: Virgin Mobile Buttons Set and " +
                        "Made Visible");


                ibtnOption1.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt1);

                        Intent intent = new Intent
                                (BuyFoodActivity.this, BuyActivity.class);
                        Bundle extras = new Bundle();

                        extras.putString("location", "Virgin Mobile");
                        extras.putString("category2", category);
                        extras.putDouble("spent", opt1);
                        extras.putString("card2", card);
                        extras.putInt("buttonOn", 9999);
                        extras.putString("cardNo3", cardNo);
                        extras.putDouble("iamount2", iamount);

                        Log.i(TAG, "onClick: Button Clicked " +
                                "with value of R" + opt1);

                        intent.putExtras(extras);
                        startActivity(intent);

                        Log.i(TAG, "onClick: Starting BuyActivity");
                    }
                });

                ibtnOption2.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt2);

                        Intent intent = new Intent
                                (BuyFoodActivity.this, BuyActivity.class);
                        Bundle extras = new Bundle();

                        extras.putString("location", "Virgin Mobile");
                        extras.putString("category2", category);
                        extras.putDouble("spent", opt2);
                        extras.putString("card2", card);
                        extras.putInt("buttonOn", 9999);
                        extras.putString("cardNo3", cardNo);
                        extras.putDouble("iamount2", iamount);

                        Log.i(TAG, "onClick: Button Clicked " +
                                "with value of R" + opt2);

                        intent.putExtras(extras);
                        startActivity(intent);

                        Log.i(TAG, "onClick: Starting BuyActivity");
                    }
                });

                ibtnOption3.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt3);

                        Intent intent = new Intent
                                (BuyFoodActivity.this, BuyActivity.class);
                        Bundle extras = new Bundle();

                        extras.putString("location", "Virgin Mobile");
                        extras.putString("category2", category);
                        extras.putDouble("spent", opt3);
                        extras.putString("card2", card);
                        extras.putInt("buttonOn", 9999);
                        extras.putString("cardNo3", cardNo);
                        extras.putDouble("iamount2", iamount);

                        Log.i(TAG, "onClick: Button Clicked " +
                                "with value of R" + opt3);

                        intent.putExtras(extras);
                        startActivity(intent);

                        Log.i(TAG, "onClick: Starting BuyActivity");
                    }
                });

                ibtnOption4.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt4);

                        Intent intent = new Intent
                                (BuyFoodActivity.this, BuyActivity.class);
                        Bundle extras = new Bundle();

                        extras.putString("location", "Virgin Mobile");
                        extras.putString("category2", category);
                        extras.putDouble("spent", opt4);
                        extras.putString("card2", card);
                        extras.putInt("buttonOn", 9999);
                        extras.putString("cardNo3", cardNo);
                        extras.putDouble("iamount2", iamount);

                        Log.i(TAG, "onClick: Button Clicked " +
                                "with value of R" + opt4);

                        intent.putExtras(extras);
                        startActivity(intent);

                        Log.i(TAG, "onClick: Starting BuyActivity");
                    }
                });

                ibtnOption5.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt5);

                        Intent intent = new Intent
                                (BuyFoodActivity.this, BuyActivity.class);
                        Bundle extras = new Bundle();

                        extras.putString("location", "Virgin Mobile");
                        extras.putString("category2", category);
                        extras.putDouble("spent", opt5);
                        extras.putString("card2", card);
                        extras.putInt("buttonOn", 9999);
                        extras.putString("cardNo3", cardNo);
                        extras.putDouble("iamount2", iamount);

                        Log.i(TAG, "onClick: Button Clicked " +
                                "with value of R" + opt5);

                        intent.putExtras(extras);
                        startActivity(intent);

                        Log.i(TAG, "onClick: Starting BuyActivity");
                    }
                });
            }
        });
    }

    public void Steers()
    {
        Log.i(TAG, "TelkomMobile: Selected This Carrier");

        ibtnSteers.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                final double opt1 = 10.00;
                final double opt2 = 20.00;
                final double opt3 = 29.00;
                final double opt4 = 30.00;
                final double opt5 = 50.00;
                final double opt6 = 100.00;
                final double opt7 = 200.00;
                final double opt8 = 250.00;
                final double opt9 = 1000.00;

                Log.i(TAG, "onClick: Setting Button Texts");

                // Setting Text for the user
                ibtnOption1.setBackgroundResource(R.drawable.bank_logo_cellc);
                ibtnOption2.setBackgroundResource(R.drawable.bank_logo_cellc);
                ibtnOption3.setBackgroundResource(R.drawable.bank_logo_cellc);;
                ibtnOption4.setBackgroundResource(R.drawable.bank_logo_cellc);
                ibtnOption5.setBackgroundResource(R.drawable.bank_logo_cellc);
                ibtnOption6.setBackgroundResource(R.drawable.bank_logo_cellc);
                ibtnOption7.setBackgroundResource(R.drawable.bank_logo_cellc);
                ibtnOption8.setBackgroundResource(R.drawable.bank_logo_cellc);
                ibtnOption9.setBackgroundResource(R.drawable.bank_logo_cellc);

                etSpent.setText(null);
                llOptions.setVisibility(View.VISIBLE);

                // Setting the visibility of some buttons
                ibtnOption1.setVisibility(View.VISIBLE);
                ibtnOption2.setVisibility(View.VISIBLE);
                ibtnOption3.setVisibility(View.VISIBLE);
                ibtnOption4.setVisibility(View.VISIBLE);
                ibtnOption5.setVisibility(View.VISIBLE);
                ibtnOption6.setVisibility(View.VISIBLE);
                ibtnOption7.setVisibility(View.VISIBLE);
                ibtnOption8.setVisibility(View.VISIBLE);
                ibtnOption9.setVisibility(View.VISIBLE);
                ibtnOption10.setVisibility(View.GONE);

                Log.i(TAG, "onClick: Telkom Mobile Buttons Set and " +
                        "Made Visible");

                ibtnOption1.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt1);

                        Intent intent = new Intent
                                (BuyFoodActivity.this, BuyActivity.class);
                        Bundle extras = new Bundle();

                        extras.putString("location", "Telkom Mobile");
                        extras.putString("category2", category);
                        extras.putDouble("spent", opt1);
                        extras.putString("card2", card);
                        extras.putInt("buttonOn", 9999);
                        extras.putString("cardNo3", cardNo);
                        extras.putDouble("iamount2", iamount);

                        Log.i(TAG, "onClick: Button Clicked " +
                                "with value of R" + opt1);

                        intent.putExtras(extras);
                        startActivity(intent);

                        Log.i(TAG, "onClick: Starting BuyActivity");
                    }
                });

                ibtnOption2.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt2);

                        Intent intent = new Intent
                                (BuyFoodActivity.this, BuyActivity.class);
                        Bundle extras = new Bundle();

                        extras.putString("location", "Telkom Mobile");
                        extras.putString("category2", category);
                        extras.putDouble("spent", opt2);
                        extras.putString("card2", card);
                        extras.putInt("buttonOn", 9999);
                        extras.putString("cardNo3", cardNo);
                        extras.putDouble("iamount2", iamount);

                        Log.i(TAG, "onClick: Button Clicked " +
                                "with value of R" + opt2);

                        intent.putExtras(extras);
                        startActivity(intent);

                        Log.i(TAG, "onClick: Starting BuyActivity");
                    }
                });

                ibtnOption3.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt3);

                        Intent intent = new Intent
                                (BuyFoodActivity.this, BuyActivity.class);
                        Bundle extras = new Bundle();

                        extras.putString("location", "Telkom Mobile");
                        extras.putString("category2", category);
                        extras.putDouble("spent", opt3);
                        extras.putString("card2", card);
                        extras.putInt("buttonOn", 9999);
                        extras.putString("cardNo3", cardNo);
                        extras.putDouble("iamount2", iamount);

                        Log.i(TAG, "onClick: Button Clicked " +
                                "with value of R" + opt3);

                        intent.putExtras(extras);
                        startActivity(intent);

                        Log.i(TAG, "onClick: Starting BuyActivity");
                    }
                });

                ibtnOption4.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt4);

                        Intent intent = new Intent
                                (BuyFoodActivity.this, BuyActivity.class);
                        Bundle extras = new Bundle();

                        extras.putString("location", "Telkom Mobile");
                        extras.putString("category2", category);
                        extras.putDouble("spent", opt4);
                        extras.putString("card2", card);
                        extras.putInt("buttonOn", 9999);
                        extras.putString("cardNo3", cardNo);
                        extras.putDouble("iamount2", iamount);

                        Log.i(TAG, "onClick: Button Clicked " +
                                "with value of R" + opt4);

                        intent.putExtras(extras);
                        startActivity(intent);

                        Log.i(TAG, "onClick: Starting BuyActivity");
                    }
                });

                ibtnOption5.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt5);

                        Intent intent = new Intent
                                (BuyFoodActivity.this, BuyActivity.class);
                        Bundle extras = new Bundle();

                        extras.putString("location", "Telkom Mobile");
                        extras.putString("category2", category);
                        extras.putDouble("spent", opt5);
                        extras.putString("card2", card);
                        extras.putInt("buttonOn", 9999);
                        extras.putString("cardNo3", cardNo);
                        extras.putDouble("iamount2", iamount);

                        Log.i(TAG, "onClick: Button Clicked " +
                                "with value of R" + opt5);

                        intent.putExtras(extras);
                        startActivity(intent);

                        Log.i(TAG, "onClick: Starting BuyActivity");
                    }
                });

                ibtnOption6.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt6);

                        Intent intent = new Intent
                                (BuyFoodActivity.this, BuyActivity.class);
                        Bundle extras = new Bundle();

                        extras.putString("location", "Telkom Mobile");
                        extras.putString("category2", category);
                        extras.putDouble("spent", opt6);
                        extras.putString("card2", card);
                        extras.putInt("buttonOn", 9999);
                        extras.putString("cardNo3", cardNo);
                        extras.putDouble("iamount2", iamount);

                        Log.i(TAG, "onClick: Button Clicked " +
                                "with value of R" + opt6);

                        intent.putExtras(extras);
                        startActivity(intent);

                        Log.i(TAG, "onClick: Starting BuyActivity");
                    }
                });

                ibtnOption7.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt7);

                        Intent intent = new Intent
                                (BuyFoodActivity.this, BuyActivity.class);
                        Bundle extras = new Bundle();

                        extras.putString("location", "Telkom Mobile");
                        extras.putString("category2", category);
                        extras.putDouble("spent", opt7);
                        extras.putString("card2", card);
                        extras.putInt("buttonOn", 9999);
                        extras.putString("cardNo3", cardNo);
                        extras.putDouble("iamount2", iamount);

                        Log.i(TAG, "onClick: Button Clicked " +
                                "with value of R" + opt7);

                        intent.putExtras(extras);
                        startActivity(intent);

                        Log.i(TAG, "onClick: Starting BuyActivity");
                    }
                });

                ibtnOption8.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt8);

                        Intent intent = new Intent
                                (BuyFoodActivity.this, BuyActivity.class);
                        Bundle extras = new Bundle();

                        extras.putString("location", "Telkom Mobile");
                        extras.putString("category2", category);
                        extras.putDouble("spent", opt8);
                        extras.putString("card2", card);
                        extras.putInt("buttonOn", 9999);
                        extras.putString("cardNo3", cardNo);
                        extras.putDouble("iamount2", iamount);

                        Log.i(TAG, "onClick: Button Clicked " +
                                "with value of R" + opt8);

                        intent.putExtras(extras);
                        startActivity(intent);

                        Log.i(TAG, "onClick: Starting BuyActivity");
                    }
                });

                ibtnOption9.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt9);

                        Intent intent = new Intent
                                (BuyFoodActivity.this, BuyActivity.class);
                        Bundle extras = new Bundle();

                        extras.putString("location", "Telkom Mobile");
                        extras.putString("category2", category);
                        extras.putDouble("spent", opt9);
                        extras.putString("card2", card);
                        extras.putInt("buttonOn", 9999);
                        extras.putString("cardNo3", cardNo);
                        extras.putDouble("iamount2", iamount);

                        Log.i(TAG, "onClick: Button Clicked " +
                                "with value of R" + opt9);

                        intent.putExtras(extras);
                        startActivity(intent);

                        Log.i(TAG, "onClick: Starting BuyActivity");
                    }
                });
            }
        });
    }

    public void getStuff()
    {
        Log.i(TAG, "getStuff: Getting Extras from BuyActivity");

        Bundle extras = getIntent().getExtras();
        if (extras != null)
        {
            category = extras.getString("category");
            card = extras.getString("card");
            cardNo = extras.getString("cardNo2");
            iamount = extras.getDouble("iamount");

            Log.i(TAG, "getStuff: Category is stored as: " + category);
            Log.i(TAG, "getStuff: card is stored as: " + card);
        }
    }
}
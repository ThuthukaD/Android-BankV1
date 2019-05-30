package com.example.desel.bankv1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class BuyAirtimeActivity extends AppCompatActivity
{
    // VARIABLES

    // Image Buttons
    ImageButton ibtnCellC;
    ImageButton ibtnMTN;
    ImageButton ibtnTelkom;
    ImageButton ibtnVodacom;
    ImageButton ibtnVirginMobile;
    ImageButton ibtnTelkomMobile;

    // Edit Texts
    EditText etSpent;

    // Buttons
    Button btnOption1;
    Button btnOption2;
    Button btnOption3;
    Button btnOption4;
    Button btnOption5;
    Button btnOption6;
    Button btnOption7;
    Button btnOption8;
    Button btnOption9;
    Button btnOption10;

    // Storage
    String category;
    String card;
    String cardNo;
    double iamount;

    // Other
    LinearLayout llOptions;

    private static final String TAG = "BuyAirtimeActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_airtime);

        // INITIALISING

        // Image Buttons
        ibtnCellC = findViewById(R.id.ibtnCellC);
        ibtnMTN = findViewById(R.id.ibtnMTN);
        ibtnTelkom = findViewById(R.id.ibtnTelkom);
        ibtnVodacom = findViewById(R.id.ibtnVodacom);
        ibtnVirginMobile = findViewById(R.id.ibtnVirginMobile);
        ibtnTelkomMobile = findViewById(R.id.ibtnTelkomMobile);

        // Edit Texts
        etSpent = findViewById(R.id.etSpent);

        // Buttons
        btnOption1 = findViewById(R.id.btnOption1);
        btnOption2 = findViewById(R.id.btnOption2);
        btnOption3 = findViewById(R.id.btnOption3);
        btnOption4 = findViewById(R.id.btnOption4);
        btnOption5 = findViewById(R.id.btnOption5);
        btnOption6 = findViewById(R.id.btnOption6);
        btnOption7 = findViewById(R.id.btnOption7);
        btnOption8 = findViewById(R.id.btnOption8);
        btnOption9 = findViewById(R.id.btnOption9);
        btnOption10 = findViewById(R.id.btnOption10);

        // Other
        llOptions = findViewById(R.id.llOptions);

        selection();
        getStuff();
    }

    public void selection()
    {
        Log.i(TAG, "selection: Selected a Carrier");

        CellC();
        MTN();
        Telkom();
        Vodacom();
        VirginMobile();
        TelkomMobile();
    }

    public void CellC()
    {
        Log.i(TAG, "CellC: Selected This Carrier");

        ibtnCellC.setOnClickListener(new View.OnClickListener()
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
                btnOption1.setText("R" + opt1);
                btnOption2.setText("R" + opt2);
                btnOption3.setText("R" + opt3);
                btnOption4.setText("R" + opt4);
                btnOption5.setText("R" + opt5);

                etSpent.setText(null);
                llOptions.setVisibility(View.VISIBLE);

                // Setting the visibility of some buttons
                btnOption1.setVisibility(View.VISIBLE);
                btnOption2.setVisibility(View.VISIBLE);
                btnOption3.setVisibility(View.VISIBLE);
                btnOption4.setVisibility(View.VISIBLE);
                btnOption5.setVisibility(View.VISIBLE);
                btnOption6.setVisibility(View.GONE);
                btnOption7.setVisibility(View.GONE);
                btnOption8.setVisibility(View.GONE);
                btnOption9.setVisibility(View.GONE);
                btnOption10.setVisibility(View.GONE);

                Log.i(TAG, "onClick: Cell C Buttons Set and " +
                        "Made Visible");

                btnOption1.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt1);

                        Intent intent = new Intent
                                (BuyAirtimeActivity.this, BuyActivity.class);
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

                btnOption2.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt2);

                        Intent intent = new Intent
                                (BuyAirtimeActivity.this, BuyActivity.class);
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

                btnOption3.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt3);

                        Intent intent = new Intent
                                (BuyAirtimeActivity.this, BuyActivity.class);
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

                btnOption4.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt4);

                        Intent intent = new Intent
                                (BuyAirtimeActivity.this, BuyActivity.class);
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

                btnOption5.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt5);

                        Intent intent = new Intent
                                (BuyAirtimeActivity.this, BuyActivity.class);
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

    public void MTN()
    {
        Log.i(TAG, "MTN: Selected This Carrier");

        ibtnMTN.setOnClickListener(new View.OnClickListener()
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
                btnOption1.setText("R" + opt1);
                btnOption2.setText("R" + opt2);
                btnOption3.setText("R" + opt3);
                btnOption4.setText("R" + opt4);
                btnOption5.setText("R" + opt5);

                etSpent.setText(null);
                llOptions.setVisibility(View.VISIBLE);

                // Setting the visibility of some buttons
                btnOption1.setVisibility(View.VISIBLE);
                btnOption2.setVisibility(View.VISIBLE);
                btnOption3.setVisibility(View.VISIBLE);
                btnOption4.setVisibility(View.VISIBLE);
                btnOption5.setVisibility(View.VISIBLE);
                btnOption6.setVisibility(View.GONE);
                btnOption7.setVisibility(View.GONE);
                btnOption8.setVisibility(View.GONE);
                btnOption9.setVisibility(View.GONE);
                btnOption10.setVisibility(View.GONE);

                Log.i(TAG, "onClick: MTN Buttons Set and " +
                        "Made Visible");

                btnOption1.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt1);

                        Intent intent = new Intent
                                (BuyAirtimeActivity.this, BuyActivity.class);
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

                btnOption2.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt2);

                        Intent intent = new Intent
                                (BuyAirtimeActivity.this, BuyActivity.class);
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

                btnOption3.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt3);

                        Intent intent = new Intent
                                (BuyAirtimeActivity.this, BuyActivity.class);
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

                btnOption4.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt4);

                        Intent intent = new Intent
                                (BuyAirtimeActivity.this, BuyActivity.class);
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

                btnOption5.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt5);

                        Intent intent = new Intent
                                (BuyAirtimeActivity.this, BuyActivity.class);
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

    public void Telkom()
    {
        Log.i(TAG, "Telkom: Selected This Carrier");

        ibtnTelkom.setOnClickListener(new View.OnClickListener()
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
                btnOption1.setText("R" + opt1);
                btnOption2.setText("R" + opt2);
                btnOption3.setText("R" + opt3);
                btnOption4.setText("R" + opt4);

                etSpent.setText(null);
                llOptions.setVisibility(View.VISIBLE);

                // Setting the visibility of some buttons
                btnOption1.setVisibility(View.VISIBLE);
                btnOption2.setVisibility(View.VISIBLE);
                btnOption3.setVisibility(View.VISIBLE);
                btnOption4.setVisibility(View.VISIBLE);
                btnOption5.setVisibility(View.GONE);
                btnOption6.setVisibility(View.GONE);
                btnOption7.setVisibility(View.GONE);
                btnOption8.setVisibility(View.GONE);
                btnOption9.setVisibility(View.GONE);
                btnOption10.setVisibility(View.GONE);

                Log.i(TAG, "onClick: Telkom Buttons Set and " +
                        "Made Visible");

                btnOption1.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt1);

                        Intent intent = new Intent
                                (BuyAirtimeActivity.this, BuyActivity.class);
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

                btnOption2.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt2);

                        Intent intent = new Intent
                                (BuyAirtimeActivity.this, BuyActivity.class);
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

                btnOption3.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt3);

                        Intent intent = new Intent
                                (BuyAirtimeActivity.this, BuyActivity.class);
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

                btnOption4.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt4);

                        Intent intent = new Intent
                                (BuyAirtimeActivity.this, BuyActivity.class);
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

    public void Vodacom()
    {
        Log.i(TAG, "Vodacom: Selected This Carrier");

        ibtnVodacom.setOnClickListener(new View.OnClickListener()
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
                btnOption1.setText("R" + opt1);
                btnOption2.setText("R" + opt2);
                btnOption3.setText("R" + opt3);
                btnOption4.setText("R" + opt4);
                btnOption5.setText("R" + opt5);

                etSpent.setText(null);
                llOptions.setVisibility(View.VISIBLE);

                // Setting the visibility of some buttons
                btnOption1.setVisibility(View.VISIBLE);
                btnOption2.setVisibility(View.VISIBLE);
                btnOption3.setVisibility(View.VISIBLE);
                btnOption4.setVisibility(View.VISIBLE);
                btnOption5.setVisibility(View.VISIBLE);
                btnOption6.setVisibility(View.GONE);
                btnOption7.setVisibility(View.GONE);
                btnOption8.setVisibility(View.GONE);
                btnOption9.setVisibility(View.GONE);
                btnOption10.setVisibility(View.GONE);

                Log.i(TAG, "onClick: Vodacom Buttons Set and " +
                        "Made Visible");

                btnOption1.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt1);

                        Intent intent = new Intent
                                (BuyAirtimeActivity.this, BuyActivity.class);
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

                btnOption2.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt2);

                        Intent intent = new Intent
                                (BuyAirtimeActivity.this, BuyActivity.class);
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

                btnOption3.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt3);

                        Intent intent = new Intent
                                (BuyAirtimeActivity.this, BuyActivity.class);
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

                btnOption4.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt4);

                        Intent intent = new Intent
                                (BuyAirtimeActivity.this, BuyActivity.class);
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

                btnOption5.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt5);

                        Intent intent = new Intent
                                (BuyAirtimeActivity.this, BuyActivity.class);
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

    public void VirginMobile()
    {
        Log.i(TAG, "VirginMobile: Selected This Carrier");

        ibtnVirginMobile.setOnClickListener(new View.OnClickListener()
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
                btnOption1.setText("R" + opt1);
                btnOption2.setText("R" + opt2);
                btnOption3.setText("R" + opt3);
                btnOption4.setText("R" + opt4);
                btnOption5.setText("R" + opt5);

                etSpent.setText(null);
                llOptions.setVisibility(View.VISIBLE);

                // Setting the visibility of some buttons
                btnOption1.setVisibility(View.VISIBLE);
                btnOption2.setVisibility(View.VISIBLE);
                btnOption3.setVisibility(View.VISIBLE);
                btnOption4.setVisibility(View.VISIBLE);
                btnOption5.setVisibility(View.VISIBLE);
                btnOption6.setVisibility(View.GONE);
                btnOption7.setVisibility(View.GONE);
                btnOption8.setVisibility(View.GONE);
                btnOption9.setVisibility(View.GONE);
                btnOption10.setVisibility(View.GONE);

                Log.i(TAG, "onClick: Virgin Mobile Buttons Set and " +
                        "Made Visible");


                btnOption1.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt1);

                        Intent intent = new Intent
                                (BuyAirtimeActivity.this, BuyActivity.class);
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

                btnOption2.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt2);

                        Intent intent = new Intent
                                (BuyAirtimeActivity.this, BuyActivity.class);
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

                btnOption3.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt3);

                        Intent intent = new Intent
                                (BuyAirtimeActivity.this, BuyActivity.class);
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

                btnOption4.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt4);

                        Intent intent = new Intent
                                (BuyAirtimeActivity.this, BuyActivity.class);
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

                btnOption5.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt5);

                        Intent intent = new Intent
                                (BuyAirtimeActivity.this, BuyActivity.class);
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

    public void TelkomMobile()
    {
        Log.i(TAG, "TelkomMobile: Selected This Carrier");

        ibtnTelkomMobile.setOnClickListener(new View.OnClickListener()
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
                btnOption1.setText("R" + opt1);
                btnOption2.setText("R" + opt2);
                btnOption3.setText("R" + opt3);
                btnOption4.setText("R" + opt4);
                btnOption5.setText("R" + opt5);
                btnOption6.setText("R" + opt6);
                btnOption7.setText("R" + opt7);
                btnOption8.setText("R" + opt8);
                btnOption9.setText("R" + opt9);

                etSpent.setText(null);
                llOptions.setVisibility(View.VISIBLE);

                // Setting the visibility of some buttons
                btnOption1.setVisibility(View.VISIBLE);
                btnOption2.setVisibility(View.VISIBLE);
                btnOption3.setVisibility(View.VISIBLE);
                btnOption4.setVisibility(View.VISIBLE);
                btnOption5.setVisibility(View.VISIBLE);
                btnOption6.setVisibility(View.VISIBLE);
                btnOption7.setVisibility(View.VISIBLE);
                btnOption8.setVisibility(View.VISIBLE);
                btnOption9.setVisibility(View.VISIBLE);
                btnOption10.setVisibility(View.GONE);

                Log.i(TAG, "onClick: Telkom Mobile Buttons Set and " +
                        "Made Visible");

                btnOption1.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt1);

                        Intent intent = new Intent
                                (BuyAirtimeActivity.this, BuyActivity.class);
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

                btnOption2.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt2);

                        Intent intent = new Intent
                                (BuyAirtimeActivity.this, BuyActivity.class);
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

                btnOption3.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt3);

                        Intent intent = new Intent
                                (BuyAirtimeActivity.this, BuyActivity.class);
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

                btnOption4.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt4);

                        Intent intent = new Intent
                                (BuyAirtimeActivity.this, BuyActivity.class);
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

                btnOption5.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt5);

                        Intent intent = new Intent
                                (BuyAirtimeActivity.this, BuyActivity.class);
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

                btnOption6.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt6);

                        Intent intent = new Intent
                                (BuyAirtimeActivity.this, BuyActivity.class);
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

                btnOption7.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt7);

                        Intent intent = new Intent
                                (BuyAirtimeActivity.this, BuyActivity.class);
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

                btnOption8.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt8);

                        Intent intent = new Intent
                                (BuyAirtimeActivity.this, BuyActivity.class);
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

                btnOption9.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt9);

                        Intent intent = new Intent
                                (BuyAirtimeActivity.this, BuyActivity.class);
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
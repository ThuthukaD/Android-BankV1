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
import android.widget.Toast;

public class BuyDataActivity extends AppCompatActivity
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

    private static final String TAG = "BuyDataActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_data);

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
                final double opt1 = 12.00;
                final double opt2 = 20.00;
                final double opt3 = 29.00;
                final double opt4 = 49.00;
                final double opt5 = 99.00;
                final double opt6 = 149.00;
                final double opt7 = 249.00;
                final double opt8 = 299.00;
                final double opt9 = 399.00;
                final double opt10 = 599.00;

                Log.i(TAG, "onClick: Setting Button Texts");

                // Setting Text for the user
                btnOption1.setText("30MB for R12.00");
                btnOption2.setText("60MB  for R20.00");
                btnOption3.setText("100MB for R29.00");
                btnOption4.setText("200MB for R49.00");
                btnOption5.setText("500MB for R99.00");
                btnOption6.setText("1GB for R149.00");
                btnOption7.setText("2GB for R249.00");
                btnOption8.setText("3GB for R299.00");
                btnOption9.setText("5GB for R399.00");
                btnOption10.setText("10GB for R599.00");

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
                btnOption10.setVisibility(View.VISIBLE);

                Log.i(TAG, "onClick: Cell C Buttons Set and " +
                        "Made Visible");

                btnOption1.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt1);

                        Intent intent = new Intent
                                (BuyDataActivity.this, BuyActivity.class);
                        Bundle extras = new Bundle();

                        extras.putString("location", "Cell C");
                        extras.putString("category2", category);
                        extras.putDouble("spent", opt1);
                        extras.putString("card2", card);
                        extras.putInt("buttonOn", 9999);
                        extras.putString("cardNo3", cardNo);
                        extras.putString("data", "30MB");
                        extras.putDouble("iamount2", iamount);

                        Log.i(TAG, "onClick: Button Clicked " +
                                "with value of R" + opt1 + " with data of 30MB");

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
                                (BuyDataActivity.this, BuyActivity.class);
                        Bundle extras = new Bundle();

                        extras.putString("location", "Cell C");
                        extras.putString("category2", category);
                        extras.putDouble("spent", opt2);
                        extras.putString("card2", card);
                        extras.putInt("buttonOn", 9999);
                        extras.putString("cardNo3", cardNo);
                        extras.putString("data", "60MB");
                        extras.putDouble("iamount2", iamount);

                        Log.i(TAG, "onClick: Button Clicked " +
                                "with value of R" + opt2 + " with data of 60MB");

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
                                (BuyDataActivity.this, BuyActivity.class);
                        Bundle extras = new Bundle();

                        extras.putString("location", "Cell C");
                        extras.putString("category2", category);
                        extras.putDouble("spent", opt3);
                        extras.putString("card2", card);
                        extras.putInt("buttonOn", 9999);
                        extras.putString("cardNo3", cardNo);
                        extras.putString("data", "100MB");
                        extras.putDouble("iamount2", iamount);

                        Log.i(TAG, "onClick: Button Clicked " +
                                "with value of R" + opt3 + " with data of 100MB");

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
                                (BuyDataActivity.this, BuyActivity.class);
                        Bundle extras = new Bundle();

                        extras.putString("location", "Cell C");
                        extras.putString("category2", category);
                        extras.putDouble("spent", opt4);
                        extras.putString("card2", card);
                        extras.putInt("buttonOn", 9999);
                        extras.putString("cardNo3", cardNo);
                        extras.putString("data", "200MB");
                        extras.putDouble("iamount2", iamount);

                        Log.i(TAG, "onClick: Button Clicked " +
                                "with value of R" + opt4 + " with data of 200MB");

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
                                (BuyDataActivity.this, BuyActivity.class);
                        Bundle extras = new Bundle();

                        extras.putString("location", "Cell C");
                        extras.putString("category2", category);
                        extras.putDouble("spent", opt5);
                        extras.putString("card2", card);
                        extras.putInt("buttonOn", 9999);
                        extras.putString("cardNo3", cardNo);
                        extras.putString("data", "500MB");
                        extras.putDouble("iamount2", iamount);

                        Log.i(TAG, "onClick: Button Clicked " +
                                "with value of R" + opt5 + " with data of 500MB");

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
                                (BuyDataActivity.this, BuyActivity.class);
                        Bundle extras = new Bundle();

                        extras.putString("location", "Cell C");
                        extras.putString("category2", category);
                        extras.putDouble("spent", opt6);
                        extras.putString("card2", card);
                        extras.putInt("buttonOn", 9999);
                        extras.putString("cardNo3", cardNo);
                        extras.putString("data", "1GB");
                        extras.putDouble("iamount2", iamount);

                        Log.i(TAG, "onClick: Button Clicked " +
                                "with value of R" + opt6 + " with data of 1GB");

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
                                (BuyDataActivity.this, BuyActivity.class);
                        Bundle extras = new Bundle();

                        extras.putString("location", "Cell C");
                        extras.putString("category2", category);
                        extras.putDouble("spent", opt7);
                        extras.putString("card2", card);
                        extras.putInt("buttonOn", 9999);
                        extras.putString("cardNo3", cardNo);
                        extras.putString("data", "2GB");
                        extras.putDouble("iamount2", iamount);

                        Log.i(TAG, "onClick: Button Clicked " +
                                "with value of R" + opt7 + " with data of 2GB");

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
                                (BuyDataActivity.this, BuyActivity.class);
                        Bundle extras = new Bundle();

                        extras.putString("location", "Cell C");
                        extras.putString("category2", category);
                        extras.putDouble("spent", opt8);
                        extras.putString("card2", card);
                        extras.putInt("buttonOn", 9999);
                        extras.putString("cardNo3", cardNo);
                        extras.putString("data", "3GB");
                        extras.putDouble("iamount2", iamount);

                        Log.i(TAG, "onClick: Button Clicked " +
                                "with value of R" + opt8 + " with data of 3GB");

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
                                (BuyDataActivity.this, BuyActivity.class);
                        Bundle extras = new Bundle();

                        extras.putString("location", "Cell C");
                        extras.putString("category2", category);
                        extras.putDouble("spent", opt9);
                        extras.putString("card2", card);
                        extras.putInt("buttonOn", 9999);
                        extras.putString("cardNo3", cardNo);
                        extras.putString("data", "5GB");
                        extras.putDouble("iamount2", iamount);

                        Log.i(TAG, "onClick: Button Clicked " +
                                "with value of R" + opt9 + " with data of 5GB");

                        intent.putExtras(extras);
                        startActivity(intent);

                        Log.i(TAG, "onClick: Starting BuyActivity");
                    }
                });
                btnOption10.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt10);

                        Intent intent = new Intent
                                (BuyDataActivity.this, BuyActivity.class);
                        Bundle extras = new Bundle();

                        extras.putString("location", "Cell C");
                        extras.putString("category2", category);
                        extras.putDouble("spent", opt10);
                        extras.putString("card2", card);
                        extras.putInt("buttonOn", 9999);
                        extras.putString("cardNo3", cardNo);
                        extras.putString("data", "10GB");
                        extras.putDouble("iamount2", iamount);

                        Log.i(TAG, "onClick: Button Clicked " +
                                "with value of R" + opt10 + " with data of 10GB");

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
                final double opt1 = 10.00;
                final double opt2 = 20.00;
                final double opt3 = 29.00;
                final double opt4 = 60.00;
                final double opt5 = 99.00;
                final double opt6 = 120.00;
                final double opt7 = 149.00;
                final double opt8 = 189.00;
                final double opt9 = 299.00;
                final double opt10 = 399.00;

                Log.i(TAG, "onClick: Setting Button Texts");

                // Setting Text for the user
                btnOption1.setText("20MB for R10.00");
                btnOption2.setText("50MB for R20.00");
                btnOption3.setText("100MB for R29.00");
                btnOption4.setText("300MB for R60.00");
                btnOption5.setText("600MB for R99.00");
                btnOption6.setText("750MB for R120.00");
                btnOption7.setText("1GB for R149.00");
                btnOption8.setText("1,5GB for R189.00");
                btnOption9.setText("3GB for R299.00");
                btnOption10.setText("6GB for R399.00");

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
                btnOption10.setVisibility(View.VISIBLE);

                Log.i(TAG, "onClick: MTN Buttons Set and " +
                        "Made Visible");

                btnOption1.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt1);

                        Intent intent = new Intent
                                (BuyDataActivity.this, BuyActivity.class);
                        Bundle extras = new Bundle();

                        extras.putString("location", "MTN");
                        extras.putString("category2", category);
                        extras.putDouble("spent", opt1);
                        extras.putString("card2", card);
                        extras.putInt("buttonOn", 9999);
                        extras.putString("cardNo3", cardNo);
                        extras.putString("data", "20MB");
                        extras.putDouble("iamount2", iamount);

                        Log.i(TAG, "onClick: Button Clicked " +
                                "with value of R" + opt1 + " with data of 20MB");

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
                                (BuyDataActivity.this, BuyActivity.class);
                        Bundle extras = new Bundle();

                        extras.putString("location", "MTN");
                        extras.putString("category2", category);
                        extras.putDouble("spent", opt2);
                        extras.putString("card2", card);
                        extras.putInt("buttonOn", 9999);
                        extras.putString("cardNo3", cardNo);
                        extras.putString("data", "50MB");
                        extras.putDouble("iamount2", iamount);

                        Log.i(TAG, "onClick: Button Clicked " +
                                "with value of R" + opt2 + " with data of 50MB");

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
                                (BuyDataActivity.this, BuyActivity.class);
                        Bundle extras = new Bundle();

                        extras.putString("location", "MTN");
                        extras.putString("category2", category);
                        extras.putDouble("spent", opt3);
                        extras.putString("card2", card);
                        extras.putInt("buttonOn", 9999);
                        extras.putString("cardNo3", cardNo);
                        extras.putString("data", "100MB");
                        extras.putDouble("iamount2", iamount);

                        Log.i(TAG, "onClick: Button Clicked " +
                                "with value of R" + opt3 + " with data of 100MB");

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
                                (BuyDataActivity.this, BuyActivity.class);
                        Bundle extras = new Bundle();

                        extras.putString("location", "MTN");
                        extras.putString("category2", category);
                        extras.putDouble("spent", opt4);
                        extras.putString("card2", card);
                        extras.putInt("buttonOn", 9999);
                        extras.putString("cardNo3", cardNo);
                        extras.putString("data", "300MB");
                        extras.putDouble("iamount2", iamount);

                        Log.i(TAG, "onClick: Button Clicked " +
                                "with value of R" + opt4 + " with data of 300MB");

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
                                (BuyDataActivity.this, BuyActivity.class);
                        Bundle extras = new Bundle();

                        extras.putString("location", "MTN");
                        extras.putString("category2", category);
                        extras.putDouble("spent", opt5);
                        extras.putString("card2", card);
                        extras.putInt("buttonOn", 9999);
                        extras.putString("cardNo3", cardNo);
                        extras.putString("data", "600MB");
                        extras.putDouble("iamount2", iamount);

                        Log.i(TAG, "onClick: Button Clicked " +
                                "with value of R" + opt5 + " with data of 600MB");

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
                                (BuyDataActivity.this, BuyActivity.class);
                        Bundle extras = new Bundle();

                        extras.putString("location", "MTN");
                        extras.putString("category2", category);
                        extras.putDouble("spent", opt6);
                        extras.putString("card2", card);
                        extras.putInt("buttonOn", 9999);
                        extras.putString("cardNo3", cardNo);
                        extras.putString("data", "750MB");
                        extras.putDouble("iamount2", iamount);

                        Log.i(TAG, "onClick: Button Clicked " +
                                "with value of R" + opt6 + " with data of 750MB");

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
                                (BuyDataActivity.this, BuyActivity.class);
                        Bundle extras = new Bundle();

                        extras.putString("location", "MTN");
                        extras.putString("category2", category);
                        extras.putDouble("spent", opt7);
                        extras.putString("card2", card);
                        extras.putInt("buttonOn", 9999);
                        extras.putString("cardNo3", cardNo);
                        extras.putString("data", "1GB");
                        extras.putDouble("iamount2", iamount);

                        Log.i(TAG, "onClick: Button Clicked " +
                                "with value of R" + opt7 + " with data of 1GB");

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
                                (BuyDataActivity.this, BuyActivity.class);
                        Bundle extras = new Bundle();

                        extras.putString("location", "MTN");
                        extras.putString("category2", category);
                        extras.putDouble("spent", opt8);
                        extras.putString("card2", card);
                        extras.putInt("buttonOn", 9999);
                        extras.putString("cardNo3", cardNo);
                        extras.putString("data", "1,5GB");
                        extras.putDouble("iamount2", iamount);

                        Log.i(TAG, "onClick: Button Clicked " +
                                "with value of R" + opt8 + " with data of 1,5GB");

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
                                (BuyDataActivity.this, BuyActivity.class);
                        Bundle extras = new Bundle();

                        extras.putString("location", "MTN");
                        extras.putString("category2", category);
                        extras.putDouble("spent", opt9);
                        extras.putString("card2", card);
                        extras.putInt("buttonOn", 9999);
                        extras.putString("cardNo3", cardNo);
                        extras.putString("data", "3GB");
                        extras.putDouble("iamount2", iamount);

                        Log.i(TAG, "onClick: Button Clicked " +
                                "with value of R" + opt9 + " with data of 3GB");

                        intent.putExtras(extras);
                        startActivity(intent);

                        Log.i(TAG, "onClick: Starting BuyActivity");
                    }
                });
                btnOption10.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt10);

                        Intent intent = new Intent
                                (BuyDataActivity.this, BuyActivity.class);
                        Bundle extras = new Bundle();

                        extras.putString("location", "MTN");
                        extras.putString("category2", category);
                        extras.putDouble("spent", opt10);
                        extras.putString("card2", card);
                        extras.putInt("buttonOn", 9999);
                        extras.putString("cardNo3", cardNo);
                        extras.putString("data", "6GB");
                        extras.putDouble("iamount2", iamount);

                        Log.i(TAG, "onClick: Button Clicked " +
                                "with value of R" + opt10 + " with data of 6GB");

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
                Toast.makeText(BuyDataActivity.this,
                        "No Data Options available for this carrier",
                        Toast.LENGTH_SHORT).show();

                // Setting the visibility of some buttons
                btnOption1.setVisibility(View.GONE);
                btnOption2.setVisibility(View.GONE);
                btnOption3.setVisibility(View.GONE);
                btnOption4.setVisibility(View.GONE);
                btnOption5.setVisibility(View.GONE);
                btnOption6.setVisibility(View.GONE);
                btnOption7.setVisibility(View.GONE);
                btnOption8.setVisibility(View.GONE);
                btnOption9.setVisibility(View.GONE);
                btnOption10.setVisibility(View.GONE);
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
                final double opt1 = 10.00;
                final double opt2 = 12.00;
                final double opt3 = 25.00;
                final double opt4 = 29.00;
                final double opt5 = 63.00;
                final double opt6 = 100.00;
                final double opt7 = 149.00;
                final double opt8 = 249.00;
                final double opt9 = 299.00;
                final double opt10 = 405.00;

                Log.i(TAG, "onClick: Setting Button Texts");

                // Setting Text for the user
                btnOption1.setText("15MB for R10.00");
                btnOption2.setText("30MB for R12.00");
                btnOption3.setText("55MB for R25.00");
                btnOption4.setText("100MB for R29.00");
                btnOption5.setText("250MB for R63.00");
                btnOption6.setText("500MB for R100.00");
                btnOption7.setText("1GB for R149.00");
                btnOption8.setText("2GB for R249.00");
                btnOption9.setText("3GB for R299.00");
                btnOption10.setText("5GB for R405.00");

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
                btnOption10.setVisibility(View.VISIBLE);

                Log.i(TAG, "onClick: Vodacom Buttons Set and " +
                        "Made Visible");

                btnOption1.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt1);

                        Intent intent = new Intent
                                (BuyDataActivity.this, BuyActivity.class);
                        Bundle extras = new Bundle();

                        extras.putString("location", "Vodacom");
                        extras.putString("category2", category);
                        extras.putDouble("spent", opt1);
                        extras.putString("card2", card);
                        extras.putInt("buttonOn", 9999);
                        extras.putString("cardNo3", cardNo);
                        extras.putString("data", "15MB");
                        extras.putDouble("iamount2", iamount);

                        Log.i(TAG, "onClick: Button Clicked " +
                                "with value of R" + opt1 + " with data of 15MB");

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
                                (BuyDataActivity.this, BuyActivity.class);
                        Bundle extras = new Bundle();

                        extras.putString("location", "Vodacom");
                        extras.putString("category2", category);
                        extras.putDouble("spent", opt2);
                        extras.putString("card2", card);
                        extras.putInt("buttonOn", 9999);
                        extras.putString("cardNo3", cardNo);
                        extras.putString("data", "30MB");
                        extras.putDouble("iamount2", iamount);

                        Log.i(TAG, "onClick: Button Clicked " +
                                "with value of R" + opt2 + " with data of 30MB");

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
                                (BuyDataActivity.this, BuyActivity.class);
                        Bundle extras = new Bundle();

                        extras.putString("location", "Vodacom");
                        extras.putString("category2", category);
                        extras.putDouble("spent", opt3);
                        extras.putString("card2", card);
                        extras.putInt("buttonOn", 9999);
                        extras.putString("cardNo3", cardNo);
                        extras.putString("data", "55MB");
                        extras.putDouble("iamount2", iamount);

                        Log.i(TAG, "onClick: Button Clicked " +
                                "with value of R" + opt3 + " with data of 55MB");

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
                                (BuyDataActivity.this, BuyActivity.class);
                        Bundle extras = new Bundle();

                        extras.putString("location", "Vodacom");
                        extras.putString("category2", category);
                        extras.putDouble("spent", opt4);
                        extras.putString("card2", card);
                        extras.putInt("buttonOn", 9999);
                        extras.putString("cardNo3", cardNo);
                        extras.putString("data", "100MB");
                        extras.putDouble("iamount2", iamount);

                        Log.i(TAG, "onClick: Button Clicked " +
                                "with value of R" + opt4 + " with data of 100MB");

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
                                (BuyDataActivity.this, BuyActivity.class);
                        Bundle extras = new Bundle();

                        extras.putString("location", "Vodacom");
                        extras.putString("category2", category);
                        extras.putDouble("spent", opt5);
                        extras.putString("card2", card);
                        extras.putInt("buttonOn", 9999);
                        extras.putString("cardNo3", cardNo);
                        extras.putString("data", "250MB");
                        extras.putDouble("iamount2", iamount);

                        Log.i(TAG, "onClick: Button Clicked " +
                                "with value of R" + opt5 + " with data of 250MB");

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
                                (BuyDataActivity.this, BuyActivity.class);
                        Bundle extras = new Bundle();

                        extras.putString("location", "Vodacom");
                        extras.putString("category2", category);
                        extras.putDouble("spent", opt6);
                        extras.putString("card2", card);
                        extras.putInt("buttonOn", 9999);
                        extras.putString("cardNo3", cardNo);
                        extras.putString("data", "500MB");
                        extras.putDouble("iamount2", iamount);

                        Log.i(TAG, "onClick: Button Clicked " +
                                "with value of R" + opt6 + " with data of 500MB");

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
                                (BuyDataActivity.this, BuyActivity.class);
                        Bundle extras = new Bundle();

                        extras.putString("location", "Vodacom");
                        extras.putString("category2", category);
                        extras.putDouble("spent", opt7);
                        extras.putString("card2", card);
                        extras.putInt("buttonOn", 9999);
                        extras.putString("cardNo3", cardNo);
                        extras.putString("data", "1GB");
                        extras.putDouble("iamount2", iamount);

                        Log.i(TAG, "onClick: Button Clicked " +
                                "with value of R" + opt7 + " with data of 1GB");

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
                                (BuyDataActivity.this, BuyActivity.class);
                        Bundle extras = new Bundle();

                        extras.putString("location", "Vodacom");
                        extras.putString("category2", category);
                        extras.putDouble("spent", opt8);
                        extras.putString("card2", card);
                        extras.putInt("buttonOn", 9999);
                        extras.putString("cardNo3", cardNo);
                        extras.putString("data", "2GB");
                        extras.putDouble("iamount2", iamount);

                        Log.i(TAG, "onClick: Button Clicked " +
                                "with value of R" + opt8 + " with data of 2GB");

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
                                (BuyDataActivity.this, BuyActivity.class);
                        Bundle extras = new Bundle();

                        extras.putString("location", "Vodacom");
                        extras.putString("category2", category);
                        extras.putDouble("spent", opt9);
                        extras.putString("card2", card);
                        extras.putInt("buttonOn", 9999);
                        extras.putString("cardNo3", cardNo);
                        extras.putString("data", "3GB");
                        extras.putDouble("iamount2", iamount);

                        Log.i(TAG, "onClick: Button Clicked " +
                                "with value of R" + opt9 + " with data of 3GB");

                        intent.putExtras(extras);
                        startActivity(intent);

                        Log.i(TAG, "onClick: Starting BuyActivity");
                    }
                });
                btnOption10.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt10);

                        Intent intent = new Intent
                                (BuyDataActivity.this, BuyActivity.class);
                        Bundle extras = new Bundle();

                        extras.putString("location", "Vodacom");
                        extras.putString("category2", category);
                        extras.putDouble("spent", opt10);
                        extras.putString("card2", card);
                        extras.putInt("buttonOn", 9999);
                        extras.putString("cardNo3", cardNo);
                        extras.putString("data", "5GB");
                        extras.putDouble("iamount2", iamount);

                        Log.i(TAG, "onClick: Button Clicked " +
                                "with value of R" + opt10 + " with data of 5GB");

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
                Toast.makeText(BuyDataActivity.this,
                        "No Data Options available for this carrier",
                        Toast.LENGTH_SHORT).show();

                // Setting the visibility of some buttons
                btnOption1.setVisibility(View.GONE);
                btnOption2.setVisibility(View.GONE);
                btnOption3.setVisibility(View.GONE);
                btnOption4.setVisibility(View.GONE);
                btnOption5.setVisibility(View.GONE);
                btnOption6.setVisibility(View.GONE);
                btnOption7.setVisibility(View.GONE);
                btnOption8.setVisibility(View.GONE);
                btnOption9.setVisibility(View.GONE);
                btnOption10.setVisibility(View.GONE);
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
                final double opt1 = 7.30;
                final double opt2 = 14.65;
                final double opt3 = 29.25;
                final double opt4 = 39.50;
                final double opt5 = 69.60;
                final double opt6 = 100.00;
                final double opt7 = 140.00;
                final double opt8 = 201.00;
                final double opt9 = 301.00;
                final double opt10 = 505.00;

                Log.i(TAG, "onClick: Setting Button Texts");

                // Setting Text for the user
                btnOption1.setText("25MB for R7.30");
                btnOption2.setText("50MB for R14.65");
                btnOption3.setText("100MB for R29.25");
                btnOption4.setText("250MB for R39.50");
                btnOption5.setText("500MB for R69.60");
                btnOption6.setText("1GB for R100.00");
                btnOption7.setText("2GB for R140.00");
                btnOption8.setText("3GB for R201.00");
                btnOption9.setText("5GB for R301.00");
                btnOption10.setText("10GB for R505.00");

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
                btnOption10.setVisibility(View.VISIBLE);

                Log.i(TAG, "onClick: Virgin Mobile Buttons Set and " +
                        "Made Visible");

                btnOption1.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt1);

                        Intent intent = new Intent
                                (BuyDataActivity.this, BuyActivity.class);
                        Bundle extras = new Bundle();

                        extras.putString("location", "Telkom Mobile");
                        extras.putString("category2", category);
                        extras.putDouble("spent", opt1);
                        extras.putString("card2", card);
                        extras.putInt("buttonOn", 9999);
                        extras.putString("cardNo3", cardNo);
                        extras.putString("data", "15MB");
                        extras.putDouble("iamount2", iamount);

                        Log.i(TAG, "onClick: Button Clicked " +
                                "with value of R" + opt1 + " with data of 15MB");

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
                                (BuyDataActivity.this, BuyActivity.class);
                        Bundle extras = new Bundle();

                        extras.putString("location", "Telkom Mobile");
                        extras.putString("category2", category);
                        extras.putDouble("spent", opt2);
                        extras.putString("card2", card);
                        extras.putInt("buttonOn", 9999);
                        extras.putString("cardNo3", cardNo);
                        extras.putString("data", "30MB");
                        extras.putDouble("iamount2", iamount);

                        Log.i(TAG, "onClick: Button Clicked " +
                                "with value of R" + opt2 + " with data of 30MB");

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
                                (BuyDataActivity.this, BuyActivity.class);
                        Bundle extras = new Bundle();

                        extras.putString("location", "Telkom Mobile");
                        extras.putString("category2", category);
                        extras.putDouble("spent", opt3);
                        extras.putString("card2", card);
                        extras.putInt("buttonOn", 9999);
                        extras.putString("cardNo3", cardNo);
                        extras.putString("data", "55MB");
                        extras.putDouble("iamount2", iamount);

                        Log.i(TAG, "onClick: Button Clicked " +
                                "with value of R" + opt3 + " with data of 55MB");

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
                                (BuyDataActivity.this, BuyActivity.class);
                        Bundle extras = new Bundle();

                        extras.putString("location", "Telkom Mobile");
                        extras.putString("category2", category);
                        extras.putDouble("spent", opt4);
                        extras.putString("card2", card);
                        extras.putInt("buttonOn", 9999);
                        extras.putString("cardNo3", cardNo);
                        extras.putString("data", "100MB");
                        extras.putDouble("iamount2", iamount);

                        Log.i(TAG, "onClick: Button Clicked " +
                                "with value of R" + opt4 + " with data of 100MB");

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
                                (BuyDataActivity.this, BuyActivity.class);
                        Bundle extras = new Bundle();

                        extras.putString("location", "Telkom Mobile");
                        extras.putString("category2", category);
                        extras.putDouble("spent", opt5);
                        extras.putString("card2", card);
                        extras.putInt("buttonOn", 9999);
                        extras.putString("cardNo3", cardNo);
                        extras.putString("data", "250MB");
                        extras.putDouble("iamount2", iamount);

                        Log.i(TAG, "onClick: Button Clicked " +
                                "with value of R" + opt5 + " with data of 250MB");

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
                                (BuyDataActivity.this, BuyActivity.class);
                        Bundle extras = new Bundle();

                        extras.putString("location", "Telkom Mobile");
                        extras.putString("category2", category);
                        extras.putDouble("spent", opt6);
                        extras.putString("card2", card);
                        extras.putInt("buttonOn", 9999);
                        extras.putString("cardNo3", cardNo);
                        extras.putString("data", "500MB");
                        extras.putDouble("iamount2", iamount);

                        Log.i(TAG, "onClick: Button Clicked " +
                                "with value of R" + opt6 + " with data of 500MB");

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
                                (BuyDataActivity.this, BuyActivity.class);
                        Bundle extras = new Bundle();

                        extras.putString("location", "Telkom Mobile");
                        extras.putString("category2", category);
                        extras.putDouble("spent", opt7);
                        extras.putString("card2", card);
                        extras.putInt("buttonOn", 9999);
                        extras.putString("cardNo3", cardNo);
                        extras.putString("data", "1GB");
                        extras.putDouble("iamount2", iamount);

                        Log.i(TAG, "onClick: Button Clicked " +
                                "with value of R" + opt7 + " with data of 1GB");

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
                                (BuyDataActivity.this, BuyActivity.class);
                        Bundle extras = new Bundle();

                        extras.putString("location", "Telkom Mobile");
                        extras.putString("category2", category);
                        extras.putDouble("spent", opt8);
                        extras.putString("card2", card);
                        extras.putInt("buttonOn", 9999);
                        extras.putString("cardNo3", cardNo);
                        extras.putString("data", "2GB");
                        extras.putDouble("iamount2", iamount);

                        Log.i(TAG, "onClick: Button Clicked " +
                                "with value of R" + opt8 + " with data of 2GB");

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
                                (BuyDataActivity.this, BuyActivity.class);
                        Bundle extras = new Bundle();

                        extras.putString("location", "Telkom Mobile");
                        extras.putString("category2", category);
                        extras.putDouble("spent", opt9);
                        extras.putString("card2", card);
                        extras.putInt("buttonOn", 9999);
                        extras.putString("cardNo3", cardNo);
                        extras.putString("data", "3GB");
                        extras.putDouble("iamount2", iamount);

                        Log.i(TAG, "onClick: Button Clicked " +
                                "with value of R" + opt9 + " with data of 3GB");

                        intent.putExtras(extras);
                        startActivity(intent);

                        Log.i(TAG, "onClick: Starting BuyActivity");
                    }
                });
                btnOption10.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt10);

                        Intent intent = new Intent
                                (BuyDataActivity.this, BuyActivity.class);
                        Bundle extras = new Bundle();

                        extras.putString("location", "Telkom Mobile");
                        extras.putString("category2", category);
                        extras.putDouble("spent", opt10);
                        extras.putString("card2", card);
                        extras.putInt("buttonOn", 9999);
                        extras.putString("cardNo3", cardNo);
                        extras.putString("data", "5GB");
                        extras.putDouble("iamount2", iamount);

                        Log.i(TAG, "onClick: Button Clicked " +
                                "with value of R" + opt10 + " with data of 5GB");

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
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

public class BuyElectricityActivity extends AppCompatActivity
{
    // VARIABLES

    // Image Buttons
    ImageButton ibtnEskom;
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

    private static final String TAG = "BuyElectricityActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_electricity);

        // INITIALISING

        // Image Buttons
        ibtnEskom = findViewById(R.id.ibtnCellC);
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
        ibtnEskom.performClick();

        etSpent.performClick();

        if (etSpent.isFocusableInTouchMode() == false)
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
                        Toast.makeText(BuyElectricityActivity.this,
                                "Select it again", Toast.LENGTH_SHORT).show();
                    }

                    etSpent.setFocusableInTouchMode(true);
                }
            });
        }
    }

    public void selection()
    {
        Log.i(TAG, "selection: Selected a Carrier");

        electricity();
//        CellC();
//        MTN();
//        Telkom();
//        Vodacom();
//        VirginMobile();
//        TelkomMobile();
    }

    public void electricity()
    {
        Log.i(TAG, "CellC: Selected This Carrier");

        ibtnEskom.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                final double opt1 = 0.00;
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
                btnOption1.setText("Buy");

                etSpent.setText(null);
                llOptions.setVisibility(View.VISIBLE);

                // Setting the visibility of some buttons
                btnOption1.setVisibility(View.VISIBLE);
                btnOption2.setVisibility(View.GONE);
                btnOption3.setVisibility(View.GONE);
                btnOption4.setVisibility(View.GONE);
                btnOption5.setVisibility(View.GONE);
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
                        double optElectricity = Double.parseDouble(etSpent.getText().toString());

                        etSpent.setText("" + optElectricity);

                        Intent intent = new Intent
                                (BuyElectricityActivity.this, BuyActivity.class);
                        Bundle extras = new Bundle();

                        extras.putString("location", "Eskom");
                        extras.putString("category2", category);
                        extras.putDouble("spent", optElectricity);
                        extras.putString("card2", card);
                        extras.putInt("buttonOn", 9999);
                        extras.putString("cardNo3", cardNo);
                        extras.putString("data", "" + opt1);
                        extras.putDouble("iamount2", iamount);

                        Log.i(TAG, "onClick: Button Clicked " +
                                "with value of R" + optElectricity);

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
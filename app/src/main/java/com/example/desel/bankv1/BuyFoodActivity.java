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
        Log.i(TAG, "BurgerKing: Selected This Restaurant");

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
                ibtnOption1.setBackgroundResource(R.drawable.bk_1_whopper);
                ibtnOption2.setBackgroundResource(R.drawable.bk_2_big_king);
                ibtnOption3.setBackgroundResource(R.drawable.bk_3_bk_crunch);
                ibtnOption4.setBackgroundResource(R.drawable.bk_4_chicken_wings);

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

                Log.i(TAG, "onClick: BurgerKing Buttons Set and " +
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

                        extras.putString("location", "Burger King");
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

                        extras.putString("location", "Burger King");
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

                        extras.putString("location", "Burger King");
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

                        extras.putString("location", "Burger King");
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

    public void ChickenLicken()
    {
        Log.i(TAG, "ChickenLicken: Selected This Restaurant");

        ibtnChickenLicken.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                final double opt1 = 29.90;
                final double opt2 = 129.90;
                final double opt3 = 30.90;
                final double opt4 = 48.90;

                Log.i(TAG, "onClick: Setting Button Texts");

                // Setting Text for the user
                ibtnOption1.setBackgroundResource(R.drawable.cl_1_hot_wings);
                ibtnOption2.setBackgroundResource(R.drawable.cl_2_family_full_house);
                ibtnOption3.setBackgroundResource(R.drawable.cl_3_love_me_tender);
                ibtnOption4.setBackgroundResource(R.drawable.cl_4_lunch);

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

                Log.i(TAG, "onClick: ChickenLicken Buttons Set and " +
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

                        extras.putString("location", "Chicken Licken");
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

                        extras.putString("location", "Chicken Licken");
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

                        extras.putString("location", "Chicken Licken");
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

                        extras.putString("location", "Chicken Licken");
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

    public void Fishaways()
    {
        Log.i(TAG, "Fishaways: Selected This Carrier");

        ibtnFishaways.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                final double opt1 = 36.90;
                final double opt2 = 79.90;
                final double opt3 = 40.90;
                final double opt4 = 19.90;

                Log.i(TAG, "onClick: Setting Button Texts");

                // Setting Text for the user
                ibtnOption1.setBackgroundResource(R.drawable.f_1_hake_meals);
                ibtnOption2.setBackgroundResource(R.drawable.f_2_double_up_meal);
                ibtnOption3.setBackgroundResource(R.drawable.f_3_sliders);
                ibtnOption4.setBackgroundResource(R.drawable.f_4_sides);

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

                Log.i(TAG, "onClick: Fishaways Buttons Set and " +
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

                        extras.putString("location", "Fishaways");
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

                        extras.putString("location", "Fishaways");
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

                        extras.putString("location", "Fishaways");
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

                        extras.putString("location", "Fishaways");
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
        Log.i(TAG, "KFC: Selected This Carrier");

        ibtnKFC.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                final double opt1 = 60.00;
                final double opt2 = 50.00;
                final double opt3 = 60.00;
                final double opt4 = 65.00;

                Log.i(TAG, "onClick: Setting Button Texts");

                // Setting Text for the user
                ibtnOption1.setBackgroundResource(R.drawable.k_1_wings);
                ibtnOption2.setBackgroundResource(R.drawable.k_2_boundry_deal);
                ibtnOption3.setBackgroundResource(R.drawable.k_3_rounders);
                ibtnOption4.setBackgroundResource(R.drawable.k_4_twisters);

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

                Log.i(TAG, "onClick: KFC Buttons Set and " +
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

                        extras.putString("location", "KFC");
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

                        extras.putString("location", "KFC");
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

                        extras.putString("location", "KFC");
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

                        extras.putString("location", "KFC");
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

    public void McDonalds()
    {
        Log.i(TAG, "McDonalds: Selected This Carrier");

        ibtnMcDonalds.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                final double opt1 = 59.00;
                final double opt2 = 31.00;
                final double opt3 = 32.50;
                final double opt4 = 28.00;

                Log.i(TAG, "onClick: Setting Button Texts");

                // Setting Text for the user
                ibtnOption1.setBackgroundResource(R.drawable.m_1_big_tasty);
                ibtnOption2.setBackgroundResource(R.drawable.m_2_big_mac);
                ibtnOption3.setBackgroundResource(R.drawable.m_3_cajun);
                ibtnOption4.setBackgroundResource(R.drawable.m_4_mcchicken);

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

                Log.i(TAG, "onClick: McDonalds Buttons Set and " +
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

                        extras.putString("location", "McDonalds");
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

                        extras.putString("location", "McDonalds");
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

                        extras.putString("location", "McDonalds");
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

                        extras.putString("location", "McDonalds");
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

    public void Steers()
    {
        Log.i(TAG, "Steers: Selected This Carrier");

        ibtnSteers.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                final double opt1 = 77.90;
                final double opt2 = 87.90;
                final double opt3 = 102.90;
                final double opt4 = 47.90;

                Log.i(TAG, "onClick: Setting Button Texts");

                // Setting Text for the user
                ibtnOption1.setBackgroundResource(R.drawable.s_1_original);
                ibtnOption2.setBackgroundResource(R.drawable.s_2_big_bacon);
                ibtnOption3.setBackgroundResource(R.drawable.s_3_mighty);;
                ibtnOption4.setBackgroundResource(R.drawable.s_4_chicken);

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

                Log.i(TAG, "onClick: Steers Buttons Set and " +
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

                        extras.putString("location", "Steers");
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

                        extras.putString("location", "Steers");
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

                        extras.putString("location", "Steers");
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

                        extras.putString("location", "Steers");
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
package com.example.desel.bankv1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

    // Other
    LinearLayout llOptions;

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
        buttonClicks();
    }

    public void selection()
    {
        CellC();
        MTN();
        Telkom();
        Vodacom();
        VirginMobile();
        TelkomMobile();
    }

    public void CellC()
    {
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

                btnOption1.setText("R" + opt1);
                btnOption2.setText("R" + opt2);
                btnOption3.setText("R" + opt3);
                btnOption4.setText("R" + opt4);
                btnOption5.setText("R" + opt5);

                etSpent.setText(null);
                llOptions.setVisibility(View.VISIBLE);

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

                btnOption1.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt1);
                    }
                });

                btnOption2.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt2);
                    }
                });

                btnOption3.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt3);
                    }
                });

                btnOption4.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt4);
                    }
                });

                btnOption5.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt5);
                    }
                });
            }
        });
    }

    public void MTN()
    {
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

                btnOption1.setText("R" + opt1);
                btnOption2.setText("R" + opt2);
                btnOption3.setText("R" + opt3);
                btnOption4.setText("R" + opt4);
                btnOption5.setText("R" + opt5);

                etSpent.setText(null);
                llOptions.setVisibility(View.VISIBLE);

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

                btnOption1.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt1);
                    }
                });

                btnOption2.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt2);
                    }
                });

                btnOption3.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt3);
                    }
                });

                btnOption4.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt4);
                    }
                });

                btnOption5.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt5);
                    }
                });
            }
        });
    }

    public void Telkom()
    {
        ibtnTelkom.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                final double opt1 = 40.00;
                final double opt2 = 50.00;
                final double opt3 = 100.00;
                final double opt4 = 200.00;

                btnOption1.setText("R" + opt1);
                btnOption2.setText("R" + opt2);
                btnOption3.setText("R" + opt3);
                btnOption4.setText("R" + opt4);

                etSpent.setText(null);
                llOptions.setVisibility(View.VISIBLE);

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

                btnOption1.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt1);
                    }
                });

                btnOption2.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt2);
                    }
                });

                btnOption3.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt3);
                    }
                });

                btnOption4.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt4);
                    }
                });
            }
        });
    }

    public void Vodacom()
    {
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

                btnOption1.setText("R" + opt1);
                btnOption2.setText("R" + opt2);
                btnOption3.setText("R" + opt3);
                btnOption4.setText("R" + opt4);
                btnOption5.setText("R" + opt5);

                etSpent.setText(null);
                llOptions.setVisibility(View.VISIBLE);

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

                btnOption1.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt1);
                    }
                });

                btnOption2.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt2);
                    }
                });

                btnOption3.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt3);
                    }
                });

                btnOption4.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt4);
                    }
                });

                btnOption5.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt5);
                    }
                });
            }
        });
    }

    public void VirginMobile()
    {
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

                btnOption1.setText("R" + opt1);
                btnOption2.setText("R" + opt2);
                btnOption3.setText("R" + opt3);
                btnOption4.setText("R" + opt4);
                btnOption5.setText("R" + opt5);

                etSpent.setText(null);
                llOptions.setVisibility(View.VISIBLE);

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


                btnOption1.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt1);
                    }
                });

                btnOption2.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt2);
                    }
                });

                btnOption3.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt3);
                    }
                });

                btnOption4.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt4);
                    }
                });

                btnOption5.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt5);
                    }
                });
            }
        });
    }

    public void TelkomMobile()
    {
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

                btnOption1.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt1);
                    }
                });

                btnOption2.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt2);
                    }
                });

                btnOption3.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt3);
                    }
                });

                btnOption4.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt4);
                    }
                });

                btnOption5.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt5);
                    }
                });

                btnOption6.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt6);
                    }
                });

                btnOption7.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt7);
                    }
                });

                btnOption8.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt8);
                    }
                });

                btnOption9.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etSpent.setText("" + opt9);
                    }
                });
            }
        });
    }

    public void buttonClicks()
    {

    }
}


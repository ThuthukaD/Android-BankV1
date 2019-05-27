package com.example.desel.bankv1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;

public class SplashActivity extends AppCompatActivity
{
    // VARIABLES

    // Other
    public ProgressBar progressBar;
    public int progressStatus = 0;

    // Debugging
    private static final String TAG = "SplashActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // INITIALISING
        progressBar = findViewById(R.id.progressBar);

        Log.i("SplashActivity", "Splash Starting");

        Log.i("SplashActivity", "Progressbar Starting");
        loading();
    }

    public void loading()
    {
        Log.i(TAG, "run: Loading Running");

        // Progress Bar Code
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                // Determines length of the progress bar
                while (progressStatus < 100)
                {
                    progressStatus++;
                    SystemClock.sleep(20);
                    progressBar.setProgress(progressStatus);
                }
                autoLogo();
            }
        }).start();
        Log.i(TAG, "run: Loading Complete");
    }

    public void autoLogo()
    {
        Log.i("SplashActivity", "Auto Login Starting");

        // Auto Login Code
        SharedPreferences prefs = getSharedPreferences("login",
                MODE_PRIVATE);
        final Boolean isLogged = prefs.getBoolean("isLogged",
                false);

        Thread timer = new Thread()
        {
            public void run()
            {
                Log.i(TAG, "run: Splash - Auto Log Timer Started");

                try
                {
                    // Short delay for the next page to open
                    sleep(10);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    Log.i(TAG, "run: Splash - Auto Log Timer Complete");

                    if (isLogged)
                    {
                        Log.i(TAG, "run: Splash - Starting LoginActivity");

                        // If logged in previously, open Login Activity
                        Intent intent = new Intent
                                (SplashActivity.this,
                                        LoginActivity.class);
                        startActivity(intent);
                        finish();

                        Log.i(TAG, "run: Splash - Closing SplashActivity");
                    }
                    else
                    {
                        Log.i(TAG, "run: Splash - Starting RegisterActivity");

                        // If never logged in previously, open Register Activity
                        Intent intent = new Intent
                                (SplashActivity.this,
                                        RegisterActivity.class);
                        startActivity(intent);
                        finish();

                        Log.i(TAG, "run: Splash - Closing SplashActivity");
                    }
                }
                Log.i(TAG, "run: Splash - Auto Login Complete");
            }
        };
        timer.start();
    }
}
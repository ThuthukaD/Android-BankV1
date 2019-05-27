package com.example.desel.bankv1;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.text.DateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class LoginActivity extends AppCompatActivity
{
    // VARIABLES

    // Text View
    TextView tvUser;
    TextView tvSwitchUser;

    // Edit Texts
    EditText etPin;
    EditText etEmail;
    EditText etLoginNumber;
    EditText etLoginNotification;

    // Buttons
    Button btnLogin;

    // Strings
    String stLogin;

    // Other
    private FirebaseAuth mAuth;
    private final int SEND_SMS_PERMISSION_REQUEST_CODE = 1;

    // Debugging
    private static final String TAG = "LoginActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Log.i(TAG, "onCreate: Login Started");

        // INSTANCING

        // Text Views
        tvUser = findViewById(R.id.tvUser);
        tvSwitchUser = findViewById(R.id.tvSwitchUser);

        // Edit Texts
        etEmail = findViewById(R.id.etEmail);
        etPin = findViewById(R.id.etPin);
        etLoginNumber = findViewById(R.id.etLoginNumber);
        etLoginNotification = findViewById(R.id.etLoginNotification);

        // Buttons
        btnLogin = findViewById(R.id.btnLogin);

        // Other
        mAuth = FirebaseAuth.getInstance();

        loginPermissions();
    }

    // Login Method
    public void Login(View view)
    {
        Log.i(TAG, "Login: Button Clicked");
        final String email = etEmail.getText().toString().trim();
        String pin = etPin.getText().toString().trim();

        // Checks if email and password is empty
        Log.i(TAG, "Login: Checking Details");
        if (TextUtils.isEmpty(email))
        {
            Log.i(TAG, "Login: Account Error");

            Toast.makeText(this, "Account Error, account not found",
                    Toast.LENGTH_LONG).show();
            etEmail.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(pin))
        {
            Log.i(TAG, "Login: Pin Not Detected");

            Toast.makeText(this, "Please enter your pin",
                    Toast.LENGTH_SHORT).show();
            etPin.requestFocus();
            return;
        }

        // Constraint for password type or length
        if (pin.length() < 6)
        {
            Log.i(TAG, "Login: Pin Requirements Not Met");

            Toast.makeText(this, "Pin must be 6 digits",
                    Toast.LENGTH_SHORT).show();
            etPin.requestFocus();
            return;
        }

        // Sign in allowed if all is good
        mAuth.signInWithEmailAndPassword(email,pin).addOnCompleteListener(this, new
                OnCompleteListener<AuthResult>()
                {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task)
                    {
                        if (task.isSuccessful())
                        {
                            Log.i(TAG, "onComplete: Access Granted");

                            Intent intent = new Intent(LoginActivity.this,
                                    MainActivity.class);

                            Log.i(TAG, "onComplete: Copying Text To Relevant Page");

                            stLogin = tvUser.getText().toString();
                            intent.putExtra("UserLogin", stLogin);

                            Log.i(TAG, "onComplete: Getting Notification Details");

                            // Getting Phone Number and Date for Sending Notifications
                            String number = etLoginNumber.getText().toString();
                            String currentDateTimeString = DateFormat.getDateTimeInstance()
                                    .format(new Date());

                            Log.i(TAG, "onComplete: Number is " + number +
                                    " Date is " + currentDateTimeString);

                            if  (checkPermission(Manifest.permission.SEND_SMS))
                            {
                                Log.i(TAG, "onComplete: Checking Manifest Permissions");
                                SmsManager smsManager = SmsManager.getDefault();

                                // Sending Message to User if Successful
                                smsManager.sendTextMessage
                                        (number, null, "Bank App : Account login " +
                                                "On: " + currentDateTimeString + ". Is this you?",
                                        null, null);

                                Toast.makeText(LoginActivity.this,
                                        "Logged In", Toast.LENGTH_SHORT).show();

                                Log.i(TAG, "onComplete: Login for " + email + " Successful");
                            }
                            else
                            {
                                Log.i(TAG, "onComplete: Checking Manifest Permissions");

                                SmsManager smsManager = SmsManager.getDefault();

                                // Sending Message to User if Unsuccessful
                                smsManager.sendTextMessage(number, null,
                                        "Bank App : Account login failed " +
                                                "On: " + currentDateTimeString + ". Is this you?",
                                        null, null);

                                Toast.makeText(LoginActivity.this,
                                        "Permission Denied", Toast.LENGTH_SHORT).show();

                                Log.i(TAG, "onComplete: Login for " + email + " Unsuccessful");
                            }
                            startActivity(intent);

                            Log.d(TAG, "onComplete: Clearing Text Fields");
                            emptyInputs();
                        }
                        else
                        {
                            Log.d(TAG, "onComplete: Access Declined");

                            String number = etLoginNumber.getText().toString();
                            String currentDateTimeString = DateFormat.getDateTimeInstance()
                                    .format(new Date());

                            // Sending Message to User if Unsuccessful Due to Unexpected Error
                            SmsManager smsManager = SmsManager.getDefault();
                            smsManager.sendTextMessage(number, null,
                                    "Bank App : Account login failed " +
                                            "On: " + currentDateTimeString + ". Is this you?",
                                    null, null);

                            emptyInputs();
                            Toast.makeText(LoginActivity.this,
                                    "Unexpected Error, pleas try again",
                                    Toast.LENGTH_SHORT).show();

                            Log.i(TAG, "onComplete: Unexpected Error");
                        }
                    }
                });
    }

    // Get text method
    public void Text()
    {
        Log.i(TAG, "Text: Attempting to Write Text");

        // Calling prefs from RegisterActivity
        SharedPreferences prefs = getSharedPreferences("login", MODE_PRIVATE);

        // Passed string for user
        String username = prefs.getString("username", "Username");

        // Passed string for email
        String email = prefs.getString("email", "Email");

        // Passed string for phone number
        String phone = prefs.getString("phone", "PhoneNumber");

        // Setting the current fields to the stored text
        tvUser.setText(username);
        etEmail.setText(email);
        etLoginNumber.setText(phone);
    }

    // Empties pin field
    private void emptyInputs()
    {
        Log.i(TAG, "emptyInputs: Clearing PIN Field");
        etPin.setText(null);
    }

    // Open Register Page Method
    public void SwitchUser(View view)
    {
        Log.i(TAG, "SwitchUser: Opening Register Page");

        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
        finish();
    }

    public boolean checkPermission(String permission)
    {
        Log.i(TAG, "checkPermission: Permission Check Method Ran");

        int check = ContextCompat.checkSelfPermission(this, permission);
        return (check == PackageManager.PERMISSION_GRANTED);
    }

    public void loginPermissions()
    {
        try
        {
            Log.i(TAG, "onCreate: Getting Text");

            // Calling text method
            Text();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Log.i(TAG, "onCreate: Failed to get Text");
        }

        btnLogin.setEnabled(false);

        Log.i(TAG, "onCreate: SMS Permissions Check");

        // SMS Permissions check
        if (checkPermission(Manifest.permission.SEND_SMS))
        {
            try
            {
                Log.i(TAG, "onCreate: Button Set to Enabled");
                btnLogin.setEnabled(true);
            }
            catch (Exception e)
            {
                e.printStackTrace();
                btnLogin.setEnabled(true);

                Log.i(TAG, "onCreate: Error Setting Button to Enabled but Still Set");
            }
            Log.i(TAG, "onCreate: Permission Check Complete");
        }
        else
        {
            // Asking user for permission if not set
            ActivityCompat.requestPermissions(this,
                    new String [] {Manifest.permission.SEND_SMS},
                    SEND_SMS_PERMISSION_REQUEST_CODE);
        }
        Log.i(TAG, "onCreate: Login Page Loaded");
    }
}
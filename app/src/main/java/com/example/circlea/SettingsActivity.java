package com.example.circlea;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity {
    Button LogoutBtn, ModeBtn;
    RadioButton Light, Night;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Light = findViewById(R.id.LightRadioBtn);
        Night = findViewById(R.id.NightRadioBtn);
        LogoutBtn = findViewById(R.id.LogoutBtn);
        ModeBtn = findViewById(R.id.ModeBtn);
        ModeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Light.isChecked()) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(SettingsActivity.this);
                    builder.setMessage("Change to Light Mode & Logout?");
                    builder.setTitle("Alert !");
                    builder.setCancelable(false);
                    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //yes
                            if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_NO) {
                                AlertDialog.Builder builder = new AlertDialog.Builder(SettingsActivity.this);
                                builder.setMessage("Current Mode is already Light!");
                                builder.setTitle("Alert!");
                                builder.setCancelable(false);
                                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        //OK
                                        dialog.cancel();
                                    }
                                });
                                AlertDialog alertDialog = builder.create();
                                alertDialog.show();
                            } else
                                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                        }
                    });
                    builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // If user click no
                            // then dialog box is canceled.
                            dialog.cancel();
                        }
                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                } else if (Night.isChecked()) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(SettingsActivity.this);
                    builder.setMessage("Change to Night Mode & Logout?");
                    builder.setTitle("Alert !");
                    builder.setCancelable(false);
                    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //yes
                            if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
                                AlertDialog.Builder builder = new AlertDialog.Builder(SettingsActivity.this);
                                builder.setMessage("Current Mode is already Night!");
                                builder.setTitle("Alert!");
                                builder.setCancelable(false);
                                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        //OK
                                        dialog.cancel();
                                    }
                                });
                                AlertDialog alertDialog = builder.create();
                                alertDialog.show();
                            } else
                                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                        }
                    });
                    builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // If user click no
                            // then dialog box is canceled.
                            dialog.cancel();
                        }
                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                } else
                    Toast.makeText(getApplicationContext(), "Choose Light or Night , please", Toast.LENGTH_LONG).show();
            }
        });

        LogoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SettingsActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}
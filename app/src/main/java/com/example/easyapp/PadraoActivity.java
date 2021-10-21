package com.example.easyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class PadraoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_padrao);
        getSupportActionBar().setHomeButtonEnabled(true);
    }
}
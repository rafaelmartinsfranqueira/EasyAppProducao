package com.example.easyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void buttonFormulaClick(View view) {
        Intent intent = new Intent(this,FormulaActivity.class);
        startActivity(intent);
    }

    public void buttonNotasClick(View view) {
        Intent intent = new Intent(this, NotasActivity.class);
        startActivity(intent);
    }
}
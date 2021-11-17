package com.example.easyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    public void buttonFormulaClick(View view) {
        Intent intent = new Intent(this,FormulaActivity.class);
        startActivity(intent);
    }

    public void buttonNotasClick(View view) {
        Intent intent = new Intent(this, NotaActivity.class);
        startActivity(intent);
    }

    public void buttonDashboardClick(View view) {
        Intent intent = new Intent(this, DashboardActivity.class);
        startActivity(intent);
    }
    public void buttonMateriasClick(View view) {
        Intent intent = new Intent(this, MateriaActivity.class);
        startActivity(intent);
    }
    public void buttonProfileClick(View view) {
        Intent intent = new Intent(this, PerfilActivity.class);
        startActivity(intent);
    }
}
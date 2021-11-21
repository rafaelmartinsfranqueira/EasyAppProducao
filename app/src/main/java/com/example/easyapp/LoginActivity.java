package com.example.easyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText txtLoginUsuario, txtLoginSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txtLoginUsuario = (EditText) findViewById(R.id.txtLoginUsuario);
        txtLoginSenha = (EditText) findViewById(R.id.txtLoginSenha);
    }

    public void btnLoginEntrarClick(View view) {
        if (txtLoginUsuario.getText().toString().equals("x") && txtLoginSenha.getText().toString().equals("x")) {
            Intent intent = new Intent(this, MenuActivity.class);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(LoginActivity.this, "Usuario ou Senha incorretos !!!", Toast.LENGTH_SHORT).show();
        }
    }

    public void buttonHCadastroClick(View view) {
        Intent intent = new Intent(this, CadastroActivity.class);
        startActivity(intent);
    }
}


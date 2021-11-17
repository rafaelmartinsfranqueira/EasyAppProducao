package com.example.easyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import models.Login;
import services.ServiceApi;

public class LoginActivity extends AppCompatActivity {

    int id = 0;
    Login login;
    TextView textNome, textSenha;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void buttonHomeClick(View view) {
        login.setNome(textNome.getText().toString());
        login.setSenha(textSenha.getText().toString());
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }

    public void buttonHCadastroClick(View view) {
        Intent intent = new Intent(this, CadastroActivity.class);
        startActivity(intent);
    }

    public class LoginAPI extends AsyncTask<String, String, String> {
        private String metodo;

        public LoginAPI(String metodo) {
            this.metodo = metodo;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... strings) {
            String data = ServiceApi.getService(strings[0], metodo, strings[1]);
            return data;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if (metodo == "GET") {
                login = Login.parseOneObject(s);
                dialog.dismiss();
            }
            if (s == "OK") {
                Toast.makeText(LoginActivity.this, "Operacao realizada com sucesso", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                finish();
            }
        }
    }
}


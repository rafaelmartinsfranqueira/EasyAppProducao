package com.example.easyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import models.Login;
import services.ServiceApi;

public class LoginActivity extends AppCompatActivity {

    int usuarioid;
    Login login;
    public EditText txtLoginUsuario;
    public EditText txtLoginSenha;
    ProgressDialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        SharedPreferences shared = getSharedPreferences("usuario_id", MODE_PRIVATE);
        txtLoginUsuario = (EditText) findViewById(R.id.txtLoginUsuario);
        txtLoginSenha = (EditText) findViewById(R.id.txtLoginSenha);
    }

    public void btnLoginEntrarClick(View view) {
        String Usuario = txtLoginUsuario.getText().toString();
        String Senha = txtLoginSenha.getText().toString();
        new LoginActivity.LoginAPI("GET").execute("usuarios/autenticar?usuario=" + Usuario + "&senha=" + Senha , Login.parseJson(login));

    }

    public void buttonHCadastroClick(View view) {
        Intent intent = new Intent(this, CadastroActivity.class);
        startActivity(intent);
    }

    // criar este método

    private void adicionarUsuarioId(SharedPreferences shared) {
        SharedPreferences.Editor editor = shared.edit();
        editor.putInt("usuario_id", usuarioid);
        editor.commit();
    }


// no onClick adicionar:



    public class LoginAPI extends AsyncTask<String, String, String> {
        private String metodo;

        public LoginAPI(String metodo) {
            this.metodo = metodo;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog = ProgressDialog.show(LoginActivity.this, "Aguarde", "Por Favor Aguarde...");
        }

        @Override
        protected String doInBackground(String... strings) {
            String data = ServiceApi.getService(strings[0], metodo, strings[1]);
            return data;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if (s == "") {
                dialog.dismiss();
                Toast.makeText(LoginActivity.this, "Usuario e Senha Nao encontrados", Toast.LENGTH_SHORT).show();

            }
            else
            {
                //adicionarUsuarioId(s.get);
                Intent intent = new Intent(LoginActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        }
    }
}


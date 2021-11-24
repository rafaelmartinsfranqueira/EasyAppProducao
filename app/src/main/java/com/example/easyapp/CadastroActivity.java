package com.example.easyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import models.Cadastro;
import services.ServiceApi;

public class CadastroActivity extends AppCompatActivity {

    int usuarioid = 0;
    Cadastro cadastro;
    public EditText txtCadastroNome;
    public EditText txtCadastroSenha;
    public EditText txtCadastroUsuario;
    public EditText txtCadastroEmail;
    public EditText txtCadastroInstituicao;
    public Switch switchCadastroTermoDeUso;
    public Switch switchCadastroTermoDePrivacidade;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        getSupportActionBar().setHomeButtonEnabled(true);
        txtCadastroNome = (EditText) findViewById(R.id.txtCadastroNome);
        txtCadastroSenha = (EditText) findViewById(R.id.txtCadastroSenha);
        txtCadastroUsuario = (EditText) findViewById(R.id.txtCadastroUsuario);
        txtCadastroEmail = (EditText) findViewById(R.id.txtCadastroEmail);
        txtCadastroInstituicao = (EditText) findViewById(R.id.txtCadastroInstituicao);
        switchCadastroTermoDeUso = (Switch) findViewById(R.id.switchCadastroTermoDeUso);
        switchCadastroTermoDePrivacidade = (Switch) findViewById(R.id.switchCadastroTermoDePrivacidade);
     }

    public void btnSalvarCadastroClick(View v) {
        boolean TermosDeUso, TermosDePrivacidade;
        String Nome = txtCadastroNome.getText().toString();
        String Senha = txtCadastroSenha.getText().toString();
        String Usuario = txtCadastroUsuario.getText().toString();
        String Email = txtCadastroEmail.getText().toString();
        String Instituicao = txtCadastroInstituicao.getText().toString();

        if (switchCadastroTermoDeUso.isChecked()) {
            TermosDeUso = true;
        } else {
            TermosDeUso = false;
        }

        if (switchCadastroTermoDePrivacidade.isChecked()) {
            TermosDePrivacidade = true;
        } else {
            TermosDePrivacidade = false;
        }

        cadastro = new Cadastro(10,Nome, Senha, Usuario, Email, Instituicao,TermosDeUso,TermosDePrivacidade);
        cadastro.setUsuarioid(0);
        new CadastroAPI("POST").execute("usuarios/criar", Cadastro.parseJson(cadastro));
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }

    public class CadastroAPI extends AsyncTask<String, String, String> {
        private String metodo;

        public CadastroAPI(String metodo) {
            this.metodo = metodo;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog = ProgressDialog.show(CadastroActivity.this, "Aguarde", "Por Favor Aguarde...");
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
                cadastro = Cadastro.parseOneObject(s);
                dialog.dismiss();
            }
            if (s == "OK") {
                Toast.makeText(CadastroActivity.this, "Operacao realizada com sucesso", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                finish();
            }
        }
    }
}
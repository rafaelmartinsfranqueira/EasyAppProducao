package com.example.easyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import models.Cadastro;
import services.ServiceApi;

public class CadastroActivity extends AppCompatActivity {

    int usuarioid = 0;
    Cadastro cadastro;
    public EditText txtNome;
    public EditText txtSenha;
    public EditText txtUsuario;
    public EditText txtEmail;
    public EditText txtInstituicao;
    public TextView txttermoDeUso;
    public TextView txttermoDePrivacidade;
    //public TextView imgCadastroUsuario;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        getSupportActionBar().setHomeButtonEnabled(true);
        txtNome = findViewById(R.id.txtCadastroNome);
        txtSenha = findViewById(R.id.txtCadastroSenha);
        txtUsuario = findViewById(R.id.txtCadastroUsuario);
        txtEmail = findViewById(R.id.txtCadastroEmail);
        txtInstituicao = findViewById(R.id.txtCadastroInstituicao);
        txttermoDeUso = findViewById(R.id.txtCadastroTermosDeUso);
        txttermoDePrivacidade = findViewById(R.id.txtCadastroTermosDePrivacidade);
        //imgCadastroUsuario = findViewById(R.id.imgCadastroUsuario);
    }

    public void carregarCampos() {
        txtNome.setText(cadastro.getNome());
        txtSenha.setText(cadastro.getEmail());
        txtUsuario.setText(cadastro.getUsuario());
        txtEmail.setText(cadastro.getEmail());
        txtInstituicao.setText(cadastro.getInstituicao());
        txttermoDeUso.setText(cadastro.getTermosdeuso());
        txttermoDePrivacidade.setText(cadastro.getTermosdeprivacidade());
        //imgCadastroUsuario.setText(cadastro.getUsuarioimagem());
    }

    public void btnSalvarCadastroClick(View v) {
        cadastro = new Cadastro();
        txtNome.setText(cadastro.getNome());
        txtSenha.setText(cadastro.getEmail());
        txtUsuario.setText(cadastro.getUsuario());
        txtEmail.setText(cadastro.getEmail());
        txtInstituicao.setText(cadastro.getInstituicao());
        txttermoDeUso.setText(cadastro.getTermosdeuso());
        txttermoDePrivacidade.setText(cadastro.getTermosdeprivacidade());
        //imgCadastroUsuario.setText(cadastro.getUsuarioimagem());
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
            carregarCampos();
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
                carregarCampos();
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
package com.example.easyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import models.Perfil;
import services.ServiceApi;

public class PerfilActivity extends AppCompatActivity {

    Perfil perfil;
    public EditText txtPerfilNome;
    public EditText txtPerfilSenha;
    public EditText txtPerfilUsuario;
    public EditText txtPerfilEmail;
    public EditText txtPerfilInstituicao;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        getSupportActionBar().setHomeButtonEnabled(true);
        txtPerfilNome = (EditText) findViewById(R.id.txtPerfilNome);
        txtPerfilSenha = (EditText) findViewById(R.id.txtPerfilSenha);
        txtPerfilUsuario = (EditText) findViewById(R.id.txtPerfilUsuario);
        txtPerfilEmail = (EditText) findViewById(R.id.txtPerfilEmail);
        txtPerfilInstituicao = (EditText) findViewById(R.id.txtPerfilInstituicao);
        buscarPerfis(1);//Fixo para teste
    }

    public void btnEditarPerfilClick(View v) {
        String Nome = txtPerfilNome.getText().toString();
        String Senha = txtPerfilSenha.getText().toString();
        String Usuario = txtPerfilUsuario.getText().toString();
        String Email = txtPerfilEmail.getText().toString();
        String Instituicao = txtPerfilInstituicao.getText().toString();
        perfil = new Perfil(1,Nome, Senha, Usuario, Email, Instituicao);
        new PerfilAPI("PUT").execute("usuarios/update", Perfil.parseJson(perfil));
    }

        public void buscarPerfis(int usuarioid) {
            new PerfilAPI("GET").execute("usuarios/select?usuarioid=" + usuarioid, "");
        }

    public void carregarCampos() {
        txtPerfilNome.setText(perfil.getNome());
        txtPerfilSenha.setText(perfil.getSenha());
        txtPerfilUsuario.setText(perfil.getUsuario());
        txtPerfilEmail.setText(perfil.getEmail());
        txtPerfilInstituicao.setText(perfil.getInstituicao());
    }


    public class PerfilAPI extends AsyncTask<String, String, String> {
        private String metodo;

        public PerfilAPI(String metodo) {
            this.metodo = metodo;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog = ProgressDialog.show(PerfilActivity.this, "Aguarde", "Por Favor Aguarde...");
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
                perfil = Perfil.parseOneObject(s);
                carregarCampos();
                dialog.dismiss();
            }
            if (metodo == "PUT") {
                dialog.dismiss();
                Toast.makeText(PerfilActivity.this, "Operacao realizada com sucesso", Toast.LENGTH_SHORT).show();
            }
            if (s == "OK") {
                Toast.makeText(PerfilActivity.this, "Operacao realizada com sucesso", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        }

    }
}
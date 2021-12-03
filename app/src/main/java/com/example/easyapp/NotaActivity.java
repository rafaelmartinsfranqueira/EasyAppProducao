package com.example.easyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import models.Materia;
import models.Nota;
import services.ServiceApi;

public class NotaActivity extends AppCompatActivity {

    Nota nota;
    ArrayList<Materia> materiaArray;
    public EditText txtNotasNomeNota1;
    public EditText txtNotasNumNota1;
    public EditText txtNotasNomeNota2;
    public EditText txtNotasNumNota2;
    public EditText txtNotasNomeNota3;
    public EditText txtNotasNumNota3;
    public EditText txtNotasNomeNota4;
    public EditText txtNotasNumNota4;
    private int usuarioid;
    private int materiaid;
    private TextView txtNotasMediaCalculada;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nota);


        txtNotasNomeNota1 = (EditText) findViewById(R.id.txtNotasNomeNota1);
        txtNotasNumNota1 = (EditText) findViewById(R.id.txtNotasNumNota1);
        txtNotasNomeNota2 = (EditText) findViewById(R.id.txtNotasNomeNota2);
        txtNotasNumNota2 = (EditText) findViewById(R.id.txtNotasNumNota2);
        txtNotasNomeNota3 = (EditText) findViewById(R.id.txtNotasNomeNota3);
        txtNotasNumNota3 = (EditText) findViewById(R.id.txtNotasNumNota3);
        txtNotasNomeNota4 = (EditText) findViewById(R.id.txtNotasNomeNota4);
        txtNotasNumNota4 = (EditText) findViewById(R.id.txtNotasNumNota4);
        txtNotasMediaCalculada = (TextView) findViewById(R.id.txtNotasMediaCalculada);

        new MateriaAPI("GET").execute("materias/listar","");

        getSupportActionBar().setHomeButtonEnabled(true);
    }

    public void btnSalvarNotaClick(View v) {
        String notanome1 = txtNotasNomeNota1.getText().toString();
        String notavalor1 = txtNotasNumNota1.getText().toString();
        String notanome2 = txtNotasNomeNota2.getText().toString();
        String notavalor2 = txtNotasNumNota2.getText().toString();
        String notanome3 = txtNotasNomeNota3.getText().toString();
        String notavalor3 = txtNotasNumNota3.getText().toString();
        String notanome4 = txtNotasNomeNota4.getText().toString();
        String notavalor4 = txtNotasNumNota4.getText().toString();
        String notamediacalculada = txtNotasMediaCalculada.getText().toString();
        nota = new Nota( 0,  1,  notanome1,  notavalor1,  notanome2,  notavalor2,  notanome3,  notavalor3,  notanome4,  notavalor4,  notamediacalculada,  1);
        new NotaActivity.NotaAPI("POST").execute("notas/criar", Nota.parseJson(nota));
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }

    public void btnSalvarMediaClick(View v) {
        Double numero1;
        Double numero2;
        Double numero3;
        Double numero4;
        Double resultado;

        numero1 = Double.parseDouble(txtNotasNumNota1.getText().toString());
        numero2 = Double.parseDouble(txtNotasNumNota2.getText().toString());
        numero3 = Double.parseDouble(txtNotasNumNota3.getText().toString());
        numero4 = Double.parseDouble(txtNotasNumNota4.getText().toString());
        resultado = (numero1 + numero2 + numero3 + numero4) / 4;
        txtNotasMediaCalculada.setText(resultado.toString());
    }

    public class NotaAPI extends AsyncTask<String, String, String> {
        private String metodo;

        public NotaAPI(String metodo) {
            this.metodo = metodo;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog = ProgressDialog.show(NotaActivity.this, "Aguarde", "Por Favor Aguarde...");
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
                nota = Nota.parseOneObject(s);
                dialog.dismiss();
            }
            if (s == "OK") {
                Toast.makeText(NotaActivity.this, "Operacao realizada com sucesso", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                finish();
            }
        }
    }


    public class MateriaAPI extends AsyncTask<String, String, String> {
        private String metodo;

        public MateriaAPI(String metodo) {
            this.metodo = metodo;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog = ProgressDialog.show(NotaActivity.this, "Aguarde", "Por Favor Aguarde...");
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
                materiaArray = Materia.parseObject(s);
                Spinner spinner = (Spinner) findViewById(R.id.spinnerNotasMaterias);
                spinner.setAdapter(new ArrayAdapter<Materia>(NotaActivity.this, R.layout.support_simple_spinner_dropdown_item, materiaArray));


                dialog.dismiss();
            }
            if (s == "OK") {
                Toast.makeText(NotaActivity.this, "Operacao realizada com sucesso", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                finish();
            }
        }
    }
}
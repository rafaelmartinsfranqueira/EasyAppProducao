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

import models.Formula;
import models.Materia;
import models.Nota;
import services.ServiceApi;

public class NotaActivity extends AppCompatActivity {

    Nota nota;
    Formula formula;
    ArrayList<Materia> materiaArray;
    public EditText formulanomenota1;
    public EditText txtNotasNumNota1;
    public EditText formulanomenota2;
    public EditText txtNotasNumNota2;
    public EditText formulanomenota3;
    public EditText txtNotasNumNota3;
    public EditText formulanomenota4;
    public EditText txtNotasNumNota4;
    private int usuarioid;
    private int materiaid;
    private TextView txtNotasMediaCalculada;
    ProgressDialog dialog1;
    ProgressDialog dialog2;
    ProgressDialog dialog3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nota);


        formulanomenota1 = (EditText) findViewById(R.id.txtNotasNomeNota1);
        txtNotasNumNota1 = (EditText) findViewById(R.id.txtNotasNumNota1);
        formulanomenota2 = (EditText) findViewById(R.id.txtNotasNomeNota2);
        txtNotasNumNota2 = (EditText) findViewById(R.id.txtNotasNumNota2);
        formulanomenota3 = (EditText) findViewById(R.id.txtNotasNomeNota3);
        txtNotasNumNota3 = (EditText) findViewById(R.id.txtNotasNumNota3);
        formulanomenota4 = (EditText) findViewById(R.id.txtNotasNomeNota4);
        txtNotasNumNota4 = (EditText) findViewById(R.id.txtNotasNumNota4);
        txtNotasMediaCalculada = (TextView) findViewById(R.id.txtNotasMediaCalculada);

        buscarPerfis3(1);

        new MateriaAPI("GET").execute("materias/listar","");

        getSupportActionBar().setHomeButtonEnabled(true);
    }

    public void buscarPerfis3(int usuarioid3) {
        new NotaActivity.FormulaAPI("GET").execute("formulas/select?usuarioid=" + usuarioid3, "");
    }

    public void carregarCampos3() {
        formulanomenota1.setText(formula.getFormulanomenota1());
        formulanomenota2.setText(formula.getFormulanomenota2());
        formulanomenota3.setText(formula.getFormulanomenota3());
        formulanomenota4.setText(formula.getFormulanomenota4());
    }

    public void btnSalvarNotaClick(View v) {
        String notanome1 = formulanomenota1.getText().toString();
        String notavalor1 = txtNotasNumNota1.getText().toString();
        String notanome2 = formulanomenota2.getText().toString();
        String notavalor2 = txtNotasNumNota2.getText().toString();
        String notanome3 = formulanomenota3.getText().toString();
        String notavalor3 = txtNotasNumNota3.getText().toString();
        String notanome4 = formulanomenota4.getText().toString();
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
        private String metodo1;

        public NotaAPI(String metodo1) {
            this.metodo1 = metodo1;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog1 = ProgressDialog.show(NotaActivity.this, "Aguarde", "Por Favor Aguarde...");
        }

        @Override
        protected String doInBackground(String... strings) {
            String data1 = ServiceApi.getService(strings[0], metodo1, strings[1]);
            return data1;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if (metodo1 == "GET") {
                nota = Nota.parseOneObject(s);
                dialog1.dismiss();
            }
            if (s == "OK") {
                Toast.makeText(NotaActivity.this, "Operacao realizada com sucesso", Toast.LENGTH_SHORT).show();
                dialog1.dismiss();
                finish();
            }
        }
    }


    public class MateriaAPI extends AsyncTask<String, String, String> {
        private String metodo2;

        public MateriaAPI(String metodo2) {
            this.metodo2 = metodo2;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog2 = ProgressDialog.show(NotaActivity.this, "Aguarde", "Por Favor Aguarde...");
        }

        @Override
        protected String doInBackground(String... strings) {
            String data2 = ServiceApi.getService(strings[0], metodo2, strings[1]);
            return data2;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if (metodo2 == "GET") {
                materiaArray = Materia.parseObject(s);
                Spinner spinner = (Spinner) findViewById(R.id.spinnerNotasMaterias);
                spinner.setAdapter(new ArrayAdapter<Materia>(NotaActivity.this, R.layout.support_simple_spinner_dropdown_item, materiaArray));


                dialog2.dismiss();
            }
            if (s == "OK") {
                Toast.makeText(NotaActivity.this, "Operacao realizada com sucesso", Toast.LENGTH_SHORT).show();
                dialog2.dismiss();
                finish();
            }
        }
    }

    public class FormulaAPI extends AsyncTask<String, String, String> {
        private String metodo3;

        public FormulaAPI(String metodo3) {
            this.metodo3 = metodo3;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog3 = ProgressDialog.show(NotaActivity.this, "Aguarde", "Por Favor Aguarde...");
        }

        @Override
        protected String doInBackground(String... strings) {
            String data3 = ServiceApi.getService(strings[0], metodo3, strings[1]);
            return data3;
        }

        @Override
        protected void onPostExecute(String n) {
            super.onPostExecute(n);
            if (metodo3 == "GET") {
                formula = Formula.parseOneObject(n);
                carregarCampos3();
                dialog3.dismiss();
            }
            if (n == "OK") {
                Toast.makeText(NotaActivity.this, "Operacao realizada com sucesso", Toast.LENGTH_SHORT).show();
                dialog3.dismiss();
                finish();
            }
        }
    }
}
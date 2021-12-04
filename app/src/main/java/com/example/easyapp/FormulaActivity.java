package com.example.easyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import models.Formula;
import services.ServiceApi;

public class FormulaActivity extends AppCompatActivity {

    Formula formula;
    public EditText formulanome;
    public EditText formulanomenota1;
    public EditText formulanomenota2;
    public EditText formulanomenota3;
    public EditText formulanomenota4;
    public EditText formulapesonota1;
    public EditText formulapesonota2;
    public EditText formulapesonota3;
    public EditText formulapesonota4;
    private int usuarioid;
    private int formulaid;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formula);
        getSupportActionBar().setHomeButtonEnabled(true);
        formulanome = (EditText) findViewById(R.id.txtFormulaNomeFormula);
        formulanomenota1 = (EditText) findViewById(R.id.txtFormulaNomeNota1);
        formulanomenota2 = (EditText) findViewById(R.id.txtFormulaNomeNota2);
        formulanomenota3 = (EditText) findViewById(R.id.txtFormulaNomeNota3);
        formulanomenota4 = (EditText) findViewById(R.id.txtFormulaNomeNota4);
        formulapesonota1 = (EditText) findViewById(R.id.txtFormulaPesoNota1);
        formulapesonota2 = (EditText) findViewById(R.id.txtFormulaPesoNota2);
        formulapesonota3 = (EditText) findViewById(R.id.txtFormulaPesoNota3);
        formulapesonota4 = (EditText) findViewById(R.id.txtFormulaPesoNota4);

    }
    public void btnSalvarFormulaClick(View v) {
        String Nome = formulanome.getText().toString();
        String NomeFormula1 = formulanomenota1.getText().toString();
        String NomeFormula2 = formulanomenota2.getText().toString();
        String NomeFormula3 = formulanomenota3.getText().toString();
        String NomeFormula4 = formulanomenota4.getText().toString();
        Double Peso1  = Double.parseDouble(formulapesonota1.getText().toString());
        Double Peso2  = Double.parseDouble(formulapesonota2.getText().toString());
        Double Peso3  = Double.parseDouble(formulapesonota3.getText().toString());
        Double Peso4  = Double.parseDouble(formulapesonota4.getText().toString());
        formula = new Formula(0, 1, Nome, NomeFormula1, NomeFormula2, NomeFormula3, NomeFormula4, Peso1, Peso2, Peso3, Peso4);
        //formula.setUsuarioid(0);
        //formula.setFormulaid(0);
        new FormulaAPI("POST").execute("formulas/criar", Formula.parseJson(formula));
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }

    public class FormulaAPI extends AsyncTask<String, String, String> {
        private String metodo;

        public FormulaAPI(String metodo) {
            this.metodo = metodo;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog = ProgressDialog.show(FormulaActivity.this, "Aguarde", "Por Favor Aguarde...");
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
                formula = Formula.parseOneObject(s);
                dialog.dismiss();
            }
            if (s == "OK") {
                Toast.makeText(FormulaActivity.this, "Operacao realizada com sucesso", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                finish();
            }
        }
    }
}
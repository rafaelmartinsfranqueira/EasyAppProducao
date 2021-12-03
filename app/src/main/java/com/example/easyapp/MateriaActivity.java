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
import android.widget.Toast;
import models.Formula;
import models.Materia;
import services.ServiceApi;

import java.util.ArrayList;


public class MateriaActivity extends AppCompatActivity {

    Materia materia;
    ArrayList<Formula> formulaArray;
    public EditText txtMateriaNome;
    public EditText txtMateriaMeta;
    private int usuarioid;
    private int materiaid;
    private int formulaid;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materia);

        txtMateriaNome = (EditText) findViewById(R.id.txtMateriaNome);
        txtMateriaMeta = (EditText) findViewById(R.id.txtMateriaMeta);

        new FormulaAPI("GET").execute("formulas/listar","");

        getSupportActionBar().setHomeButtonEnabled(true);
    }

    public void btnSalvarMateriaClick(View v) {
        String materianome = txtMateriaNome.getText().toString();
        String materiameta = txtMateriaMeta.getText().toString();
        materia = new Materia(0, materianome, materiameta, 1, 1);
        new MateriaActivity.MateriaAPI("POST").execute("materias/criar", Materia.parseJson(materia));
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }

    public class MateriaAPI extends AsyncTask<String, String, String> {
        private String metodo;

        public MateriaAPI(String metodo) {
            this.metodo = metodo;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog = ProgressDialog.show(MateriaActivity.this, "Aguarde", "Por Favor Aguarde...");
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
                materia = Materia.parseOneObject(s);
                dialog.dismiss();
            }
            if (s == "OK") {
                Toast.makeText(MateriaActivity.this, "Operacao realizada com sucesso", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                finish();
            }
        }
    }

    public class FormulaAPI extends AsyncTask<String, String, String> {
        private String metodo;

        public FormulaAPI(String metodo) {
            this.metodo = metodo;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog = ProgressDialog.show(MateriaActivity.this, "Aguarde", "Por Favor Aguarde...");
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
                formulaArray = Formula.parseObject(s);
                Spinner spinner = (Spinner) findViewById(R.id.spinnerMateriaFormula);
                spinner.setAdapter(new ArrayAdapter<Formula>(MateriaActivity.this, R.layout.support_simple_spinner_dropdown_item, formulaArray));


                dialog.dismiss();
            }
            if (s == "OK") {
                Toast.makeText(MateriaActivity.this, "Operacao realizada com sucesso", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                finish();
            }
        }
    }
}
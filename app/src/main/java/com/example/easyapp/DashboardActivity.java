package com.example.easyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import models.Materia;
import models.Nota;
import services.ServiceApi;

public class DashboardActivity extends AppCompatActivity {

    Materia materia;
    Nota nota;
    public EditText dashboardmateria1;
    public EditText dashboardmeta1;
    public EditText dashboardMedia1;
    ProgressDialog dialog1;
    ProgressDialog dialog2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        dashboardmateria1 = (EditText) findViewById(R.id.txtDashboardMateria1);
        dashboardmeta1 = (EditText) findViewById(R.id.txtDashboardMeta1);
        dashboardMedia1  = (EditText) findViewById(R.id.txtDashboardMedia1);
        buscarPerfis1(1);//Fixo para teste
        buscarPerfis2(1);//Fixo para teste
        getSupportActionBar().setHomeButtonEnabled(true);
    }


    public void buscarPerfis1(int usuarioid1) {
        new DashboardActivity.MateriaAPI("GET").execute("materias/select?usuarioid=" + usuarioid1, "");
    }

    public void buscarPerfis2(int usuarioid2) {
        new DashboardActivity.NotaAPI("GET").execute("notas/select?usuarioid=" + usuarioid2, "");
    }

    public void carregarCampos1() {
        dashboardmateria1.setText(materia.getMaterianome());
        dashboardmeta1.setText(materia.getMateriameta());
        dashboardMedia1.setText(materia.getMateriameta());
    }

    public void carregarCampos2() {
        dashboardMedia1.setText(nota.getNotamediacalculada());
    }

    public class MateriaAPI extends AsyncTask<String, String, String> {
        private String metodo1;

        public MateriaAPI(String metodo1) {
            this.metodo1 = metodo1;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog1 = ProgressDialog.show(DashboardActivity.this, "Aguarde", "Por Favor Aguarde...");
        }

        @Override
        protected String doInBackground(String... strings) {
            String data1 = ServiceApi.getService(strings[0], metodo1, strings[1]);
            return data1;
        }

        @Override
        protected void onPostExecute(String m) {
            super.onPostExecute(m);
            if (metodo1 == "GET") {
                materia = Materia.parseOneObject(m);
                carregarCampos1();
                dialog1.dismiss();
            }
            if (m == "OK") {
                Toast.makeText(DashboardActivity.this, "Operacao realizada com sucesso", Toast.LENGTH_SHORT).show();
                dialog1.dismiss();
                finish();
            }
        }
    }

    public class NotaAPI extends AsyncTask<String, String, String> {
        private String metodo2;

        public NotaAPI(String metodo2) {
            this.metodo2 = metodo2;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog2 = ProgressDialog.show(DashboardActivity.this, "Aguarde", "Por Favor Aguarde...");
        }

        @Override
        protected String doInBackground(String... strings) {
            String data2 = ServiceApi.getService(strings[0], metodo2, strings[1]);
            return data2;
        }

        @Override
        protected void onPostExecute(String n) {
            super.onPostExecute(n);
            if (metodo2 == "GET") {
                nota = Nota.parseOneObject(n);
                carregarCampos2();
                dialog2.dismiss();
            }
            if (n == "OK") {
                Toast.makeText(DashboardActivity.this, "Operacao realizada com sucesso", Toast.LENGTH_SHORT).show();
                dialog2.dismiss();
                finish();
            }
        }
    }

}
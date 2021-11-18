package holders;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.easyapp.R;

public class FormulaHolder extends RecyclerView.ViewHolder {
    public TextView txtFormulaNome;
    public TextView txtFormulaNota1;
    public TextView txtFormulaNota2;
    public TextView txtFormulaNota3;
    public TextView txtFormulaNota4;
    public TextView txtFormulaPeso1;
    public TextView txtFormulaPeso2;
    public TextView txtFormulaPeso3;
    public TextView txtFormulaPeso4;

    public FormulaHolder(View view) {
        super(view);
        txtFormulaNome = (TextView) view.findViewById(R.id.txtFormulaNomeFormula);
        txtFormulaNota1 = (TextView) view.findViewById(R.id.txtFormulaNomeNota1);
        txtFormulaNota2 = (TextView) view.findViewById(R.id.txtFormulaNomeNota2);
        txtFormulaNota3 = (TextView) view.findViewById(R.id.txtFormulaNomeNota3);
        txtFormulaNota4 = (TextView) view.findViewById(R.id.txtFormulaNomeNota4);
        txtFormulaPeso1 = (TextView) view.findViewById(R.id.txtFormulaPesoNota1);
        txtFormulaPeso2 = (TextView) view.findViewById(R.id.txtFormulaPesoNota2);
        txtFormulaPeso3 = (TextView) view.findViewById(R.id.txtFormulaPesoNota3);
        txtFormulaPeso4 = (TextView) view.findViewById(R.id.txtFormulaPesoNota4);
    }

}


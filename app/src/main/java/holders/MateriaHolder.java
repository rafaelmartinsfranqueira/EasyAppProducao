package holders;

import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.easyapp.R;

public class MateriaHolder extends RecyclerView.ViewHolder {
    public TextView txtMateria;
    public Spinner spinnerMateriaFormula;
    public TextView txtMateriaMeta;

    public MateriaHolder(View view) {
        super(view);
        txtMateria = (TextView) view.findViewById(R.id.txtMateriaMateria);
        spinnerMateriaFormula = (Spinner) view.findViewById(R.id.spinnerMateriaFormula);
        txtMateriaMeta = (TextView) view.findViewById(R.id.txtMateriaMeta);

    }

}


package holders;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.easyapp.R;

public class MateriaViewHolder extends RecyclerView.ViewHolder {
    public TextView textViewMateria;
    public TextView textViewNota;
    public TextView textViewPercentual;

    public MateriaViewHolder(View view) {
        super(view);
        textViewMateria = (TextView)view.findViewById(R.id.textViewMateria);
        textViewNota = (TextView)view.findViewById(R.id.textViewNota);
        textViewPercentual = (TextView)view.findViewById(R.id.textViewPercentual);
    }
}

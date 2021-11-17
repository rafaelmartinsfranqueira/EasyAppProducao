package holders;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.easyapp.R;

public class NotaHolder extends RecyclerView.ViewHolder {
    public TextView txtNomeNota1;
    public TextView txtNomeNota2;
    public TextView txtNomeNota3;
    public TextView txtNomeNota4;
    public TextView txtNumNota1;
    public TextView txtNumNota2;
    public TextView txtNumNota3;
    public TextView txtNumNota4;
    public TextView txtNotaMedia;
    public TextView txtNotaMediCalculada;

    public NotaHolder(View view) {
        super(view);
        txtNomeNota1 = (TextView) view.findViewById(R.id.txtNotasNomeNota1);
        txtNomeNota2 = (TextView) view.findViewById(R.id.txtNotasNomeNota2);
        txtNomeNota3 = (TextView) view.findViewById(R.id.txtNotasNomeNota3);
        txtNomeNota4 = (TextView) view.findViewById(R.id.txtNotasNomeNota4);
        txtNumNota1 = (TextView) view.findViewById(R.id.txtNotasNumNota1);
        txtNumNota2 = (TextView) view.findViewById(R.id.txtNotasNumNota2);
        txtNumNota3 = (TextView) view.findViewById(R.id.txtNotasNumNota3);
        txtNumNota4 = (TextView) view.findViewById(R.id.txtNotasNumNota4);
        txtNotaMedia = (TextView) view.findViewById(R.id.txtNotasMedia);
        txtNotaMediCalculada = (TextView) view.findViewById(R.id.txtNotasMediaCalculada);

    }

}


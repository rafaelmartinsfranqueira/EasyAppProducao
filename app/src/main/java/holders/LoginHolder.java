package holders;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.easyapp.R;

public class LoginHolder extends RecyclerView.ViewHolder {
    public TextView txtNome;
    public TextView txtSenha;

    public LoginHolder(View view) {
        super(view);
        txtNome = (TextView) view.findViewById(R.id.txtLoginNome);
        txtSenha = (TextView) view.findViewById(R.id.txtLoginSenha);
    }

}


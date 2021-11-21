package holders;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.easyapp.R;

public class LoginHolder extends RecyclerView.ViewHolder {
    public TextView txtLoginUsuario;
    public TextView txtLoginSenha;

    public LoginHolder(View view) {
        super(view);
        txtLoginUsuario = (TextView) view.findViewById(R.id.txtLoginUsuario);
        txtLoginSenha = (TextView) view.findViewById(R.id.txtLoginSenha);
    }

}


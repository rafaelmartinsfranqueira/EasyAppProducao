package holders;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.easyapp.R;

public class CadastroHolder extends RecyclerView.ViewHolder {
    public TextView txtNome;
    public TextView txtSenha;
    public TextView txtUsuario;
    public TextView txtEmail;
    public TextView txtInstituicao;
    public TextView txttermoDeUso;
    public TextView txttermoDePrivacidade;

    public CadastroHolder(View view) {
        super(view);
        txtNome = (TextView) view.findViewById(R.id.txtCadastroNome);
        txtSenha = (TextView) view.findViewById(R.id.txtCadastroSenha);
        txtUsuario = (TextView) view.findViewById(R.id.txtCadastroUsuario);
        txtEmail = (TextView) view.findViewById(R.id.txtCadastroEmail);
        txtInstituicao = (TextView) view.findViewById(R.id.txtCadastroInstituicao);
        txttermoDeUso = (TextView) view.findViewById(R.id.txtCadastroTermosDeUso);
        txttermoDePrivacidade = (TextView) view.findViewById(R.id.txtCadastroTermosDePrivacidade);
    }

}


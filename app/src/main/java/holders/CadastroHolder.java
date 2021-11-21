package holders;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.easyapp.R;

public class CadastroHolder extends RecyclerView.ViewHolder {
    public EditText txtNome;
    public EditText txtSenha;
    public EditText txtUsuario;
    public EditText txtEmail;
    public EditText txtInstituicao;
    public TextView txttermoDeUso;
    public TextView txttermoDePrivacidade;
    public ImageView imgCadastroUsuario;

    public CadastroHolder(View view) {
        super(view);
        txtNome = (EditText) view.findViewById(R.id.txtCadastroNome);
        txtSenha = (EditText) view.findViewById(R.id.txtCadastroSenha);
        txtUsuario = (EditText) view.findViewById(R.id.txtCadastroUsuario);
        txtEmail = (EditText) view.findViewById(R.id.txtCadastroEmail);
        txtInstituicao = (EditText) view.findViewById(R.id.txtCadastroInstituicao);
        txttermoDeUso = (TextView) view.findViewById(R.id.txtCadastroTermosDeUso);
        txttermoDePrivacidade = (TextView) view.findViewById(R.id.txtCadastroTermosDePrivacidade);
        imgCadastroUsuario = (ImageView) view.findViewById(R.id.imgCadastroUsuario);
    }

}


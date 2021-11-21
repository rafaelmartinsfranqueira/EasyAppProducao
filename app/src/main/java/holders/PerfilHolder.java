package holders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.easyapp.R;

public class PerfilHolder extends RecyclerView.ViewHolder {
    public TextView txtNome;
    public TextView txtSenha;
    public TextView txtUsuario;
    public TextView txtEmail;
    public TextView txtInstituicao;
    public ImageView imgCadastroUsuario;

    public PerfilHolder(View view) {
        super(view);
        txtNome = (TextView) view.findViewById(R.id.txtPerfilNome);
        txtSenha = (TextView) view.findViewById(R.id.txtPerfilSenha);
        txtUsuario = (TextView) view.findViewById(R.id.txtPerfilUsuario);
        txtEmail = (TextView) view.findViewById(R.id.txtPerfilEmail);
        txtInstituicao = (TextView) view.findViewById(R.id.txtPerfilInstituicao);
        imgCadastroUsuario = (ImageView) view.findViewById(R.id.imgCadastroUsuario);
    }

}


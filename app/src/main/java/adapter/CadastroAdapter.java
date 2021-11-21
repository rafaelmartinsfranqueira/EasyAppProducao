package adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.easyapp.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.easyapp.CadastroActivity;

import java.util.ArrayList;

import holders.CadastroHolder;
import models.Cadastro;

public class CadastroAdapter extends RecyclerView.Adapter<CadastroHolder> {
    private final ArrayList<Cadastro> cadastros;

    public CadastroAdapter(ArrayList<Cadastro> cadastros) {
        this.cadastros = cadastros;
    }

    @NonNull
    @Override
    public CadastroHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CadastroHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista_cadastro, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CadastroHolder holder, int position) {
        holder.txtEmail.setText(cadastros.get(position).getEmail());
        holder.txtInstituicao.setText(cadastros.get(position).getInstituicao());
        holder.txtNome.setText(cadastros.get(position).getNome());
        holder.txtSenha.setText(cadastros.get(position).getSenha());
        holder.txtUsuario.setText(cadastros.get(position).getUsuario());
        holder.txttermoDePrivacidade.setText(cadastros.get(position).getTermosdeprivacidade());
        holder.txttermoDeUso.setText(cadastros.get(position).getTermosdeuso());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(holder.itemView.getContext(), CadastroActivity.class);
                i.putExtra("usuarioid", cadastros.get(holder.getAdapterPosition()).getUsuarioid());
                holder.itemView.getContext().startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return cadastros != null ? cadastros.size() : 0;
    }
}

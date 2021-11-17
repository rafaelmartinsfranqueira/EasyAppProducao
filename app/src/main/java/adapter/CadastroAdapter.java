package adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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
    return null;
    }

    @Override
    public void onBindViewHolder(@NonNull CadastroHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return cadastros != null ? cadastros.size() : 0;
    }
}

package adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import holders.PerfilHolder;
import models.Perfil;

public class PerfilAdapter extends RecyclerView.Adapter<PerfilHolder> {
    private final ArrayList<Perfil> perfis;

    public PerfilAdapter(ArrayList<Perfil> perfis) {
        this.perfis = perfis;
    }

    @NonNull
    @Override
    public PerfilHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull PerfilHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return perfis != null ? perfis.size() : 0;
    }
}

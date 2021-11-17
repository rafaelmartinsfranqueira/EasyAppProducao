package adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import holders.MateriaHolder;
import models.Materia;

public class MateriaAdapter extends RecyclerView.Adapter<MateriaHolder> {
    private final ArrayList<Materia> materias;

    public MateriaAdapter(ArrayList<Materia> materias) {
        this.materias = materias;
    }

    @NonNull
    @Override
    public MateriaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MateriaHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return materias != null ? materias.size() : 0;
    }
}

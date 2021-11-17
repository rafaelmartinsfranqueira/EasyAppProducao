package adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import holders.NotaHolder;
import models.Nota;

public class NotaAdapter extends RecyclerView.Adapter<NotaHolder> {
    private final ArrayList<Nota> notas;

    public NotaAdapter(ArrayList<Nota> notas) {
        this.notas = notas;
    }

    @NonNull
    @Override
    public NotaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull NotaHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return notas != null ? notas.size() : 0;
    }
}

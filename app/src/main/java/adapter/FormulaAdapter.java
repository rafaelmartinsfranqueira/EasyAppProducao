package adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import holders.FormulaHolder;
import models.Formula;

public class FormulaAdapter extends RecyclerView.Adapter<FormulaHolder> {
    private final ArrayList<Formula> formulas;

    public FormulaAdapter(ArrayList<Formula> formulas) {
        this.formulas = formulas;
    }

    @NonNull
    @Override
    public FormulaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull FormulaHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return formulas != null ? formulas.size() : 0;
    }
}

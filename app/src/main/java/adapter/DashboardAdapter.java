package adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import holders.DashboardHolder;
import models.Dashboard;

public class DashboardAdapter extends RecyclerView.Adapter<DashboardHolder> {
    private final ArrayList<Dashboard> dashboards;

    public DashboardAdapter(ArrayList<Dashboard> dashboards) {
        this.dashboards = dashboards;
    }

    @NonNull
    @Override
    public DashboardHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull DashboardHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return dashboards != null ? dashboards.size() : 0;
    }
}

package holders;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.easyapp.R;

public class DashboardHolder extends RecyclerView.ViewHolder {
    public TextView txtMateriaNome1;
    public TextView txtMateriaNome2;
    public TextView txtMateriaNome3;
    public TextView txtMateriaNome4;
    public TextView txtMateriaMedia1;
    public TextView txtMateriaMedia2;
    public TextView txtMateriaMedia3;
    public TextView txtMateriaMedia4;
    public TextView txtMateriaMeta1;
    public TextView txtMateriaMeta2;
    public TextView txtMateriaMeta3;
    public TextView txtMateriaMeta4;

    public DashboardHolder(View view) {
        super(view);
        txtMateriaNome1 = (TextView) view.findViewById(R.id.txtDashboardMateria1);
        txtMateriaNome2 = (TextView) view.findViewById(R.id.txtDashboardMateria2);
        txtMateriaNome3 = (TextView) view.findViewById(R.id.txtDashboardMateria3);
        txtMateriaNome4 = (TextView) view.findViewById(R.id.txtDashboardMateria4);
        txtMateriaMedia1 = (TextView) view.findViewById(R.id.txtDashboardMedia1);
        txtMateriaMedia2 = (TextView) view.findViewById(R.id.txtDashboardMedia2);
        txtMateriaMedia3 = (TextView) view.findViewById(R.id.txtDashboardMedia3);
        txtMateriaMedia4 = (TextView) view.findViewById(R.id.txtDashboardMedia4);
        txtMateriaMeta1 = (TextView) view.findViewById(R.id.txtDashboardMeta1);
        txtMateriaMeta2 = (TextView) view.findViewById(R.id.txtDashboardMeta2);
        txtMateriaMeta3 = (TextView) view.findViewById(R.id.txtDashboardMeta3);
        txtMateriaMeta4 = (TextView) view.findViewById(R.id.txtDashboardMeta4);
    }

}


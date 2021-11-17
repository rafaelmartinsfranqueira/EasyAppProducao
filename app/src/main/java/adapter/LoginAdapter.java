package adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import holders.LoginHolder;
import models.Login;

public class LoginAdapter extends RecyclerView.Adapter<LoginHolder> {
    private final ArrayList<Login> logins;

    public LoginAdapter(ArrayList<Login> logins) {
        this.logins = logins;
    }

    @NonNull
    @Override
    public LoginHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull LoginHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return logins != null ? logins.size() : 0;
    }
}

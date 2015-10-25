package co.zonaapp.appcerofilas.Adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import co.zonaapp.appcerofilas.ActMaps;
import co.zonaapp.appcerofilas.Activities.ActSecedes;
import co.zonaapp.appcerofilas.Entities.Entidades;
import co.zonaapp.appcerofilas.Entities.RowViewHolder;
import co.zonaapp.appcerofilas.R;

public class AdapterRecyclerView extends RecyclerView.Adapter<RowViewHolder>  {

    Context context;
    List<Entidades> itemsList;

    public AdapterRecyclerView(Context context, List<Entidades> itemsList) {
        this.context = context;
        this.itemsList = itemsList;
    }

    @Override
    public RowViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_entidades, parent, false);
        return new RowViewHolder(v, context);
    }

    @Override
    public void onBindViewHolder(RowViewHolder holder, final int position) {
        final Entidades items = itemsList.get(position);

        holder.nombre.setText(items.getNombre());
        holder.secundario.setText(items.getDireccion());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putInt("posicion", position);
                context.startActivity(new Intent(context, ActSecedes.class).putExtras(bundle));
            }
        });
    }

    @Override
    public int getItemCount() {
        if (itemsList == null) {
            return 0;
        } else {
            return itemsList.size();
        }
    }
}

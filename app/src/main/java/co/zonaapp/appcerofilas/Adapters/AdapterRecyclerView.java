package co.zonaapp.appcerofilas.Adapters;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import co.zonaapp.appcerofilas.Activities.ActEntidades;
import co.zonaapp.appcerofilas.Activities.ActUbicacion;
import co.zonaapp.appcerofilas.Activities.SimpleScannerActivity;
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
        RowViewHolder viewHolder = new RowViewHolder(v, context);
        return viewHolder;
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
                context.startActivity(new Intent(context, ActUbicacion.class).putExtras(bundle));
                //overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
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

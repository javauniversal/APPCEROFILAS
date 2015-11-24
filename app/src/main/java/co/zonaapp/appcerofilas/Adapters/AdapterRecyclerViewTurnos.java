package co.zonaapp.appcerofilas.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import co.zonaapp.appcerofilas.Entities.RowViewHolderTurno;
import co.zonaapp.appcerofilas.Entities.Turno;
import co.zonaapp.appcerofilas.R;

import static co.zonaapp.appcerofilas.Entities.Turno.getListTurnoStactic;

public class AdapterRecyclerViewTurnos extends RecyclerView.Adapter<RowViewHolderTurno> {

    Context context;

    public AdapterRecyclerViewTurnos(Context context) {
        super();
        this.context = context;
    }

    @Override
    public RowViewHolderTurno onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_turnos, parent, false);
        return new RowViewHolderTurno(v, context);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public void onBindViewHolder(RowViewHolderTurno holder, final int position) {

        Turno items = getListTurnoStactic().get(position);

        holder.txtResulTurno.setText(items.getTurid()+"");
        holder.txtViewUbicacion.setText(String.format("%1$s: %2$s","Ubicación", items.getUbinombre()));
        holder.txtCanTurnos.setText(String.format("Turnos en la fila: %1$s", items.getTurno()));

        if (items.getEstado() == 1) {
            holder.txtEstado.setText("En espera");
            holder.txtEstado.setTextColor(Color.parseColor("#01DF01"));
            holder.contentItemTurno.setBackgroundColor(Color.parseColor("#E0F8EC"));
        }else if (items.getEstado() == 2) {
            holder.txtEstado.setText("En proceso");
            holder.txtEstado.setTextColor(Color.parseColor("#2962FF"));
            holder.contentItemTurno.setBackgroundColor(Color.parseColor("#E0E6F8"));
        }else if (items.getEstado() == 3) {
            holder.txtEstado.setText("Finalizado");
            holder.txtEstado.setTextColor(Color.parseColor("#B71C1C"));
            holder.contentItemTurno.setBackgroundColor(Color.parseColor("#F6CECE"));
        }

        int promedio = items.getTurno() * items.getProtiempo();

        holder.txtTiempoPromedio.setText(String.format("Atención en: %1$sM", promedio));

        //holder.secundario.setText(items.getDireccion());
        /*holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setEntidadSelect(items);
                context.startActivity(new Intent(context, ActSecedes.class));
            }
        });*/

    }

    @Override
    public int getItemCount() {
        if (getListTurnoStactic() == null) {
            return 0;
        } else {
            return getListTurnoStactic().size();
        }
    }
}

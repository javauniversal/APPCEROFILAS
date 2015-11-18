package co.zonaapp.appcerofilas.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import co.zonaapp.appcerofilas.Entities.RowViewHolderTurno;
import co.zonaapp.appcerofilas.Entities.Turno;
import co.zonaapp.appcerofilas.R;

public class AdapterRecyclerViewTurnos extends RecyclerView.Adapter<RowViewHolderTurno> {

    Context context;
    List<Turno> itemsList;

    public AdapterRecyclerViewTurnos(Context context, List<Turno> itemsList) {
        this.context = context;
        this.itemsList = itemsList;
    }

    @Override
    public RowViewHolderTurno onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_turnos, parent, false);
        return new RowViewHolderTurno(v, context);
    }

    @Override
    public void onBindViewHolder(RowViewHolderTurno holder, final int position) {
        final Turno items = itemsList.get(position);

        holder.txtResulTurno.setText(items.getTurid()+"");
        holder.txtViewUbicacion.setText(String.format("%1$s: %2$s","Ubicación", items.getUbinombre()));

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
        if (itemsList == null) {
            return 0;
        } else {
            return itemsList.size();
        }
    }
}

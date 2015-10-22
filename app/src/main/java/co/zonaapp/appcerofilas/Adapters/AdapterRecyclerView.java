package co.zonaapp.appcerofilas.Adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;
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
    public void onBindViewHolder(RowViewHolder holder, int position) {
        final Entidades items = itemsList.get(position);
        holder.nombre.setText(items.getNombre());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, items.getNombre(), Toast.LENGTH_LONG).show();
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Seleccione una ubicación")
                        .setItems(R.array.tabs, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // The 'which' argument contains the index position
                                // of the selected item
                            }
                        });
                builder.create();

                builder.show();

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

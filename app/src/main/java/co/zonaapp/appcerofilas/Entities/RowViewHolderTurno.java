package co.zonaapp.appcerofilas.Entities;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import co.zonaapp.appcerofilas.R;

public class RowViewHolderTurno extends RecyclerView.ViewHolder {

    public ImageView imageView;
    public TextView txtResulTurno;
    public TextView txtViewTurno;
    public TextView txtViewUbicacion;
    public TextView txtCanTurnos;
    public TextView txtEstado;
    public TextView txtTiempoPromedio;
    public LinearLayout contentItemTurno;

    public RowViewHolderTurno(View itemView, Context context) {
        super(itemView);
        Typeface type = Typeface.createFromAsset(context.getAssets(), "fonts/Nunito-Bold.ttf");

        this.txtResulTurno = (TextView) itemView.findViewById(R.id.txtResulTurno);
        txtResulTurno.setTypeface(type);

        this.txtViewTurno = (TextView) itemView.findViewById(R.id.txtTurno);
        txtViewTurno.setTypeface(type);

        this.txtViewUbicacion = (TextView) itemView.findViewById(R.id.txtUbicacion);
        txtViewUbicacion.setTypeface(type);

        this.txtCanTurnos = (TextView) itemView.findViewById(R.id.txtCanTurnos);
        txtCanTurnos.setTypeface(type);

        this.txtEstado = (TextView) itemView.findViewById(R.id.txtEstado);
        txtEstado.setTypeface(type);

        this.txtTiempoPromedio = (TextView) itemView.findViewById(R.id.txtTiempoEs);
        txtTiempoPromedio.setTypeface(type);

        this.contentItemTurno = (LinearLayout) itemView.findViewById(R.id.contentItemTurno);

        /*this.imageView = (ImageView) itemView.findViewById(R.id.person_photo);*/

    }
}

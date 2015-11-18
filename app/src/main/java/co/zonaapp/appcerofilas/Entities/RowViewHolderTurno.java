package co.zonaapp.appcerofilas.Entities;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import co.zonaapp.appcerofilas.R;

public class RowViewHolderTurno extends RecyclerView.ViewHolder {

    public ImageView imageView;
    public TextView txtResulTurno;
    public TextView txtViewTurno;
    public TextView txtViewUbicacion;
    public TextView secundario;

    public RowViewHolderTurno(View itemView, Context context) {
        super(itemView);
        Typeface type = Typeface.createFromAsset(context.getAssets(), "fonts/Nunito-Bold.ttf");

        this.txtResulTurno = (TextView) itemView.findViewById(R.id.txtResulTurno);
        txtResulTurno.setTypeface(type);

        this.txtViewTurno = (TextView) itemView.findViewById(R.id.txtTurno);
        txtViewTurno.setTypeface(type);

        this.txtViewUbicacion = (TextView) itemView.findViewById(R.id.txtUbicacion);
        txtViewUbicacion.setTypeface(type);

        /*this.imageView = (ImageView) itemView.findViewById(R.id.person_photo);*/

    }
}

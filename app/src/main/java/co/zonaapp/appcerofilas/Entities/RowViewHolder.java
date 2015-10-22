package co.zonaapp.appcerofilas.Entities;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import co.zonaapp.appcerofilas.R;

public class RowViewHolder extends RecyclerView.ViewHolder {

    public ImageView imageView;
    public TextView nombre;
    public TextView secundario;

    public RowViewHolder(View itemView, Context context) {
        super(itemView);
        Typeface type = Typeface.createFromAsset(context.getAssets(), "fonts/Nunito-Bold.ttf");

        this.nombre = (TextView) itemView.findViewById(R.id.person_name);
        nombre.setTypeface(type);
        this.secundario = (TextView) itemView.findViewById(R.id.person_age);
        secundario.setTypeface(type);

        this.imageView = (ImageView) itemView.findViewById(R.id.person_photo);
    }
}

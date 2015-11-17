package co.zonaapp.appcerofilas.Adapters;

import android.app.Activity;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import co.zonaapp.appcerofilas.Entities.Areas;
import co.zonaapp.appcerofilas.Entities.Sedes;
import co.zonaapp.appcerofilas.R;

public class AdapterArea extends BaseAdapter {

    private Activity actx;
    private List<Areas> data;

    public AdapterArea(Activity actx, List<Areas> data){
        this.actx = actx;
        this.data = data;
    }

    @Override
    public int getCount() {
        if(data == null || data.size() < 0) return 0;

        return data.size();
    }

    @Override
    public Areas getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = View.inflate(actx, R.layout.items_ubicacion, null);
            new ViewHolder(convertView);
        }

        ViewHolder holder = (ViewHolder) convertView.getTag();
        Areas item = getItem(position);

        holder.txtEmpresa.setText(item.getNombre());

        return convertView;
    }

    class ViewHolder {

        TextView txtEmpresa;

        public ViewHolder(View view) {
            Typeface type = Typeface.createFromAsset(actx.getAssets(), "fonts/Nunito-Bold.ttf");
            txtEmpresa = (TextView) view.findViewById(R.id.txtUbicacion);
            txtEmpresa.setTypeface(type);
            view.setTag(this);
        }
    }
}

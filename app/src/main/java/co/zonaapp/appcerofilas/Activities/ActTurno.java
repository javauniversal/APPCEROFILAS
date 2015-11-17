package co.zonaapp.appcerofilas.Activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import co.zonaapp.appcerofilas.Entities.Entidades;
import co.zonaapp.appcerofilas.R;

public class ActTurno extends AppCompatActivity {

    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_turno);

        Intent intent = getIntent();
        bundle = intent.getExtras();

        initialText();
    }

    private void initialText() {
        Typeface type = Typeface.createFromAsset(getAssets(), "fonts/Nunito-Bold.ttf");

        //TextEtiqueta Horas
        TextView horaAtencion = (TextView) findViewById(R.id.txtHoraAtencion);
        horaAtencion.setTypeface(type);

        //TextEtiqueta Promedio
        TextView promedi = (TextView) findViewById(R.id.txtPromedio);
        promedi.setTypeface(type);

        //TextEtiqueta Turno
        TextView turno = (TextView) findViewById(R.id.txtTurno);
        turno.setTypeface(type);

        //TextEtiqueta Entidad
        TextView entidad = (TextView) findViewById(R.id.txtEntidad);
        entidad.setTypeface(type);

        //TextEtiqueta sede
        TextView sede = (TextView) findViewById(R.id.txtSede);
        sede.setTypeface(type);

        //TextEtiqueta Ubicacion
        TextView ubicacion = (TextView) findViewById(R.id.txtUbicacion);
        ubicacion.setTypeface(type);

        //SET TXT
        TextView txtNombre = (TextView) findViewById(R.id.txtNombreEntidad);
        //txtNombre.setText(Entidades.getStaticEntidades().get(bundle.getInt("posicionEntida")).getNombre());

        TextView txtNombreSede = (TextView) findViewById(R.id.txtNombreSede);
        //txtNombreSede.setText(Entidades.getStaticEntidades().get(bundle.getInt("posicionEntida")).getListSedes().get(bundle.getInt("posicionSede")).getSednombre());

        TextView txtNombreUbicacion = (TextView) findViewById(R.id.txtNombreUbicacion);
        //txtNombreUbicacion.setText(Entidades.getStaticEntidades().get(bundle.getInt("posicionEntida")).getListSedes().get(bundle.getInt("posicionSede")).getListUbicaciones().get(bundle.getInt("posicionUbicacion")).getUbinombre());

        TextView txtHoraInicial = (TextView) findViewById(R.id.horaInicial);
        //txtHoraInicial.setText(Entidades.getStaticEntidades().get(bundle.getInt("posicionEntida")).getListSedes().get(bundle.getInt("posicionSede")).getListUbicaciones().get(bundle.getInt("posicionUbicacion")).getHorhorai());

        TextView txtHoraFinal = (TextView) findViewById(R.id.horaFina);
        //txtHoraFinal.setText(Entidades.getStaticEntidades().get(bundle.getInt("posicionEntida")).getListSedes().get(bundle.getInt("posicionSede")).getListUbicaciones().get(bundle.getInt("posicionUbicacion")).getHorhoraf());

        //int promedioInt = Entidades.getStaticEntidades().get(bundle.getInt("posicionEntida")).getListSedes().get(bundle.getInt("posicionSede")).getListUbicaciones().get(bundle.getInt("posicionUbicacion")).getProtiempo();
        //String promedioFormato = Entidades.getStaticEntidades().get(bundle.getInt("posicionEntida")).getListSedes().get(bundle.getInt("posicionSede")).getListUbicaciones().get(bundle.getInt("posicionUbicacion")).getProformato();

        TextView txtPromedio = (TextView) findViewById(R.id.txtPromedioAtencion);
        //txtPromedio.setText(String.format("%1$s %2$s", promedioInt, promedioFormato));

        TextView txtEspera = (TextView) findViewById(R.id.txtTurnosEspera);
        //txtEspera.setText(String.format("%1$s %2$s", Entidades.getStaticEntidades().get(bundle.getInt("posicionEntida")).getListSedes().get(bundle.getInt("posicionSede")).getListUbicaciones().get(bundle.getInt("posicionUbicacion")).getTurno(), "Personas"));

    }

}

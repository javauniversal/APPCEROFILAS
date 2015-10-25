package co.zonaapp.appcerofilas;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import co.zonaapp.appcerofilas.Entities.Entidades;

public class ActMaps extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_turno);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabTurno);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ActMaps.this,"Hola Turno", Toast.LENGTH_LONG).show();
            }
        });

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
        txtNombre.setText(Entidades.getStaticEntidades().get(bundle.getInt("posicionEntida")).getNombre());

        TextView txtNombreSede = (TextView) findViewById(R.id.txtNombreSede);
        txtNombreSede.setText(Entidades.getStaticEntidades().get(bundle.getInt("posicionEntida")).getListSedes().get(bundle.getInt("posicionSede")).getSednombre());

        TextView txtNombreUbicacion = (TextView) findViewById(R.id.txtNombreUbicacion);
        txtNombreUbicacion.setText(Entidades.getStaticEntidades().get(bundle.getInt("posicionEntida")).getListSedes().get(bundle.getInt("posicionSede")).getListUbicaciones().get(bundle.getInt("posicionUbicacion")).getUbinombre());

        TextView txtHoraInicial = (TextView) findViewById(R.id.horaInicial);
        txtHoraInicial.setText(Entidades.getStaticEntidades().get(bundle.getInt("posicionEntida")).getListSedes().get(bundle.getInt("posicionSede")).getListUbicaciones().get(bundle.getInt("posicionUbicacion")).getHorhorai());

        TextView txtHoraFinal = (TextView) findViewById(R.id.horaFina);
        txtHoraFinal.setText(Entidades.getStaticEntidades().get(bundle.getInt("posicionEntida")).getListSedes().get(bundle.getInt("posicionSede")).getListUbicaciones().get(bundle.getInt("posicionUbicacion")).getHorhoraf());

        int promedioInt = Entidades.getStaticEntidades().get(bundle.getInt("posicionEntida")).getListSedes().get(bundle.getInt("posicionSede")).getListUbicaciones().get(bundle.getInt("posicionUbicacion")).getProtiempo();
        String promedioFormato = Entidades.getStaticEntidades().get(bundle.getInt("posicionEntida")).getListSedes().get(bundle.getInt("posicionSede")).getListUbicaciones().get(bundle.getInt("posicionUbicacion")).getProformato();

        TextView txtPromedio = (TextView) findViewById(R.id.txtPromedioAtencion);
        txtPromedio.setText(String.format("%1$s %2$s", promedioInt, promedioFormato));

        TextView txtEspera = (TextView) findViewById(R.id.txtTurnosEspera);
        txtEspera.setText(String.format("%1$s %2$s", Entidades.getStaticEntidades().get(bundle.getInt("posicionEntida")).getListSedes().get(bundle.getInt("posicionSede")).getListUbicaciones().get(bundle.getInt("posicionUbicacion")).getTurno(), "Personas"));

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        mMap.setMyLocationEnabled(true);

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}

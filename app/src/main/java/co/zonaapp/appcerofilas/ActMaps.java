package co.zonaapp.appcerofilas;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.location.Location;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import co.zonaapp.appcerofilas.Activities.DetailsActivity;
import co.zonaapp.appcerofilas.Entities.Entidades;
import co.zonaapp.appcerofilas.Services.ServiceLocation;

public class ActMaps extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Bundle bundle;
    private ServiceLocation appLocationService;
    private Location nwLocation;

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
                setPedirTurno();
            }
        });

        initialText();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        mMap.setMyLocationEnabled(true);

        markerMaps();

        markerDistance();
    }

    //Inicializamos todo los componentes de la actividad
    private void initialText() {

        appLocationService = new ServiceLocation(this);

        Intent intent = getIntent();
        bundle = intent.getExtras();

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

        //TextEtiqueta Entidad
        TextView txtDistance = (TextView) findViewById(R.id.txtDistance);
        txtDistance.setTypeface(type);

        //SET TXT
        TextView txtNombre = (TextView) findViewById(R.id.txtNombreEntidad);
        txtNombre.setText(Entidades.getStaticEntidades().get(bundle.getInt("posicionEntida")).getNombre());

        TextView txtNombreSede = (TextView) findViewById(R.id.txtNombreSede);
        txtNombreSede.setText(Entidades.getStaticEntidades().get(bundle.getInt("posicionEntida")).getListSedes().get(bundle.getInt("posicionSede")).getSednombre());

        TextView txtNombreUbicacion = (TextView) findViewById(R.id.txtNombreUbicacion);
        txtNombreUbicacion.setText(Entidades.getStaticEntidades().get(bundle.getInt("posicionEntida")).getListSedes().get(bundle.getInt("posicionSede")).getListUbicaciones().get(bundle.getInt("posicionUbicacion")).getUbinombre());

        TextView txtHoraInicial = (TextView) findViewById(R.id.horaInicial);
        txtHoraInicial.setText(Entidades.getStaticEntidades().get(bundle.getInt("posicionEntida")).getListSedes().get(bundle.getInt("posicionSede")).getListUbicaciones().get(bundle.getInt("posicionUbicacion")).getHorhorai());

        TextView txtDistanceValor = (TextView) findViewById(R.id.txtDistanceValor);
        txtDistanceValor.setText(String.format("%1$s Km", distancia()));

        TextView txtHoraFinal = (TextView) findViewById(R.id.horaFina);
        txtHoraFinal.setText(Entidades.getStaticEntidades().get(bundle.getInt("posicionEntida")).getListSedes().get(bundle.getInt("posicionSede")).getListUbicaciones().get(bundle.getInt("posicionUbicacion")).getHorhoraf());

        int promedioInt = Entidades.getStaticEntidades().get(bundle.getInt("posicionEntida")).getListSedes().get(bundle.getInt("posicionSede")).getListUbicaciones().get(bundle.getInt("posicionUbicacion")).getProtiempo();
        String promedioFormato = Entidades.getStaticEntidades().get(bundle.getInt("posicionEntida")).getListSedes().get(bundle.getInt("posicionSede")).getListUbicaciones().get(bundle.getInt("posicionUbicacion")).getProformato();

        TextView txtPromedio = (TextView) findViewById(R.id.txtPromedioAtencion);
        txtPromedio.setText(String.format("%1$s %2$s", promedioInt, promedioFormato));

        TextView txtEspera = (TextView) findViewById(R.id.txtTurnosEspera);
        txtEspera.setText(String.format("%1$s %2$s", Entidades.getStaticEntidades().get(bundle.getInt("posicionEntida")).getListSedes().get(bundle.getInt("posicionSede")).getListUbicaciones().get(bundle.getInt("posicionUbicacion")).getTurno(), "Personas"));

    }

    //Calcula la distancia de un puto a otro
    private float distancia(){
        nwLocation = appLocationService.getLocation();

        Location locationD = new Location("point D");
        locationD.setLatitude(Entidades.getStaticEntidades().get(bundle.getInt("posicionEntida")).getLatitud());
        locationD.setLongitude(Entidades.getStaticEntidades().get(bundle.getInt("posicionEntida")).getLongitud());

        float distance = Math.round(nwLocation.distanceTo(locationD)/1000);

        return distance;
    }

    //Marcadores en el mapa
    private void markerMaps(){

        LatLng entidad = new LatLng(Entidades.getStaticEntidades().get(bundle.getInt("posicionEntida")).getLatitud(), Entidades.getStaticEntidades().get(bundle.getInt("posicionEntida")).getLongitud());

        mMap.addMarker(new MarkerOptions().position(entidad).title(Entidades.getStaticEntidades().get(bundle.getInt("posicionEntida")).getNombre()));

        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(entidad)      // Sets the center of the map to LatLng (refer to previous snippet)
                .zoom(12)             // Sets the zoom
                // .bearing(50)       // Sets the orientation of the camera to east
                .tilt(45)             // Sets the tilt of the camera to 30 degrees
                .build();             // Creates a CameraPosition from the builder
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

    }

    //Marcador de la distancia de un punto a otro
    private void markerDistance(){
        mMap.addPolyline(new PolylineOptions()
                .add(new LatLng(Entidades.getStaticEntidades().get(bundle.getInt("posicionEntida")).getLatitud(), Entidades.getStaticEntidades().get(bundle.getInt("posicionEntida")).getLongitud()),
                        new LatLng(nwLocation.getLatitude(), nwLocation.getLongitude()))
                .width(5)
                .color(Color.RED));
    }

    private void setPedirTurno(){
        String url = String.format("%1$s%2$s", getString(R.string.url_base), "setPedirTurno");
        RequestQueue rq = Volley.newRequestQueue(this);
        StringRequest jsonRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response) {
                        // response
                        //parseJSON(response);
                    }
                },
                new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // error
                        Toast.makeText(ActMaps.this, "No tiene conexión a internet ", Toast.LENGTH_LONG).show();
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> params = new HashMap<>();

                TelephonyManager telephonyManager = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
                telephonyManager.getDeviceId();

                params.put("idEntidad", String.valueOf(Entidades.getStaticEntidades().get(bundle.getInt("posicionEntida")).getIdEntidad()));
                params.put("idSede", String.valueOf(Entidades.getStaticEntidades().get(bundle.getInt("posicionEntida")).getListSedes().get(bundle.getInt("posicionSede")).getSedid()));
                params.put("idUbicacion", String.valueOf(Entidades.getStaticEntidades().get(bundle.getInt("posicionEntida")).getListSedes().get(bundle.getInt("posicionSede")).getListUbicaciones().get(bundle.getInt("posicionUbicacion")).getUbiid()));
                params.put("distancia", "");
                params.put("latitud", "");
                params.put("longitud", "");
                params.put("deviceIde", telephonyManager.getDeviceId());

                return params;
            }
        };
        rq.add(jsonRequest);
    }

}

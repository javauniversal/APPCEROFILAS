package co.zonaapp.appcerofilas.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import co.zonaapp.appcerofilas.Adapters.AdapterUbicacion;
import co.zonaapp.appcerofilas.Entities.Entidades;
import co.zonaapp.appcerofilas.R;

public class ActUbicacion extends AppCompatActivity {

    private Bundle bundle;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_ubicacion);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listView = (ListView) findViewById(R.id.listView);

        Intent intent = getIntent();
        bundle = intent.getExtras();

        int posicion = bundle.getInt("posicion");

        AdapterUbicacion adapter = new AdapterUbicacion(this, Entidades.getStaticEntidades().get(posicion).getListUbicaciones());
        listView.setAdapter(adapter);




    }

    public void loadUbicacion(){

    }

}

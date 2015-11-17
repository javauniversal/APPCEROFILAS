package co.zonaapp.appcerofilas.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import co.zonaapp.appcerofilas.ActMaps;
import co.zonaapp.appcerofilas.Adapters.AdapterUbicacion;
import co.zonaapp.appcerofilas.R;

import static co.zonaapp.appcerofilas.Entities.Areas.getListUbicacionStatic;
import static co.zonaapp.appcerofilas.Entities.Ubicaciones.setUbicaciones;

public class ActUbicacion extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_ubicacion);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listView = (ListView) findViewById(R.id.listViewUbicacion);

        if(getListUbicacionStatic() == null || getListUbicacionStatic().size() < 0){
            Intent intentActivity = new Intent(getApplicationContext(), DetailsActivity.class);
            intentActivity.putExtra("STATE", "EMPTY");
            startActivity(intentActivity);
        }else {
            AdapterUbicacion adapter = new AdapterUbicacion(this, getListUbicacionStatic());
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int posicionUbicacion, long id) {

                    setUbicaciones(getListUbicacionStatic().get(posicionUbicacion));

                    startActivity(new Intent(ActUbicacion.this, ActMaps.class));
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                }
            });
        }
    }

}

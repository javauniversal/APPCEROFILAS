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
import co.zonaapp.appcerofilas.Entities.Entidades;
import co.zonaapp.appcerofilas.R;

public class ActUbicacion extends AppCompatActivity {

    private Bundle bundle;
    private ListView listView;
    private int posicionEntidad;
    private int posicionSede;

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

        Intent intent = getIntent();
        bundle = intent.getExtras();

        posicionEntidad = bundle.getInt("posicionEntida");
        posicionSede = bundle.getInt("posicionSede");

        if(Entidades.getStaticEntidades().get(posicionEntidad).getListSedes().get(posicionSede).getListUbicaciones() == null || Entidades.getStaticEntidades().get(posicionEntidad).getListSedes().get(posicionSede).getListUbicaciones().size() < 0){
            Intent intentActivity = new Intent(getApplicationContext(), DetailsActivity.class);
            intentActivity.putExtra("STATE", "EMPTY");
            startActivity(intentActivity);
        }else {
            AdapterUbicacion adapter = new AdapterUbicacion(this, Entidades.getStaticEntidades().get(posicionEntidad).getListSedes().get(posicionSede).getListUbicaciones());
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int posicionUbicacion, long id) {

                    Bundle bundle = new Bundle();
                    bundle.putInt("posicionEntida", posicionEntidad);
                    bundle.putInt("posicionSede", posicionSede);
                    bundle.putInt("posicionUbicacion", posicionUbicacion);

                    startActivity(new Intent(ActUbicacion.this, ActMaps.class).putExtras(bundle));
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                }
            });
        }
    }

}

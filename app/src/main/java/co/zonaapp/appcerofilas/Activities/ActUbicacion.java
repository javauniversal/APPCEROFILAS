package co.zonaapp.appcerofilas.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
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

        int posicionEntidad = bundle.getInt("posicionEntida");
        int posicionSede = bundle.getInt("posicionSede");

        AdapterUbicacion adapter = new AdapterUbicacion(this, Entidades.getStaticEntidades().get(posicionEntidad).getListSedes().get(posicionSede).getListUbicaciones());
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(ActUbicacion.this, ActTurno.class).putExtras(bundle));
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });


    }

}

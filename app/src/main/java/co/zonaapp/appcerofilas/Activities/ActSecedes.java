package co.zonaapp.appcerofilas.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import co.zonaapp.appcerofilas.Adapters.AdapterSedes;
import co.zonaapp.appcerofilas.Entities.Entidades;
import co.zonaapp.appcerofilas.R;

public class ActSecedes extends AppCompatActivity {

    private Bundle bundle;
    private ListView listView;
    private int posicionEntidad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_act_secedes);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listView = (ListView) findViewById(R.id.listViewSede);

        Intent intent = getIntent();
        bundle = intent.getExtras();

        posicionEntidad = bundle.getInt("posicion");

        if(Entidades.getStaticEntidades().get(posicionEntidad).getListSedes() == null || Entidades.getStaticEntidades().get(posicionEntidad).getListSedes().size() < 0){
            Intent intentActivity = new Intent(getApplicationContext(), DetailsActivity.class);
            intentActivity.putExtra("STATE", "EMPTY");
            startActivity(intentActivity);
        }else {
            AdapterSedes adapter = new AdapterSedes(this, Entidades.getStaticEntidades().get(posicionEntidad).getListSedes());
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int positionSede, long id) {

                    Bundle bundle = new Bundle();
                    bundle.putInt("posicionEntida", posicionEntidad);
                    bundle.putInt("posicionSede", positionSede);

                    startActivity(new Intent(ActSecedes.this, ActUbicacion.class).putExtras(bundle));
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                }
            });
        }
    }

}

package co.zonaapp.appcerofilas.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import co.zonaapp.appcerofilas.Adapters.AdapterSedes;
import co.zonaapp.appcerofilas.Entities.Areas;
import co.zonaapp.appcerofilas.Entities.Entidades;
import co.zonaapp.appcerofilas.R;

import static co.zonaapp.appcerofilas.Entities.Sedes.setListAreasStatic;

public class ActSecedes extends AppCompatActivity {

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

        ListView listView = (ListView) findViewById(R.id.listViewSede);

        if(Entidades.getEntidadSelect().getListSedes() == null || Entidades.getEntidadSelect().getListSedes().size() < 0){
            Intent intentActivity = new Intent(getApplicationContext(), DetailsActivity.class);
            intentActivity.putExtra("STATE", "EMPTY");
            startActivity(intentActivity);
        }else {
            AdapterSedes adapter = new AdapterSedes(this, Entidades.getEntidadSelect().getListSedes());
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int positionSede, long id) {

                    setListAreasStatic(Entidades.getEntidadSelect().getListSedes().get(positionSede).getLisAreas());

                    startActivity(new Intent(ActSecedes.this, ActArea.class));
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                }
            });
        }
    }

}

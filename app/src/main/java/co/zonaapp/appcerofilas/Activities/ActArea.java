package co.zonaapp.appcerofilas.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import co.zonaapp.appcerofilas.Adapters.AdapterArea;
import co.zonaapp.appcerofilas.R;

import static co.zonaapp.appcerofilas.Entities.Areas.setListUbicacionStatic;
import static co.zonaapp.appcerofilas.Entities.Sedes.getListAreasStatic;

public class ActArea extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_area);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ListView listView = (ListView) findViewById(R.id.listViewAreas);

        if(getListAreasStatic() == null || getListAreasStatic().size() < 0){
            Intent intentActivity = new Intent(getApplicationContext(), DetailsActivity.class);
            intentActivity.putExtra("STATE", "EMPTY");
            startActivity(intentActivity);
        }else {
            AdapterArea adapter = new AdapterArea(this, getListAreasStatic());
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    setListUbicacionStatic(getListAreasStatic().get(position).getListUbicaciones());

                    startActivity(new Intent(ActArea.this, ActUbicacion.class));
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                }
            });
        }
    }

}

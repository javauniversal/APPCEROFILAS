package co.zonaapp.appcerofilas.Activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import co.zonaapp.appcerofilas.Adapters.AdapterRecyclerView;
import co.zonaapp.appcerofilas.Entities.Entidades;
import co.zonaapp.appcerofilas.R;

public class ActEntidades extends AppCompatActivity {

    private RecyclerView recycler;
    private RecyclerView.LayoutManager lManager;
    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_entidades);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Inicializar Animes
        List<Entidades> items = new ArrayList<>();
        items.add(new Entidades(1,"ABCDEE","ABCD",12.00,13.00));
        items.add(new Entidades(2,"ABCHGH","ABCD",12.00,13.00));
        items.add(new Entidades(3,"ABCHGH","ABCD",12.00,13.00));
        items.add(new Entidades(4,"ABHFGo","ABCD",12.00,13.00));
        items.add(new Entidades(5,"ABGDGG","ABCD",12.00,13.00));
        items.add(new Entidades(6,"ARTRET","ABCD",12.00,13.00));
        items.add(new Entidades(7,"A4334D","ABCD",12.00,13.00));
        items.add(new Entidades(8,"ABDFDF","ABCD",12.00,13.00));
        items.add(new Entidades(9,"ABDFFF","ABCD",12.00,13.00));
        items.add(new Entidades(10,"ABCFF","ABCD",12.00,13.00));

        // Obtener el Recycler
        recycler = (RecyclerView) findViewById(R.id.recyclerView);
        recycler.setHasFixedSize(true);

        // Usar un administrador para LinearLayout
        lManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(lManager);

        // Crear un nuevo adaptador
        adapter = new AdapterRecyclerView(this, items);
        recycler.setAdapter(adapter);

    }

}

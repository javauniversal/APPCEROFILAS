package co.zonaapp.appcerofilas.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;

import co.zonaapp.appcerofilas.Adapters.AdapterRecyclerView;
import co.zonaapp.appcerofilas.Entities.Entidades;
import co.zonaapp.appcerofilas.Entities.ListEntidades;
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

        // Obtener el Recycler
        recycler = (RecyclerView) findViewById(R.id.recyclerView);
        recycler.setHasFixedSize(true);

        // Usar un administrador para LinearLayout
        lManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(lManager);

        LoadEntity();
    }

    public void LoadEntity(){
        String url = String.format("%1$s%2$s", getString(R.string.url_base),"listEntidades");
        RequestQueue rq = Volley.newRequestQueue(this);
        StringRequest jsonRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response) {
                        // response
                        parseJSON(response);
                    }
                },
                new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // error
                        Toast.makeText(ActEntidades.this, "No tiene conexión a internet ", Toast.LENGTH_LONG).show();
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();

                return params;
            }
        };
        rq.add(jsonRequest);
    }

    private boolean parseJSON(String json) {
        boolean indicant = false;
        Gson gson = new Gson();
        if (!json.equals("[]")){
            try {
                ListEntidades listEntidades = gson.fromJson(json, ListEntidades.class);
                Entidades.setStaticEntidades(listEntidades);
                adapter = new AdapterRecyclerView(this, listEntidades);
                recycler.setAdapter(adapter);
                indicant = true;
            }catch (IllegalStateException ex) {
                ex.printStackTrace();
                indicant = false;
            }
        }

        return indicant;
    }

}

package co.zonaapp.appcerofilas.Activities;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.telephony.TelephonyManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayout;
import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayoutDirection;

import java.util.HashMap;
import java.util.Map;

import co.zonaapp.appcerofilas.Adapters.AdapterRecyclerViewTurnos;
import co.zonaapp.appcerofilas.Entities.ListTurnos;
import co.zonaapp.appcerofilas.R;

public class ActMain extends AppCompatActivity implements SwipyRefreshLayout.OnRefreshListener {

    private SwipyRefreshLayout mSwipyRefreshLayout;
    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Obtener el Recycler
        recycler = (RecyclerView) findViewById(R.id.recyclerViewTurnos);
        recycler.setHasFixedSize(true);

        // Usar un administrador para LinearLayout
        RecyclerView.LayoutManager lManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(lManager);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogMenu();
            }
        });

        mSwipyRefreshLayout = (SwipyRefreshLayout) findViewById(R.id.swipyrefreshlayout);
        mSwipyRefreshLayout.setOnRefreshListener(this);

        LoadTurno();

    }

    public void LoadTurno(){
        String url = String.format("%1$s%2$s", getString(R.string.url_base),"getListTurnos");
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
                        mSwipyRefreshLayout.setRefreshing(false);
                        Intent intent = new Intent(getApplicationContext(), DetailsActivity.class);
                        intent.putExtra("STATE", "ERROR");
                        startActivity(intent);
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();

                TelephonyManager telephonyManager = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
                params.put("deviceIde", telephonyManager.getDeviceId());

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

                ListTurnos listTurnos = gson.fromJson(json, ListTurnos.class);

                adapter = new AdapterRecyclerViewTurnos(this,listTurnos);
                recycler.setAdapter(adapter);

            }catch (IllegalStateException ex) {
                ex.printStackTrace();
                indicant = false;
            }
        }else {
            Intent intent = new Intent(getApplicationContext(), DetailsActivity.class);
            intent.putExtra("STATE", "EMPTY");
            startActivity(intent);
        }


        return indicant;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void dialogMenu(){
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/Nunito-Bold.ttf");
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        // ...Irrelevant code for customizing the buttons and title
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.layout_dialog, null);
        dialogBuilder.setView(dialogView);
        final AlertDialog alertDialog = dialogBuilder.create();
        Button btnScan = (Button) dialogView.findViewById(R.id.btnScan);
        btnScan.setTypeface(font);
        btnScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
                startActivity(new Intent(ActMain.this, SimpleScannerActivity.class));
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });

        Button btnPedirTurno = (Button) dialogView.findViewById(R.id.btnPedir);
        btnPedirTurno.setTypeface(font);
        btnPedirTurno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
                startActivity(new Intent(ActMain.this, ActEntidades.class));
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });

        alertDialog.show();

    }

    @Override
    public void onRefresh(SwipyRefreshLayoutDirection direction) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //Hide the refresh after 2sec
                ActMain.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mSwipyRefreshLayout.setRefreshing(false);
                    }
                });
            }
        }, 2000 );
    }
}

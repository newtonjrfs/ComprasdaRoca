package newton.com.comprasdaroca.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import newton.com.comprasdaroca.R;
import newton.com.comprasdaroca.activity.adicionarTarefaActivity;
import newton.com.comprasdaroca.adapter.CompraAdapter;
import newton.com.comprasdaroca.model.Compra;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CompraAdapter compraAdapter;
    private List<Compra> listaCompras = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.recyclerViewId);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),adicionarTarefaActivity.class);
                startActivity(intent);
            }
        });
    }

    public void carregarListaDeTarefas(){

        Compra compra1 = new Compra();
        compra1.setNomeProduto("Oleo");
        listaCompras.add(compra1);

        Compra compra2 = new Compra();
        compra2.setNomeProduto("Gasolina");
        listaCompras.add(compra2);

        Compra compra3 = new Compra();
        compra3.setNomeProduto("Racao pro gado");
        listaCompras.add(compra3);

        Compra compra4 = new Compra();
        compra4.setNomeProduto("Sal puro");
        listaCompras.add(compra4);

        Compra compra5 = new Compra();
        compra5.setNomeProduto("Mineral das bezerras");
        listaCompras.add(compra5);




        compraAdapter = new CompraAdapter(listaCompras);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayout.VERTICAL));
        recyclerView.setAdapter(compraAdapter);


    }

    @Override
    protected void onStart() {
        carregarListaDeTarefas();
        super.onStart();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

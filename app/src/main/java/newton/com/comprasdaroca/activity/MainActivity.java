package newton.com.comprasdaroca.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import newton.com.comprasdaroca.R;
import newton.com.comprasdaroca.adapter.CompraAdapter;
import newton.com.comprasdaroca.helper.ComprasDAO;
import newton.com.comprasdaroca.helper.RecyclerItemClickListener;
import newton.com.comprasdaroca.model.Compra;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CompraAdapter compraAdapter;
    private List<Compra> listaCompras = new ArrayList<>();
    private Compra compraSelecionada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.recyclerViewId);

        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(), recyclerView,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                //evento de clique rapido

                                Compra compraSelecionada = listaCompras.get(position);

                                Intent intent = new Intent(MainActivity.this,adicionarCompraActivity.class);

                                intent.putExtra("compraSelecionada", compraSelecionada);

                                startActivity(intent);

                            }

                            @Override
                            public void onLongItemClick(View view, int position) {
                                //evento de clique longo

                                compraSelecionada = listaCompras.get(position);

                                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                                dialog.setTitle("Confirmar Exclusão ");
                                dialog.setMessage("Deseja excluir o produto " + compraSelecionada.getNomeProduto() + " ? ");

                                dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                        ComprasDAO comprasDAO = new ComprasDAO(getApplicationContext());
                                        if (comprasDAO.deletar(compraSelecionada)){
                                            carregarListaDeCompras();
                                            Toast.makeText(getApplicationContext(),"Produto excluido com sucesso",Toast.LENGTH_LONG).show();
                                        }else{
                                            Toast.makeText(getApplicationContext(),"Erro ao excluir produto",Toast.LENGTH_LONG).show();
                                        }

                                        }
                                });

                            dialog.setNegativeButton("Não",null);

                            dialog.create();
                            dialog.show();

                            }

                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            }
                        }
                )
        );

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),adicionarCompraActivity.class);
                startActivity(intent);
            }
        });
    }

    public void carregarListaDeCompras(){

        ComprasDAO comprasDAO = new ComprasDAO(getApplicationContext());
        listaCompras = comprasDAO.listar();

        compraAdapter = new CompraAdapter(listaCompras);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayout.VERTICAL));
        recyclerView.setAdapter(compraAdapter);


    }

    @Override
    protected void onStart() {
        carregarListaDeCompras();
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

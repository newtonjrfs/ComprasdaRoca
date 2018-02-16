package newton.com.comprasdaroca.activity;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import newton.com.comprasdaroca.R;
import newton.com.comprasdaroca.helper.ComprasDAO;
import newton.com.comprasdaroca.model.Compra;

public class adicionarCompraActivity extends AppCompatActivity {

    private TextInputEditText editCompra;
    private Compra compraAtual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_produto);

        editCompra = findViewById(R.id.textCompra);

        compraAtual = (Compra) getIntent().getSerializableExtra("compraSelecionada");

        if (compraAtual!= null){
            editCompra.setText(compraAtual.getNomeProduto());
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_adicionar_produto,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.itemSalvar:

                ComprasDAO comprasDAO = new ComprasDAO(getApplicationContext());
                String nomeProduto = editCompra.getText().toString();

                if (compraAtual!= null){
                    if (!nomeProduto.isEmpty()){
                        Compra compra = new Compra();
                        compra.setNomeProduto(nomeProduto);
                        compra.setId(compraAtual.getId());

                        if (comprasDAO.atualizar(compra)){
                            finish();
                            Toast.makeText(getApplicationContext(),"Produto atualizado na lista de compras", Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(getApplicationContext(),"Erro na atualização do produto", Toast.LENGTH_LONG).show();
                        }

                    }


                }else{

                    if (!nomeProduto.isEmpty()){
                        Compra compra = new Compra();
                        compra.setNomeProduto(nomeProduto);
                        if (comprasDAO.salvar(compra)){
                            finish();
                            Toast.makeText(getApplicationContext(),"Produto salvo na lista de compras", Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(getApplicationContext(),"Ocorreu um erro ao salvar o produto", Toast.LENGTH_LONG).show();
                        }

                    }
                }


                break;
        }

        return super.onOptionsItemSelected(item);
    }
}

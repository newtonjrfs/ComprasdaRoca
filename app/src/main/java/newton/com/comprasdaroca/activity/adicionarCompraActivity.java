package newton.com.comprasdaroca.activity;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import newton.com.comprasdaroca.R;
import newton.com.comprasdaroca.helper.ComprasDAO;
import newton.com.comprasdaroca.model.Compra;

public class adicionarCompraActivity extends AppCompatActivity {

    private TextInputEditText editCompra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_produto);

        editCompra = findViewById(R.id.textCompra);
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

                String nomeProduto = editCompra.getText().toString();
                if (!nomeProduto.isEmpty()){
                    ComprasDAO comprasDAO = new ComprasDAO(getApplicationContext());
                    Compra compra = new Compra();
                    compra.setNomeProduto(nomeProduto);
                    comprasDAO.salvar(compra);
                    finish();
                }


                break;
        }

        return super.onOptionsItemSelected(item);
    }
}

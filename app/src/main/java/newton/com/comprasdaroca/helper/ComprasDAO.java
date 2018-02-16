package newton.com.comprasdaroca.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import newton.com.comprasdaroca.model.Compra;

/**
 * Created by Newton on 15/02/2018.
 */

public class ComprasDAO implements IComprasDAO{

    private SQLiteDatabase escreve;
    private SQLiteDatabase le;

    public ComprasDAO(Context context) {
        DbHelper db = new DbHelper(context);
        escreve = db.getWritableDatabase();
        le = db.getReadableDatabase();
    }

    @Override
    public boolean salvar(Compra compra) {

        ContentValues cv = new ContentValues();
        cv.put("nome",compra.getNomeProduto());

        try {
            escreve.insert(DbHelper.TABELA_COMPRAS,null,cv);
        }catch (Exception e){
            return false;
        }

        return true;
    }

    @Override
    public boolean atualizar(Compra compra) {
        return false;
    }

    @Override
    public boolean deletar(Compra compra) {
        return false;
    }

    @Override
    public List<Compra> listar() {

        List<Compra> compras = new ArrayList<>();

        String sql = "SELECT * FROM " + DbHelper.TABELA_COMPRAS + ";";
        Cursor c = le.rawQuery(sql,null);
        while (c.moveToNext()){

            Compra compra = new Compra();

            Long id = c.getLong(c.getColumnIndex("id"));
            String nomeProduto = c.getString(c.getColumnIndex("nome"));

            compra.setId(id);
            compra.setNomeProduto(nomeProduto);

            compras.add(compra);

        }

        return compras;
    }
}

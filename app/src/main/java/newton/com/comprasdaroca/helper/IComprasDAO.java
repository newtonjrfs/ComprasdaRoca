package newton.com.comprasdaroca.helper;

import java.util.List;

import newton.com.comprasdaroca.model.Compra;

/**
 * Created by Newton on 15/02/2018.
 */

public interface IComprasDAO {



    public boolean salvar(Compra compra);
    public boolean atualizar(Compra compra);
    public boolean deletar(Compra compra);
    public List<Compra> listar();

}

package newton.com.comprasdaroca.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import newton.com.comprasdaroca.R;
import newton.com.comprasdaroca.model.Compra;

/**
 * Created by Newton on 05/02/2018.
 */

public class CompraAdapter extends RecyclerView.Adapter<CompraAdapter.MyViewHolder> {

    private List<Compra> listaCompra;

    public CompraAdapter(List<Compra>compras) {
        this.listaCompra= compras;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.lista_compra_adapter,parent,false);

        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Compra compra = listaCompra.get(position);
        holder.tarefa.setText(compra.getNomeProduto());


    }

    @Override
    public int getItemCount() {
        return this.listaCompra.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tarefa;

        public MyViewHolder(View itemView){
            super(itemView);

            tarefa = itemView.findViewById(R.id.textTarefa);


        }
    }
}

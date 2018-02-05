package newton.com.comprasdaroca.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

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
        return null;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public MyViewHolder(View itemView){
            super(itemView);
        }
    }
}

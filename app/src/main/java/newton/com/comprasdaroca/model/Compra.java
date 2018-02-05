package newton.com.comprasdaroca.model;

import java.io.Serializable;

/**
 * Created by Newton on 05/02/2018.
 */

public class Compra implements Serializable {

   private Long id;
   private String nomeProduto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }
}

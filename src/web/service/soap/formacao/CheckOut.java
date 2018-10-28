package web.service.soap.formacao;

import java.util.List;
import java.util.UUID;
public class CheckOut {

    public List<Product> CheckOutBox;
    private UUID boxChain;
    private int qtd = 0;
    public CheckOut (){ this.boxChain = UUID.randomUUID(); }

    public UUID getBoxChain(){
        return this.boxChain;
    }
    public void addNewProduct(Product products){
        this.CheckOutBox.add(products);
    }
    public void removeOldProduct(Product products){
        this.CheckOutBox.remove(products);
    }
    public void setQtd (int qtd){
        this.qtd = qtd;
    }
    public int getQtd (){
        return this.qtd;
    }

}

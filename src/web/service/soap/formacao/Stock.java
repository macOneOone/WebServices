package web.service.soap.formacao;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Stock {
    private static ArrayList<Product> Stocks = new ArrayList<Product>();
    public void setNewProductInStock (Product product){
        this.Stocks.add(product);
    }
    public ArrayList<Product> getProductInStock (){
        return this.Stocks;
    }
    public boolean removeInProductInStock (Product product){
        return this.Stocks.remove(product);
    }
    public int getTotal(){
        return this.Stocks.size();
    }

    public ArrayList<Product> Products(){
        return this.Stocks;
    }
}

package web.service.soap.formacao;


import com.sun.tools.javadoc.Start;

import java.util.ArrayList;
import java.util.List;

public class StockController {
    private static Stock stock = StartEngine.getStock();
    private static int size;
    public void addProductInStock(Product product){
      stock.setNewProductInStock(product);
    }
    public boolean removeProductInStock(Product product){
        return stock.removeInProductInStock(product);
    }
    public int getTotalProductsInStock (){
        return this.stock.getTotal();
    }
    public List<Product> getAllProducts(){
        return this.stock.Products();
    }

    public static Product findProductInStock (String cod){
            ArrayList<Product> product = stock.Products();
            int size = product.size();

            for (int v=0; v < size ;v++){
                if(product.get(v).getCodProduct().toString().equals(cod)){
                    return product.get(v);
                }
            }
            return null;
    }
}

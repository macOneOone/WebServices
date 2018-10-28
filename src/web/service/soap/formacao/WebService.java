package web.service.soap.formacao;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.xml.ws.Endpoint;

import java.util.ArrayList;

@javax.jws.WebService()

public class WebService{

    public static Stock stock;

    @WebMethod
    public String addProductInStock (@WebParam(name = "nome") String name,@WebParam(name = "price") float price, @WebParam(name = "Qtd")int qtd){
        Product product = new Product();
        product.setName(name);
        product.setValuePrice(price);
        product.setQtd(qtd);
        stock.setNewProductInStock(product);
        return product.getCodProduct().toString();
    }

    @WebMethod
    public int getTotalOfProducts(){
        return stock.getTotal();
    }

    @WebMethod
    public ArrayList<Product> List(){
        return stock.Products();
    }

    @WebMethod
    public String getProductNamebByCod(@WebParam(name = "CodProducts")String cod){
        Product product = this.QueryStock(cod);
        return product.getNome();
    }

    @WebMethod
    public float getProductPriceByCod (@WebParam(name = "CodProducts")String cod) {
        Product product = this.QueryStock(cod);
        return product.getValuePrice();
    }

    @WebMethod
    public boolean addProductInCart (@WebParam(name = "CodProducts") String cod,@WebParam(name = "Qtd" )int qtd){
        Product product = this.QueryStock(cod);
        int calculation = 0;
        if(product != null && qtd <= product.getQtd()){
            ProductsInCart addInCartAction = new ProductsInCart(product,qtd);
            ProductsInCartController.addProductsInCart(addInCartAction);
            calculation = product.getQtd() - qtd;
            product.setQtd(calculation);
            return true;
        }
        return false;
    }

    @WebMethod
    public boolean CheckWeatherAProductExistsInCart(@WebParam(name = "CodProducts") String cod){
        Product product = this.QueryCart(cod);
        if(product!=null){
            return true;
        }
        return false;
    }

    private static Product QueryStock(String cod) {
        return StockController.findProductInStock(cod);
    }
    private static Product QueryCart(String cod){
        return ProductsInCartController.findProductInCart(cod);
    }

    public static void main(String[] argv) {
        Object implementor = new WebService();
        String address = "http://localhost:9000/WebService";
        Endpoint.publish(address, implementor);
        StartEngine.createStock();
        stock = StartEngine.getStock();
    }

}

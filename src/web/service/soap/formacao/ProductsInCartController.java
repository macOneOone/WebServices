package web.service.soap.formacao;

import java.util.ArrayList;

public class ProductsInCartController {

    private static ArrayList<ProductsInCart> productsInCarts = new ArrayList<ProductsInCart>();
    private static int lastIndex;
    public static void addProductsInCart (ProductsInCart item){
        Product product = findProductInCart(item.getProduct().getCodProduct().toString());

        if(product == null){
            productsInCarts.add(item);
        }else {
            //do an update into the cart
            productsInCarts.get(lastIndex).setQtd(item.getQtd());
        }
    }

    public static int getTotalInCart(){
        return productsInCarts.size();
    }

    public static Product findProductInCart (String cod){
        int size = productsInCarts.size();
        for (int v = 0; v < size ;v++){
            if(productsInCarts.get(v).getProduct().getCodProduct().toString().equals(cod)){
                lastIndex = v;
                return productsInCarts.get(v).getProduct();
            }
        }
        return null;
    }
}

package web.service.soap.formacao;

import java.util.ArrayList;
import java.util.UUID;

public class ProductsInCart {
    private Product product;
    private int qtd;
    private UUID codIdentifier;

    public ProductsInCart (Product product, int qtd){
        this.codIdentifier = UUID.randomUUID();
        this.product = product;
        this.qtd = qtd;
    }

    public void setProduct (Product product){
        this.product = product;
    }

    public void setQtd (int qtd){
        this.qtd = qtd;
    }

    public Product getProduct() {
        return product;
    }

    public int getQtd() {
        return qtd;
    }

    public UUID getCodIdentifier() {
        return codIdentifier;
    }
}

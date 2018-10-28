package web.service.soap.formacao;

import java.util.UUID;

public class Product {
    private String name;
    private UUID codProduct;
    private float valuePrice;
    private int qtd;

    public Product(){
        this.codProduct = UUID.randomUUID();
    }
    public void setName (String name){
        this.name = name;
    }
    public void setValuePrice(float valuePrice){
        this.valuePrice = valuePrice;
    }
    public UUID getCodProduct(){
        return this.codProduct;
    }
    public String getNome () {
        return this.name;
    }
    public float getValuePrice(){
        return this.valuePrice;
    }
    public void setQtd (int qtd){
        this.qtd = qtd;
    }
    public int getQtd () {
        return this.qtd;
    }
}

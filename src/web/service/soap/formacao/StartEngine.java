package web.service.soap.formacao;

public class StartEngine {
    private static Stock stock;
    public static void createStock(){
        stock = new Stock();
    }
    public static Stock getStock(){
        return stock;
    }
}

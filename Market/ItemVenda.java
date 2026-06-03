public class ItemVenda {
    private Produto produto;
    private int quantidade;
    private double precoUnitario;
    private double subtotal;

    public ItemVenda(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.precoUnitario = produto.getPreco(); 
        this.subtotal = calcularSubTotal();
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double calcularSubTotal() {
        return precoUnitario * quantidade;
    }
}

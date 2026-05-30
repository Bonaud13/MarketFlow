public class Estoque {
    private Produto produto;
    private int quantidade;

    public Estoque(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double calcularValorTotal(){
        return produto.valorTotalEmEstoque();
    }
    public String toString(){
        return "Produto: " + produto.getNome()
                + "\nQuantidade em estoque: " +quantidade
                + "\nValor total: " + produto.valorTotalEmEstoque();
    }
}

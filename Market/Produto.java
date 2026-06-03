public class Produto {
    private int codigo;
    private String nome;
    private double preco;
    private int quantidade;
    private int quantidadeMinima;

    public Produto(int codigo, String nome, double preco, int quantidade, int quantidadeMinima) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.quantidadeMinima = quantidadeMinima;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getQuantidadeMinima() {
        return quantidadeMinima;
    }

    public void setQuantidadeMinima(int quantidadeMinima) {
        this.quantidadeMinima = quantidadeMinima;
    }

    public double valorTotalEmEstoque() {
        return preco * quantidade;
    }

    public void adicionarProdutos(int quantidade) {
        this.quantidade += quantidade;
    }

    // Dá baixa no estoque. Se não houver quantidade suficiente, lança exceção.
    public void removerProdutos(int quantidade) {
        if (quantidade > this.quantidade) {
            throw new EstoqueInsuficienteException(
                "Estoque insuficiente para o produto " + nome +
                ". Disponível: " + this.quantidade + ", solicitado: " + quantidade);
        }
        this.quantidade -= quantidade;
    }

    public boolean precisaRepor() {
        return quantidade < quantidadeMinima;
    }
}

public class Loja {
    private String nome;
    private String endereco;
    private Estoque estoque;
    private Venda[] vendas; 
    private int totalVendas;

    public Loja(String nome, String endereco, int capacidadeEstoque, int capacidadeVendas) {
        this.nome = nome;
        this.endereco = endereco;
        this.estoque = new Estoque(capacidadeEstoque, this);
        this.vendas = new Venda[capacidadeVendas];
        this.totalVendas = 0;
    }

    
    public void registrarVenda(Venda venda) {
        if (totalVendas >= vendas.length) {
            System.out.println("Histórico de vendas cheio.");
            return;
        }
        vendas[totalVendas] = venda;
        totalVendas++;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public Venda[] getVendas() {
        return vendas;
    }

    public int getTotalVendas() {
        return totalVendas;
    }
}

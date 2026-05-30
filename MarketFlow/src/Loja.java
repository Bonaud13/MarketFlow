import java.util.ArrayList;

public class Loja {
    private String nome;
    private String endereco;
    private ArrayList<Estoque> estoque;
    private ArrayList<Venda> vendas;

    public Loja(String nome, String endereco, ArrayList<Estoque> estoque, ArrayList<Venda> vendas) {
        this.nome = nome;
        this.endereco = endereco;
        this.estoque = estoque;
        this.vendas = vendas;
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

    public ArrayList<Estoque> getEstoque() {
        return estoque;
    }

    public void setEstoque(ArrayList<Estoque> estoque) {
        this.estoque = estoque;
    }

    public ArrayList<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(ArrayList<Venda> vendas) {
        this.vendas = vendas;
    }
}


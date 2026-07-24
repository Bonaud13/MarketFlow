public class Cliente {
    private String cpf;
    private String nome;
    private boolean fidelidade;
    private double desconto;

    public Cliente(String cpf, String nome, boolean fidelidade) {
        this.cpf = cpf;
        this.nome = nome;
        this.fidelidade = fidelidade;
        this.desconto = fidelidade ? 0.15 : 0.0;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isFidelidade() {
        return fidelidade;
    }

    public void setFidelidade(boolean fidelidade) {
        this.fidelidade = fidelidade;
        this.desconto = fidelidade ? 0.15 : 0.0;
    }

    public double getDesconto() {
        return desconto;
    }
}

public class Cliente {
    private String cpf;
    private String nome;
    private boolean fidelidade;

    public Cliente(String cpf, String nome, boolean fidelidade) {
        this.cpf = cpf;
        this.nome = nome;
        this.fidelidade = fidelidade;
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
    }
}

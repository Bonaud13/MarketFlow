public class Estoque {
    private Produto[] produtos; // uso de ARRAY, como exigido
    private int capacidade;
    private int total; // quantos produtos já foram cadastrados
    private Loja loja;

    public Estoque(int capacidade, Loja loja) {
        this.capacidade = capacidade;
        this.loja = loja;
        this.produtos = new Produto[capacidade];
        this.total = 0;
    }

    // Cadastra um novo produto no estoque
    public void adicionarProduto(Produto produto) {
        if (total >= capacidade) {
            System.out.println("Estoque cheio! Não é possível cadastrar mais produtos.");
            return;
        }
        produtos[total] = produto;
        total++;
    }

    // Procura um produto pelo código. Se não achar, lança exceção.
    public Produto buscarPorCodigo(int codigo) {
        for (int i = 0; i < total; i++) {
            if (produtos[i].getCodigo() == codigo) {
                return produtos[i];
            }
        }
        throw new ProdutoNaoEncontradoException(
            "Produto com código " + codigo + " não encontrado no estoque.");
    }

    // Dá baixa na quantidade de um produto (usado na venda)
    public void atualizarQtd(int codigo, int quantidade) {
        Produto produto = buscarPorCodigo(codigo);
        produto.removerProdutos(quantidade);
    }

    // Verifica e avisa quais produtos estão abaixo do mínimo
    public void verificarMinimo() {
        boolean algumAbaixo = false;
        for (int i = 0; i < total; i++) {
            if (produtos[i].precisaRepor()) {
                System.out.println("ALERTA: " + produtos[i].getNome()
                    + " está abaixo do mínimo (atual: " + produtos[i].getQuantidade()
                    + ", mínimo: " + produtos[i].getQuantidadeMinima() + "). Reposição necessária.");
                algumAbaixo = true;
            }
        }
        if (!algumAbaixo) {
            System.out.println("Todos os produtos estão com estoque adequado.");
        }
    }

    // Relatório de giro/estoque da loja
    public void gerarRelatorio() {
        System.out.println("\n===== RELATÓRIO DE ESTOQUE - " + loja.getNome() + " =====");
        double valorTotal = 0;
        for (int i = 0; i < total; i++) {
            Produto p = produtos[i];
            System.out.printf("[%d] %s | Qtd: %d | Preço: R$ %.2f | Total: R$ %.2f%n",
                p.getCodigo(), p.getNome(), p.getQuantidade(), p.getPreco(), p.valorTotalEmEstoque());
            valorTotal += p.valorTotalEmEstoque();
        }
        System.out.printf("Valor total em estoque: R$ %.2f%n", valorTotal);
        System.out.println("===============================================");
    }

    public Produto[] getProdutos() {
        return produtos;
    }

    public int getTotal() {
        return total;
    }

    public Loja getLoja() {
        return loja;
    }
}

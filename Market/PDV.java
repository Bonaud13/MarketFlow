import java.util.Locale;
import java.util.Scanner;

public class PDV {
    private Loja[] lojas; 
    private Loja lojaAtual;
    private Scanner scanner;

    public PDV() {
        this.scanner = new Scanner(System.in);
        
        this.lojas = new Loja[5];
        lojas[0] = new Loja("MarketFlow Centro", "Av. Principal, 100", 50, 100);
        this.lojaAtual = lojas[0];
        carregarProdutosIniciais();
    }

    
    private void carregarProdutosIniciais() {
        Estoque estoque = lojaAtual.getEstoque();
        estoque.adicionarProduto(new Produto(1, "Arroz 5kg", 25.90, 20, 5));
        estoque.adicionarProduto(new Produto(2, "Feijão 1kg", 8.50, 15, 5));
        estoque.adicionarProduto(new Produto(3, "Óleo de Soja", 7.20, 3, 5)); // já abaixo do mínimo
        estoque.adicionarProduto(new Produto(4, "Açúcar 1kg", 4.80, 30, 8));
        estoque.adicionarProduto(new Produto(5, "Café 500g", 18.00, 10, 4));
    }

    public void iniciar() {
        Locale.setDefault(Locale.US);
        int opcao;
        do {
            System.out.println("\nBem-vindo ao MarketFlow - onde cada venda conta!");
            System.out.println("Loja: " + lojaAtual.getNome());
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Realizar venda (Caixa)");
            System.out.println("2 - Ver estoque (Gerente)");
            System.out.println("3 - Repor estoque (Gerente)");
            System.out.println("4 - Verificar estoque mínimo");
            System.out.println("0 - Sair");

            opcao = lerInteiro();
            switch (opcao) {
                case 1:
                    realizarVenda();
                    break;
                case 2:
                    lojaAtual.getEstoque().gerarRelatorio();
                    break;
                case 3:
                    reporEstoque();
                    break;
                case 4:
                    lojaAtual.getEstoque().verificarMinimo();
                    break;
                case 0:
                    System.out.println("Encerrando o sistema. Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private void realizarVenda() {
        Estoque estoque = lojaAtual.getEstoque();

        
        System.out.println("\nCliente possui cadastro? (1 - Sim / 0 - Não):");
        int temCadastro = lerInteiro();

        Cliente cliente;
        if (temCadastro == 1) {
            System.out.println("Informe o CPF do cliente:");
            String cpf = scanner.nextLine();
            cliente = new Cliente(cpf, "Cliente Fidelidade", true);
            System.out.println("Cliente fidelidade identificado. Desconto será aplicado.");
        } else {
            cliente = new Cliente("000.000.000-00", "Cliente Avulso", false);
            System.out.println("Prosseguindo sem cadastro (sem desconto).");
        }

       
        Venda venda = new Venda(cliente, 50);
        String continuar = "s";

        while (continuar.equalsIgnoreCase("s")) {
            System.out.println("\nDigite o código do produto:");
            int codigo = lerInteiro();

            try {
                Produto produto = estoque.buscarPorCodigo(codigo);
                System.out.println("Produto: " + produto.getNome()
                    + " | Preço: R$ " + produto.getPreco()
                    + " | Em estoque: " + produto.getQuantidade());

                System.out.println("Digite a quantidade:");
                int quantidade = lerInteiro();

                
                estoque.atualizarQtd(codigo, quantidade);

                
                ItemVenda item = new ItemVenda(produto, quantidade);
                venda.adicionarItem(item);
                System.out.println("Item adicionado!");

            } catch (ProdutoNaoEncontradoException e) {
                System.out.println("ERRO: " + e.getMessage());
            } catch (EstoqueInsuficienteException e) {
                System.out.println("ERRO: " + e.getMessage());
            }

            System.out.println("Adicionar mais produtos? (s/n):");
            continuar = scanner.nextLine();
        }

        if (venda.getTotalItens() == 0) {
            System.out.println("Venda cancelada: nenhum item adicionado.");
            return;
        }

        
        venda.emitirCupom();
        lojaAtual.registrarVenda(venda);

        
        System.out.println("\nVerificando estoque após a venda...");
        estoque.verificarMinimo();
    }

    private void reporEstoque() {
        Estoque estoque = lojaAtual.getEstoque();
        System.out.println("\nDigite o código do produto a repor:");
        int codigo = lerInteiro();
        try {
            Produto produto = estoque.buscarPorCodigo(codigo);
            System.out.println("Produto: " + produto.getNome()
                + " | Em estoque: " + produto.getQuantidade());
            System.out.println("Quantidade a adicionar:");
            int quantidade = lerInteiro();
            produto.adicionarProdutos(quantidade);
            System.out.println("Estoque atualizado! Novo total: " + produto.getQuantidade());
        } catch (ProdutoNaoEncontradoException e) {
            System.out.println("ERRO: " + e.getMessage());
        }
    }

   
    private int lerInteiro() {
        while (!scanner.hasNextInt()) {
            System.out.println("Digite um número válido:");
            scanner.next();
        }
        int valor = scanner.nextInt();
        scanner.nextLine();
        return valor;
    }

    public static void main(String[] args) {
        PDV pdv = new PDV();
        pdv.iniciar();
    }
}

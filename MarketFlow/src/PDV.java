import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class PDV {
    public static void realizarVenda(Scanner sc) {
        System.out.println("Cliente possui cadastro? (1 - Sim / 0 - Não):");
        int opcao = sc.nextInt();
        sc.nextLine();

        Cliente cliente = null;
        if (opcao == 1) {
            System.out.println("Informe o CPF do cliente:");
            String cpf = sc.nextLine();
            cliente = new Cliente(cpf, "Cliente Fidelidade", true);
            System.out.println("Cliente encontrado: " + cliente.getNome());
        } else {
            cliente = new Cliente("000.000.000-00", "Cliente Avulso", false);
            System.out.println("Prosseguindo sem cadastro.");
        }
        ArrayList<ItemVenda> itens = new ArrayList<>();
        String continuar = "s";

        while (continuar.equalsIgnoreCase("s")) {
            System.out.println("Digite o nome do produto:");
            String nomeProduto = sc.nextLine();
            System.out.println("Digite o preço do produto:");
            double preco = sc.nextDouble();
            System.out.println("Digite a quantidade:");
            int quantidade = sc.nextInt();

            Produto produto = new Produto(0, nomeProduto, preco, quantidade, 0);
            ItemVenda item = new ItemVenda(produto, quantidade);
            itens.add(item);

            System.out.println("Adicionar mais produtos? (s/n):");
            sc.nextLine();
            continuar = sc.nextLine();
        }
        double totalNormal = 0;
        for (ItemVenda item : itens) {
            totalNormal += item.getSubtotal();
        }

        double totalFinal = totalNormal;
        if (cliente.isFidelidade()) {
            totalFinal = totalNormal * 0.85;
        }

        System.out.println("\n===== CUPOM FISCAL =====");
        System.out.println("Cliente: " + cliente.getNome());
        for (ItemVenda item : itens) {
            System.out.printf("%s x%d - R$ %.2f%n", item.getProduto().getNome(), item.getQuantidade(), item.getSubtotal());
        }
        System.out.printf("Subtotal: R$ %.2f%n", totalNormal);
        if (cliente.isFidelidade()) {
            System.out.printf("Desconto fidelidade (15%%): -R$ %.2f%n", totalNormal - totalFinal);
        }
        System.out.printf("Total: R$ %.2f%n", totalFinal);
        System.out.println("========================");
    }
    public static void main(String[]ARGS) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int selecionarMenu = 0;
        do {
            System.out.println("Bem-vindo ao MarketFlow — onde cada venda conta! 🛒 \nEscolha uma opção: \n1 - Realizar venda \n2 - Ver estoque \n0 - Sair");
            selecionarMenu = sc.nextInt();
            switch (selecionarMenu) {
                case 1:
                    System.out.println("Iniciando venda...");
                    realizarVenda(sc);
                    break;
                case 2:
                    System.out.println("Exibindo estoque...");
                    break;
                case 0:
                    System.out.println("Encerrando o sistema. Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (selecionarMenu != 0);
    }
}


import java.time.LocalDate;

public class Venda {
    private ItemVenda[] itens; // uso de ARRAY
    private int totalItens;
    private double total;
    private Cliente cliente;
    private LocalDate data;

    public Venda(Cliente cliente, int capacidade) {
        this.cliente = cliente;
        this.itens = new ItemVenda[capacidade];
        this.totalItens = 0;
        this.data = LocalDate.now();
    }

    public void adicionarItem(ItemVenda item) {
        if (totalItens >= itens.length) {
            System.out.println("Limite de itens da venda atingido.");
            return;
        }
        itens[totalItens] = item;
        totalItens++;
    }

    // Soma os subtotais (valor bruto, sem desconto)
    public double calcularTotal() {
        double soma = 0;
        for (int i = 0; i < totalItens; i++) {
            soma += itens[i].getSubtotal();
        }
        this.total = soma;
        return soma;
    }

    // Emite o cupom fiscal aplicando o desconto do cliente
    public void emitirCupom() {
        double bruto = calcularTotal();
        double desconto = bruto * cliente.getDesconto();
        double liquido = bruto - desconto;

        System.out.println("\n========== CUPOM FISCAL ==========");
        System.out.println("Data: " + data);
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("CPF: " + cliente.getCpf());
        System.out.println("----------------------------------");
        for (int i = 0; i < totalItens; i++) {
            ItemVenda item = itens[i];
            System.out.printf("%s x%d - R$ %.2f%n",
                item.getProduto().getNome(), item.getQuantidade(), item.getSubtotal());
        }
        System.out.println("----------------------------------");
        System.out.printf("Subtotal: R$ %.2f%n", bruto);
        if (cliente.isFidelidade()) {
            System.out.printf("Desconto fidelidade (15%%): -R$ %.2f%n", desconto);
        }
        System.out.printf("TOTAL: R$ %.2f%n", liquido);
        System.out.println("==================================");
    }

    public ItemVenda[] getItens() {
        return itens;
    }

    public int getTotalItens() {
        return totalItens;
    }

    public double getTotal() {
        return total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public LocalDate getData() {
        return data;
    }
}

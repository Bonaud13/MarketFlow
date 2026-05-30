import java.time.LocalDate;
import java.util.ArrayList;

public class Venda {
    private ArrayList<ItemVenda> itens;
    private double total;
    private Cliente cliente;
    private LocalDate data;

    public Venda(ArrayList<ItemVenda> itens, Cliente cliente, LocalDate data) {
        this.itens = itens;
        this.cliente = cliente;
        this.data = data;
        this.total = calcularTotal();
    }

    public ArrayList<ItemVenda> getItens() {
        return itens;
    }

    public void setItens(ArrayList<ItemVenda> itens) {
        this.itens = itens;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public double calcularTotal() {
        double soma = 0;
        for (ItemVenda item : itens) {
            soma += item.getSubtotal();
        }
        return soma;
    }
}
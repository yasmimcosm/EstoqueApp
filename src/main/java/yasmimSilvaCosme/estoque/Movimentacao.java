package yasmimSilvaCosme.estoque;

import java.util.Date;

public class Movimentacao {
    private Date data;
    private String tipo; // "Compra" ou "Venda"
    private int quantidade;
    private double valorUnitario;

    public Movimentacao(String tipo, int quantidade, double valorUnitario) {
        this.data = new Date();
        this.tipo = tipo;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
    }

    public Date getData() { return data; }

    public String getTipo() { return tipo; }

    public int getQuantidade() { return quantidade; }

    public double getValorUnitario() { return valorUnitario; }

    @Override
    public String toString() {
        double total = valorUnitario * quantidade;
        return data + " - " + tipo + ": qtd=" + quantidade + ", valor unit=" + valorUnitario + ", total=" + total;
    }
}


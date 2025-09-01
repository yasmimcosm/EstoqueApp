package yasmimSilvaCosme.estoque;

import java.util.ArrayList;

public class Produto {
    private int cod;
    private String desc;
    private int estoqueMinimo;
    private double lucro;
    private double precoCompra;
    private double precoVenda;
    private int quantidade;

    private ArrayList<Fornecedor> fornecedores = new ArrayList<>();
    private ArrayList<Movimentacao> movimentacoes = new ArrayList<>();

    public Produto(int cod, String desc, int min, double lucro) {
        this.cod = cod;
        this.desc = desc;
        this.estoqueMinimo = min;
        this.lucro = lucro;
        this.precoCompra = 0.0;
        this.precoVenda = 0.0;
        this.quantidade = 0;
    }

    public int getCod() { return cod; }
    public String getDesc() { return desc; }
    public int getQuantidade() { return quantidade; }
    public double getPrecoCompra() { return precoCompra; }
    public double getPrecoVenda() { return precoVenda; }
    public ArrayList<Fornecedor> getFornecedores() { return fornecedores; }
    public ArrayList<Movimentacao> getMovimentacoes() { return movimentacoes; }

    public void adicionarFornecedor(Fornecedor f) {
        if (f != null && !fornecedores.contains(f)) {
            fornecedores.add(f);
        }
    }

    public void compra(int quant, double val) {
        if (quant <= 0 || val <= 0) return;

        double totalAtual = this.precoCompra * this.quantidade;
        double totalNovo  = val * quant;
        int novaQuantidade = this.quantidade + quant;

        this.precoCompra = (totalAtual + totalNovo) / novaQuantidade;
        this.quantidade  = novaQuantidade;

        this.precoVenda = this.precoCompra * (1.0 + this.lucro);

        movimentacoes.add(new Movimentacao("Compra", quant, val));
    }

    public double venda(int quant) {
        if (quant <= 0 || quant > this.quantidade) return -1.0;

        this.quantidade -= quant;
        movimentacoes.add(new Movimentacao("Venda", quant, this.precoVenda));
        return this.precoVenda * quant;
    }

    public boolean abaixoDoMinimo() {
        return this.quantidade < this.estoqueMinimo;
    }

    @Override
    public String toString() {
        return "Produto{cod=" + cod + ", desc='" + desc + "', qtd=" + quantidade +
                ", precoCompra=" + precoCompra + ", precoVenda=" + precoVenda + "}";
    }
}

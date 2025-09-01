package yasmimSilvaCosme.estoque;

import java.util.ArrayList;
import java.util.Date;

public class Estoque {
    private ArrayList<Produto> produtos;

    public Estoque() {
        this.produtos = new ArrayList<>();
    }

    public void incluir(Produto p) {
        if (p == null) return;
        if (buscarProduto(p.getCod()) == null) {
            produtos.add(p);
        }
    }

    public void comprar(int cod, int quant, double preco) {
        Produto p = buscarProduto(cod);
        if (p != null) {
            p.compra(quant, preco);
        }
    }

    public double vender(int cod, int quant) {
        Produto p = buscarProduto(cod);
        if (p == null) return -1.0;
        return p.venda(quant);
    }

    public int quantidade(int cod) {
        Produto p = buscarProduto(cod);
        return (p == null) ? -1 : p.getQuantidade();
    }

    public String movimentacao(int cod, Date inicio, Date fim) {
        Produto p = buscarProduto(cod);
        if (p == null) return null;

        StringBuilder sb = new StringBuilder();
        sb.append("Movimentações do produto ").append(cod).append(" (").append(p.getDesc()).append("):\n");

        for (Movimentacao m : p.getMovimentacoes()) {
            if (!m.getData().before(inicio) && !m.getData().after(fim)) {
                sb.append(m).append("\n");
            }
        }

        sb.append("Estoque final: ").append(p.getQuantidade());
        return sb.toString();
    }


    public ArrayList<Fornecedor> fornecedores(int cod) {
        Produto p = buscarProduto(cod);
        return (p == null) ? null : p.getFornecedores();
    }

    public ArrayList<Produto> estoqueAbaixoDoMinimo() {
        ArrayList<Produto> list = new ArrayList<>();
        for (Produto p : produtos) {
            if (p.abaixoDoMinimo()) list.add(p);
        }
        return list;
    }

    public void adicionarFornecedor(int cod, Fornecedor f) {
        Produto p = buscarProduto(cod);
        if (p != null) p.adicionarFornecedor(f);
    }

    public double precoDeVenda(int cod) {
        Produto p = buscarProduto(cod);
        return (p == null) ? -1.0 : p.getPrecoVenda();
    }

    public double precoDeCompra(int cod) {
        Produto p = buscarProduto(cod);
        return (p == null) ? -1.0 : p.getPrecoCompra();
    }

    private Produto buscarProduto(int cod) {
        for (Produto p : produtos) {
            if (p.getCod() == cod) return p;
        }
        return null;
    }
}

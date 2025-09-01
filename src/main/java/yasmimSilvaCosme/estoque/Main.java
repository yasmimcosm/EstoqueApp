package yasmimSilvaCosme.estoque;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Estoque estoque = new Estoque();
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n--- Sistema de Estoque ---");
            System.out.println("1. Incluir Produto");
            System.out.println("2. Adicionar Fornecedor ao Produto");
            System.out.println("3. Comprar Produto");
            System.out.println("4. Vender Produto");
            System.out.println("5. Listar Produtos");
            System.out.println("6. Produtos abaixo do estoque mínimo");
            System.out.println("7. Mostrar movimentação de Produto");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch(opcao) {
                case 1:
                    System.out.print("Código: ");
                    int cod = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Descrição: ");
                    String desc = sc.nextLine();
                    System.out.print("Estoque mínimo: ");
                    int min = sc.nextInt();
                    System.out.print("Lucro (% em decimal, ex: 0,5): ");
                    double lucro = sc.nextDouble();
                    estoque.incluir(new Produto(cod, desc, min, lucro));
                    System.out.println("Produto incluído!");
                    break;

                case 2:
                    System.out.print("Código do Produto: ");
                    cod = sc.nextInt();
                    sc.nextLine();
                    System.out.print("CNPJ do fornecedor: ");
                    int cnpj = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nome do fornecedor: ");
                    String nome = sc.nextLine();
                    estoque.adicionarFornecedor(cod, new Fornecedor(cnpj, nome));
                    System.out.println("Fornecedor adicionado!");
                    break;

                case 3:
                    System.out.print("Código do Produto: ");
                    cod = sc.nextInt();
                    System.out.print("Quantidade: ");
                    int qtd = sc.nextInt();
                    System.out.print("Preço unitário: ");
                    double preco = sc.nextDouble();
                    estoque.comprar(cod, qtd, preco);
                    System.out.println("Compra realizada!");
                    break;

                case 4:
                    System.out.print("Código do Produto: ");
                    cod = sc.nextInt();
                    System.out.print("Quantidade: ");
                    qtd = sc.nextInt();
                    double valorVenda = estoque.vender(cod, qtd);
                    if(valorVenda == -1) System.out.println("Venda inválida!");
                    else System.out.println("Venda realizada. Valor total: " + valorVenda);
                    break;

                case 5:
                    System.out.println("--- Lista de Produtos ---");
                    for (Produto p : estoque.estoqueAbaixoDoMinimo()) {
                        System.out.println(p);
                    }
                    break;

                case 6:
                    ArrayList<Produto> lista = estoque.estoqueAbaixoDoMinimo();
                    if(lista.isEmpty()) System.out.println("Nenhum produto abaixo do mínimo.");
                    else {
                        System.out.println("--- Produtos abaixo do estoque mínimo ---");
                        for(Produto p : lista) System.out.println(p);
                    }
                    break;

                case 7:
                    System.out.print("Código do Produto: ");
                    cod = sc.nextInt();
                    String mov = estoque.movimentacao(cod, null, null);
                    if(mov == null) System.out.println("Produto não encontrado!");
                    else System.out.println(mov);
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while(opcao != 0);

        sc.close();
    }
}

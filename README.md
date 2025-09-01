# 🛒 Sistema de Controle de Estoque

![Java](https://img.shields.io/badge/Java-17-blue)
![GitHub](https://img.shields.io/badge/GitHub-ControleEstoque-green)

## 🔹 Descrição

Sistema em **Java** para controle de estoque de um pequeno mercado.  
Permite gerenciar produtos, fornecedores, compras, vendas e movimentações detalhadas, garantindo controle eficiente do estoque mínimo, preços e lucros.

O projeto segue boas práticas de **orientação a objetos**, usando classes separadas para `Produto`, `Fornecedor`, `Movimentacao` e `Estoque`.

---

## 💡 Funcionalidades

- Cadastro de produtos com:
  - Código, descrição, preço de compra, preço de venda, lucro, quantidade e estoque mínimo.
- Cadastro de fornecedores com:
  - CNPJ e nome.
- Compras e vendas com atualização automática de preços e quantidade.
- Registro de movimentações detalhadas (compra e venda) com data e valores.
- Consulta de movimentações em intervalos de datas.
- Relatórios de produtos com estoque abaixo do mínimo.
- Consulta de preços de compra e venda.
- Adição de múltiplos fornecedores por produto.

---

## 🗂 Estrutura do Projeto

```
/BancoApp
  ├─ src/main/java/
  │   ├─ Main.java        # Menu interativo do sistema
  │   ├─ Estoque.java       
  │   ├─ Fornecedor.java
  │   ├─ Produto.java      
  │   └─ Movimentacao.java      
  └─ README.md            # Este arquivo
```

- `Produto.java`: Representa os produtos do mercado, calcula preço de venda e registra movimentações.
- `Fornecedor.java`: Representa os fornecedores do produto.
- `Movimentacao.java`: Registra cada compra ou venda com data, quantidade e valor.
- `Estoque.java`: Gerencia toda a lista de produtos, compras, vendas e movimentações.

---

## 📊 Diagrama UML

```text
+----------------+        +----------------+
|    Estoque     |        |    Produto     |
+----------------+        +----------------+
| - produtos[]   |<>----- | - cod          |
|                |        | - desc         |
| + incluir()    |        | - estoqueMin   |
| + comprar()    |        | - lucro        |
| + vender()     |        | - precoCompra  |
| + quantidade() |        | - precoVenda   |
| + movimentacao()|       | - quantidade   |
| + fornecedores()|       | - fornecedores |
| + estoqueAbaixoDoMinimo()| - movimentacoes|
+----------------+        +----------------+
                             | + compra()
                             | + venda()
                             | + adicionarFornecedor()
                             | + abaixoDoMinimo()
                             +----------------+
                                      ^
                                      |
                              +----------------+
                              |  Fornecedor    |
                              +----------------+
                              | - cnpj         |
                              | - nome         |
                              +----------------+
                              | + getCnpj()    |
                              | + getNome()    |
                              +----------------+
```

## 🚀 Como Rodar

1. Clone o repositório:

```bash
git clone https://github.com/seu-usuario/BancoApp.git
```

2. Compile todos os arquivos dentro de `src/main/java`:

```bash
javac src/main/java/*.java
```

3. Execute o programa:

```bash
java -cp src/main/java Main

```

---
## 📈 Funcionalidades avançadas

Atualização automática do preço de venda com base no lucro definido.

Registro completo de todas as movimentações do estoque.

Relatórios de produtos com estoque abaixo do mínimo.

Sistema modular, fácil de expandir com novas funcionalidades.

---
## 📝 Licença

Este projeto está sob a licença MIT.
Sinta-se à vontade para usar, estudar e modificar para seus próprios projetos.

---
## 🔗 Contato

Desenvolvedora: Yasmim Silva Cosme

GitHub: https://github.com/yasmimcosm/EstoqueApp

E-mail: yasmicosm@email.com
---

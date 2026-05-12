# 🍔 Sistema de Lanchonete - POO em Java

Sistema de gerenciamento de pedidos de uma lanchonete desenvolvido em Java, aplicando os 4 pilares da Programação Orientada a Objetos.

## 🎯 Funcionalidades

- Cadastro de produtos (Lanches e Bebidas)
- Gerenciamento de carrinho de compras
- Cálculo do valor total com desconto e taxa de entrega
- Exibição de resumo detalhado do pedido

## 🧱 Pilares da POO aplicados

- **Abstração:** classe `Produto` abstrata
- **Encapsulamento:** atributos privados com getters/setters
- **Herança:** `Lanche` e `Bebida` herdam de `Produto`
- **Polimorfismo:** método `exibir()` sobrescrito em cada classe filha

## 💰 Regra de negócio

Se o subtotal do pedido ultrapassar R$ 50,00, é aplicado um desconto de 10% antes da soma da taxa de entrega.

## 🚀 Como executar

1. Clone o repositório
2. Abra o projeto no IntelliJ IDEA
3. Execute a classe `Main.java`

## 👨‍💻 Autor

Nicolas Pinheiro - Estudante de Sistemas de Desenvolvimento

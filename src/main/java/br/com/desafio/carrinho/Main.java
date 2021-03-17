package br.com.desafio.carrinho;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        // Código clientes
        String identificadorCliente1 = "45A47B";
        String identificadorCliente2 = "46A47B";
        String identificadorCliente3 = "47A47B";

        // Produtos
        Produto monitor = new Produto(1L, "Monitor 29'");
        Produto mouse = new Produto(2L, "Mouse");
        Produto teclado = new Produto(3L, "Teclado");

        // Carrinhos
        CarrinhoComprasFactory carrinhoComprasFactory = new CarrinhoComprasFactory();

        CarrinhoCompras carrinhoComprasCliente1 = carrinhoComprasFactory.criar(identificadorCliente1);
        CarrinhoCompras carrinhoComprasCliente2 = carrinhoComprasFactory.criar(identificadorCliente2);
        CarrinhoCompras carrinhoComprasCliente3 = carrinhoComprasFactory.criar(identificadorCliente3);
        CarrinhoCompras carrinhoComprasCliente4 = carrinhoComprasFactory.criar(identificadorCliente3);

        // Adicionando Itens
        carrinhoComprasCliente1.adicionarItem(monitor, BigDecimal.valueOf(433), 3);
        carrinhoComprasCliente2.adicionarItem(mouse, BigDecimal.valueOf(91.50), 1);
        carrinhoComprasCliente2.adicionarItem(teclado, BigDecimal.valueOf(210), 5);
        carrinhoComprasCliente3.adicionarItem(teclado, BigDecimal.valueOf(210), 7);

        // Verificando Valor total e Valor Ticket Medio
        System.out.println("Total Carrinho Cliente 1: " + carrinhoComprasCliente1.getValorTotal());
        System.out.println("Total Carrinho Cliente 2: " + carrinhoComprasCliente2.getValorTotal());
        System.out.println("Total Carrinho Cliente 3: " + carrinhoComprasCliente3.getValorTotal());
        System.out.println("TicketMedio: " + carrinhoComprasFactory.getValorTicketMedio());

        // Verificando se o criar retornou o carrinho pelo identificador
        System.out.println("O carrinho 3 é o mesmo que o 4: " + carrinhoComprasCliente3.equals(carrinhoComprasCliente4));

        // Invalidando um carrinho
        carrinhoComprasFactory.invalidar(identificadorCliente1);
        System.out.println("TicketMedio sem o carrinho 1: " + carrinhoComprasFactory.getValorTicketMedio());

        // Verificando acumulo de itens
        carrinhoComprasCliente1.adicionarItem(monitor, BigDecimal.valueOf(433), 3);
        System.out.println("Items carrinho 1: " + carrinhoComprasCliente1.getItens().size());
        System.out.println("Total carrinho 1: " + carrinhoComprasCliente1.getValorTotal());

        // Verificando remoção de item  do carrinho por produto
        System.out.println("Removendo Mouse do carrinho 1: " + carrinhoComprasCliente1.removerItem(mouse));
        System.out.println("Items carrinho 1: " + carrinhoComprasCliente1.getItens().size());
        System.out.println("Total carrinho 1: " + carrinhoComprasCliente1.getValorTotal());
        System.out.println("Removendo Monitor do carrinho 1: " + carrinhoComprasCliente1.removerItem(monitor));
        System.out.println("Items carrinho 1: " + carrinhoComprasCliente1.getItens().size());
        System.out.println("Total carrinho 1: " + carrinhoComprasCliente1.getValorTotal());

        // Verificando remoção de item  do carrinho por posiçãoItem
        carrinhoComprasCliente2.adicionarItem(monitor, BigDecimal.valueOf(433), 3);
        System.out.println("Qauntidade items carrinho 2: " + carrinhoComprasCliente2.getItens().size());
        System.out.println("carrinho de compras 2: " + carrinhoComprasCliente2);
        System.out.println("Removendo teclado do carrinho 2: " + carrinhoComprasCliente2.removerItem(2));
        System.out.println("Qauntidade items carrinho 2: " + carrinhoComprasCliente2.getItens().size());
        System.out.println("carrinho de compras 2: " + carrinhoComprasCliente2);
    }

}


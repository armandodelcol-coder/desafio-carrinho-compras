package br.com.desafio.carrinho;


import br.com.desafio.carrinho.exception.CarrinhoCompraItemInvalidException;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Classe que representa o carrinho de compras de um cliente.
 */
public class CarrinhoCompras {

    private List<Item> itens = new ArrayList<>();

    /**
     * Permite a adição de um novo item no carrinho de compras.
     *
     * Caso o item já exista no carrinho, ou seja, já exista um item no carrinho referenciando esse mesmo produto,
     * deverá seguir as seguintes duas regras:
     * - Deverá ser alterada apenas a quantidade, sendo que o novo valor deverá ser a soma da quantidade
     * atual e o valor da quantidade passada como parâmetro.
     * - Se o valor unitário informado for diferente do valor unitário atual do item, o novo valor uitário do item deverá ser
     * o passado como parâmetro.
     *
     * Devem ser lançadas subclasses de RuntimeException caso não seja possível adicionar o item ao carrinho de compras.
     *
     * @param produto
     * @param valorUnitario
     * @param quantidade
     */
    public void adicionarItem(Produto produto, BigDecimal valorUnitario, int quantidade) {
        try {
            Optional<Item> foundItem = itens.stream().filter(item -> item.getProduto().equals(produto)).findFirst();
            if (foundItem.isPresent()) {
                foundItem.get().setValorUnitario(valorUnitario);
                foundItem.get().setQuantidade(foundItem.get().getQuantidade() + quantidade);
            } else {
                Item newItem = new Item(produto, valorUnitario, quantidade);
                newItem.setIndex(itens.size() + 1);
                this.itens.add(newItem);
            }
        } catch (RuntimeException e) {
            throw new CarrinhoCompraItemInvalidException("Não foi possível adicionar o item no carrinho, verifique os dados informados");
        }
    }

    /**
     * Permite a remoção do carrinho de compras do produto passado como parâmetro.
     *
     * @param produto
     * @return Retorna um boolean, tendo o valor true caso o produto exista no carrinho de compras e false
     * caso o produto não exista no carrinho.
     */
    public boolean removerItem(Produto produto) {
        Optional<Item> itemToRemove = this.itens.stream().filter(item -> item.getProduto().equals(produto)).findFirst();
        return itemToRemove.isPresent() && itens.remove(itemToRemove.get());
    }

    /**
     * Permite a remoção do item de acordo com a posição.
     * Essa posição deve ser determinada pela ordem de inclusão do produto na coleção.
     *
     * @param posicaoItem
     * @return Retorna um boolean, tendo o valor true caso o produto exista no carrinho de compras e false
     * caso o produto não exista no carrinho.
     */
    public boolean removerItem(int posicaoItem) {
        // Minha primeira alternativa:
        /*try {
            Item itemRemoved = itens.remove(posicaoItem);
            return itemRemoved != null;
        } catch (Exception e) {
            return false;
        }*/

        // Uma implementação manual
        Optional<Item> itemToRemove = this.itens.stream().filter(item -> item.getIndex() == posicaoItem).findFirst();
        return itemToRemove.isPresent() && itens.remove(itemToRemove.get());
    }

    /**
     * Retorna o valor total do carrinho de compras, que deve ser a soma dos valores totais
     * de todos os itens que compõem o carrinho.
     *
     * @return BigDecimal
     */
    public BigDecimal getValorTotal() {
        List<BigDecimal> valorTotalItens = itens.stream().map(item -> item.getValorTotal()).collect(Collectors.toList());
        return valorTotalItens.stream().reduce(BigDecimal.ZERO, (subtotal, element) -> subtotal.add(element));
    }

    /**
     * Retorna a lista de itens do carrinho de compras.
     *
     * @return Collection<Itens>
     */
    public Collection<Item> getItens() {
        return this.itens;
    }

    @Override
    public String toString() {
        List<String> list = itens.stream()
                .map(
                        item -> String.format(
                                "{ Index: %d, Produto: %s, Quantidade: %d, ValorUnitário: %.2f }",
                                item.getIndex(),
                                item.getProduto().getDescricao(),
                                item.getQuantidade(),
                                item.getValorUnitario()
                        )).collect(Collectors.toList());

        return list.toString();
    }
}
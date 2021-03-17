package br.com.desafio.carrinho;

import java.math.BigDecimal;

/**
 * Classe que representa um item no carrinho de compras.
 */
public class Item {

    private Integer index;
    private Produto produto;
    private BigDecimal valorUnitario;
    private int quantidade;

    /**
     * Construtor da classe Item.
     * \
     * @param produto
     * @param valorUnitario
     * @param quantidade
     */
    public Item(Produto produto, BigDecimal valorUnitario, int quantidade) {
        this.produto = produto;
        this.valorUnitario = valorUnitario;
        this.quantidade = quantidade;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    /**
     * Retorna o produto.
     *
     * @return Produto
     */
    public Produto getProduto() {
        return this.produto;
    }

    /**
     * Seta o produto.
     *
     * @param produto
     */
    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    /**
     * Retorna o valor unitário do item.
     *
     * @return BigDecimal
     */
    public BigDecimal getValorUnitario() {
        return this.valorUnitario;
    }

    /**
     * Seta o valor unitário do item.
     *
     * @param valorUnitario
     */
    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    /**
     * Retorna a quantidade dos item.
     *
     * @return int
     */
    public int getQuantidade() {
        return this.quantidade;
    }

    /**
     * Seta a quantidade do item.
     *
     * @param quantidade
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * Retorna o valor total do item.
     *
     * @return BigDecimal
     */
    public BigDecimal getValorTotal() {
        return this.valorUnitario.multiply(BigDecimal.valueOf(this.quantidade));
    }

}

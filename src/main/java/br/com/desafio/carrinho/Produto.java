package br.com.desafio.carrinho;

import java.util.Objects;

/**
 * Classe que representa um produto que pode ser adicionado
 * como item ao carrinho de compras.
 *
 * Importante: Dois produtos são considerados iguais quando ambos possuem o
 * mesmo código.
 */
public class Produto {

    private Long codigo;
    private String descricao;

    /**
     * Construtor da classe Produto.
     *
     * @param codigo
     * @param descricao
     */
    public Produto(Long codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    /**
     * Retorna o código da produto.
     *
     * @return Long
     */
    public Long getCodigo() {
        return this.codigo;
    }

    /**
     * Seta o código do produto.
     *
     * @param codigo
     */
    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    /**
     * Retorna a descrição do produto.
     *
     * @return String
     */
    public String getDescricao() {
        return this.descricao;
    }

    /**
     * Seta a descrição do produto.
     *
     * @param descricao
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(codigo, produto.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}
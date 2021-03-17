package br.com.desafio.carrinho;

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
    }

    /**
     * Retorna o código da produto.
     *
     * @return Long
     */
    public Long getCodigo() {
    }

    /**
     * Seta o código do produto.
     *
     * @param codigo
     */
    public void setCodigo(Long codigo) {
    }

    /**
     * Retorna a descrição do produto.
     *
     * @return String
     */
    public String getDescricao() {
    }

    /**
     * Seta a descrição do produto.
     *
     * @param descricao
     */
    public void setDescricao(String descricao) {
    }
}
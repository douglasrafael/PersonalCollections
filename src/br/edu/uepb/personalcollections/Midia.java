package br.edu.uepb.personalcollections;

import br.edu.uepb.personalcollections.enums.Estado;
import br.edu.uepb.personalcollections.enums.TipoItem;

/**
 * Representa uma mídia (DVD, CD, Blu-Ray...)
 *
 * @author Douglas Rafael
 *
 */
public class Midia extends Item {
    private static final long serialVersionUID = -2497614711449537086L;

    private String marca;
    private String conteudo;
    private boolean assistido;

    /**
     * Método construtor.
     * Para o id é utilizado o auto_increment da class mãe.
     *
     * @param titulo O título
     * @param observacao As observações
     * @param dataDeCompra A data de compra
     * @param precoDeCompra O preço que foi pago
     * @param totalEmprestado O total de vezes que o item foi emprestado
     * @param nota A nota do item
     * @param estado O estado em que o item se encontra
     * @param emprestado Se o item encontra-se emprestado (true), caso contrário (false)
     * @param marca A marca
     * @param conteudo O conteúdo
     * @param assistido Se assitido (true), caso contrário (false)
     */
    public Midia(String titulo, String observacao, String dataDeCompra, double precoDeCompra, int totalEmprestado, double nota, Estado estado, boolean emprestado, String marca, String conteudo, boolean assistido) {
        super(titulo, observacao, dataDeCompra, precoDeCompra, totalEmprestado, nota, estado, emprestado, TipoItem.MIDIA);
        this.marca = marca;
        this.conteudo = conteudo;
        this.assistido = assistido;
    }
    
    /**
     * Construtor que recebe o id.
     * Não é utilizado o auto_increment para o id
     * 
     * @param id O id
     * @param titulo O título
     * @param observacao As observações
     * @param dataDeCompra A data de compra
     * @param precoDeCompra O preço que foi pago
     * @param totalEmprestado O total de vezes que o item foi emprestado
     * @param nota A nota do item
     * @param estado O estado em que o item se encontra
     * @param emprestado Se o item encontra-se emprestado (true), caso contrário (false)
     * @param marca A marca
     * @param conteudo O conteúdo
     * @param assistido Se assitido (true), caso contrário (false)
     */
    public Midia(int id , String titulo, String observacao, String dataDeCompra, double precoDeCompra, int totalEmprestado, double nota, Estado estado, boolean emprestado, String marca, String conteudo, boolean assistido) {
        super(id, titulo, observacao, dataDeCompra, precoDeCompra, totalEmprestado, nota, estado, emprestado, TipoItem.MIDIA);
        this.marca = marca;
        this.conteudo = conteudo;
        this.assistido = assistido;
    }

    /**
     * Recupera a marca da mídia
     *
     * @return A marca da mídia
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Seta a marca da mídia.
     *
     * @param marca A marca
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Recupera o conteúdo da mídia.
     *
     * @return O conteúdo da mídia
     */
    public String getConteudo() {
        return conteudo;
    }

    /**
     * Seta o conteúdo da mídia.
     *
     * @param conteudo O conteúdo
     */
    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    /**
     * Recupera o status da mídia: true se já foi assistido e false se não.
     *
     * @return O status da mídia
     */
    public boolean isAssistido() {
        return assistido;
    }

    /**
     * Seta o status da mídia: true se já foi assistido e false se não.
     *
     * @param assistido true ou false
     */
    public void setAssistido(boolean assistido) {
        this.assistido = assistido;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Midia)) {
            return false;
        } else {
            Midia outroMidia = (Midia) o;
            return getId() == outroMidia.getId();
        }
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nMarca: " + getMarca()
                + "\nConteúdo: " + getConteudo()
                + "\nJá foi assistido? " + isAssistido();
    }
}

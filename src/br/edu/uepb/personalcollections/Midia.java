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

    private String marca;
    private String conteudo;
    private boolean assistido;

    /**
     * Método construtor.
     *
     * @param titulo
     * @param observacao
     * @param dataDeCompra
     * @param precoDeCompra
     * @param totalEmprestado
     * @param nota
     * @param estado
     * @param emprestado
     * @param marca
     * @param conteudo
     * @param assistido
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
     * @param id
     * @param titulo
     * @param observacao
     * @param dataDeCompra
     * @param precoDeCompra
     * @param totalEmprestado
     * @param nota
     * @param estado
     * @param emprestado
     * @param marca
     * @param conteudo
     * @param assistido 
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
     * @param marca
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
     * @param conteudo
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
     * @param assistido
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

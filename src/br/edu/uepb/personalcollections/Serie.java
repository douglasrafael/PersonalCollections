package br.edu.uepb.personalcollections;

import java.util.List;
import java.io.Serializable;

/**
 * Representa o cadastro de séries.
 *
 * @author Douglas Rafael
 */
public class Serie implements Comparable<Serie>, Serializable {

    private static final long serialVersionUID = 4028397478239954676L;

    private static int auto_increment = 0;
    private int id;
    private String titulo;
    private List<Item> itens;

    /**
     * Construtor com id
     *
     * @param id
     * @param titulo
     * @param itens
     */
    public Serie(int id, String titulo, List<Item> itens) {
        this.id = id;
        this.titulo = titulo;
        this.itens = itens;
    }

    /**
     * Construtor sem id.
     *
     * @param titulo
     * @param itens
     */
    public Serie(String titulo, List<Item> itens) {
        this.id = ++auto_increment;
        this.titulo = titulo;
        this.itens = itens;
    }

    /**
     * recupera o id da serie
     *
     * @return <code>int</code> Id da série
     */
    public int getId() {
        return id;
    }

    /**
     * Seta o id da série
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Recupera o valor atual do auto_increment.
     *
     * @return <code>int</code> Valor do auto_increment
     */
    public static int getAuto_increment() {
        return auto_increment;
    }

    /**
     * Seta o valor inicial do auto_increment.
     *
     * @param auto_increment O valor a ser setado
     */
    public static void setAuto_increment(int auto_increment) {
        Serie.auto_increment = auto_increment;
    }

    /**
     * Recupera o título da série.
     *
     * @return <code>String</code> Título da série
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Seta o título da série.
     *
     * @param nome
     */
    public void setTitulo(String nome) {
        this.titulo = nome;
    }

    /**
     * Recupera a lista de itens que é da série
     *
     * @return <code>List</code> Lista dos itens que são da série
     */
    public List<Item> getItens() {
        return itens;
    }

    /**
     * Seta a lista de itens da série.
     *
     * @param itens
     */
    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    /**
     * Retorna o total de itens cadastrados na serie
     *
     * @return <code>int</code> Total de itens
     */
    public int getTotalItens() {
        return getItens().size();
    }

    /**
     * Retorna uma string com todos os itens separados por virgula
     *
     * @return String de itens
     */
    public String getStringItens() {
        String str_itens = "";
        for (Item item : getItens()) {
            str_itens += ", " + item.getTitulo();
        }
        if (str_itens.length() > 0 && str_itens.substring(0, 1).equals(",")) {
            str_itens = str_itens.substring(2, str_itens.length());
        }
        return str_itens;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Serie)) {
            return false;
        } else {
            Serie e = (Serie) o;
            return e.getId() == getId();
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + this.id;
        return hash;
    }

    @Override
    public String toString() {
        return getId() + "\n"
                + getTitulo() + "\n"
                + getItens();
    }

    @Override
    public int compareTo(Serie outro) {
        if (getId() < outro.getId()) {
            return 1;
        } else if (getId() > outro.getId()) {
            return -1;
        } else {
            return 0;
        }
    }
}

package br.edu.uepb.personalcollections;

import java.io.Serializable;
import java.util.Objects;

/**
 * Representa WishList (Lista de Desejos).
 *
 * @author Douglas Rafael
 */
public class ListaDeDesejo implements Comparable<ListaDeDesejo>, Serializable {

    private static final long serialVersionUID = -6700884717790127804L;

    private static int auto_increment = 0;
    private int id;
    private String dataDeLancamento;
    private String urlDeCompra;
    private Item item;

    /**
     * Método construtor que recebe o id como parametro, não uso o
     * auto_increment.
     *
     * @param id O id
     * @param dataDeLancamento A data de lançamento
     * @param urlDeCompra A url
     * @param item O item
     */
    public ListaDeDesejo(int id, String dataDeLancamento, String urlDeCompra, Item item) {
        this.id = id;
        this.dataDeLancamento = dataDeLancamento;
        this.urlDeCompra = urlDeCompra;
        this.item = item;
    }

    /**
     * Método construtor que não recebe o id como parametro, utiliza o
     * auto_increment.
     *
     * @param dataDeLancamento A data de lançamento
     * @param urlDeCompra A url
     * @param item O item
     */
    public ListaDeDesejo(String dataDeLancamento, String urlDeCompra, Item item) {
        this.dataDeLancamento = dataDeLancamento;
        this.urlDeCompra = urlDeCompra;
        this.item = item;
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
        ListaDeDesejo.auto_increment = auto_increment;
    }

    /**
     * Recupera o id da lista de desejo.
     *
     * @return <code>int</code> Id da Lista de Desejo
     */
    public int getId() {
        return id;
    }

    /**
     * Seta o id da lista de desejo.
     *
     * @param id O id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Recupera a data de lançamento do item da lista de desejo.
     *
     * @return <code>String</code> A data de lançamento do item da lista de
     * desejo.
     */
    public String getDataDeLancamento() {
        return dataDeLancamento;
    }

    /**
     * Seta a data de lançamento do item a ser cadastrado na lista de desejo.
     *
     * @param dataDeLancamento A data de lançamento
     */
    public void setDataDeLancamento(String dataDeLancamento) {
        this.dataDeLancamento = dataDeLancamento;
    }

    /**
     * Recupera a url de compra do item cadastrado na lista de desejo.
     *
     * @return <code>String</code> A url de compra do item.
     */
    public String getUrlDeCompra() {
        return urlDeCompra;
    }

    /**
     * Seta a url de compra o item da lista de desejo.
     *
     * @param urlDeCompra url para compra
     */
    public void setUrlDeCompra(String urlDeCompra) {
        this.urlDeCompra = urlDeCompra;
    }

    /**
     * Recupera o item da lista de desejo.
     *
     * @return <code>Item</code> Item da lista de desejo
     */
    public Item getItem() {
        return item;
    }

    /**
     * Seta o item na lista de desejo.
     *
     * @param item O item
     */
    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ListaDeDesejo)) {
            return false;
        } else {
            ListaDeDesejo outro = (ListaDeDesejo) o;
            return outro.getItem().getTitulo() == getItem().getTitulo();
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.item.getTitulo());
        return hash;
    }

    @Override
    public String toString() {
        return  getDataDeLancamento() + "\n"
                + getUrlDeCompra() + "\n"
                + getItem().getTitulo();
    }

    @Override
    public int compareTo(ListaDeDesejo outro) {
        if (getItem().getId() < outro.getItem().getId()) {
            return 1;
        } else if (getItem().getId() > outro.getItem().getId()) {
            return -1;
        } else {
            return 0;
        }
    }
}
package br.edu.uepb.personalcollections;

import java.io.Serializable;

/**
 * Representa um empréstimo de item.
 * 
 * @author Douglas Rafael
 */
public class Emprestimo implements Comparable<Emprestimo>, Serializable {

    private static final long serialVersionUID = 6083128787453657324L;

    private static int auto_increment = 0;
    private int id;
    private String dataEmprestimo;
    private String dataRetono;
    private boolean finalizado;
    private Item item;
    private Amigo amigo;

    /**
     * Método Construtor sem o id. É utilizado o auto_increment
     *
     * @param dataEmprestimo A data em que o empréstimo foi realizado
     * @param dataRetono A data que deverá ser finalizado
     * @param finalizado Se o emprestimo estar finalizado (true) caso contrário (false)
     * @param amigo O amigo que pegou o item emprestado
     * @param item O item emprestado
     */
    public Emprestimo(String dataEmprestimo, String dataRetono, boolean finalizado, Amigo amigo, Item item) {
        this.id = ++auto_increment;
        this.dataEmprestimo = dataEmprestimo;
        this.dataRetono = dataRetono;
        this.finalizado = finalizado;
        this.amigo = amigo;
        this.item = item;
    }

    /**
     * Construtor com id. Não utiliza o auto_increment
     *
     * @param id O id do empréstimo
     * @param dataEmprestimo A data em que o empréstimo foi realizado
     * @param dataRetono A data que deverá ser finalizado
     * @param finalizado Se o emprestimo estar finalizado (true) caso contrário (false)
     * @param amigo O amigo que pegou o item emprestado
     * @param item O item emprestado
     */
    public Emprestimo(int id, String dataEmprestimo, String dataRetono, boolean finalizado, Amigo amigo, Item item) {
        this.id = id;
        this.dataEmprestimo = dataEmprestimo;
        this.dataRetono = dataRetono;
        this.finalizado = finalizado;
        this.amigo = amigo;
        this.item = item;
    }

    /**
     * Recupera o valor atual do auto_increment.
     *
     * @return O valor do auto_increment
     */
    public static int getAuto_increment() {
        return auto_increment;
    }

    /**
     * Seta o valor inicial do auto_increment.
     *
     * @param auto_increment O valor do auto_increment
     */
    public static void setAuto_increment(int auto_increment) {
        Emprestimo.auto_increment = auto_increment;
    }

    /**
     * Recupera o id
     *
     * @return O id do empréstimo
     */
    public int getId() {
        return id;
    }

    /**
     * Seta o id
     *
     * @param id O id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Recupera a data em que o emprestimo foi realizado.
     *
     * @return A data do emprestimo
     */
    public String getDataEmprestimo() {
        return dataEmprestimo;
    }

    /**
     * Seta a data em que o emprestimo foi realizado
     *
     * @param dataEmprestimo A data emq ue foi realizado o empréstimo
     */
    public void setDataEmprestimo(String dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    /**
     * Recupera a data em que o item deve ser devolvido
     *
     * @return A Data de retorno
     */
    public String getDataRetono() {
        return dataRetono;
    }

    /**
     * Seta a data em que o item deverá ser devolvido
     *
     * @param dataRetono A data de retorno
     */
    public void setDataRetono(String dataRetono) {
        this.dataRetono = dataRetono;
    }

    /**
     * Recupera o item
     *
     * @return O Objeto item
     */
    public Item getItem() {
        return item;
    }

    /**
     * Seta o item
     *
     * @param item O item emprestado
     */
    public void setItem(Item item) {
        this.item = item;
    }

    /**
     * Recupera o amigo
     *
     * @return O objeto Amigo
     */
    public Amigo getAmigo() {
        return amigo;
    }

    /**
     * Seta o amigo
     *
     * @param amigo O amigo que realizou o emprestimo
     */
    public void setAmigo(Amigo amigo) {
        this.amigo = amigo;
    }

    /**
     * Recupera se o empréstimo está finalizado ou não.
     *
     * @return True para finalizado e False para não.
     */
    public boolean isFinalizado() {
        return finalizado;
    }

    /**
     * Seta se o estado do empréstimo como finalizado ou não. True para
     * finalizado e False para não.
     *
     * @param finalizado false ou true
     */
    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }

    /**
     * Retorna o status do emprestimo (ativo ou inativo)
     *
     * @return O status do emprestimo (Ativo ou Inativo)
     */
    public String getStatus() {
        return !isFinalizado() ? "Ativo" : "Finalizado";
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Emprestimo)) {
            return false;
        } else {
            Emprestimo emp = (Emprestimo) o;
            return getId() == emp.getId();
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.id;
        return hash;
    }

    @Override
    public String toString() {
        return "item: " + getItem()
                + "\nData do Empréstimo: " + getDataEmprestimo()
                + "\nData do Retorno: " + getDataRetono();
    }

    @Override
    public int compareTo(Emprestimo o) {
        if (this.getId() < o.getId()) {
            return 1;
        } else if (this.getId() > o.getId()) {
            return -1;
        } else {
            return 0;
        }
    }
}

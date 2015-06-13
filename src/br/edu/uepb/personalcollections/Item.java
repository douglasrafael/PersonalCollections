package br.edu.uepb.personalcollections;

import br.edu.uepb.personalcollections.enums.Estado;
import br.edu.uepb.personalcollections.enums.TipoItem;
import java.io.Serializable;

/**
 * Representa um item
 *
 * @author Douglas Rafael
 *
 */
public class Item implements Comparable<Item>, Serializable {

    private static final long serialVersionUID = 6228383725592637006L;
    
    private static int auto_increment = 0;

    private int id;
    private String titulo;
    private String observacao;
    private String dataDeCompra;
    private double precoDeCompra;
    private double nota;
    private int totalEmprestado;
    private Estado estado;
    private boolean emprestado;
    private TipoItem tipo;
    private boolean possui;

    /**
     * Método construtor da classe.
     *
     * @param titulo
     * @param observacao
     * @param dataDeCompra
     * @param precoDeCompra
     * @param totalEmprestado
     * @param nota
     * @param estado
     * @param emprestado
     * @param tipo
     */
    public Item(String titulo, String observacao, String dataDeCompra, double precoDeCompra, int totalEmprestado, double nota, Estado estado, boolean emprestado, TipoItem tipo) {
        this.id = ++auto_increment;
        this.titulo = titulo;
        this.observacao = observacao;
        this.dataDeCompra = dataDeCompra;
        this.precoDeCompra = precoDeCompra;
        this.nota = nota;
        this.totalEmprestado = totalEmprestado;
        this.estado = estado;
        this.emprestado = emprestado;
        this.tipo = tipo;
        this.possui = true;
    }

    /**
     * Método construtor que recebe o id como parametro, não uso o
     * auto_increment.
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
     * @param tipo
     */
    public Item(int id, String titulo, String observacao, String dataDeCompra, double precoDeCompra, int totalEmprestado, double nota, Estado estado, boolean emprestado, TipoItem tipo) {
        this.id = id;
        this.titulo = titulo;
        this.observacao = observacao;
        this.dataDeCompra = dataDeCompra;
        this.precoDeCompra = precoDeCompra;
        this.nota = nota;
        this.totalEmprestado = totalEmprestado;
        this.estado = estado;
        this.emprestado = emprestado;
        this.tipo = tipo;
        this.possui = true;
    }

    /**
     * Recupera o valor atual do auto_increment.
     *
     * @return Valor do auto_increment
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
        Item.auto_increment = auto_increment;
    }

    /**
     * Recupera o título do item.
     *
     * @return O título do item
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Seta o título do item.
     *
     * @param titulo
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Recupera a observação do item.
     *
     * @return A observação do item
     */
    public String getObservacao() {
        return observacao;
    }

    /**
     * Seta a observação do item.
     *
     * @param observacao
     */
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    /**
     * Recupera a data que o item foi comprado.
     *
     * @return A data de compra do item.
     */
    public String getDataDeCompra() {
        return dataDeCompra;
    }

    /**
     * Seta a data em que o item foi comprado.
     *
     * @param dataDeCompra
     */
    public void setDataDeCompra(String dataDeCompra) {
        this.dataDeCompra = dataDeCompra;
    }

    /**
     * Recupera o preço de compra do item.
     *
     * @return
     */
    public double getPrecoDeCompra() {
        return precoDeCompra;
    }

    /**
     * Seta o preço pago pela compra do item.
     *
     * @param precoDeCompra
     */
    public void setPrecoDeCompra(double precoDeCompra) {
        this.precoDeCompra = precoDeCompra;
    }

    /**
     * Recupera o total de vezes que o item foi emprestado.
     *
     * @return O total de empréstimos
     */
    public int getTotalEmprestado() {
        return totalEmprestado;
    }

    /**
     * Incrementa em 1 o total de vezes que o item foi emprestado.
     */
    public void setTotalEmprestado() {
        this.totalEmprestado += 1;
    }

    /**
     * Decrementa em 1 o total de vezes que o item foi emprestado.
     */
    public void decrementaTotalEmprestado() {
        this.totalEmprestado -= 1;
    }

    /**
     * Recupera a nota atribuída ao item.
     *
     * @return A nota do item
     */
    public double getNota() {
        return nota;
    }

    /**
     * Atribui um anota ao item.
     *
     * @param nota
     */
    public void setNota(double nota) {
        this.nota = nota;
    }

    /**
     * Recupera o Estado (novo, rasurado, defeituoso, quebrado...) do item.
     *
     * @return O Estado do item
     */
    public Estado getEstado() {
        return estado;
    }

    /**
     * Seta o Estado (novo, rasurado, defeituoso, quebrado...) do item.
     *
     * @param estado
     */
    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    /**
     * Recupera o status do item: true se estiver emprestado e false se não;
     *
     * @return O status do item.
     */
    public boolean isEmprestado() {
        return emprestado;
    }

    /**
     * Retorna em string se o item estar emprestado ou não.
     *
     * @return Sim ou Não
     */
    public String getStringEmprestado() {
        return isEmprestado() ? "Sim" : "Não";
    }

    /**
     * Seta o status do item: true se estiver emprestado e false se não;
     *
     * @param emprestado
     */
    public void setEmprestado(boolean emprestado) {
        this.emprestado = emprestado;
    }

    /**
     * Recupera o id
     *
     * @return O id
     */
    public int getId() {
        return id;
    }

    /**
     * Seta o id
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Recupera o Tipo de item.
     *
     * @return O tipo de item
     */
    public TipoItem getTipo() {
        return tipo;
    }

    /**
     * Seta o tipo de item.
     *
     * @param tipo o tipo de item
     */
    public void setTipo(TipoItem tipo) {
        this.tipo = tipo;
    }

    /**
     * Verifica se o item estar contido no acervo.
     * 
     * @return <code>true</code> se o item estiver no acervo pessoal ou <code>false</code> caso contrário.
     */
    public boolean isPossui() {
        return possui;
    }

    /**
     * Seta se o item estar no acerto ou não.
     * 
     * @param possui 
     */
    public void setPossui(boolean possui) {
        this.possui = possui;
    }
    
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Item)) {
            return false;
        } else {
            Item outroItem = (Item) o;
            return getId() == outroItem.getId();
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id;
        return hash;
    }

    @Override
    public int compareTo(Item outro) {
        if (this.getId() < outro.getId()) {
            return 1;
        } else if (this.getId() > outro.getId()) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Id: " + getId()
                + "\nTítulo: " + getTitulo()
                + "\nOBS.: " + getObservacao()
                + "\nEstado: " + getEstado().getTitulo()
                + "\nData da compra: " + getDataDeCompra()
                + "\nPreço de Compra: " + getPrecoDeCompra()
                + "\nNota: " + getNota()
                + "\nTotal de Empréstimos: " + getTotalEmprestado()
                + "\nEstá emprestado? " + isEmprestado();
    }
}

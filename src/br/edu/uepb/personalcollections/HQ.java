package br.edu.uepb.personalcollections;

import br.edu.uepb.personalcollections.enums.Estado;
import br.edu.uepb.personalcollections.enums.TipoItem;

/**
 * Representa uma HQ
 *
 * @author Douglas Rafael
 *
 */
public class HQ extends Item {

    private static final long serialVersionUID = 5886700636491703531L;

    private int numero;
    private String editora;
    private String saga;
    private String universo;
    private boolean lido;

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
     * @param tipo
     * @param numero
     * @param editora
     * @param saga
     * @param universo
     * @param lido
     */
    public HQ(String titulo, String observacao, String dataDeCompra, double precoDeCompra, int totalEmprestado, double nota, Estado estado, boolean emprestado, TipoItem tipo, int numero, String editora, String saga, String universo, boolean lido) {
        super(titulo, observacao, dataDeCompra, precoDeCompra, totalEmprestado, nota, estado, emprestado, tipo);
        this.numero = numero;
        this.editora = editora;
        this.saga = saga;
        this.universo = universo;
        this.lido = lido;
    }

    /**
     * Costrutor que recebe também o id como parametro. Não usa o auto_icrement
     * para o id
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
     * @param numero
     * @param editora
     * @param saga
     * @param universo
     * @param lido
     */
    public HQ(int id, String titulo, String observacao, String dataDeCompra, double precoDeCompra, int totalEmprestado, double nota, Estado estado, boolean emprestado, TipoItem tipo, int numero, String editora, String saga, String universo, boolean lido) {
        super(id, titulo, observacao, dataDeCompra, precoDeCompra, totalEmprestado, nota, estado, emprestado, tipo);
        this.numero = numero;
        this.editora = editora;
        this.saga = saga;
        this.universo = universo;
        this.lido = lido;
    }

    /**
     * Recupera o nome da HQ.
     *
     * @return O nome da HQ
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Seta o nome da HQ.
     *
     * @param numero
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * Recupera a editora da HQ.
     *
     * @return A editora da HQ
     */
    public String getEditora() {
        return editora;
    }

    /**
     * Seta a editora da HQ.
     *
     * @param editora
     */
    public void setEditora(String editora) {
        this.editora = editora;
    }

    /**
     * Recupera a saga da HQ.
     *
     * @return A saga da HQ
     */
    public String getSaga() {
        return saga;
    }

    /**
     * Seta a saga da HQ.
     *
     * @param saga
     */
    public void setSaga(String saga) {
        this.saga = saga;
    }

    /**
     * Recupera o universo da HQ.
     *
     * @return A saga
     */
    public String getUniverso() {
        return universo;
    }

    /**
     * Seta o universo da HQ.
     *
     * @param universo
     */
    public void setUniverso(String universo) {
        this.universo = universo;
    }

    /**
     * Recupera se a HQ foi lida ou não: true se foi lida e false se não.
     *
     * @return Se a HQ foi lida ou não
     */
    public boolean isLido() {
        return lido;
    }

    /**
     * Seta o status de leitura da HQ: true se foi lida e false se não.
     *
     * @param lido
     */
    public void setLido(boolean lido) {
        this.lido = lido;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof HQ)) {
            return false;
        } else {
            HQ outroHQ = (HQ) o;
            return getId() == outroHQ.getId();
        }
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nNúmero: " + getNumero()
                + "\nEditora: " + getEditora()
                + "\nSaga: " + getSaga()
                + "\nJá foi lido? " + isLido();
    }
}

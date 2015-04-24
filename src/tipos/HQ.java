package tipos;

import enums.Estado;
import enums.TipoItem;

/**
 * Representa uma HQ
 *
 * @author Douglas Rafael
 *
 */
public class HQ extends Item {

    private int numero;
    private String editora;
    private String saga;
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
     * @param lido
     */
    public HQ(String titulo, String observacao, String dataDeCompra, double precoDeCompra, int totalEmprestado, double nota, Estado estado, boolean emprestado, TipoItem tipo, int numero, String editora, String saga, boolean lido) {
        super(titulo, observacao, dataDeCompra, precoDeCompra, totalEmprestado, nota, estado, emprestado, tipo);
        this.numero = numero;
        this.editora = editora;
        this.saga = saga;
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

package br.edu.uepb.personalcollections;

import br.edu.uepb.personalcollections.enums.Estado;
import br.edu.uepb.personalcollections.enums.TipoItem;

/**
 * Representa um jogo de tabuleiro.
 *
 * @author Douglas Rafael
 *
 */
public class Tabuleiro extends Item {

    private static final long serialVersionUID = -7898727857937184320L;

    /**
     * Método construtor.
     * Para o id é utilizado o auto_increment da super classe.
     *
     * @param titulo O título do item
     * @param observacao As observações
     * @param dataDeCompra A data em que foi realizada a compra
     * @param precoDeCompra O preço pago pelo item
     * @param totalEmprestado O total de vez que o item foi emprestado
     * @param nota A nota
     * @param estado O estado que se encontra
     * @param emprestado Se estar emprestado (true), caso contrário (false)
     */
    public Tabuleiro(String titulo, String observacao, String dataDeCompra, double precoDeCompra, int totalEmprestado, double nota, Estado estado, boolean emprestado) {
        super(titulo, observacao, dataDeCompra, precoDeCompra, totalEmprestado, nota, estado, emprestado, TipoItem.JOGOTABULEIRO);
    }

    /**
     * Construtor que recebe o id como parametro.
     *
     * @param id o id
     * @param titulo O título do item
     * @param observacao As observações
     * @param dataDeCompra A data em que foi realizada a compra
     * @param precoDeCompra O preço pago pelo item
     * @param totalEmprestado O total de vez que o item foi emprestado
     * @param nota A nota
     * @param estado O estado que se encontra
     * @param emprestado Se estar emprestado (true), caso contrário (false)
     */
    public Tabuleiro(int id, String titulo, String observacao, String dataDeCompra, double precoDeCompra, int totalEmprestado, double nota, Estado estado, boolean emprestado) {
        super(id, titulo, observacao, dataDeCompra, precoDeCompra, totalEmprestado, nota, estado, emprestado, TipoItem.JOGOTABULEIRO);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Tabuleiro)) {
            return false;
        } else {
            Tabuleiro outroT = (Tabuleiro) o;
            return getId() == outroT.getId();
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }
}

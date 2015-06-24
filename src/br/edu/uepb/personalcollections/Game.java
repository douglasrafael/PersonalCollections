package br.edu.uepb.personalcollections;

import java.util.ArrayList;
import java.util.List;

import br.edu.uepb.personalcollections.enums.Console;
import br.edu.uepb.personalcollections.enums.Estado;
import br.edu.uepb.personalcollections.enums.TipoItem;

/**
 * Representa jogos de vídeo game
 *
 * @author Douglas Rafael
 *
 */
public class Game extends Item {

    private static final long serialVersionUID = -5611502416819270867L;
    
    private Console console;
    private boolean zerado;
    private boolean possuiDLC;
    private List<DLC> DLCs;

    /**
     * Método construtor usado para Game que possuí DLC's.
     * Para o id é utilizado o auto-increment.
     *
     * @param titulo O título
     * @param observacao As observações
     * @param dataDeCompra A data de compra
     * @param precoDeCompra O preço que foi pago
     * @param totalEmprestado O total de vezes que o item foi emprestado
     * @param nota A nota do item
     * @param estado O estado em que o item se encontra
     * @param emprestado Se o item encontra-se emprestado (true), caso contrário (false)
     * @param console o console, plataforma do game
     * @param zerado Se foi zerado (true) se não (false)
     * @param possuiDLC Se o game possui DLC (true), caso contrário (false)
     * @param dlcs Lista de DLC, caso o game possua
     */
    public Game(String titulo, String observacao, String dataDeCompra, double precoDeCompra, int totalEmprestado, double nota, Estado estado, boolean emprestado, Console console, boolean zerado, boolean possuiDLC, List<DLC> dlcs) {
        super(titulo, observacao, dataDeCompra, precoDeCompra, totalEmprestado, nota, estado, emprestado, TipoItem.JOGOVIDEOGAME);
        this.console = console;
        this.zerado = zerado;
        this.possuiDLC = possuiDLC;
        this.DLCs = dlcs;
    }

    /**
     * Método construtor com id e que possue DLC's. Não utiliza o auto_increment
     * para o id.
     *
     * @param id Id do game
     * @param titulo O título
     * @param observacao As observações
     * @param dataDeCompra A data de compra
     * @param precoDeCompra O preço que foi pago
     * @param totalEmprestado O total de vezes que o item foi emprestado
     * @param nota A nota do item
     * @param estado O estado em que o item se encontra
     * @param emprestado Se o item encontra-se emprestado (true), caso contrário (false)
     * @param console o console, plataforma do game
     * @param zerado Se foi zerado (true) se não (false)
     * @param possuiDLC Se o game possui DLC (true), caso contrário (false)
     * @param dlcs Lista de DLC, caso o game possua
     */
    public Game(int id, String titulo, String observacao, String dataDeCompra, double precoDeCompra, int totalEmprestado, double nota, Estado estado, boolean emprestado, Console console, boolean zerado, boolean possuiDLC, List<DLC> dlcs) {
        super(id, titulo, observacao, dataDeCompra, precoDeCompra, totalEmprestado, nota, estado, emprestado, TipoItem.JOGOVIDEOGAME);
        this.console = console;
        this.zerado = zerado;
        this.possuiDLC = possuiDLC;
        this.DLCs = dlcs;
    }

    /**
     * Construtor usado para Game que não possui DLC.
     * Para o id é utilizado o auto-increment.
     *
     * @param titulo O título
     * @param observacao As observações
     * @param dataDeCompra A data de compra
     * @param precoDeCompra O preço que foi pago
     * @param totalEmprestado O total de vezes que o item foi emprestado
     * @param nota A nota do item
     * @param estado O estado em que o item se encontra
     * @param emprestado Se o item encontra-se emprestado (true), caso contrário (false)
     * @param console o console, plataforma do game
     * @param zerado Se foi zerado (true) se não (false)
     */
    public Game(String titulo, String observacao, String dataDeCompra, double precoDeCompra, int totalEmprestado, double nota, Estado estado, boolean emprestado, Console console, boolean zerado) {
        super(titulo, observacao, dataDeCompra, precoDeCompra, totalEmprestado, nota, estado, emprestado, TipoItem.JOGOVIDEOGAME);
        this.console = console;
        this.zerado = zerado;
        this.possuiDLC = false;
        List<DLC> semDLCs = new ArrayList<>();
        this.DLCs = semDLCs;
    }

    /**
     * Método construtor com id e que não possui DLC's. Não utiliza o
     * auto_increment para o id.
     *
     * @param id Id do game
     * @param titulo O título
     * @param observacao As observações
     * @param dataDeCompra A data de compra
     * @param precoDeCompra O preço que foi pago
     * @param totalEmprestado O total de vezes que o item foi emprestado
     * @param nota A nota do item
     * @param estado O estado em que o item se encontra
     * @param emprestado Se o item encontra-se emprestado (true), caso contrário (false)
     * @param console o console, plataforma do game
     * @param zerado Se foi zerado (true) se não (false)
     */
    public Game(int id, String titulo, String observacao, String dataDeCompra, double precoDeCompra, int totalEmprestado, double nota, Estado estado, boolean emprestado, Console console, boolean zerado) {
        super(id, titulo, observacao, dataDeCompra, precoDeCompra, totalEmprestado, nota, estado, emprestado, TipoItem.JOGOVIDEOGAME);
        this.console = console;
        this.zerado = zerado;
        this.possuiDLC = false;
        List<DLC> semDLCs = new ArrayList<>();
        this.DLCs = semDLCs;
    }

    /**
     * Recupera o console do game.
     *
     * @return Console do game
     */
    public Console getConsole() {
        return console;
    }

    /**
     * Seta o console do game.
     *
     * @param console O console
     */
    public void setConsole(Console console) {
        this.console = console;
    }

    /**
     * Verifica se o jogo possui DLC's: true se possuir e false se não.
     *
     * @return Se possui DLC's
     */
    public boolean isDLC() {
        return possuiDLC;
    }

    /**
     * Seta se o jogo possui DLC's: true se possuir e false se não.
     *
     * @param possuiDLC Se possui DLC ou não
     */
    public void setPossuiDLC(boolean possuiDLC) {
        this.possuiDLC = possuiDLC;
    }

    /**
     * Recupera o status do jogo se foi zerado ou não: true se foi zerado e
     * false se não.
     *
     * @return Se o jogo foi zerado ou não
     */
    public boolean isZerado() {
        return zerado;
    }

    /**
     * Seta se o jogo foi zerado ou não: true se foi zerado e false se não.
     *
     * @param zerado Se foi zerado ou nao
     */
    public void setZerado(boolean zerado) {
        this.zerado = zerado;
    }

    /**
     * Recupera lista de DLC's do Game
     *
     * @return Lista dos DLC's
     */
    public List<DLC> getDLCs() {
        return DLCs;
    }

    /**
     * Seta os DLC's do Game.
     *
     * @param dlcs Lista de DLC's
     */
    public void setDLCs(List<DLC> dlcs) {
        DLCs = dlcs;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Game)) {
            return false;
        }
        Game outroGame = (Game) o;
        return getId() == outroGame.getId();
    }

    @Override
    public String toString() {
        String complemento = "";
        if (isDLC()) {
            complemento = "\nDLC's: " + getDLCs().toString();
        }

        return super.toString()
                + "\nConsole: " + getConsole().getNome()
                + "\nFoi Zerado? " + isZerado()
                + "\nPossui DLC's? " + isDLC()
                + complemento;
    }
}

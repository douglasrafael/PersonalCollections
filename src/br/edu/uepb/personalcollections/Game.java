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

    private Console console;
    private boolean zerado;
    private boolean possuiDLC;
    private List<DLC> DLCs;

    /**
     * Método construtor usado para Game que possuí DLC's.
     *
     * @param titulo
     * @param observacao
     * @param dataDeCompra
     * @param precoDeCompra
     * @param totalEmprestado
     * @param nota
     * @param estado
     * @param emprestado
     * @param console
     * @param zerado
     * @param possuiDLC
     * @param dlcs
     */
    public Game(String titulo, String observacao, String dataDeCompra, double precoDeCompra, int totalEmprestado, double nota, Estado estado, boolean emprestado, Console console, boolean zerado, boolean possuiDLC, List<DLC> dlcs) {
        super(titulo, observacao, dataDeCompra, precoDeCompra, totalEmprestado, nota, estado, emprestado, TipoItem.JOGOVIDEOGAME);
        this.console = console;
        this.zerado = zerado;
        this.possuiDLC = possuiDLC;
        this.DLCs = dlcs;
    }
    
    /**
     * Método construtor com id e que possue DLC's. 
     * Não utiliza o auto_increment para o id.
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
     * @param console
     * @param zerado
     * @param possuiDLC
     * @param dlcs 
     */
    public Game(int id, String titulo, String observacao, String dataDeCompra, double precoDeCompra, int totalEmprestado, double nota, Estado estado, boolean emprestado, Console console, boolean zerado, boolean possuiDLC, List<DLC> dlcs) {
        super(id, titulo, observacao, dataDeCompra, precoDeCompra, totalEmprestado, nota, estado, emprestado, TipoItem.JOGOVIDEOGAME);
        this.console = console;
        this.zerado = zerado;
        this.possuiDLC = possuiDLC;
        this.DLCs = dlcs;
    }

    /**
     * Construtor usado para Game que não possui DLC
     *
     * @param titulo
     * @param observacao
     * @param dataDeCompra
     * @param precoDeCompra
     * @param totalEmprestado
     * @param nota
     * @param estado
     * @param emprestado
     * @param console
     * @param zerado
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
     * Método construtor com id e que não possui DLC's. 
     * Não utiliza o auto_increment para o id.
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
     * @param console
     * @param zerado 
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
     * @param console
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
     * @param possuiDLC
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
     * @param zerado
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

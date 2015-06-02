package br.edu.uepb.personalcollections.enums;

/**
 * Representa os filtros disponíveis para refinação de pesquisa por item
 *
 * @author Douglas Rafael
 */
public enum FiltroItem {

    /**
     * Filtros
     */
    TITULO("Título"), ESTADO("Estado"), HQTITULO("HQ - Título"), MIDIATITULO("Mídia - Título"), GAMETITULO("Jogo de Videogame - Título"), TABULEIROTITULO("Jogo de Tabuleiro - Título"), HQESTADO("HQ - Estado"), MIDIAESTADO("Mídia - Estado"), GAMEESTADO("Jogo de Videogame - Estado"), TABULEIROESTADO("Jogo de Tabuleiro - Estado"),
    HQEDITORA("HQ - Editora"), HQUNIVERSO("HQ - Universo"), GAMEDLC("Jogo de Videogame - DLC");

    private String titulo;

    FiltroItem(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Recupera o título do filtro.
     *
     * @return
     */
    public String getTitulo() {
        return titulo;
    }

    @Override
    public String toString() {
        return getTitulo();
    }
}

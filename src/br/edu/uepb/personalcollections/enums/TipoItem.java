package br.edu.uepb.personalcollections.enums;

/**
 * Representa os tipos de items que podem ser cadastrados
 *
 * @author Douglas Rafael
 *
 */
public enum TipoItem {

    HQ("HQ"), MIDIA("DVD/CD/Blu-Ray..."), JOGOVIDEOGAME("Jogo de Videogame"), JOGOTABULEIRO("Jogo de Tabuleiro");

    private String titulo;

    /**
     * Método construtor.
     *
     * @param titulo
     */
    private TipoItem(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Recupera o título do enum
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

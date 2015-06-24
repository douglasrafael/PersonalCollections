package br.edu.uepb.personalcollections.enums;

/**
 * Representa a localização de onde DLCs se encontra
 *
 * @author Douglas Rafael
 *
 */
public enum LocalizacaoDLC {

    LIVE("Live"), PSN("PSN"), STEAM("Steam"), ORIGIN("Origin"), DISCO("Disco");

    private String nome;

    /**
     * Método Construtor
     *
     * @param nome O nome
     */
    LocalizacaoDLC(String nome) {
        this.nome = nome;
    }

    /**
     * Recupera o nome do local onde o DLC se encontra.
     *
     * @return O nome do local onde o DLC se encontra
     */
    public String getNome() {
        return nome;
    }
    
    @Override
    public String toString() {
        return getNome();
    }
}

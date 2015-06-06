package br.edu.uepb.personalcollections;

import br.edu.uepb.personalcollections.enums.LocalizacaoDLC;
import java.io.Serializable;
import java.util.Objects;

/**
 * Representa um DLC de game
 *
 * @author Douglas Rafael
 *
 */
public class DLC implements Serializable {

    private static final long serialVersionUID = -424713358112129380L;

    private String titulo;
    private LocalizacaoDLC localizacao;

    /**
     * Método construtor
     *
     * @param titulo
     * @param localizacao
     */
    public DLC(String titulo, LocalizacaoDLC localizacao) {
        this.titulo = titulo;
        this.localizacao = localizacao;
    }

    /**
     * Recupera o título do DLC
     *
     * @return O título do DLC
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Seta o título do DLC
     *
     * @param titulo O título do DLC
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Recupera a localização do DLC
     *
     * @return A localuzação do DLC
     */
    public LocalizacaoDLC getLocalizacao() {
        return localizacao;
    }

    /**
     * Seta a localização do DLC
     *
     * @param localizacao A localização do DLC
     */
    public void setLocalizacao(LocalizacaoDLC localizacao) {
        this.localizacao = localizacao;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof DLC)) {
            return false;
        } else {
            DLC outroDLC = (DLC) o;
            return outroDLC.getTitulo().equals(getTitulo()) && getLocalizacao() == outroDLC.getLocalizacao();
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.titulo);
        hash = 47 * hash + Objects.hashCode(this.localizacao);
        return hash;
    }

    @Override
    public String toString() {
        return "\nTítulo: " + getTitulo() + ", Localização: " + getLocalizacao().getNome();
    }
}

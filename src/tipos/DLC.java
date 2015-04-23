package tipos;

import enums.LocalizacaoDLC;

/**
 * Representa um DLC de game
 *
 * @author Douglas Rafael
 *
 */
public class DLC {

    private String titulo;
    private LocalizacaoDLC localizacao;

    /**
     * Método construtor
     *
     * @param titulo
     * @param localizacao
     */
    public DLC(String titulo, LocalizacaoDLC localizacao) {
        super();
        setTitulo(titulo);
        setLocalizacao(localizacao);
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
    public String toString() {
        return "\nTítulo: " + getTitulo() + ", Localização: " + getLocalizacao().getNome();
    }
}

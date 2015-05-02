package enums;

/**
 * Reperesenta os estados dos items.
 *
 * @author Douglas Rafael
 *
 */
public enum Estado {

    NOVO("Novo"), RASURADO("Rasurado"), DESGATADO("Desgatado"), DEFEITUOSO("Com Defeito"), QUEBRADO("Quebrado");

    private final String titulo;

    /**
     * Método construtor.
     *
     * @param título
     */
    Estado(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Recupera o título do estado.
     *
     * @return O título do estado
     */
    public String getTitulo() {
        return titulo;
    }

    @Override
    public String toString() {
        return getTitulo();
    }
}

package tipos;

public class Emprestimo implements Comparable<Emprestimo> {

    private static int auto_increment = 0;
    private int id;
    private String dataEmprestimo;
    private String dataRetono;
    private Item item;
    private Amigo amigo;

    /**
     * Método Construtor.
     *
     * @param dataEmprestimo
     * @param dataRetono
     * @param amigo
     * @param item
     */
    public Emprestimo(String dataEmprestimo, String dataRetono, Amigo amigo, Item item) {
        this.id = ++auto_increment;
        this.dataEmprestimo = dataEmprestimo;
        this.dataRetono = dataRetono;
        this.amigo = amigo;
        this.item = item;
    }

    /**
     * Construtor com id. Não utiliza o auto_increment
     *
     * @param id
     * @param dataEmprestimo
     * @param dataRetono
     * @param amigo
     * @param item
     */
    public Emprestimo(int id, String dataEmprestimo, String dataRetono, Amigo amigo, Item item) {
        this.id = id;
        this.dataEmprestimo = dataEmprestimo;
        this.dataRetono = dataRetono;
        this.amigo = amigo;
        this.item = item;
    }

    /**
     * Recupera o valor do auto_increment
     *
     * @return
     */
    public static int getAuto_increment() {
        return auto_increment;
    }

    /**
     * Seta ++ p valor de auto_increment
     *
     * @param auto_increment
     */
    public static void setAuto_increment(int auto_increment) {
        Emprestimo.auto_increment++;
    }

    /**
     * Recupera o id
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * Seta o id
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Recupera a data em que o emprestimo foi realizado.
     *
     * @return A data do emprestimo
     */
    public String getDataEmprestimo() {
        return dataEmprestimo;
    }

    /**
     * Seta a data em que o emprestimo foi realizado
     *
     * @param dataEmprestimo
     */
    public void setDataEmprestimo(String dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    /**
     * Recupera a data em que o item deve ser devolvido
     *
     * @return A Data de retorno
     */
    public String getDataRetono() {
        return dataRetono;
    }

    /**
     * Seta a data em que o item deverá ser devolvido
     *
     * @param dataRetono
     */
    public void setDataRetono(String dataRetono) {
        this.dataRetono = dataRetono;
    }

    /**
     * Recupera o item
     *
     * @return O Objeto item
     */
    public Item getItem() {
        return item;
    }

    /**
     * Seta o item
     *
     * @param item
     */
    public void setItem(Item item) {
        this.item = item;
    }

    /**
     * Recupera o amigo
     *
     * @return O objeto Amigo
     */
    public Amigo getAmigo() {
        return amigo;
    }

    /**
     * Seta o amigo
     *
     * @param amigo
     */
    public void setAmigo(Amigo amigo) {
        this.amigo = amigo;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Emprestimo)) {
            return false;
        } else {
            Emprestimo emp = (Emprestimo) o;
            return getId() == emp.getId();
        }
    }

    @Override
    public String toString() {
        return "item: " + getItem()
                + "\nData do Empréstimo: " + getDataEmprestimo()
                + "\nData do Retorno: " + getDataRetono();
    }

    @Override
    public int compareTo(Emprestimo o) {
        if (this.getId() < o.getId()) {
            return 1;
        } else if (this.getId() > o.getId()) {
            return -1;
        } else {
            return 0;
        }
    }

}

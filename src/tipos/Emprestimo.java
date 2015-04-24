package tipos;

public class Emprestimo {

    private String dataEmprestimo;
    private String dataRetono;
    private Item item;

    
    /**
     * Método Construtor. 
     * 
     * @param dataEmprestimo
     * @param dataRetono
     * @param item 
     */
    public Emprestimo(String dataEmprestimo, String dataRetono, Item item) {
        this.dataEmprestimo = dataEmprestimo;
        this.dataRetono = dataRetono;
        this.item = item;
    }

    public String getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(String dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public String getDataRetono() {
        return dataRetono;
    }

    public void setDataRetono(String dataRetono) {
        this.dataRetono = dataRetono;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Emprestimo)) {
            return false;
        } else {
            Emprestimo emp = (Emprestimo) o;
            return emp.getItem() == getItem();
        }
    }

    @Override
    public String toString() {
        return "item: " + getItem().getTitulo()
                + "\nData do Empréstimo: " + getDataEmprestimo()
                + "\nData do Retorno: " + getDataRetono();
    }

}

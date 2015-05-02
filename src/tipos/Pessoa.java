package tipos;

/**
 * Representa uma pessoa.
 *
 * @author Douglas Rafael
 *
 */
public class Pessoa implements Comparable<Pessoa> {

    private static int auto_increment = 0;

    private int id;
    private String nome;
    private char sexo;

    /**
     * Método construtor.
     *
     * @param nome
     * @param sexo
     */
    public Pessoa(String nome, char sexo) {
        this.id = ++auto_increment;
        this.nome = nome;
        this.sexo = sexo;
    }

    /**
     * Construtor que não utiliza o auto_increment para id.
     *
     * @param id
     * @param nome
     * @param sexo
     */
    public Pessoa(int id, String nome, char sexo) {
        this.id = id;
        this.nome = nome;
        this.sexo = sexo;
    }

    /**
     * Recupera o nome da pessoa.
     *
     * @return O nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Seta o nome da pessoa.
     *
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Recupera o sexo da pessoa.
     *
     * @return O sexo
     */
    public char getSexo() {
        return sexo;
    }

    /**
     * Seta o sexo da pessoa.
     *
     * @param sexo
     */
    public void setSexo(char sexo) {
        this.sexo = sexo;
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
     * Seta o id usando o auto_increment
     *
     */
    public void setId() {
        ++auto_increment;
    }

    @Override
    public String toString() {
        return "Id: " + getId() + "\nNome: " + getNome() + "\nSexo: " + getSexo();
    }

    @Override
    public int compareTo(Pessoa outra) {
        if (this.getId() < outra.getId()) {
            return 1;
        } else if (this.getId() > outra.getId()) {
            return -1;
        } else {
            return 0;
        }
    }
}

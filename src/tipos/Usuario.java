package tipos;

public class Usuario extends Pessoa {

    private String login;
    private String password;

    /**
     * Método construtor.
     *
     * @param nome
     * @param sexo
     * @param login
     * @param password
     */
    public Usuario(String nome, char sexo, String login, String password) {
        super(nome, sexo);
        this.login = login;
        this.password = password;
    }

    /**
     * Construtor com id.
     * Não é utilizado o auto_increment para o id.
     * 
     * @param id
     * @param nome
     * @param sexo
     * @param login
     * @param password 
     */
    public Usuario(int id, String nome, char sexo, String login, String password) {
        super(id, nome, sexo);
        this.login = login;
        this.password = password;
    }

    /**
     * Recupera o login do usuário.
     *
     * @return O login
     */
    public String getLogin() {
        return login;
    }

    /**
     * Seta o login do usuário.
     *
     * @param login
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Recupera o password (senha) do usuário.
     *
     * @return O password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Seta o password do usuário.
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Usuario)) {
            return false;
        }
        Usuario outroUsuario = (Usuario) o;
        return outroUsuario.getLogin() == getLogin() && outroUsuario.getPassword() == getPassword();
    }

    @Override
    public String toString() {
        return super.toString() + "\nLogin: " + getLogin() + "\nPassword: " + getPassword();
    }
}

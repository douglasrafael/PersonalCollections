package br.edu.uepb.personalcollections;

import java.util.Objects;
import java.util.Arrays;

/**
 * Representa usuário administrador. Apenas um usuário é permitido.
 *
 * @author Douglas Rafael
 */
public class Usuario extends Pessoa {

    private static final long serialVersionUID = -7344963702457089731L;

    private String login;
    private char[] password;

    /**
     * Método construtor.
     *
     * @param nome O nome
     * @param sexo O sexo
     * @param login o login
     * @param password O password, senha
     */
    public Usuario(String nome, char sexo, String login, char[] password) {
        super(0, nome, sexo);
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
     * @param login O login
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Recupera o password (senha) do usuário.
     *
     * @return O password
     */
    public char[] getPassword() {
        return password;
    }

    /**
     * Seta o password do usuário.
     *
     * @param password O password
     */
    public void setPassword(char[] password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Usuario)) {
            return false;
        }
        Usuario outroUsuario = (Usuario) o;
        return outroUsuario.getLogin().equals(getLogin()) && Arrays.equals(outroUsuario.getPassword(), getPassword());
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.login);
        hash = 17 * hash + Objects.hashCode(this.password);
        return hash;
    }

    @Override
    public String toString() {
        return super.toString() + "\nLogin: " + getLogin() + "\nPassword: " + getPassword();
    }
}

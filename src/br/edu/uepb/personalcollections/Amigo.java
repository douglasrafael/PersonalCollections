package br.edu.uepb.personalcollections;

import br.edu.uepb.personalcollections.enums.Parentesco;

/**
 * Representa um amigo do usuário.
 *
 * @author Douglas Rafael
 *
 */
public class Amigo extends Pessoa {

    private static final long serialVersionUID = -7652369002447746103L;

    private String endereco;
    private String telefone;
    private String email;
    private Parentesco parentesco;

    /**
     * Método construtor sem o id. É utilizado o auto-incremnet da classe Pai
     *
     * @param nome Nome
     * @param sexo Sexo
     * @param endereco Endereço
     * @param telefone Telefone de contato
     * @param email E-Mail para contato
     * @param parentesco Parantesco da pessoa
     */
    public Amigo(String nome, char sexo, String endereco, String telefone, String email, Parentesco parentesco) {
        super(nome, sexo);
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.parentesco = parentesco;
    }

    /**
     * Contrutor que recebe o id. Não é utilizado o auto_increment para o id.
     *
     * @param id id da pessoa
     * @param nome Nome
     * @param sexo Sexo
     * @param endereco Endereço
     * @param telefone Telefone de contato
     * @param email E-Mail para contato
     * @param parentesco Parantesco da pessoa
     */
    public Amigo(int id, String nome, char sexo, String endereco, String telefone, String email, Parentesco parentesco) {
        super(id, nome, sexo);
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.parentesco = parentesco;
    }

    /**
     * Recupera o endereço do amigo do usuário.
     *
     * @return O endereço
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * Seta o endereço.
     *
     * @param endereco Endereço
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * Recupera o telefone do amigo do usuário.
     *
     * @return o telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * Seta o telefone.
     *
     * @param telefone O Telefone
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * Recupera o email do amigo do usuário.
     *
     * @return O email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Seta o email.
     *
     * @param email O E-Mail
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Recupera o parentesco do amigo do usuário.
     *
     * @return O parentesco
     */
    public Parentesco getParentesco() {
        return parentesco;
    }

    /**
     * Seta o parentesco do amigo.
     *
     * @param parentesco O Paraentesco
     */
    public void setParentesco(Parentesco parentesco) {
        this.parentesco = parentesco;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Amigo)) {
            return false;
        } else {
            Amigo outroAmigo = (Amigo) o;
            return getId() == outroAmigo.getId();
        }
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nEndereço: " + getEndereco()
                + "\nTelefone: " + getTelefone()
                + "\nE-Mail: " + getEmail()
                + "\nParentesco: " + getParentesco().getNome();
    }
}

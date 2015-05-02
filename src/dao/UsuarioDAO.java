package dao;

import excecoes.PersonalCollectionsException;
import tipos.Usuario;

public class UsuarioDAO {
    private final String LOGIN = "Admin";
    private final String PASSWORD = "123456";
    private final String NOME = "Douglas Rafael";
    private final char SEXO = 'M';

    /**
     * Faz autenticação do usuário no sistema. Se o login foi feito com sucesso
     * retorna o objeto usuário, se não null.
     *
     * @param login
     * @param password
     * @return O usuário ou null
     */
    public Usuario autenticar(String login, String password) throws PersonalCollectionsException {
        if (login.equals(LOGIN) && password.equals(PASSWORD)) {
            Usuario usuario = new Usuario(0, NOME, SEXO, LOGIN, PASSWORD);
            return usuario;
        }
        return null;
    }
}
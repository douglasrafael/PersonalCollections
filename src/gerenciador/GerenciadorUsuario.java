package gerenciador;

import tipos.Usuario;

public class GerenciadorUsuario {

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
    public Usuario autentica(String login, String password) {
        if (login == LOGIN && password == PASSWORD) {
            Usuario usuario = new Usuario(NOME, SEXO, LOGIN, PASSWORD);
            return usuario;
        }
        return null;
    }
}

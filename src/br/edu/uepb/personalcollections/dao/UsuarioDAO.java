package br.edu.uepb.personalcollections.dao;

import br.edu.uepb.personalcollections.excecoes.PersonalCollectionsException;
import br.edu.uepb.personalcollections.Usuario;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDAO {

    private Serializador ser;
    private Usuario usuario;
    private final String PATH = "data/data_usuario.dat";

    /**
     * Construtor. Cria a instância do Serializador
     */
    public UsuarioDAO() {
        this.ser = new Serializador();
    }

    /**
     * Faz autenticação do usuário no sistema. Se o login foi feito com sucesso
     * retorna o objeto usuário, se não null.
     *
     * @param login
     * @param password
     * @return O usuário ou null
     * @throws PersonalCollectionsException
     */
    public Usuario autenticar(String login, String password) throws PersonalCollectionsException {
        deserializar();
        if (usuario != null) {
            if (usuario.getLogin().equals(login) && usuario.getPassword().equals(password)) {
                return usuario;
            }
        }
        return null;
    }

    /**
     * Atualiza dos dodos do usuario
     *
     * @param u Usuario a ser atualizado
     */
    public void atualizar(Usuario u) {
        if (u != null) {
            usuario = u;
            serializar();
        }
    }

    /**
     * Recupera o usuário administrador do sistema
     *
     * @return O usuario
     */
    public Usuario listar() {
        if (usuario == null) {
            deserializar();
        }
        return usuario;
    }

    /**
     * Grava os dados do usuário no arquivo do PATH
     */
    public void serializar() {
        try {
            ser.serializar(PATH, usuario);
        } catch (IOException ex) {
            Logger.getLogger(TabuleiroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Recupera do arquivo do PATH os dados do usuário.
     */
    public void deserializar() {
        try {
            Object o = ser.deserializar(PATH);
            if (o != null) {
                usuario = (Usuario) o;
            }
        } catch (IOException ex) {
            Logger.getLogger(TabuleiroDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TabuleiroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

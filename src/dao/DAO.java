package dao;

import java.util.List;

import excecoes.PersonalCollectionsException;

/**
 * Interface que garante o contrato com as classes que a implementarem.
 * Implementação do CRUD e outros métodos essenciais é obrigatório.
 *
 * @author Douglas Rafael
 *
 * @param <T> O tipo do objeto
 */
public interface DAO<T> {

    /**
     * Monta lista contendo os objetos.
     *
     * @return A lista com os objetos
     * @throws PersonalCollectionsException
     */
    public List<T> listar() throws PersonalCollectionsException;

    /**
     * Salva um objeto.
     *
     * @param o Objeto a ser salvo
     * @throws PersonalCollectionsException
     */
    public void save(T o) throws PersonalCollectionsException;

    /**
     * Atualiza um objeto específico.
     *
     * @param o Objeto a ser atualizado
     * @throws PersonalCollectionsException
     */
    public void atualizar(T o) throws PersonalCollectionsException;

    /**
     * Remove um objeto específico.
     *
     * @param o Objeto a ser removido
     * @return True se removeu e False se não
     * @throws PersonalCollectionsException
     */
    public boolean remove(T o) throws PersonalCollectionsException;
    
    /**
     * Pesquisar item pelo id. Uma vez que o ID é único para cada item.
     * 
     * @param id 
     * @return O Objeto ou null caso não encontre
     * @throws PersonalCollectionsException 
     */
    public T pesquisar(int id) throws PersonalCollectionsException;
}

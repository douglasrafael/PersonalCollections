package br.edu.uepb.personalcollections.dao;

import java.util.List;

import br.edu.uepb.personalcollections.excecoes.PersonalCollectionsException;
import java.io.FileNotFoundException;
import java.io.IOException;

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
     * @throws PersonalCollectionsException se houver uma exceção 
     */
    public List<T> listar() throws PersonalCollectionsException;

    /**
     * Salva um objeto.
     *
     * @param o Objeto a ser salvo
     * @throws PersonalCollectionsException se houver uma exceção 
     */
    public void save(T o) throws PersonalCollectionsException;

    /**
     * Atualiza um objeto específico.
     *
     * @param o Objeto a ser atualizado
     * @throws PersonalCollectionsException se houver uma exceção 
     */
    public void atualizar(T o) throws PersonalCollectionsException;

    /**
     * Remove um objeto específico.
     *
     * @param o Objeto a ser removido
     * @return True se removeu e False se não
     * @throws PersonalCollectionsException se houver uma exceção 
     */
    public boolean remove(T o) throws PersonalCollectionsException;
    
    /**
     * Pesquisar item pelo id. Uma vez que o ID é único para cada item.
     * 
     * @param id O id
     * @return O Objeto ou null caso não encontre
     * @throws PersonalCollectionsException se houver uma exceção 
     */
    public T pesquisar(int id) throws PersonalCollectionsException;
    
    /**
     * Salva (Grava) no arquivo a lista atual completa do item em questão
     * 
     * @throws java.io.FileNotFoundException se houver uma exceção por não encontrar o arquivo
     * @throws IOException se houver uma exceção
     */
    public void serializar() throws FileNotFoundException, IOException; 
    
    /**
     * Recupera a lista completa do item que está no PATH específico ao tipo de item
     * 
     * @throws IOException se houver uma exceção
     * @throws java.io.FileNotFoundException se houver uma exceção por não encontrar o arquivo
     * @throws ClassNotFoundException se houver uma exceção
     */
    public void deserializar() throws IOException, FileNotFoundException, ClassNotFoundException;
}

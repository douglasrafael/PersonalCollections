package br.edu.uepb.personalcollections.dao;

import br.edu.uepb.personalcollections.Amigo;
import java.util.LinkedList;
import java.util.List;

import br.edu.uepb.personalcollections.excecoes.PersonalCollectionsException;
import br.edu.uepb.personalcollections.Emprestimo;
import br.edu.uepb.personalcollections.Item;
import br.edu.uepb.personalcollections.enums.TipoItem;
import br.edu.uepb.personalcollections.gerenciador.Gerenciador;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmprestimoDAO implements DAO<Emprestimo> {

    private static List<Emprestimo> listaDeEmprestimos = new LinkedList<>();
    private Serializador ser;
    private final String PATH = "data/data_emprestimo.dat";

    /**
     * Construtor. Cria a instância do Serializador
     */
    public EmprestimoDAO() {
        this.ser = new Serializador();
    }

    @Override
    public List<Emprestimo> listar() throws PersonalCollectionsException {
//        if (listaDeEmprestimos.isEmpty()) {
        deserializar();
//        }
        return listaDeEmprestimos;
    }

    @Override
    public void save(Emprestimo o) throws PersonalCollectionsException {
        listaDeEmprestimos.add(o);
        serializar();
    }

    @Override
    public void atualizar(Emprestimo o) throws PersonalCollectionsException {
        if (!listaDeEmprestimos.isEmpty()) {
            Emprestimo e = pesquisar(o.getId());
            if (e != null) {
                listaDeEmprestimos.set(listaDeEmprestimos.indexOf(e), o);
                serializar();
            }
        }
    }

    @Override
    public boolean remove(Emprestimo o) throws PersonalCollectionsException {
        boolean result = listaDeEmprestimos.remove(o);
        if (result) {
            serializar();
        }
        return result;
    }

    @Override
    public Emprestimo pesquisar(int id) {
        if (!listaDeEmprestimos.isEmpty()) {
            for (Emprestimo e : listaDeEmprestimos) {
                if (e.getId() == id) {
                    return e;
                }
            }
        }
        return null;
    }

    @Override
    public void serializar() {
        try {
            ser.serializar(PATH, listaDeEmprestimos);
        } catch (IOException ex) {
            Logger.getLogger(TabuleiroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deserializar() {
        try {
            Object o = ser.deserializar(PATH);
            boolean up = false;
            if (o != null) {
                listaDeEmprestimos = (LinkedList<Emprestimo>) o;
                Gerenciador manager = new Gerenciador();
                for (Emprestimo e : listaDeEmprestimos) {
                    // Item
                    if (e.getItem() != null) {
                        Item item = manager.pesquisarItem(e.getItem().getId(), e.getItem().getTipo());
                        if (item != null) {
                            e.setItem(item);
                            atualizar(e);
                            up = true;
                        }
                    }

                    // Amigo
                    if (e.getAmigo() != null) {
                        Amigo amigo = manager.pesquisarAmigo(e.getAmigo().getId());
                        if (amigo != null) {
                            e.setAmigo(amigo);
                            atualizar(e);
                            up = true;
                        }
                    }
                }
                // Atualiza o arquivo
                if (up) {
                    serializar();
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(TabuleiroDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TabuleiroDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PersonalCollectionsException ex) {
            Logger.getLogger(EmprestimoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

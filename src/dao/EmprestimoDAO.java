package dao;

import java.util.LinkedList;
import java.util.List;

import excecoes.PersonalCollectionsException;
import tipos.Emprestimo;

public class EmprestimoDAO implements DAO<Emprestimo> {

    private static List<Emprestimo> listaDeEmprestimos = new LinkedList<>();

    @Override
    public List<Emprestimo> listar() throws PersonalCollectionsException {
        return listaDeEmprestimos;
    }

    @Override
    public void save(Emprestimo o) throws PersonalCollectionsException {
        listaDeEmprestimos.add(o);
    }

    @Override
    public void atualizar(Emprestimo o) throws PersonalCollectionsException {
        if (!listaDeEmprestimos.isEmpty()) {
            Emprestimo e = pesquisar(o.getId());
            if (e != null) {
                listaDeEmprestimos.set(listaDeEmprestimos.indexOf(e), o);
            }
        }
    }

    @Override
    public boolean remove(Emprestimo o) throws PersonalCollectionsException {
        return listaDeEmprestimos.remove(o);
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
}

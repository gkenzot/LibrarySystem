package br.com.senac.library.dao;

import br.com.senac.library.model.Emprestimo;
import br.com.senac.library.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;

public class EmprestimoDAO {

    public void cadastrar(Emprestimo e) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(e);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
            throw ex;
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

    public List<Emprestimo> listar() {
        EntityManager em = JPAUtil.getEntityManager();
        List emprestimos = null;
        try {
            String textoQuery = "SELECT e FROM Emprestimo e";
            Query consulta = em.createQuery(textoQuery);
            emprestimos = consulta.getResultList();
        } finally {
            JPAUtil.closeEntityManager();
        }
        return emprestimos;
    }

    public void excluir(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            Emprestimo e = em.find(Emprestimo.class, id);
            if (e != null) {
                em.getTransaction().begin();
                em.remove(e);
                em.getTransaction().commit();
            }
        } catch (Exception ex) {
            em.getTransaction().rollback();
            throw ex;
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

    public Emprestimo obter(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.find(Emprestimo.class, id);
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

    public void atualizar(Emprestimo e) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(e);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
            throw ex;
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

    public Emprestimo obterPorLivro(int idLivro) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            String textoQuery = "SELECT e FROM Emprestimo e WHERE e.livro.id = :idLivro";
            Query consulta = em.createQuery(textoQuery);
            consulta.setParameter("idLivro", idLivro);
            Emprestimo emprestimo = (Emprestimo) consulta.getSingleResult();

            // Verificar se o livro está emprestado para preencher as datas
            if (emprestimo != null && "emprestado".equals(emprestimo.getLivro().getStatus())) {
                return emprestimo;
            } else {
                return null; // Ou lançar uma exceção, dependendo do comportamento desejado
            }
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

}

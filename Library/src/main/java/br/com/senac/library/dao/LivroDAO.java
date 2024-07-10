package br.com.senac.library.dao;

import br.com.senac.library.model.Livro;
import br.com.senac.library.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;

public class LivroDAO {

    public void cadastrar(Livro l) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(l);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

    public List<Livro> listar(String pesquisar) {
        EntityManager em = JPAUtil.getEntityManager();
        List livros = null;
        try {
            String textoQuery = "SELECT l FROM Livro l " + " WHERE (:titulo is null OR l.titulo LIKE :titulo ) ";
            Query consulta = em.createQuery(textoQuery); // breakpoint
            consulta.setParameter("titulo", pesquisar.isEmpty() ? null : "%" + pesquisar + "%");
            livros = consulta.getResultList();
        } finally {
            JPAUtil.closeEntityManager(); // breakpoint
        }
        return livros;
    }

    public void excluir(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            Livro l = em.find(Livro.class, id);
            if (l != null) {
                em.getTransaction().begin();
                em.remove(l);
                em.getTransaction().commit();
            }
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

    public Livro obter(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.find(Livro.class, id);
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

    public void atualizar(Livro l) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(l);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

    public boolean verificarEmprestimos(int idLivro) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            String textoQuery = "SELECT COUNT(e) FROM Emprestimo e WHERE e.livro.id = :idLivro";
            Query consulta = em.createQuery(textoQuery);
            consulta.setParameter("idLivro", idLivro);
            Long count = (Long) consulta.getSingleResult();
            return count > 0;
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

}

package br.com.senac.library.dao;

import br.com.senac.library.model.Usuario;
import br.com.senac.library.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;

public class UsuarioDAO {

    public void cadastrar(Usuario u) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(u);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

    public List<Usuario> listar(String pesquisar) {
        EntityManager em = JPAUtil.getEntityManager();
        List usuarios = null;
        try {
            String textoQuery = "SELECT u FROM Usuario u " + " WHERE (:nome is null OR u.nome LIKE :nome ) ";
            Query consulta = em.createQuery(textoQuery); // breakpoint
            consulta.setParameter("nome", pesquisar.isEmpty() ? null : "%" + pesquisar + "%");
            usuarios = consulta.getResultList();
        } finally {
            JPAUtil.closeEntityManager(); // breakpoint
        }
        return usuarios;
    }

    public void excluir(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            Usuario u = em.find(Usuario.class, id);
            if (u != null) {
                em.getTransaction().begin();
                em.remove(u);
                em.getTransaction().commit();
            }
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

    public Usuario obter(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.find(Usuario.class, id);
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

    public void atualizar(Usuario u) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(u);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

    public boolean verificarEmprestimos(int idUsuario) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            String textoQuery = "SELECT COUNT(e) FROM Emprestimo e WHERE e.usuario.id = :idUsuario";
            Query consulta = em.createQuery(textoQuery);
            consulta.setParameter("idUsuario", idUsuario);
            Long count = (Long) consulta.getSingleResult();
            return count > 0;
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

}

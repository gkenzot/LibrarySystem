package br.com.senac.library.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {

    private static final String PERSISTENCE_UNIT = "librarydb";
    private static EntityManager em;
    private static EntityManagerFactory fabrica;

    public static EntityManager getEntityManager() {
        if (fabrica == null || !fabrica.isOpen()) {
            fabrica = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        }
        if (em == null || !em.isOpen()) {

        }
        em = fabrica.createEntityManager();
        return em;
    }

    public static void closeEntityManager() {
        if (em.isOpen() && em != null) {
            em.close();
            fabrica.close();
        }
        
    }
}

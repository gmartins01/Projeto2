package proj2.bd.BLL;

import proj2.bd.entity.Codpostais;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import javax.persistence.Query;
import java.util.List;
import java.util.ArrayList;

public class CodpostaisBLL
{
    private static final String PERSISTENCE_UNIT_NAME = "default";
    private static EntityManagerFactory factory = null;
    private static EntityManager em = null;

    public static void create(Codpostais cod){
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.persist(cod);
        em.getTransaction().commit();
    }

    public static Codpostais readById(String codPostal){
        Codpostais cod = null;
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("Codpostais.findByCodPostal");
        q1.setParameter("codPostal", codPostal);
        Object obj = q1.getSingleResult();

        if(obj != null){
            cod = ((Codpostais)obj);
        }
        else
            return null;

        return cod;
    }

    public static int serachCodigo(String codPostal){
        Codpostais cod = null;
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("Codpostais.findByCodPostal");
        q1.setParameter("codPostal", codPostal);
        Object obj = q1.getSingleResult();

        if(obj != null){
            cod = ((Codpostais)obj);
            return 0;
        }
        else
            return -1;

    }

    public static List<Codpostais> readAll(){
        List<Codpostais> listaCodPostais = new ArrayList<>();
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("Codpostais.findAll");
        List<Object> result = q1.getResultList();

        for(Object cod : result){
            listaCodPostais.add((Codpostais) cod);
        }

        return listaCodPostais;
    }

}

package proj2.bd.BLL;

import proj2.bd.entity.Galinha;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import javax.persistence.Query;
import java.util.List;
import java.util.ArrayList;

public class GalinhaBLL
{
    private static final String PERSISTENCE_UNIT_NAME = "default";
    private static EntityManagerFactory factory = null;
    private static EntityManager em = null;

    public static void create(Galinha galinha){
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.persist(galinha);
        em.getTransaction().commit();
    }

    public static Galinha read(int codGalinha){
        Galinha gal = null;
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("Galinha.findByCodGalinha");
        q1.setParameter("codGalinha", codGalinha);
        Object obj = q1.getSingleResult();

        if(obj != null){
            gal = ((Galinha)obj);
        }
        else
            return null;

        return gal;
    }

    public static List<Galinha> readAll(){
        List<Galinha> listaGalinha = new ArrayList<>();
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("Galinha.findAll");
        List<Object> result = q1.getResultList();

        for(Object galinha : result){
            listaGalinha.add((Galinha) galinha);
            System.out.println(galinha);
        }

        return listaGalinha;
    }

}

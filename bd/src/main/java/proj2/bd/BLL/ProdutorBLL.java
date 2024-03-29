package proj2.bd.BLL;

import proj2.bd.entity.Produtor;
import proj2.bd.entity.Utilizador;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import javax.persistence.Query;
import java.util.List;
import java.util.ArrayList;

public class ProdutorBLL
{
    private static final String PERSISTENCE_UNIT_NAME = "default";
    private static EntityManagerFactory factory = null;
    private static EntityManager em = null;

    public static void create(Produtor produtor){
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.persist(produtor);
        em.getTransaction().commit();
    }

    public static Produtor read(int idProdutor){
        Produtor produtor = null;
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("Produtor.findByIdProdutor");
        q1.setParameter("idProdutor", idProdutor);
        Object obj = q1.getSingleResult();

        if(obj != null){
            produtor = ((Produtor)obj);
        }
        else
            return null;

        return produtor;
    }

    public static List<Produtor> readAll(){
        List<Produtor> listaProdutor = new ArrayList<>();
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("Produtor.findAll");
        List<Object> result = q1.getResultList();

        for(Object produtor : result){
            listaProdutor.add((Produtor) produtor);
        }

        return listaProdutor;
    }

    public static void delete(Produtor produtor){
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.remove(produtor);
        em.getTransaction().commit();
    }

}

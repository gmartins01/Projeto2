package proj2.bd.BLL;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import proj2.bd.entity.*;
import proj2.bd.entity.Estado;

import java.util.ArrayList;
import java.util.List;

public class EstadoBLL
{
    private static final String PERSISTENCE_UNIT_NAME = "default";
    private static EntityManagerFactory factory = null;
    private static EntityManager em = null;

    public static void create(Estado estado){
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.persist(estado);
        em.getTransaction().commit();
    }

    public static List<Estado> readAll(){
        List<Estado> listaEstado = new ArrayList<>();
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("Estado.findAll");
        List<Object> result = q1.getResultList();

        for(Object estado : result){
            listaEstado.add((Estado) estado);
            System.out.println(estado);
        }

        return listaEstado;
    }

}

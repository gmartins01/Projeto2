package proj2.bd.BLL;

import proj2.bd.entity.EntidadeCertificadora;
import proj2.bd.entity.Veterinario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import javax.persistence.Query;
import java.util.List;
import java.util.ArrayList;

public class EntidadecertificadoraBLL
{
    private static final String PERSISTENCE_UNIT_NAME = "default";
    private static EntityManagerFactory factory = null;
    private static EntityManager em = null;

    public static void create(EntidadeCertificadora entidade){
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.persist(entidade);
        em.getTransaction().commit();
    }

    public static List<EntidadeCertificadora> readAll(){
        List<EntidadeCertificadora> listaEntidadeCertificadora = new ArrayList<>();
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("EntidadeCertificadora.findAll");
        List<Object> result = q1.getResultList();

        for(Object enti : result){
            listaEntidadeCertificadora.add((EntidadeCertificadora) enti);
            System.out.println(enti);
        }

        return listaEntidadeCertificadora;
    }

    public static void delete(EntidadeCertificadora ent){
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.remove(ent);
        em.getTransaction().commit();
    }

}

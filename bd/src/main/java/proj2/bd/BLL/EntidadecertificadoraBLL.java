package proj2.bd.BLL;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import proj2.bd.entity.*;
import proj2.bd.entity.Entidadecertificadora;

import javax.persistence.Query;
import java.util.List;
import java.util.ArrayList;

public class EntidadecertificadoraBLL
{
    private static final String PERSISTENCE_UNIT_NAME = "default";
    private static EntityManagerFactory factory = null;
    private static EntityManager em = null;

    public static void create(Entidadecertificadora entidade){
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.persist(entidade);
        em.getTransaction().commit();
    }

    public static List<Entidadecertificadora> readAll(){
        List<Entidadecertificadora> listaEntidadeCertificadora = new ArrayList<>();
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("Entidadecertificadora.findAll");
        List<Object> result = q1.getResultList();

        for(Object enti : result){
            listaEntidadeCertificadora.add((Entidadecertificadora) enti);
            System.out.println(enti);
        }

        return listaEntidadeCertificadora;
    }

}

package proj2.bd.BLL;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import proj2.bd.entity.*;
import proj2.bd.entity.Loteovos;

import javax.persistence.Query;
import java.util.List;
import java.util.ArrayList;

public class LoteovosBLL
{
    private static final String PERSISTENCE_UNIT_NAME = "default";
    private static EntityManagerFactory factory = null;
    private static EntityManager em = null;

    public static void create(Loteovos ovos){
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.persist(ovos);
        em.getTransaction().commit();
    }

    public static Loteovos read(int idLote){
        Loteovos lote = null;
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("Loteovos.findAllById");
        q1.setParameter("idloteovos", idLote);
        Object obj = q1.getSingleResult();

        if(obj != null){
            lote = ((Loteovos)obj);
        }
        else
            return null;

        return lote;
    }

    public static List<Loteovos> readAll(){
        List<Loteovos> listaLoteOvos = new ArrayList<>();
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("Loteovos.findAll");
        List<Object> result = q1.getResultList();

        for(Object lote : result){
            listaLoteOvos.add((Loteovos) lote);
            System.out.println(lote);
        }

        return listaLoteOvos;
    }

}

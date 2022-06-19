package proj2.bd.BLL;

import proj2.bd.entity.LoteOvos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import javax.persistence.Query;
import java.util.List;
import java.util.ArrayList;

public class LoteOvosBLL
{
    private static final String PERSISTENCE_UNIT_NAME = "default";
    private static EntityManagerFactory factory = null;
    private static EntityManager em = null;

    public static void create(LoteOvos ovos){
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.persist(ovos);
        em.getTransaction().commit();
    }

    public static LoteOvos read(int idLote){
        LoteOvos lote = null;
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("LoteOvos.findByIdLote");
        q1.setParameter("idLote", idLote);
        Object obj = q1.getSingleResult();

        if(obj != null){
            lote = ((LoteOvos)obj);
        }
        else
            return null;

        return lote;
    }

    public static List<LoteOvos> readAll(){
        List<LoteOvos> listaLoteOvos = new ArrayList<>();
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("LoteOvos.findAll");
        List<Object> result = q1.getResultList();

        for(Object lote : result){
            listaLoteOvos.add((LoteOvos) lote);
            System.out.println(lote);
        }

        return listaLoteOvos;
    }

}
